package com.sxt.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.sxt.enums.MessageVerifyCodeTypeEnum;
import com.sxt.enums.UserAwardTypeEnum;
import com.sxt.inter.IMemberMoney;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.inter.dto.MemberMoneyDto;
import com.sxt.models.LdCheckUserNameLog;
import com.sxt.models.LdMemberCertificateCheck;
import com.sxt.models.LdMemberContactInfo;
import com.sxt.models.LdMemberScoreDetail;
import com.sxt.models.LdUserSignInLog;
import com.sxt.models.Mail;
import com.sxt.models.MemberInfo;
import com.sxt.models.MemberMoney;
import com.sxt.models.Members;
import com.sxt.service.Base64Encrypt;
import com.sxt.service.BorrowInvestorService;
import com.sxt.service.LdCheckUserNameLogService;
import com.sxt.service.LdMemberCertificateCheckService;
import com.sxt.service.LdMemberContactInfoService;
import com.sxt.service.LdMemberRewardService;
import com.sxt.service.LdRewardCodeService;
import com.sxt.service.LdUserSignInLogService;
import com.sxt.service.MemberInfoService;
import com.sxt.service.MemberMoneyService;
import com.sxt.service.MemberScoreDetailService;
import com.sxt.service.MemberService;
import com.sxt.service.MessageService;
import com.sxt.service.product.CiProductService;
import com.sxt.util.Base64;
import com.sxt.util.CoreConstant;
import com.sxt.util.DesUtil;
import com.sxt.util.FileUtil;
import com.sxt.util.MailUtil;
import com.sxt.util.Money;
import com.sxt.util.PropertiesRead;
import com.sxt.util.SHAUtil;
import com.sxt.util.StringUtil;

@Controller
@RequestMapping("/person")
public class MembersController extends AbstractGeneralController
{
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberInfoService memberInfoService;
	@Autowired
	private MemberMoneyService memberMoneyService;
	@Autowired
	private BorrowInvestorService borrowInvestorService;
	@Autowired
	private CiProductService iCiProductService;
	@Autowired
	private Base64Encrypt base64Encrypt;
	@Autowired
	private LdMemberContactInfoService ldMemberContactInfoService;
	@Autowired
	IMemberMoney iMemberMoney;
	@Autowired
	private MessageService messageService;
	@Autowired
	private LdCheckUserNameLogService ldCheckUserNameLogService;
	@Autowired
	private LdUserSignInLogService ldUserSignInLogService;
	@Autowired
	private LdMemberRewardService ldMemberRewardService;
	@Autowired
	private MemberScoreDetailService memberScoreDetailService;
	@Autowired
	private LdMemberCertificateCheckService ldMemberCertificateCheckService;
	@Autowired
	private LdRewardCodeService rewardCodeService;
	
	/**
	 * 跳转个人资料
	 * 
	 * @return
	 */
	@RequestMapping("/editPerson.htm")
	public ModelAndView editPerson(HttpServletRequest request,
			HttpServletResponse response,@RequestParam Map<String,Object> maps)
	{
		LocalUserDto lud = super.getLocalUser(request);
		ModelAndView mv=new ModelAndView("person/personal");
		request.setAttribute("headFlag", maps.get("headFlag"));
		request.setAttribute("param", request.getParameter("param"));
		String tag = request.getParameter("tag");
		if (StringUtil.isNotEmpty(tag)) {
			Members members =  memberService.fquerybyphone(lud.getUserPhone());
			String email = members.getUserEmail();
			if("1".equals(tag) && StringUtil.isEmpty(email)) {
				mv.addObject("editType", "mail");
			}
			if ("2".equals(tag)) {
				mv.addObject("editType", "realName");
			}
		}
		mv.addObject("mail",maps.get("mail"));
		return mv;
	}

