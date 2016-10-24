package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RepaymentDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date repaymentTime;
	private String productId;
	private String systemTraceNo;
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
	private Integer returnType;
	private Date realReturnDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRepaymentTime() {
		return repaymentTime;
	}

	public void setRepaymentTime(Date repaymentTime) {
		this.repaymentTime = repaymentTime;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSystemTraceNo() {
		return systemTraceNo;
	}

	public void setSystemTraceNo(String systemTraceNo) {
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

	public Integer getReturnType() {
		return returnType;
	}

	public void setReturnType(Integer returnType) {
		this.returnType = returnType;
	}

	public Date getRealReturnDate() {
		return realReturnDate;
	}

	public void setRealReturnDate(Date realReturnDate) {
		this.realReturnDate = realReturnDate;
	}

}
