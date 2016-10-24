package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SiProductDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String productId;
	private Integer borrowType;
	private Date datetime;
	private String addIp;
	private String borrowInfo;
	private Integer total;
	private BigDecimal hasPay;
	private BigDecimal substituteMoney;
	private Float rewardVouchRate;
	private BigDecimal rewardVouchMoney;
	private Integer rewardType;
	private BigDecimal rewardMin;
	private Float rewardValue;
	private BigDecimal investMin;
	private BigDecimal investMax;
	private Integer vouchMember;
	private String password;
	private Integer isRecommend;
	private Integer canAuto;
	private String informationDisclosure;
	private Integer vouchUid;
	private BigDecimal vouchMoney;
	private BigDecimal autoMaxLimit;
	private String riskControl;
	private Date updateTime;
	private Float expiredRate;
	private Integer rewardTotalScore;
	private BigDecimal rewardExperienceGold;
	private Integer rewardWay;
	private Integer canBonus;
	private Integer canAddInterest;
	private Integer contractType;
	private Integer increaseProgressively;
	private String extField;
	private Integer extField2;
	private Integer version;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getBorrowType() {
		return borrowType;
	}

	public void setBorrowType(Integer borrowType) {
		this.borrowType = borrowType;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	
	public String getAddIp() {
		return addIp;
	}

	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}

	public String getBorrowInfo() {
		return borrowInfo;
	}

	public void setBorrowInfo(String borrowInfo) {
		this.borrowInfo = borrowInfo;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public BigDecimal getHasPay() {
		return hasPay;
	}

	public void setHasPay(BigDecimal hasPay) {
		this.hasPay = hasPay;
	}

	public BigDecimal getSubstituteMoney() {
		return substituteMoney;
	}

	public void setSubstituteMoney(BigDecimal substituteMoney) {
		this.substituteMoney = substituteMoney;
	}

	public Float getRewardVouchRate() {
		return rewardVouchRate;
	}

	public void setRewardVouchRate(Float rewardVouchRate) {
		this.rewardVouchRate = rewardVouchRate;
	}

	public BigDecimal getRewardVouchMoney() {
		return rewardVouchMoney;
	}

	public void setRewardVouchMoney(BigDecimal rewardVouchMoney) {
		this.rewardVouchMoney = rewardVouchMoney;
	}

	public Integer getRewardType() {
		return rewardType;
	}

	public void setRewardType(Integer rewardType) {
		this.rewardType = rewardType;
	}

	public BigDecimal getRewardMin() {
		return rewardMin;
	}

	public void setRewardMin(BigDecimal rewardMin) {
		this.rewardMin = rewardMin;
	}

	public Float getRewardValue() {
		return rewardValue;
	}

	public void setRewardValue(Float rewardValue) {
		this.rewardValue = rewardValue;
	}

	public BigDecimal getInvestMin() {
		return investMin;
	}

	public void setInvestMin(BigDecimal investMin) {
		this.investMin = investMin;
	}

	public BigDecimal getInvestMax() {
		return investMax;
	}

	public void setInvestMax(BigDecimal investMax) {
		this.investMax = investMax;
	}

	public Integer getVouchMember() {
		return vouchMember;
	}

	public void setVouchMember(Integer vouchMember) {
		this.vouchMember = vouchMember;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Integer getCanAuto() {
		return canAuto;
	}

	public void setCanAuto(Integer canAuto) {
		this.canAuto = canAuto;
	}

	public String getInformationDisclosure() {
		return informationDisclosure;
	}

	public void setInformationDisclosure(String informationDisclosure) {
		this.informationDisclosure = informationDisclosure;
	}

	public Integer getVouchUid() {
		return vouchUid;
	}

	public void setVouchUid(Integer vouchUid) {
		this.vouchUid = vouchUid;
	}

	public BigDecimal getVouchMoney() {
		return vouchMoney;
	}

	public void setVouchMoney(BigDecimal vouchMoney) {
		this.vouchMoney = vouchMoney;
	}

	public BigDecimal getAutoMaxLimit() {
		return autoMaxLimit;
	}

	public void setAutoMaxLimit(BigDecimal autoMaxLimit) {
		this.autoMaxLimit = autoMaxLimit;
	}

	public String getRiskControl() {
		return riskControl;
	}

	public void setRiskControl(String riskControl) {
		this.riskControl = riskControl;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Float getExpiredRate() {
		return expiredRate;
	}

	public void setExpiredRate(Float expiredRate) {
		this.expiredRate = expiredRate;
	}

	public Integer getRewardTotalScore() {
		return rewardTotalScore;
	}

	public void setRewardTotalScore(Integer rewardTotalScore) {
		this.rewardTotalScore = rewardTotalScore;
	}

	public BigDecimal getRewardExperienceGold() {
		return rewardExperienceGold;
	}

	public void setRewardExperienceGold(BigDecimal rewardExperienceGold) {
		this.rewardExperienceGold = rewardExperienceGold;
	}

	public Integer getRewardWay() {
		return rewardWay;
	}

	public void setRewardWay(Integer rewardWay) {
		this.rewardWay = rewardWay;
	}

	public Integer getCanBonus() {
		return canBonus;
	}

	public void setCanBonus(Integer canBonus) {
		this.canBonus = canBonus;
	}

	public Integer getCanAddInterest() {
		return canAddInterest;
	}

	public void setCanAddInterest(Integer canAddInterest) {
		this.canAddInterest = canAddInterest;
	}

	public Integer getContractType() {
		return contractType;
	}

	public void setContractType(Integer contractType) {
		this.contractType = contractType;
	}

	public Integer getIncreaseProgressively() {
		return increaseProgressively;
	}

	public void setIncreaseProgressively(Integer increaseProgressively) {
		this.increaseProgressively = increaseProgressively;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