	/**
	 * 查询个人资料
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/getPerson.htm")
	public void getPerson(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		Members members = memberService.getMembers(super.getLocalUser(request)
				.getUid());
		if(members.getInfo()==null){
			members.setInfo(new MemberInfo());
		}
		if(members.getContact()==null){
			members.setContact(new LdMemberContactInfo());
		}
		members.setUserPhone(getSubPhone(members.getUserPhone()));
		String json = JSONObject.toJSONString(members);
		response.getWriter().write(json);
	}
	/**
	 * 查询实名
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/getPersonReal.htm")
	public void getPersonReal(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		MemberInfo info = memberInfoService.fQueryMemberInfoByUid(super
				.getLocalUser(request).getUid());
		info.setIdcard(info.getIdcard()==null?"":info.getIdcard());
		info.setRealName(info.getRealName()==null?"":info.getRealName());
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("uid", info.getUid());
		List<LdMemberCertificateCheck> list=ldMemberCertificateCheckService.queryCertificateCheck(map);
		if(list.size()>0){
			info.setCheckInfo(list.get(0));
		}else{
			info.setCheckInfo(null);
		}
		String json = JSONObject.toJSONString(info);
		response.getWriter().write(json);
	}
	/**
	 * 查询个人头像
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/getPersonHead.htm")
	public void getPersonHead(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		MemberInfo info = memberInfoService.fQueryMemberInfoByUid(super
				.getLocalUser(request).getUid());
		if (info.getHeadshotUrl() != null
				&& !"".equals(info.getHeadshotUrl()))
		{
			info.setHeadshotUrl(PropertiesRead.use_classLoador().getProperty(
					"image.ip")
					+ info.getHeadshotUrl());
		}
		String json = JSONObject.toJSONString(info);
		response.getWriter().write(json);
	}

	/**
	 * 保存基本信息
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @throws IOException
	 */
	@RequestMapping("/savePerson.htm")
	public void savePerson(HttpServletRequest request,
			HttpServletResponse response, @RequestParam Map<String, Object> map)
			throws IOException
	{
		saveMembers(request, map);
		saveMemberInfo(request, map);
		saveContactInfo(request, map);
		response.getWriter().write("success");
	}

