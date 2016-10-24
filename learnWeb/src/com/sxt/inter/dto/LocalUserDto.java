package com.sxt.inter.dto;

import java.math.BigDecimal;


/**
 * 用户登录信息 LocalUserDto pillar liu
 * 
 * @version 1.0.0
 */
public class LocalUserDto  extends AbstractDto{
	
	private static final long serialVersionUID = 7760854434803988338L;
	
	/** 会员号 */
	private Integer uid;
	/** 会员类型 */
	private Integer userType;
	/** 用户名 */
	private String userName;
	/** 手机号 */
	private String userPhone;
	/** 是否实名 1为实名  */
	private String isRealName;
	/** 是否绑定银行卡 1 绑定*/
	private String isAddCard;
	/** 是否vip 1 vip */
	private String isVip;
	/** 头像 */
	private String headshotUrl;
	/** 积分 */
	private Integer totalScore;
	/** 可用余额  */
	private BigDecimal moneys;
	/** 是否有站内消息*/
	private Integer message;
	/** 是否签到*/
	private Integer signFlag;
	/**
	 * 体验金
	 */
	
	private BigDecimal experienceGold;
	private String payPass;
	/**是否绑定邮箱*/
	private String userEmail;
	/**抽奖次数*/
	private Integer luckyDrawCount;
	/**再抽一次标识*/
	private Integer luckyDrawFlag;
	
	public Integer getLuckyDrawFlag() {
		return luckyDrawFlag;
	}
	public void setLuckyDrawFlag(Integer luckyDrawFlag) {
		this.luckyDrawFlag = luckyDrawFlag;
	}
	public Integer getLuckyDrawCount() {
		return luckyDrawCount;
	}
	public void setLuckyDrawCount(Integer luckyDrawCount) {
		this.luckyDrawCount = luckyDrawCount;
	}
	public String getUserEmail()
	{
		return userEmail;
	}
	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}
	public String getPayPass() {
		return payPass;
	}
	public void setPayPass(String payPass) {
		this.payPass = payPass;
	}
	public int getMessage()
	{
		return message;
	}
	public void setMessage(int message)
	{
		this.message = message;
	}
	public BigDecimal getExperienceGold() {
		return experienceGold;
	}
	public void setExperienceGold(BigDecimal experienceGold) {
		this.experienceGold = experienceGold;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	
	public String getHeadshotUrl() {
		return headshotUrl;
	}
	public void setHeadshotUrl(String headshotUrl) {
		this.headshotUrl = headshotUrl;
	}
	
	
	public BigDecimal getMoneys() {
		return moneys;
	}
	public void setMoneys(BigDecimal moneys) {
		this.moneys = moneys;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getIsRealName() {
		return isRealName;
	}
	public void setIsRealName(String isRealName) {
		this.isRealName = isRealName;
	}
	public String getIsAddCard() {
		return isAddCard;
	}
	public void setIsAddCard(String isAddCard) {
		this.isAddCard = isAddCard;
	}
	public String getIsVip() {
		return isVip;
	}
	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}
	public Integer getSignFlag() {
		return signFlag;
	}
	public void setSignFlag(Integer signFlag) {
		this.signFlag = signFlag;
	}
	
}
