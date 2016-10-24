package com.sxt.inter.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户投资记录
 * 
 * @version 1.0.0
 */
public class InvestRecordDto implements Serializable
{

	private static final long serialVersionUID = 1L;
	/** 产品id */
	private String productId;
	/** 产品名 */
	private String productName;
	/** 加入时间 */
	private Date createTime;
	/** 投资本金 */
	private BigDecimal investorCapital;
	/** 投资利率 */
	private Float borrowInterestRate;
	/** 投资跟踪号 */
	private String systemTraceNo;
	/** 投资期限 天数 */
	private Integer borrowDayDuration;
	/** 投资期限 月数 */
	private Integer borrowMonthDuration;
	/** 加息 */
	private BigDecimal proValue;
	/** 投资状态 */
	private Integer borrowStatus;
	/**投资利息**/
	private BigDecimal investorInterest;
	/**类型*/
	private int type;
	/**还款类型 */
	private Integer repaymentType;
	
	private BigDecimal affectExperienceGold;
	
	private Integer productAdaptedType;
	
	private Date lastTime;
	
	private Integer investLimit;

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

	public Float getBorrowInterestRate() {
		return borrowInterestRate;
	}

	public void setBorrowInterestRate(Float borrowInterestRate) {
		this.borrowInterestRate = borrowInterestRate;
	}

	public String getSystemTraceNo() {
		return systemTraceNo;
	}

	public void setSystemTraceNo(String systemTraceNo) {
		this.systemTraceNo = systemTraceNo;
	}

	public Integer getBorrowDayDuration() {
		return borrowDayDuration;
	}

	public void setBorrowDayDuration(Integer borrowDayDuration) {
		this.borrowDayDuration = borrowDayDuration;
	}

	public Integer getBorrowMonthDuration() {
		return borrowMonthDuration;
	}

	public void setBorrowMonthDuration(Integer borrowMonthDuration) {
		this.borrowMonthDuration = borrowMonthDuration;
	}

	public BigDecimal getProValue() {
		return proValue;
	}

	public void setProValue(BigDecimal proValue) {
		this.proValue = proValue;
	}

	public Integer getBorrowStatus() {
		return borrowStatus;
	}

	public void setBorrowStatus(Integer borrowStatus) {
		this.borrowStatus = borrowStatus;
	}

	public BigDecimal getInvestorInterest() {
		return investorInterest;
	}

	public void setInvestorInterest(BigDecimal investorInterest) {
		this.investorInterest = investorInterest;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Integer getRepaymentType() {
		return repaymentType;
	}

	public void setRepaymentType(Integer repaymentType) {
		this.repaymentType = repaymentType;
	}

	public BigDecimal getAffectExperienceGold() {
		return affectExperienceGold;
	}

	public void setAffectExperienceGold(BigDecimal affectExperienceGold) {
		this.affectExperienceGold = affectExperienceGold;
	}

	public Integer getProductAdaptedType() {
		return productAdaptedType;
	}

	public void setProductAdaptedType(Integer productAdaptedType) {
		this.productAdaptedType = productAdaptedType;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Integer getInvestLimit() {
		return investLimit;
	}

	public void setInvestLimit(Integer investLimit) {
		this.investLimit = investLimit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