	/**
	 * 上传头像
	 * 
	 * @param file
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/uploadPerson.htm")
	@ResponseBody
	public String uploadPerson(@RequestParam("file") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException
	{
		Map<String,Object> map=new HashMap<String, Object>();
		String suffix = file.getOriginalFilename()
				.substring(file.getOriginalFilename().lastIndexOf("."));
		if (!FileUtil.isCorrectFormat(FileUtil.imgHead, suffix)) {
			map.put("msg", "err");
			return JSONObject.toJSONString(map);
		}
		
		//	支持文件大小
		if (!FileUtil.isCorrectSize(FileUtil.imgHeadSize, file.getSize())) {
			map.put("msg", "err");
			return JSONObject.toJSONString(map);
		}
		String fileName = FileUtil.saveFile(file, request);
		MemberInfo info = memberInfoService.fQueryMemberInfoByUid(super
				.getLocalUser(request).getUid());
		info.setHeadshotUrl(fileName);
		memberInfoService.update(info);
		Members member = memberService.getMembers(super.getLocalUser(request)
				.getUid());
		MemberMoney memberMoney = iMemberMoney
				.queryMemberMoney(member.getUid());
		if (memberMoney != null)
		{
			BigDecimal accountMoney = memberMoney.getAccountMoney();
			BigDecimal moneyFreeze = memberMoney.getMoneyFreeze();
			Money money = new Money(accountMoney, Currency.getInstance("CNY"));
			Money money1 = new Money(moneyFreeze, Currency.getInstance("CNY"));
			Money bd = money.subtract(money1);
			member.setMoneys(bd.getAmount());
			member.setTotalScore(memberMoney.getTotalScore());
		}
		super.setLocalUser(request, super.getLocalUserDto(member,messageService));
		map.put("msg", "success");
		map.put("url", PropertiesRead.use_classLoador().getProperty("image.ip")+ fileName);
		return JSONObject.toJSONString(map);
	}

	/**
	 * 验证密码
	 * 
	 * @param request
	 * @param response
	 * @param userPass
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	@RequestMapping("/validatePass.htm")
	public void validatePass(HttpServletRequest request,
			HttpServletResponse response, @RequestParam Map<String, Object> map)
			throws IOException, NoSuchAlgorithmException
	{
		Map<String, Object> maps = new HashMap<String, Object>();
		if ("loginPass".equals(map.get("flag")))
		{
			maps.put(
					"userPass",
					SHAUtil.encryptSHA1(base64Encrypt.encrypt(map.get(
							"userPass").toString())));
		} else
		{
			maps.put(
					"payPass",
					SHAUtil.encryptSHA1(base64Encrypt.encrypt(map.get(
							"userPass").toString())));
		}
		maps.put("uid", super.getLocalUser(request).getUid());
		Members member = memberService.validatePass(maps);
		String msg = "";
		if (member != null)
		{
			msg = "success";
		} else
		{
			msg = "err";
		}
		response.getWriter().write(msg);
	}

	/**
	 * 修改登录密码
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	@RequestMapping("/submitLogin.htm")
	public void submitLogin(HttpServletRequest request,
			HttpServletResponse response, @RequestParam Map<String, Object> map)
			throws NoSuchAlgorithmException, IOException
	{
		Members member = new Members();
		member.setUid(super.getLocalUser(request).getUid());
		member.setUserPass(SHAUtil.encryptSHA1(base64Encrypt.encrypt(map.get(
				"loginNewPass").toString())));
		memberService.update(member);
		request.getSession().invalidate();
		response.getWriter().write("success");
	}

	/**
	 * 修改支付密码
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	@RequestMapping("/submitPay.htm")
	public void submitPay(HttpServletRequest request,
			HttpServletResponse response, @RequestParam Map<String, Object> map)
			throws NoSuchAlgorithmException, IOException
	{
		Members member = new Members();
		member.setUid(super.getLocalUser(request).getUid());
		member.setPayPass(SHAUtil.encryptSHA1(base64Encrypt.encrypt(map.get(
				"payNewPass").toString())));
		memberService.update(member);
		super.getLocalUser(request).setPayPass(member.getPayPass());
		request.getSession().removeAttribute("code3");
		response.getWriter().write("success");
	}

	/**
	 * 找回支付密码
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	@RequestMapping("/submitFindPay.htm")
	public void submitFindPay(HttpServletRequest request,
			HttpServletResponse response, @RequestParam Map<String, Object> map)
			throws NoSuchAlgorithmException, IOException
	{
		Members member = new Members();
		member.setUid(super.getLocalUser(request).getUid());
		member.setPayPass(SHAUtil.encryptSHA1(base64Encrypt.encrypt(map.get(
				"findPayNewPass").toString())));
		memberService.update(member);
		response.getWriter().write("success");
		request.getSession().removeAttribute("code3");
	}

	/**
	 * 实名认证
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @throws Exception 
	 */
	@RequestMapping(value="/submitRealName.htm",method = RequestMethod.POST)
	public void submitRealName(HttpServletRequest request,
			HttpServletResponse response,@RequestParam("realName")String realName,@RequestParam("idcard")String idcard)
			throws Exception
	{
		
		LocalUserDto lud=super.getLocalUser(request);
		Members member=memberService.getMembers(lud.getUid());
		List list=memberInfoService.queryIdCard(idcard);
		String msgErr="";
		if(member.getErrorCount()<3&&list.size()==0){
			String result=sendQuickPay(realName,idcard);
			JSONObject obj=(JSONObject) JSONObject.parse(result);
			String msg=obj.get("success").toString();
			LdCheckUserNameLog log=new LdCheckUserNameLog();
			log.setCreateTime(new Date());
			log.setMessageContent(msg);
			log.setSendDate(new Date());
			log.setType(1);
			log.setUid(lud.getUid());
			log.setUpdateTime(new Date());
			if("true".equals(msg)){
				MemberInfo info = memberInfoService.fQueryMemberInfoByUid(lud.getUid());
				if (info != null)
				{
					info.setRealName(realName);
					info.setIdcard(idcard);
					memberInfoService.updateRealName(info);
				} else
				{
					info = new MemberInfo();
					info.setRealName(realName);
					info.setIdcard(idcard);
					info.setUid(super.getLocalUser(request).getUid());
					info.setCreateTime(new Date());
					info.setUpdateTime(new Date());
					memberInfoService.addRealName(info);
				}
				memberService.updateIsRealName(lud.getUid());
				lud.setIsRealName("1");
				//实名认证奖励
				ldMemberRewardService.affordUserAward(UserAwardTypeEnum.REALNAMEBIND.getCode(), 
						lud.getUid(), super.getRemoteAddr(request), request);
				//刷新session
				MemberMoney memberMoney = iMemberMoney.queryMemberMoney(lud.getUid());
				if (memberMoney != null) {
					BigDecimal accountMoney = memberMoney.getAccountMoney();
					BigDecimal moneyFreeze = memberMoney.getMoneyFreeze();
					Money money=new Money(accountMoney,Currency.getInstance("CNY"));
					Money money1=new Money(moneyFreeze,Currency.getInstance("CNY"));
					Money bd=money.subtract(money1);
					lud.setMoneys(bd.getAmount());
					lud.setTotalScore(memberMoney.getTotalScore());
				}
				super.setLocalUser(request, lud);
				msgErr="success";
				log.setSendStatus("1");
				
				//	发送奖励码
				rewardCodeService.sendCode(lud.getUid());
			}else{
				if(msg.equals("false")){
					memberService.updateErrorCount(lud.getUid());
				}
				msgErr="认证异常，请联系客服！";
				log.setSendStatus("2");
			}
			ldCheckUserNameLogService.add(log);
		}else{
			if(list.size()>0){
				msgErr="numsCardErr";
			}else if(member.getErrorCount()>=3){
				msgErr="numsErr";
			}
			
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(msgErr);
	}

	/**
	 * 设置支付密码
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	@RequestMapping("/submitJy.htm")
	public void submitJy(HttpServletRequest request,
			HttpServletResponse response) throws IOException,
			NoSuchAlgorithmException
	{
		Members member = new Members();
		member.setUid(super.getLocalUser(request).getUid());
		member.setPayPass(SHAUtil.encryptSHA1(base64Encrypt.encrypt(request
				.getParameter("zeroPass"))));
		memberService.update(member);
		super.getLocalUser(request).setPayPass(member.getPayPass());
		response.getWriter().write("success");
	}
	/**
	 * 签到
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/submitSign.htm")
	@ResponseBody
	public String submitSign(HttpServletRequest request,
			HttpServletResponse response,HttpSession httpSession) throws IOException{
		if(httpSession.getAttribute("signTotal")!=null&&super.getLocalUser(request)!=null){
			Integer singTotal=Integer.valueOf(httpSession.getAttribute("signTotal").toString());
			return ldUserSignInLogService.addSign(request,singTotal);
		}
		return "error";
		
		
	}
	public void saveMembers(HttpServletRequest request, Map<String, Object> map)
	{
		Members member = memberService.fQueryNameByUid(super.getLocalUser(
				request).getUid());
		/*member.setUserEmail(map.get("user_email").toString());
		LocalUserDto lud = super.getLocalUser(request);
		lud.setUserEmail(map.get("user_email").toString());
		super.setLocalUser(request, lud);*/
		if(map.containsKey("user_name")){
			member.setUserName(map.get("user_name").toString());
		}
		memberService.update(member);
	}

