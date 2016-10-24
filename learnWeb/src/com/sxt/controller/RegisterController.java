package com.sxt.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.models.LdUserSignInLog;
import com.sxt.models.MemberMoney;
import com.sxt.models.MemberReward;
import com.sxt.models.Members;
import com.sxt.service.Base64Encrypt;
import com.sxt.service.GenerateUid;
import com.sxt.service.LdMemberRewardService;
import com.sxt.service.LdUserSignInLogService;
import com.sxt.service.MemberInfoService;
import com.sxt.service.MemberMoneyService;
import com.sxt.service.MemberRecommenderDetailService;
import com.sxt.service.MemberService;
import com.sxt.service.MessageService;
import com.sxt.util.SingleOnline;

@Controller
@RequestMapping("/register")
public class RegisterController extends AbstractGeneralController {
	@Autowired
	private MemberService iMembers;
	@Autowired
	private GenerateUid generateUid;
	@Autowired
	private Base64Encrypt base64Encrypt;
	@Autowired
	private MemberMoneyService memberMoneyService;
	@Autowired
	private MemberInfoService memberInfoService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private LdMemberRewardService ldMemberRewardService;
	@Autowired
	private LdUserSignInLogService ldUserSignInLogService;
	@Autowired
	private MemberRecommenderDetailService memberRecommenderDetailService;

	@RequestMapping(value = "/register.htm", method = RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// 取form参数
		String user_phone = request.getParameter("user_phone").trim();

		String user_pass = request.getParameter("user_pass").trim();
		String recommender = request.getParameter("recommender").trim();
		Members member = iMembers.registor(user_phone, user_pass, recommender, null, request,
				super.getRemoteAddr(request));
		super.setLocalUser(request, super.getLocalUserDto(member, messageService));
		// 签到
		List<LdUserSignInLog> signList = ldUserSignInLogService.queryLdUserSignInLogList(member.getUid());
		if (signList.size() > 0) {
			super.getLocalUser(request).setSignFlag(1);
		} else {
			super.getLocalUser(request).setSignFlag(0);
		}
		// 获取用户签到的积分数值
		MemberReward reward = new MemberReward();
		reward.setPro_name("用户签到奖励");
		reward.setStatus("1");
		reward.setType(2);
		reward.setReward_type(3);
		List<MemberReward> rewardList = ldMemberRewardService.findMemberRewardList(reward);
		int signTotal = rewardList.size() == 0 ? 0 : rewardList.get(0).getPro_value();
		httpSession.setAttribute("signTotal", signTotal);
		httpSession.removeAttribute("code1");
		// 将SessionId+ip放入队列
		SingleOnline.addUser(member.getUid(), httpSession.getId() + "-" + super.getRemoteAddr(request));
	}

	@RequestMapping(value = "/checkMoblie.htm", method = RequestMethod.POST)
	@ResponseBody
	public String checkMobile(@RequestParam(value = "user_phone", required = true) String user_phone) {
		Members m = iMembers.fquerybyphone(user_phone);
		if (m != null) {
			if (m.getUserPhone().equals(user_phone)) {
				return "1";
			}
		}

		return "2";
	}

	@RequestMapping(value = "/checkName.htm", method = RequestMethod.POST)
	public void checkName(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "user_name", required = true) String user_name) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		Members m = iMembers.login(user_name);
		String msg = "";
		if (m != null) {
			msg = "err";
		} else {
			msg = "success";
		}
		response.getWriter().write(msg);
	}

	public MemberMoney addMoney(Integer uid) {
		MemberMoney money = new MemberMoney();
		money.setUid(uid);
		money.setAccountMoney(new BigDecimal("0.00"));
		money.setBackMoney(new BigDecimal("0.00"));
		money.setBorrowVouchCuse(new BigDecimal("0.00"));
		money.setBorrowVouchLimit(new BigDecimal("0.00"));
		money.setCanusemoney(new BigDecimal("0.00"));
		money.setCreateTime(new Date());
		money.setCreditCuse(new BigDecimal("0.00"));
		money.setCreditLimit(new BigDecimal("0.00"));
		money.setExperienceGold(new BigDecimal("0.00"));
		money.setFreeWithdraw(new BigDecimal("0.00"));
		money.setIncomeMoney(new BigDecimal("0.00"));
		money.setInvestVouchCuse(new BigDecimal("0.00"));
		money.setInvestVouchLimit(new BigDecimal("0.00"));
		money.setMoneyCollect(new BigDecimal("0.00"));
		money.setMoneyFreeze(new BigDecimal("0.00"));
		money.setTotalScore(0);
		money.setUpdateTime(new Date());
		return money;
	}

}
