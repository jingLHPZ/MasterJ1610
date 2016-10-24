package com.sxt.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sxt.enums.MessageTypeEnum;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.inter.dto.MemberMoneyDto;
import com.sxt.models.Members;
import com.sxt.service.MemberMoneyService;
import com.sxt.service.MessageService;
import com.sxt.util.Money;
import com.sxt.util.PropertiesRead;

/**
 * pillar liu 
 * 
 * @version 1.0.0
 */
public abstract class AbstractGeneralController {

	private static Log logger = LogFactory.getLog(AbstractGeneralController.class);
	
	public static final Integer DEFAULT_PAGE_NO = 1;
	
	public static final Integer DEFAULT_PAGE_SIZE = 15;
	
	private static final int year = 365;
	
	/**
	 * Get the current user information
	 * 
	 * @param request
	 * @return
	 */
	protected LocalUserDto getLocalUser(HttpServletRequest request) {
		LocalUserDto localUserDto = (LocalUserDto) request.getSession(true).getAttribute("localUser");
		logger.debug("Get local user =" + localUserDto);
		return localUserDto;
	}

	/**
	 * Set the local user object to session
	 * 
	 * @param request
	 * @param localUserDto
	 */
	protected void setLocalUser(HttpServletRequest request, LocalUserDto localUserDto) {
		request.getSession(true).removeAttribute("localUser");
		request.getSession(true).setAttribute("localUser", localUserDto);
	}
	
	/**
	 * 获取客户端IP地址
	 * 
	 * @param request
	 * @return
	 */
	protected String getRemoteAddr(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("x-client-ip");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
					ipAddress = inet.getHostAddress();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}

			}
		}
		// 多级反向代理
		if (null != ipAddress && !"".equals(ipAddress.trim())) {
			StringTokenizer st = new StringTokenizer(ipAddress, ",");
			if (st.countTokens() > 1) {
				ipAddress = st.nextToken();
			}
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = "获取不到客户端IP请检查网络配置";
		}
		return ipAddress;
	}
	/**
	 * 保存登录信息到 session
	 * @param member
	 * @return
	 */
	
	protected LocalUserDto getLocalUserDto(Members member,MessageService messageService){
		LocalUserDto dto = new LocalUserDto();
		dto.setUid(member.getUid());
		dto.setUserName(member.getUserName());
		dto.setUserPhone(member.getUserPhone());
		dto.setUserType(member.getUserType());
		dto.setIsAddCard(member.getIsAddCard());
		dto.setIsRealName(member.getIsRealName());
		dto.setIsVip(member.getIsVip());
		dto.setMoneys(member.getMoneys());
		dto.setUserEmail(member.getUserEmail());
		if(member.getInfo()!=null){
			dto.setHeadshotUrl(member.getInfo().getHeadshotUrl()==null||"".equals(member.getInfo().getHeadshotUrl())?"":PropertiesRead.use_classLoador().getProperty("image.ip")+member.getInfo().getHeadshotUrl());
		}else{
			dto.setHeadshotUrl("");
		}
		dto.setTotalScore(member.getTotalScore());
		dto.setPayPass(member.getPayPass());
		int message=messageService.fQueryMessagebyUid(member.getUid());
		dto.setMessage(message);
		return dto;
	}
	/**
	 * 刷新session 值
	 * @param memberMoneyService
	 * @param userDto
	 * @param request
	 */
	protected void refreshSessionValue(MemberMoneyService memberMoneyService,HttpServletRequest request){
		LocalUserDto userDto = this.getLocalUser(request);
		MemberMoneyDto memDto = memberMoneyService.queryMemberMoney(userDto.getUid());
		if (memDto != null)
		{
			Money accountmoney=new Money(memDto.getAccountMoney(),Currency.getInstance("CNY"));
			Money freezemoney=new Money(memDto.getMoneyFreeze(),Currency.getInstance("CNY"));
			BigDecimal canuse=accountmoney.subtract(freezemoney).getAmount();
			userDto.setMoneys(canuse);
			userDto.setTotalScore(memDto.getTotalScore());
			userDto.setExperienceGold(memDto.getExperienceGold());
			setLocalUser(request, userDto);
		}
	}
	
	/**
	 * 修改站内信时  更新 session
	 * @param messageService
	 * @param request
	 */
	protected void refreshUserSession(MessageService messageService, HttpServletRequest request){
		LocalUserDto userDto = this.getLocalUser(request);
		if(userDto != null){
			userDto.setMessage(messageService.fQueryMessagebyUid(userDto.getUid()));
			setLocalUser(request, userDto);
		}
	}
	/**
	 * 投资时发送短信
	 * @param memberMoneyService
	 * @param messageService
	 * @param member
	 * @param productId
	 * @param localUser
	 */
	protected void sendMessageForInvestment(MessageService messageService,String productId, LocalUserDto localUser){
		Map<String, Object> para = new HashMap<String, Object>();
		para.put("userName", localUser.getUserName());
		para.put("id", productId);
		para.put("money", new Money(localUser.getMoneys()));
		messageService.sendMessage(localUser.getUserPhone(), MessageTypeEnum.BID_SUC, para, localUser.getUid().toString());
	}
	
	/**
	 * @param borrowDays 天
	 * @param borrowMonths 月
	 * @param interestRate 利率
	 * @return
	 */
	protected BigDecimal calculateIncome(Integer borrowDays,Integer borrowMonths,BigDecimal moeny, float interestRate){
		BigDecimal lvs = new BigDecimal(interestRate); //利率
		Integer period = borrowDays == null?borrowMonths:borrowDays;//借款期限
		long cycle = borrowDays == null?12:year;//周期
		BigDecimal income = ((moeny.multiply(lvs).multiply(new BigDecimal(period))).divide(new BigDecimal(cycle), 2, RoundingMode.HALF_UP));
		return income;
	}
	
	/**
	 * 新手标 体验标 专用
	 * @param days
	 * @return
	 */
	protected Date getProductEndTime(Integer days){
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(new Date());//把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, days + 1); 
		return calendar.getTime();
	}
	
	
}
