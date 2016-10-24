package com.sxt.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.sxt.base.annotation.AvoidDuplicateSubmission;
import com.sxt.enums.AllInPayStatusEnum;
import com.sxt.enums.AllInPayTypeEnum;
import com.sxt.enums.MessageVerifyCodeTypeEnum;
import com.sxt.enums.UserAwardTypeEnum;
import com.sxt.inter.ILdMemberBankCardInfo;
import com.sxt.inter.IMemberInfo;
import com.sxt.inter.IMembers;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.models.BankInfo;
import com.sxt.models.LdAllInPayTransactionDetail;
import com.sxt.models.LdMemberBankCardInfo;
import com.sxt.models.MemberInfo;
import com.sxt.models.Members;
import com.sxt.models.dto.QuickPaymentDto;
import com.sxt.models.thirdInteraction.TransactionResponseQP0002;
import com.sxt.service.BankInfoService;
import com.sxt.service.Base64Encrypt;
import com.sxt.service.LdMemberBankCardInfoService;
import com.sxt.service.LdMemberRewardService;
import com.sxt.service.LdRewardCodeService;
import com.sxt.service.MemberInfoService;
import com.sxt.service.MemberMoneyService;
import com.sxt.service.MemberRecommenderDetailService;
import com.sxt.service.MemberService;
import com.sxt.service.MemberWithdrawService;
import com.sxt.service.QuickPaymentService;
import com.sxt.tonglian.PayQuery;
import com.sxt.tonglian.SinglePay;
import com.sxt.tonglian.dto.PayQueryRequestDto;
import com.sxt.tonglian.dto.PayQueryResponseDto;
import com.sxt.tonglian.dto.SinglePayRequestDto;
import com.sxt.util.CoreConstant;
import com.sxt.util.Money;
import com.sxt.util.SHAUtil;
import com.sxt.util.StringUtil;

@Controller
@RequestMapping("bankcard")
public class MemberInfoController extends AbstractGeneralController
{
	private static Logger logger = LoggerFactory.getLogger(MemberInfoController.class);
	
	@Autowired
	private MemberInfoService memberInfoService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private BankInfoService bankInfoService;
	@Autowired
	private LdMemberRewardService ldMemberRewardService;
	@Autowired
	private Base64Encrypt base64Encrypt;
	@Autowired
	private MemberRecommenderDetailService memberRecDetailService;
	@Autowired
	private MemberWithdrawService memberWithdrawService;
	@Autowired
	private QuickPaymentService quickPaymentService;
	@Autowired
	private MemberMoneyService memberMoneyService;
	@Autowired
	private LdMemberBankCardInfoService ldMemberBankCardInfoService;
	@Autowired
	private ILdMemberBankCardInfo iLdMemberBankCardInfo;
	@Autowired
	private IMemberInfo iMemberInfo;
	@Autowired
	private IMembers iMembers;
	@Autowired
	private LdRewardCodeService rewardCodeService;
	
	@RequestMapping("fquerybank.htm")
	@AvoidDuplicateSubmission(needSaveToken = true)
	public ModelAndView fquerybank(HttpServletRequest request) 	{
		ModelAndView mav = new ModelAndView("member/bankCard");
		LocalUserDto lud = super.getLocalUser(request);

		List<BankInfo> bankinfolist = bankInfoService.fquerybankinfo();
		mav.addObject("bankinfolist", bankinfolist);
		if(lud==null){
			return null;
		}
	    if (lud.getIsRealName().equals("1")) {
			MemberInfo memberinfo = memberInfoService.fQueryMemberInfoByUid(lud.getUid());
			if (lud.getIsAddCard().equals("0"))	{// 没有绑定银行卡
				//通联绑卡状态
				boolean status = false;
				LdAllInPayTransactionDetail allInPayDto = ldMemberBankCardInfoService.getAllInPayByUid(lud.getUid());
				if(allInPayDto != null && AllInPayStatusEnum.PAYING.getCode().equals(allInPayDto.getStatus())) {
					status = true;
					mav.addObject("handleStatus","process");
				}
				if(request.getParameter("display")!=null && !status){
					mav.addObject("display", true);
					mav.addObject("memberInfo", memberinfo);
				}
			}else {// 绑定了银行卡,显示信息
//				String str = memberinfo.getBankCardNo();
				LdMemberBankCardInfo bankCardInfo = new LdMemberBankCardInfo();
				bankCardInfo.setUid(lud.getUid());
				bankCardInfo.setStatus(1);
				bankCardInfo = ldMemberBankCardInfoService.selectByUidAndStatusAndCardNo(bankCardInfo);
				if(bankCardInfo != null) {
					String str = bankCardInfo.getBankCardNo();
					int a = str.length() - 7;
					StringBuffer buffer = new StringBuffer();
					for (int i = 0; i < a; i++)	{
						buffer.append("*");
					}
					String sumStr = str.substring(0, 3) + buffer.toString()+ str.substring(str.length() - 4, str.length());
					bankCardInfo.setBankCardNo(sumStr);
					mav.addObject("cardCode",str);
					mav.addObject("memberinfo", memberinfo);
					mav.addObject("bankCardInfo",bankCardInfo);
				}
			}
		} else {
				mav.addObject("realname","meiyou");
		}
	    Members member = memberService.fQueryNameByUid(lud.getUid());
		if(StringUtil.isEmpty(member.getPayPass())) {
			mav.addObject("pass", "false");
		}else {
			mav.addObject("pass", "true");
		}
		return mav;
	}
	