	public void saveMemberInfo(HttpServletRequest request,
			Map<String, Object> map)
	{
		MemberInfo info = memberInfoService.fQueryMemberInfoByUid(super
				.getLocalUser(request).getUid());
		if (info == null)
		{
			info = new MemberInfo();
			info.setUid(super.getLocalUser(request).getUid());
			info.setSex("");
			info.setZy("");
			info.setInfo("");
			info.setMarry("");
			info.setEducation("");
			info.setIncome("");
			info.setAge(0);
			info.setIdcard("");
			info.setCardImg("");
			info.setRealName("");
			info.setAddress(map.get("address").toString());
			info.setProvince(map.get("province").toString());
			info.setCity(map.get("city").toString());
			info.setArea(map.get("area").toString());
			info.setUpdateTime(new Date());
			info.setBankCardNo("");
			info.setCreateTime(new Date());
			info.setCardBank("");
			info.setCardBranchBank("");
			info.setCanAuto(0);
			info.setQq(map.get("qq").toString());
			info.setHeadshotUrl("");
			memberInfoService.add(info);
		} else
		{
			info.setQq(map.get("qq").toString());
			info.setProvince(map.get("province").toString());
			info.setCity(map.get("city").toString());
			info.setArea(map.get("area").toString());
			info.setAddress(map.get("address").toString());
			info.setUpdateTime(new Date());
			memberInfoService.update(info);
		}
	}

