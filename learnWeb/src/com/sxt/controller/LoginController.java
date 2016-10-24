package com.sxt.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.sxt.inter.IMemberMoney;
import com.sxt.inter.IMembers;
import com.sxt.models.LdUserSignInLog;
import com.sxt.models.MemberMoney;
import com.sxt.models.MemberReward;
import com.sxt.models.Memberlogin;
import com.sxt.models.Members;
import com.sxt.service.Base64Encrypt;
import com.sxt.service.LdMemberRewardService;
import com.sxt.service.LdUserSignInLogService;
import com.sxt.service.LoginService;
import com.sxt.service.MemberLoginService;
import com.sxt.service.MemberService;
import com.sxt.service.MessageService;
import com.sxt.util.Money;
import com.sxt.util.SHAUtil;
import com.sxt.util.SingleOnline;

@Controller
@RequestMapping("/login")
public class LoginController extends AbstractGeneralController{
	@Autowired
	private MemberService memberservice;
	@Autowired
	private LoginService loginService;
	@Autowired
	private IMembers iMembers;
	@Autowired
	IMemberMoney iMemberMoney;
	@Autowired
	private Base64Encrypt base64Encrypt;
	@Autowired
	private MemberLoginService memberLoginService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private LdUserSignInLogService ldUserSignInLogService; 
	@Autowired
	private LdMemberRewardService ldMemberRewardService;
	@RequestMapping(value = "/loginSub.htm", method = RequestMethod.POST)
	@ResponseBody
	public String login(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession httpSession,
			ModelMap map,
			@RequestParam(value = "user_phone", required = true) String user_phone,
			@RequestParam(value = "user_pass", required = true) String user_pass,
			@RequestParam(value = "view", required = false) String view) {
		Integer loginErrCount=httpSession.getAttribute("loginErrCount")==null?0:(Integer)httpSession.getAttribute("loginErrCount");
		try{
			user_pass = SHAUtil.encryptSHA1(base64Encrypt.encrypt(user_pass));
		}catch(Exception e){
			e.printStackTrace();
		}
		Members member = loginService.selectMember(user_phone);
		String jsonObject;
		if(member==null){
			map.put("tag", 1);
			map.put("loginErrCount", loginErrCount+1);
			jsonObject = JSONObject.toJSONString(map);
			httpSession.setAttribute("loginErrCount",loginErrCount+1);
			return jsonObject;
		}
		if("1".equals(member.getStatus())){
			map.put("tag", 3);
			jsonObject = JSONObject.toJSONString(map);
			return jsonObject;
		}
		MemberMoney memberMoney = iMemberMoney.queryMemberMoney(member.getUid());
		if (memberMoney != null) {
			BigDecimal accountMoney = memberMoney.getAccountMoney();
			BigDecimal moneyFreeze = memberMoney.getMoneyFreeze();
			Money money=new Money(accountMoney,Currency.getInstance("CNY"));
			Money money1=new Money(moneyFreeze,Currency.getInstance("CNY"));
			Money bd=money.subtract(money1);
			member.setMoneys(bd.getAmount());
			member.setTotalScore(memberMoney.getTotalScore());
		}
		if (member.getUserPass().equals(user_pass)
				&&( member.getUserPhone().equals(user_phone)||member.getUserName().equals(user_phone))) {
			httpSession.setAttribute("loginErrCount",0);
		} else {
			map.put("loginErrCount", loginErrCount+1);
			map.put("tag", 1);
			jsonObject = JSONObject.toJSONString(map);
			httpSession.setAttribute("loginErrCount",loginErrCount+1);
			return jsonObject;
		}
		map.put("tag", 2);
		map.put("view", view);
		//设置登录信息
		super.setLocalUser(request,super.getLocalUserDto(member,messageService));
		jsonObject = JSONObject.toJSONString(map);
		Memberlogin logins=new Memberlogin();
		logins.setUid(super.getLocalUser(request).getUid());
		logins.setType(1);
		logins.setCreateTime(new Date());
		logins.setIp(super.getRemoteAddr(request));
		memberLoginService.add(logins);
		//签到
		List<LdUserSignInLog> signList=ldUserSignInLogService.queryLdUserSignInLogList(member.getUid());
		if(signList.size()>0){
			super.getLocalUser(request).setSignFlag(1);
		}else{
			super.getLocalUser(request).setSignFlag(0);
		}
		//获取用户签到的积分数值
		MemberReward reward=new MemberReward();
		reward.setPro_name("用户签到奖励");
		reward.setStatus("1");
		reward.setType(2);
		reward.setReward_type(3);
		List<MemberReward> rewardList=ldMemberRewardService.findMemberRewardList(reward);
		int signTotal=rewardList.size()==0?0:rewardList.get(0).getPro_value();
		httpSession.setAttribute("signTotal", signTotal);
		//将SessionId+ip放入队列
		SingleOnline.addUser(member.getUid(), httpSession.getId()+"-"+super.getRemoteAddr(request));
		return jsonObject;
	}
	
	@RequestMapping(value = "/kaptchaVer.htm", method = RequestMethod.POST)
	@ResponseBody
	public String kaptchaVer(HttpServletRequest request,
			@RequestParam(value = "kaptcha", required = true) String kaptcha) {
		String code = (String) request.getSession().getAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if (!kaptcha.equalsIgnoreCase(code)) {
			return "0";
		} else {
			return "1";
		}
	}
	/**
	 * 找回密码
	 * @param request
	 * @param response
	 * @param map
	 * @throws IOException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping("/zhPassword.htm")
	public void zhPassword(HttpServletRequest request,HttpServletResponse response,@RequestParam Map<String,Object> map) throws IOException, NoSuchAlgorithmException{
		Members member=new Members();
		member.setUserPhone(map.get("zhPhone").toString());
		member.setUserPass(SHAUtil.encryptSHA1(base64Encrypt.encrypt(map.get("zhNewPassword").toString())));
		memberservice.updatePassword(member);
		request.getSession().removeAttribute("code2");
		response.getWriter().write("success");
	}
	/**
	 * 跳转登录
	 * @param request
	 * @param response
	 * @param map
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	@RequestMapping("/login.htm")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="view",required=false) String view) throws IOException, NoSuchAlgorithmException{
		ModelAndView mv=new ModelAndView("../../login");
//		mv.addObject("mail",request.getParameter("mail"));
//		mv.addObject("user",request.getParameter("user"));
//		mv.addObject("time",request.getParameter("time"));
		mv.addObject("view", view);
		return mv;
		
	}
	public static void main(String[] args) {
		String str="430321199112277418";
		String newStr=str.substring(str.length()-4, str.length());
		String strs="";
		for (int i = 0; i < str.length()-4; i++) {
			strs+="*";
		}
		System.out.println(strs+newStr);
	}
}