	/**
	 * 银行卡绑定
	 * @param request
	 * @param memberInfo
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("fAddMemberInfo.htm")
	@ResponseBody
	@AvoidDuplicateSubmission(needRemoveToken = true) 
	public String fAddMemberInfo(HttpServletRequest request, MemberInfo memberInfo,
			HttpServletResponse response) throws IOException {
		
		String ip = super.getRemoteAddr(request);
		LocalUserDto lud = super.getLocalUser(request);
		if(lud==null) { return null; }
		JSONObject resultMap = new JSONObject();
		//	已经实名认证
		if(lud.getIsRealName().equals("1")) {
			if (memberInfo != null) {
				String reqSn = SinglePay.makeSystemTraceNo(lud.getUid().toString());
				logger.info("绑卡生成交易号reqSn:" + reqSn);
//				查询登录用户信息
		    	memberInfo = memberInfoService.fQueryMemberInfoByUid(lud.getUid());
		    	//实时代付
		    	SinglePayRequestDto singlePayRequestDto = new SinglePayRequestDto();
		    	singlePayRequestDto.setReqSn(reqSn);
		    	singlePayRequestDto.setBankCode(request.getParameter("cardBank"));
		    	singlePayRequestDto.setAccountType("00");//银行卡
		    	singlePayRequestDto.setAccountNo(request.getParameter("bankCardNo"));
		    	singlePayRequestDto.setAccountName(memberInfo.getRealName());
		    	singlePayRequestDto.setAccountProp("0");//私人
		    	singlePayRequestDto.setAmount(1L);
//		    	singlePayRequestDto.setIdType(request.getParameter("credentialsType"));
//		    	singlePayRequestDto.setId(request.getParameter("idcard"));
		    	singlePayRequestDto.setIdType("");
		    	singlePayRequestDto.setId("");
		    	singlePayRequestDto.setCustUserid(lud.getUid().toString());
		    	//通联明细
		    	Money amount = new Money("0.01");
	    		LdAllInPayTransactionDetail transactionDetail = new LdAllInPayTransactionDetail();
	    		transactionDetail.setAmount(amount.getAmount());
	    		transactionDetail.setBankCardNo(request.getParameter("bankCardNo"));
	    		transactionDetail.setBusinessCode("09400");
	    		transactionDetail.setCreateTime(new Date());
	    		transactionDetail.setIdNo(memberInfo.getIdcard());
	    		transactionDetail.setIdType(0);
	    		transactionDetail.setMobilePhone(lud.getUserPhone());
	    		transactionDetail.setRemark("绑卡实时代付");
	    		transactionDetail.setReqSn(reqSn);
	    		transactionDetail.setUid(lud.getUid());
	    		transactionDetail.setUpdateTime(new Date());
	    		transactionDetail.setStatus(AllInPayStatusEnum.PAYING.getCode());
	    		transactionDetail.setRealName(memberInfo.getRealName());
	    		transactionDetail.setType(AllInPayTypeEnum.BINDKARD.getCode());
	    		logger.info("查询登录用户信息：" + memberInfo.getUid());
	    		PayQueryResponseDto responseDto = ldMemberBankCardInfoService.bindCard(singlePayRequestDto, transactionDetail ,lud);
	    		String result = "";
				if(responseDto != null) {
					result = PayQuery.codeConvertResult(responseDto.getRetCode2());
				}
				if(responseDto == null) {
					result = "fail";
					responseDto = new PayQueryResponseDto();
					responseDto.setErrMsg2("接口异常");
				}
				LdMemberBankCardInfo bankCardInfo = new LdMemberBankCardInfo();
				bankCardInfo.setUid(lud.getUid());
				bankCardInfo.setProvince(request.getParameter("province"));
				bankCardInfo.setCity(request.getParameter("city"));
				bankCardInfo.setArea(request.getParameter("area"));
				bankCardInfo.setUpdateTime(new Date());
				bankCardInfo.setBankCardNo(request.getParameter("bankCardNo"));
				bankCardInfo.setCreateTime(new Date());
				bankCardInfo.setCardBank(request.getParameter("bankName"));
				bankCardInfo.setCardBranchBank(request.getParameter("cardBranchBank"));
				if("success".equals(result)) {
		    		Members members = new Members();
					members.setUid(lud.getUid());
					members.setIsAddCard("1");
					bankCardInfo.setStatus(1);
					//新增银行卡信息，更新绑卡状态，更新是否第一次绑卡状态
					memberInfoService.updateBankCardByUid(members,memberInfo,bankCardInfo,request,ip);
					lud.setIsAddCard("1");
					super.setLocalUser(request, lud);
					resultMap.put("type", "success");
//					resultMap.put("type", "redirect");
//					resultMap.put("url", "/bankcard/fquerybank.htm");
					super.refreshSessionValue(memberMoneyService, request);
					
					rewardCodeService.sendCode(lud.getUid());
				} else if("fail".equals(result)){
					resultMap.put("type", "fail");
//					resultMap.put("type", "tips");
//					resultMap.put("msg", responseDto.getErrMsg2());
				} else {
		    		bankCardInfo.setStatus(0);
		    		iLdMemberBankCardInfo.insertBankCardInfo(bankCardInfo);
		    		resultMap.put("type", "process");
//		    		resultMap.put("type", "redirect");
//					resultMap.put("url", "/bankcard/fquerybank.htm");
				}
			}
		}else {
			//	未实名认证
			resultMap.put("url", "/person/editPerson.htm");
			resultMap.put("type", "redirect");
		}
		response.setCharacterEncoding("utf-8");
	    response.getWriter().write(JSONObject.toJSONString(resultMap));
	    return null;
	}
	
	/**
	 * 获取手机动态验证码
	 * @param request
	 * @param response
	 * @param dataGram
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/dynamicAuthentication", method = RequestMethod.POST)
    @ResponseBody
    public String dynamicAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		JSONObject resultMap = new JSONObject();
		
        try {
        	LocalUserDto userDto = getLocalUser(request);
        	if (userDto == null) {
        		resultMap.put("error","请登录后再绑定银行卡");
        	}
        	
        	//	查询登录用户信息
        	MemberInfo memberInfo = memberInfoService.fQueryMemberInfoByUid(userDto.getUid());
        	
        	String cardNo = request.getParameter("cardNo");
        	String bankNo = request.getParameter("bankNo");
        	/*String credentialsType = request.getParameter("credentialsType");
        	String idCard = request.getParameter("idcard");*/
        	String storableCardNo = cardNo.substring(0, 6) + cardNo.substring(cardNo.length() - 4, cardNo.length());
        	
