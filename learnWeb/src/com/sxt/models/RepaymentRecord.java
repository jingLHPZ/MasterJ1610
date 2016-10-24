package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RepaymentRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Float id;
	private Date repaymentTime;
	private CiProduct  ciProduct;
	private Integer systemTraceNo;
	private Integer investorUid;
	private Integer borrowUid;
	private BigDecimal capital;
	private BigDecimal interest;
	private BigDecimal interestFee;
	private Integer status;
	private BigDecimal receiveInterest;
	private BigDecimal receiveCapital;
	private Integer sortOrder;
	private Integer total;
	private Date deadline;
	private BigDecimal expiredMoney;
	private Integer expiredDays;
	private BigDecimal callFee;
	private BigDecimal substituteMoney;
	private Date substituteTime;
	public Float getId() {
		return id;
	}
	public void setId(Float id) {
		this.id = id;
	}
	public Date getRepaymentTime() {
		return repaymentTime;
	}
	public void setRepaymentTime(Date repaymentTime) {
		this.repaymentTime = repaymentTime;
	}
	public CiProduct getCiProduct() {
		return ciProduct;
	}
	public void setCiProduct(CiProduct ciProduct) {
		this.ciProduct = ciProduct;
	}
	public Integer getSystemTraceNo() {
		return systemTraceNo;
	}
	public void setSystemTraceNo(Integer systemTraceNo) {
		this.systemTraceNo = systemTraceNo;
	}
	public Integer getInvestorUid() {
		return investorUid;
	}
	public void setInvestorUid(Integer investorUid) {
		this.investorUid = investorUid;
	}
	public Integer getBorrowUid() {
		return borrowUid;
	}
	public void setBorrowUid(Integer borrowUid) {
		this.borrowUid = borrowUid;
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
	public BigDecimal getInterestFee() {
		return interestFee;
	}
	public void setInterestFee(BigDecimal interestFee) {
		this.interestFee = interestFee;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public BigDecimal getReceiveInterest() {
		return receiveInterest;
	}
	public void setReceiveInterest(BigDecimal receiveInterest) {
		this.receiveInterest = receiveInterest;
	}
	public BigDecimal getReceiveCapital() {
		return receiveCapital;
	}
	public void setReceiveCapital(BigDecimal receiveCapital) {
		this.receiveCapital = receiveCapital;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public BigDecimal getExpiredMoney() {
		return expiredMoney;
	}
	public void setExpiredMoney(BigDecimal expiredMoney) {
		this.expiredMoney = expiredMoney;
	}
	public Integer getExpiredDays() {
		return expiredDays;
	}
	public void setExpiredDays(Integer expiredDays) {
		this.expiredDays = expiredDays;
	}
	public BigDecimal getCallFee() {
		return callFee;
	}
	public void setCallFee(BigDecimal callFee) {
		this.callFee = callFee;
	}
	public BigDecimal getSubstituteMoney() {
		return substituteMoney;
	}
	public void setSubstituteMoney(BigDecimal substituteMoney) {
		this.substituteMoney = substituteMoney;
	}
	public Date getSubstituteTime() {
		return substituteTime;
	}
	public void setSubstituteTime(Date substituteTime) {
		this.substituteTime = substituteTime;
	}
	
}
