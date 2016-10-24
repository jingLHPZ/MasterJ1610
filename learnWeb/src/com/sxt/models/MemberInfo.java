package com.sxt.models;

import java.io.Serializable;
import java.util.Date;

public class MemberInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uid;
	private String sex;
	private String zy;
	private String info;
	private String marry;
	private String education;
	private String income;
	private Integer age;
	private String idcard;
	private String cardImg;
	private String realName;
	private String address;
	private String province;
	private String city;
	private String area;
	private Date updateTime;
	private String bankCardNo;
	private Date createTime;
	private String cardBank;
	private String cardBranchBank;
	private Integer canAuto;
	private String qq;
	private String headshotUrl;
	private String twoDimensionCodeUrl;
	private Integer firstAddCard;
	private String thirdUserId;
	private Integer salesUid;
	private String extField;
	private Integer extField2;
	private Integer firstBuy;
	private String rewardTypeIds;
	
	private LdMemberCertificateCheck checkInfo;
	
	public LdMemberCertificateCheck getCheckInfo() {
		return checkInfo;
	}

	public void setCheckInfo(LdMemberCertificateCheck checkInfo) {
		this.checkInfo = checkInfo;
	}

	public String getThirdUserId() {
		return thirdUserId;
	}

	public void setThirdUserId(String thirdUserId) {
		this.thirdUserId = thirdUserId;
	}

	public String getTwoDimensionCodeUrl() {
		return twoDimensionCodeUrl;
	}

	public void setTwoDimensionCodeUrl(String twoDimensionCodeUrl) {
		this.twoDimensionCodeUrl = twoDimensionCodeUrl;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getMarry() {
		return marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getCardImg() {
		return cardImg;
	}

	public void setCardImg(String cardImg) {
		this.cardImg = cardImg;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCardBank() {
		return cardBank;
	}

	public void setCardBank(String cardBank) {
		this.cardBank = cardBank;
	}

	public String getCardBranchBank() {
		return cardBranchBank;
	}

	public void setCardBranchBank(String cardBranchBank) {
		this.cardBranchBank = cardBranchBank;
	}

	public Integer getCanAuto() {
		return canAuto;
	}

	public void setCanAuto(Integer canAuto) {
		this.canAuto = canAuto;
	}

	public String getHeadshotUrl() {
		return headshotUrl;
	}

	public void setHeadshotUrl(String headshotUrl) {
		this.headshotUrl = headshotUrl;
	}

	public Integer getFirstAddCard() {
		return firstAddCard;
	}

	public void setFirstAddCard(Integer firstAddCard) {
		this.firstAddCard = firstAddCard;
	}

	public Integer getSalesUid() {
		return salesUid;
	}

	public void setSalesUid(Integer salesUid) {
		this.salesUid = salesUid;
	}

	public String getExtField() {
		return extField;
	}

	public void setExtField(String extField) {
		this.extField = extField;
	}

	public Integer getExtField2() {
		return extField2;
	}

	public void setExtField2(Integer extField2) {
		this.extField2 = extField2;
	}

	public Integer getFirstBuy() {
		return firstBuy;
	}

	public void setFirstBuy(Integer firstBuy) {
		this.firstBuy = firstBuy;
	}

	public String getRewardTypeIds() {
		return rewardTypeIds;
	}

	public void setRewardTypeIds(String rewardTypeIds) {
		this.rewardTypeIds = rewardTypeIds;
	}


	
}