        	if (StringUtil.isEmpty(userDto.getUserPhone())) {
        		resultMap.put("error","用户还未绑定手机号！");
        	} else {
        		//	组装发送短信数据
        		QuickPaymentDto paymentDto = new QuickPaymentDto();
        		paymentDto.setCustId(userDto.getUid().toString());
        		paymentDto.setCustIdNo(memberInfo.getIdcard());
        		paymentDto.setCustName(memberInfo.getRealName());
        		paymentDto.setCustIdType("0");
        		paymentDto.setCardNo(cardNo);
        		paymentDto.setStorableCardNo(storableCardNo);
        		paymentDto.setBankNo(bankNo);
        		paymentDto.setAmount("5");
        		paymentDto.setPhoneNo(userDto.getUserPhone());
        		TransactionResponseQP0002 transactionResponseQP0002 = quickPaymentService.sendDynamicAuthentication(paymentDto);
        		
        		if (transactionResponseQP0002 != null 
        				&& transactionResponseQP0002.getRespCode().equals(CoreConstant.RESP_CODE)) {
        			
        			//	返回订单号和手机校验码令牌
        			resultMap.put("merOrderId", transactionResponseQP0002.getMerOrderId());
        			resultMap.put("phoneToken", transactionResponseQP0002.getPhoneToken());
        		} else {
        			resultMap.put("error",transactionResponseQP0002.getRespMsg());
        		}
        	}
        } catch (Exception e) {
            logger.error(e.getMessage());
            resultMap.put("error","服务器忙，请稍后再试");
        }
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(JSONObject.toJSONString(resultMap));
        return null;
    }
	
	//解绑银行卡
	@RequestMapping(value="/unbindCard.htm")
	@ResponseBody
	public String unbindCard(HttpServletRequest request,HttpServletResponse response, String payPass,String bankCard,HttpSession session) 
			throws NoSuchAlgorithmException, IOException {
		logger.info("解绑银行卡，银行卡号：" + bankCard);
		LocalUserDto lud = super.getLocalUser(request);
		String pwd = SHAUtil.encryptSHA1(base64Encrypt.encrypt(payPass));// 加密后的交易密码
		Members member = memberService.fQueryNameByUid(lud.getUid());
		JSONObject json = new JSONObject();
		if(member != null) {
			if(pwd.equals(member.getPayPass())) {
				json.put("payPass","success");
			}else {
				json.put("payPass","fail");
				return json.toJSONString(); 
			}
		}
		//提现待审核不可解绑
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("uid", lud.getUid());
		param.put("bandCardNo", bankCard);
		List withdrawList =  memberWithdrawService.getWithdrawByStatus(param);
		if(withdrawList != null && withdrawList.size() > 0) {
			json.put("withDraw","fail");
			return json.toJSONString();
		}
		LdMemberBankCardInfo bankCardInfo = new LdMemberBankCardInfo();
		bankCardInfo.setUid(lud.getUid());
		bankCardInfo.setBankCardNo(bankCard);
		bankCardInfo.setStatus(0);
		try {
			ldMemberBankCardInfoService.updateBankCardInfoByUidAndStatus(bankCardInfo);
			Members members = new Members();
			members.setUid(lud.getUid());
			members.setIsAddCard("0");
			memberService.update(members);
			lud.setIsAddCard("0");
			setLocalUser(request, lud);
			json.put("result", "success");
			request.getSession().removeAttribute("code" + MessageVerifyCodeTypeEnum.DELETE_BANK_CARD.getCode());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return json.toJSONString();
	}
	
	@RequestMapping(value="/getAllInPayStatus.htm")
	@ResponseBody
	public String getAllInPayStatus(HttpServletRequest request) {
		String ip = super.getRemoteAddr(request);
		String convertResult = null;
		LocalUserDto lud = super.getLocalUser(request);
		LdAllInPayTransactionDetail allInPayDto = ldMemberBankCardInfoService.getAllInPayByUid(lud.getUid());
		if(allInPayDto != null && AllInPayStatusEnum.PAYING.getCode().equals(allInPayDto.getStatus())) {
			//绑卡处理中
			PayQueryRequestDto requestDto = new PayQueryRequestDto();
			requestDto.setReqSn(allInPayDto.getReqSn());
			try {
				List<PayQueryResponseDto> responseList = PayQuery.payQuery(requestDto);
				if(responseList != null && responseList.size() > 0) {
					PayQueryResponseDto responseDto = responseList.get(0);
					if(responseDto != null) {
						logger.info("查询通联接口，获取返回code:" + responseDto.getRetCode2());
						convertResult = PayQuery.codeConvertResult(responseDto.getRetCode2());
						if(convertResult == null) {//处理中
							return convertResult;
						}
						LdAllInPayTransactionDetail updateDetail = new LdAllInPayTransactionDetail();
						updateDetail.setId(allInPayDto.getId());
						updateDetail.setUpdateTime(new Date());
						updateDetail.setRemark(responseDto.getErrMsg2());
						if("success".equals(convertResult)) {
							MemberInfo memberInfo = memberInfoService.fQueryMemberInfoByUid(lud.getUid());
							updateDetail.setStatus(AllInPayStatusEnum.SUCCESS.getCode());
							ldMemberBankCardInfoService.updateMemberMoneyAndDetail(lud);
							LdMemberBankCardInfo bankCardInfo = new LdMemberBankCardInfo();
							bankCardInfo.setBankCardNo(allInPayDto.getBankCardNo());
							ldMemberBankCardInfoService.updateMemberBankCardInfoByCardNo(bankCardInfo);
							//银行卡绑定奖励
							ldMemberRewardService.affordUserAward(UserAwardTypeEnum.BANKCARDBIND.getCode(),memberInfo.getUid(), ip, request);
							//推荐好友银行卡绑定奖励
							ldMemberRewardService.affordUserAward(UserAwardTypeEnum.RECOBANKCARDBIND.getCode(),memberInfo.getUid(), ip, request);
							memberInfo.setFirstAddCard(1);
							iMemberInfo.update(memberInfo);
							Members members = new Members();
							members.setUid(lud.getUid());
							members.setIsAddCard("1");
							iMembers.update(members);
							lud.setIsAddCard("1");
						}
						if("fail".equals(convertResult)) {
							updateDetail.setStatus(AllInPayStatusEnum.FAILURE.getCode());
						}
						iLdMemberBankCardInfo.updateAllInPayTransactionDetail(updateDetail);
						super.setLocalUser(request, lud);
						super.refreshSessionValue(memberMoneyService, request);
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return convertResult;
	}
}
