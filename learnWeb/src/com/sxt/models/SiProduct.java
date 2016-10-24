package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SiProduct  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String productId;
	private String productName;
	private Integer borrowUid;
	private Integer borrowMonthDuration;
	private Integer borrowDayDuration;
	private BigDecimal borrowMoney;
	private BigDecimal borrowInterest;
	private Float borrowInterestRate;
	private BigDecimal borrowFee;
	private BigDecimal repaymentMoney;
	private BigDecimal repaymentInterest;
	private BigDecimal expiredMoney;
	private Integer repaymentType;
	private Integer borrowType;
	private Float borrowProceduresRate;
	private Integer borrowStatus;
	private String contractID;
	private Date createTime;
	private Date updateTime;
	private Date collectStartTime;
	private Date fullTime;
	private Date deadline;
	private Date checkTime;
	private String contractTemplate;
	private String checkUser;
	private String checkUser2;
	private Date checkTime2;
	private BigDecimal investFee;
	private Float investRate;
	private Date collectEndTime;
	private BigDecimal surplusmon;
	private BigDecimal caninvest;
	private Integer borrowDays;
	private Integer borrowId;
	private String ciProductId;
	private Integer interestWay;

	// 另外加的列
	private BigDecimal investorcapital;
	private BigDecimal investorinterest;

	// 1为可用红包,0为不可用红包
	private Integer canBonus;// 是否允许使用红包
	// 1为可用加息券 0为不可用加息券
	private Integer canAddInterest;// 是否允许使用加息券

	public BigDecimal getInvestorcapital() {
		return investorcapital;
	}

	public void setInvestorcapital(BigDecimal investorcapital) {
		this.investorcapital = investorcapital;
	}

	public BigDecimal getInvestorinterest() {
		return investorinterest;
	}

	public void setInvestorinterest(BigDecimal investorinterest) {
		this.investorinterest = investorinterest;
	}

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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getBorrowUid() {
		return borrowUid;
	}

	public void setBorrowUid(Integer borrowUid) {
		this.borrowUid = borrowUid;
	}

	public Integer getBorrowMonthDuration() {
		return borrowMonthDuration;
	}

	public void setBorrowMonthDuration(Integer borrowMonthDuration) {
		this.borrowMonthDuration = borrowMonthDuration;
	}

	public Integer getBorrowDayDuration() {
		return borrowDayDuration;
	}

	public void setBorrowDayDuration(Integer borrowDayDuration) {
		this.borrowDayDuration = borrowDayDuration;
	}

	public BigDecimal getBorrowMoney() {
		return borrowMoney;
	}

	public void setBorrowMoney(BigDecimal borrowMoney) {
		this.borrowMoney = borrowMoney;
	}

	public BigDecimal getBorrowInterest() {
		return borrowInterest;
	}

	public void setBorrowInterest(BigDecimal borrowInterest) {
		this.borrowInterest = borrowInterest;
	}

	public Float getBorrowInterestRate() {
		return borrowInterestRate;
	}

	public void setBorrowInterestRate(Float borrowInterestRate) {
		this.borrowInterestRate = borrowInterestRate;
	}

	public BigDecimal getBorrowFee() {
		return borrowFee;
	}

	public void setBorrowFee(BigDecimal borrowFee) {
		this.borrowFee = borrowFee;
	}

	public BigDecimal getRepaymentMoney() {
		return repaymentMoney;
	}

	public void setRepaymentMoney(BigDecimal repaymentMoney) {
		this.repaymentMoney = repaymentMoney;
	}

	public BigDecimal getRepaymentInterest() {
		return repaymentInterest;
	}

	public void setRepaymentInterest(BigDecimal repaymentInterest) {
		this.repaymentInterest = repaymentInterest;
	}

	public BigDecimal getExpiredMoney() {
		return expiredMoney;
	}

	public void setExpiredMoney(BigDecimal expiredMoney) {
		this.expiredMoney = expiredMoney;
	}

	public Integer getRepaymentType() {
		return repaymentType;
	}

	public void setRepaymentType(Integer repaymentType) {
		this.repaymentType = repaymentType;
	}

	public Integer getBorrowType() {
		return borrowType;
	}

	public void setBorrowType(Integer borrowType) {
		this.borrowType = borrowType;
	}

	public Float getBorrowProceduresRate() {
		return borrowProceduresRate;
	}

	public void setBorrowProceduresRate(Float borrowProceduresRate) {
		this.borrowProceduresRate = borrowProceduresRate;
	}

	public Integer getBorrowStatus() {
		return borrowStatus;
	}

	public void setBorrowStatus(Integer borrowStatus) {
		this.borrowStatus = borrowStatus;
	}

	public String getContractID() {
		return contractID;
	}

	public void setContractID(String contractID) {
		this.contractID = contractID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCollectStartTime() {
		return collectStartTime;
	}

	public void setCollectStartTime(Date collectStartTime) {
		this.collectStartTime = collectStartTime;
	}

	public Date getFullTime() {
		return fullTime;
	}

	public void setFullTime(Date fullTime) {
		this.fullTime = fullTime;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getContractTemplate() {
		return contractTemplate;
	}

	public void setContractTemplate(String contractTemplate) {
		this.contractTemplate = contractTemplate;
	}

	public String getCheckUser() {
		return checkUser;
	}

	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}

	public String getCheckUser2() {
		return checkUser2;
	}

	public void setCheckUser2(String checkUser2) {
		this.checkUser2 = checkUser2;
	}

	public Date getCheckTime2() {
		return checkTime2;
	}

	public void setCheckTime2(Date checkTime2) {
		this.checkTime2 = checkTime2;
	}

	public BigDecimal getInvestFee() {
		return investFee;
	}

	public void setInvestFee(BigDecimal investFee) {
		this.investFee = investFee;
	}

	public Float getInvestRate() {
		return investRate;
	}

	public void setInvestRate(Float investRate) {
		this.investRate = investRate;
	}

	public Date getCollectEndTime() {
		return collectEndTime;
	}

	public void setCollectEndTime(Date collectEndTime) {
		this.collectEndTime = collectEndTime;
	}

	public BigDecimal getSurplusmon() {
		return surplusmon;
	}

	public void setSurplusmon(BigDecimal surplusmon) {
		this.surplusmon = surplusmon;
	}

	public BigDecimal getCaninvest() {
		return caninvest;
	}

	public void setCaninvest(BigDecimal caninvest) {
		this.caninvest = caninvest;
	}

	public Integer getBorrowDays() {
		return borrowDays;
	}

	public void setBorrowDays(Integer borrowDays) {
		this.borrowDays = borrowDays;
	}

	public Integer getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(Integer borrowId) {
		this.borrowId = borrowId;
	}

	public String getCiProductId() {
		return ciProductId;
	}

	public void setCiProductId(String ciProductId) {
		this.ciProductId = ciProductId;
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

	public Integer getInterestWay() {
		return interestWay;
	}

	public void setInterestWay(Integer interestWay) {
		this.interestWay = interestWay;
	}
	
}