	public void saveContactInfo(HttpServletRequest request,
			Map<String, Object> map)
	{
		LdMemberContactInfo contact = ldMemberContactInfoService
				.getContactInfo(super.getLocalUser(request).getUid());
		if (contact == null)
		{
			contact = new LdMemberContactInfo();
			contact.setUid(super.getLocalUser(request).getUid());
			contact.setTel("");
			contact.setAddress("");
			contact.setContact1(map.get("contact1").toString());
			contact.setContact1Re(map.get("contact1Re").toString());
			contact.setContact1Tel(map.get("contact1Tel").toString());
			contact.setMemo("");
			contact.setCreateTime(new Date());
			contact.setUpdateTime(new Date());
			ldMemberContactInfoService.add(contact);
		} else
		{
			contact.setContact1(map.get("contact1").toString());
			contact.setContact1Re(map.get("contact1Re").toString());
			contact.setContact1Tel(map.get("contact1Tel").toString());
			contact.setUpdateTime(new Date());
			ldMemberContactInfoService.update(contact);
		}
	}

	public String getSubPhone(String userPhone)
	{
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < userPhone.length() - 6; i++)
		{
			buffer.append("*");
		}
		return userPhone.substring(0, 3) + buffer.toString()
				+ userPhone.substring(8);
	}
	public String sendQuickPay(String idName,String idNum) throws Exception{
			String url=PropertiesRead.use_classLoador().getProperty("card.url");
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("accountName", idName);
			map.put("id", idNum);
			 Object jsonClose=JSONObject.toJSON(map);
			String data = DesUtil.encryptDES(jsonClose.toString(), CoreConstant.DES_KEY);
			System.out.println(data);
			HttpClient client = new HttpClient();
			client.setConnectionTimeout(10000);  
			PostMethod post = new PostMethod(url);
			post.addRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");//在头文件中设置转码
			NameValuePair[] datas = {new NameValuePair("dataGram", data)};
			post.setRequestBody(datas);
			int statusCode=0;
			try {
				client.executeMethod(post);
				statusCode=post.getStatusCode();
			} catch (Exception e) {
				// TODO: handle exception
			}
			String result="";
			if(statusCode != 200){
				JSONObject json=new JSONObject();
				json.put("msg", "认证异常,请联系客服！");
				result=json.toString();
			}else{
				result = new String(post.getResponseBodyAsString());
			}
			post.releaseConnection();
			return result;
		}
		
		//发送验证邮件
		@RequestMapping(value="/sendMail.htm")
		@ResponseBody
		public void sendMail(HttpServletRequest request, @RequestParam("email") String to) {
			LocalUserDto lud = super.getLocalUser(request);
			String content = MailUtil.createContent(lud.getUserPhone(),new Date(),to);
			content = content.replace("zhangbeiparam1", lud.getUserName());//设置用户名
			Mail mail = MailUtil.createMail(to,content);
			try {
				MailUtil.sendMail(mail);
				request.getSession().removeAttribute("code" + MessageVerifyCodeTypeEnum.VERIFY_EMAIL.getCode());
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}

		//跳转到相应的邮箱登录页
		@RequestMapping(value="/toMailLogin.htm")
		@ResponseBody
		public String toMailLogin(String email) {
			return MailUtil.toMailLogin(email);
		}
		
		//邮箱验证
		@RequestMapping(value="/mailVerify.htm")
		@ResponseBody
		public ModelAndView mailVerify(@RequestParam String param ,HttpServletRequest request) {
			boolean flag = false;//第一次绑定邮箱标识
			ModelAndView mav = new ModelAndView();
			String userValue = param.substring(param.indexOf("user="), param.indexOf("&time=")).replace("user=", "");
			String timeValue = param.substring(param.indexOf("&time="), param.indexOf("&mail=")).replace("&time=", "");
			String mailValue = param.substring(param.indexOf("&mail="), param.length()).replace("&mail=", "");
			String user = new String(Base64.decode(userValue));
			String time = new String(Base64.decode(timeValue));
			String mail = new String(Base64.decode(mailValue));
			Members members =  memberService.fquerybyphone(user);
			if(StringUtil.isEmpty(members.getUserEmail())) {
				flag = true;
			}
			if((new Date().getTime()-Long.parseLong(time)) > 86400000) {//大于24小时 86400000
				mav.setViewName("redirect:/person/editPerson.htm?mail=1");//验证超时
			}else {
				Members member = new Members();
				member.setUid(members.getUid());
				member.setUserEmail(mail);
				try {
					memberService.update(member);
					if(flag) {
						ldMemberRewardService.affordUserAward(UserAwardTypeEnum.EMAILBIND.getCode(),members.getUid(), super.getRemoteAddr(request), request);
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
				mav.setViewName("redirect:/person/editPerson.htm?mail=2");//验证成功
				members.setUserEmail(mail);
			}
			super.setLocalUser(request,super.getLocalUserDto(members,messageService));
			return mav;
		}
		/**
		 * 港澳台实名认证
		 * @param file
		 * @param mCheck
		 * @param request
		 * @param response
		 * @return
		 * @throws UnsupportedEncodingException 
		 * @throws InterruptedException 
		 */
		@RequestMapping(value="/submitHKAndMRealName.htm", method=RequestMethod.POST)
		public String submitHKAndMRealName(@ModelAttribute("mCheck") LdMemberCertificateCheck mCheck,HttpServletRequest request,HttpServletResponse response){
			mCheck.setUid(super.getLocalUser(request).getUid());
			mCheck.setCreateTime(new Date());
			mCheck.setUpdateTime(new Date());
			mCheck.setStatus(100);
			mCheck.setReason(null);
			ldMemberCertificateCheckService.add(mCheck);
			return "redirect:/person/editPerson.htm?headFlag=0";
		}
		/**
		 * 上传头像
		 * 
		 * @param file
		 * @param request
		 * @param response
		 * @throws IOException
		 */
		@RequestMapping("/uploadCard1.htm")
		@ResponseBody
		public String uploadCard1(@RequestParam("file1") MultipartFile file,
				HttpServletRequest request, HttpServletResponse response)
				throws IOException
				
		{
			Map<String,Object> map=new HashMap<String, Object>();
			//			支持文件格式
			String suffix = file.getOriginalFilename()
					.substring(file.getOriginalFilename().lastIndexOf("."));
			if (!FileUtil.isCorrectFormat(FileUtil.imgCard, suffix)) {
				map.put("msg", "err");
				return JSONObject.toJSONString(map);
			}
			
			//	支持文件大小
			if (!FileUtil.isCorrectSize(FileUtil.imgSize, file.getSize())) {
				map.put("msg", "err");
				return JSONObject.toJSONString(map);
			}
			String fileName=FileUtil.saveFile3(file, "image.card.url", request);
			map.put("fileName", fileName);
			map.put("url", PropertiesRead.use_classLoador().getProperty("image.card.ip")+fileName);
			map.put("msg", "success");
			return JSONObject.toJSONString(map);
		}
		/**
		 * 上传头像
		 * 
		 * @param file
		 * @param request
		 * @param response
		 * @throws IOException
		 */
		@RequestMapping("/uploadCard2.htm")
		@ResponseBody
		public String uploadCard2(@RequestParam("file2") MultipartFile file,
				HttpServletRequest request, HttpServletResponse response)
				throws IOException
		{
			Map<String,Object> map=new HashMap<String, Object>();
			//			支持文件格式
			String suffix = file.getOriginalFilename()
					.substring(file.getOriginalFilename().lastIndexOf("."));
			if (!FileUtil.isCorrectFormat(FileUtil.imgCard, suffix)) {
				map.put("msg", "err");
				return JSONObject.toJSONString(map);
			}
			
			//	支持文件大小
			if (!FileUtil.isCorrectSize(FileUtil.imgSize, file.getSize())) {
				map.put("msg", "err");
				return JSONObject.toJSONString(map);
			}
			String fileName=FileUtil.saveFile3(file, "image.card.url", request);
			map.put("fileName", fileName);
			map.put("url", PropertiesRead.use_classLoador().getProperty("image.card.ip")+fileName);
			map.put("msg", "success");
			return JSONObject.toJSONString(map);
		}
		/**
		 * 修改用户名
		 * @param request
		 * @param response
		 * @param userName
		 * @return
		 * @throws IOException
		 */
		@RequestMapping(value = "/checkName.htm", method = RequestMethod.POST)
		@ResponseBody
		public String checkName(HttpServletRequest request, HttpServletResponse response,
				String userName) throws IOException {
			Members m = memberService.login(userName);
			String msg = "";
			if (m != null) {
				msg = "err";
			} else {
				memberService.updateUserName(userName, super.getLocalUser(request).getUid());
				msg = "success";
			}
			return msg;
		}
	}
