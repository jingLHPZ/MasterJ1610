package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Members implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userName;
	private String userPass;
	private Integer userType;
	private String payPass;
	private String userEmail;
	private String userPhone;
	private Date regTime;
	private String isRealName;
	private String isAddCard;
	private String isVip;
	private String status;
	private Integer uid;
	private String recommender;
	private String promotionperson;
	private Integer errorCount;
	private MemberInfo info;
	private LdMemberContactInfo contact;
	//展示
	private Integer jobNumber;
	private Integer investorNums;
	
	

	public Integer getInvestorNums() {
		return investorNums;
	}

	public void setInvestorNums(Integer investorNums) {
		this.investorNums = investorNums;
	}

	public Integer getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(Integer jobNumber) {
		this.jobNumber = jobNumber;
	}

	public Integer getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}

	public MemberInfo getInfo() {
		return info;
	}

	public void setInfo(MemberInfo info) {
		this.info = info;
	}

	public LdMemberContactInfo getContact() {
		return contact;
	}

	public void setContact(LdMemberContactInfo contact) {
		this.contact = contact;
	}

	private BigDecimal moneys;
	
	private Integer totalScore;
	

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public BigDecimal getMoneys() {
		return moneys;
	}

	public void setMoneys(BigDecimal moneys) {
		this.moneys = moneys;
	}

	public String getPromotionperson() {
		return promotionperson;
	}

	public void setPromotionperson(String promotionperson) {
		this.promotionperson = promotionperson;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRecommender() {
		return recommender;
	}

	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getPayPass() {
		return payPass;
	}

	public void setPayPass(String payPass) {
		this.payPass = payPass;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}



	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
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

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	
	public Members() {
		super();
	}
}
