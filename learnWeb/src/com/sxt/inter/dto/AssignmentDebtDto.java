package com.sxt.inter.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 债权转让
 *
 */
public class AssignmentDebtDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String systemTraceNo;
	
	private String productId;
	//产品名称
	private String productName;
	//债权ID
	private Integer investorUid;
	//预期年化率
	private Float borrowInterestRate;
	//剩余期数
	private Integer restTime;
	//剩余待收
	private BigDecimal restMoney;
	//下个还款日
	private Date nextRepaymentTime;
	//还款类型
	private Integer repaymentType;
	//加息券
	private Float proValue;
	//转让价格
	private BigDecimal debtPrice;
	//手续费
	private BigDecimal charges;
	//转让成功时间
	private Date createTime;
	//投资额
	private BigDecimal investorCapital;
	//投资利息
	private BigDecimal investorInterest;
	//剩余还款天数
	private Integer restDays;
	//还款总期数
	private Integer totalTime;
	//还款状态
	private Integer status;
	//最后还款期
	private Date deadLine;
	//下一期还款日
	private Date nextpayDate;
	//截止日期
	private Date downDate;
	//借款总时间
	private Integer borrowDays;
	//转让开始时间
	private Date updateTime;
	
	private Integer debtStatus;
	
	private Integer productType;
	//认购利率
	private Float subscriptionRate;
	//奖励类型
	private Integer rewardType;
	//加息券系统跟踪号
	private String rewardTraceNo;
	//满标时间
	private Date fullTime;
	//剩余待收本金
	private BigDecimal capital;
	//剩余待收利息
	private BigDecimal interest;
	//折让率
	private String extField;

	public String getSystemTraceNo() {
		return systemTraceNo;
	}

	public void setSystemTraceNo(String systemTraceNo) {
		this.systemTraceNo = systemTraceNo;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getInvestorUid() {
		return investorUid;
	}

	public void setInvestorUid(Integer investorUid) {
		this.investorUid = investorUid;
	}

	public Float getBorrowInterestRate() {
		return borrowInterestRate;
	}

	public void setBorrowInterestRate(Float borrowInterestRate) {
		this.borrowInterestRate = borrowInterestRate;
	}

	public Integer getRestTime() {
		return restTime;
	}

	public void setRestTime(Integer restTime) {
		this.restTime = restTime;
	}

	public BigDecimal getRestMoney() {
		return restMoney;
	}

	public void setRestMoney(BigDecimal restMoney) {
		this.restMoney = restMoney;
	}

	public Date getNextRepaymentTime() {
		return nextRepaymentTime;
	}

	public void setNextRepaymentTime(Date nextRepaymentTime) {
		this.nextRepaymentTime = nextRepaymentTime;
	}

	public Integer getRepaymentType() {
		return repaymentType;
	}

	public void setRepaymentType(Integer repaymentType) {
		this.repaymentType = repaymentType;
	}

	public Float getProValue() {
		return proValue;
	}

	public void setProValue(Float proValue) {
		this.proValue = proValue;
	}

	public BigDecimal getDebtPrice() {
		return debtPrice;
	}

	public void setDebtPrice(BigDecimal debtPrice) {
		this.debtPrice = debtPrice;
	}

	public BigDecimal getCharges() {
		return charges;
	}

	public void setCharges(BigDecimal charges) {
		this.charges = charges;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getInvestorCapital() {
		return investorCapital;
	}

	public void setInvestorCapital(BigDecimal investorCapital) {
		this.investorCapital = investorCapital;
	}

	public BigDecimal getInvestorInterest() {
		return investorInterest;
	}

	public void setInvestorInterest(BigDecimal investorInterest) {
		this.investorInterest = investorInterest;
	}

	public Integer getRestDays() {
		return restDays;
	}

	public void setRestDays(Integer restDays) {
		this.restDays = restDays;
	}

	public Integer getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getNextpayDate() {
		return nextpayDate;
	}

	public void setNextpayDate(Date nextpayDate) {
		this.nextpayDate = nextpayDate;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public Date getDownDate() {
		return downDate;
	}

	public void setDownDate(Date downDate) {
		this.downDate = downDate;
	}

	public Integer getBorrowDays() {
		return borrowDays;
	}

	public void setBorrowDays(Integer borrowDays) {
		this.borrowDays = borrowDays;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDebtStatus() {
		return debtStatus;
	}

	public void setDebtStatus(Integer debtStatus) {
		this.debtStatus = debtStatus;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public Float getSubscriptionRate() {
		return subscriptionRate;
	}

	public void setSubscriptionRate(Float subscriptionRate) {
		this.subscriptionRate = subscriptionRate;
	}

	public Integer getRewardType() {
		return rewardType;
	}

	public void setRewardType(Integer rewardType) {
		this.rewardType = rewardType;
	}

	public String getRewardTraceNo() {
		return rewardTraceNo;
	}

	public void setRewardTraceNo(String rewardTraceNo) {
		this.rewardTraceNo = rewardTraceNo;
	}

	public Date getFullTime() {
		return fullTime;
	}

	public void setFullTime(Date fullTime) {
		this.fullTime = fullTime;
	}

	public BigDecimal getCapital() {
		return capital;
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public String getExtField() {
		return extField;
	}

	public void setExtField(String extField) {
		this.extField = extField;
	}
	
}
