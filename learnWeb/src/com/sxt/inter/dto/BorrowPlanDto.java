package com.sxt.inter.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BorrowPlanDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date repaymentTime;
	private String productId;
	private Integer borrowUid;
	private BigDecimal capital;
	private BigDecimal interest;
	private BigDecimal interestFee;
	private Integer status;
	private Integer sortOrder;
	private Integer total;
	private Integer productType;
	private String productName;
	private Integer borrowStatus;
	private Integer borrowMonthDuration;
	private Integer borrowDayDuration;
	private Float borrowInterestRate;
	private BigDecimal borrowMoney;
	private Date deadline;
	private Integer repaymentType;
	private BigDecimal realPayMoney;
	private Date realReturnDate;
	
	
	public Integer getProductType() {
		return productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	public  Integer getId() {
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getBorrowStatus() {
		return borrowStatus;
	}
	public void setBorrowStatus(Integer borrowStatus) {
		this.borrowStatus = borrowStatus;
	}
	public BorrowPlanDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BorrowPlanDto(BigDecimal capital, BigDecimal interest) {
		super();
		this.capital = capital;
		this.interest = interest;
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
	public Float getBorrowInterestRate() {
		return borrowInterestRate;
	}
	public void setBorrowInterestRate(Float borrowInterestRate) {
		this.borrowInterestRate = borrowInterestRate;
	}
	public BigDecimal getBorrowMoney() {
		return borrowMoney;
	}
	public void setBorrowMoney(BigDecimal borrowMoney) {
		this.borrowMoney = borrowMoney;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Integer getRepaymentType() {
		return repaymentType;
	}
	public void setRepaymentType(Integer repaymentType) {
		this.repaymentType = repaymentType;
	}
	public BigDecimal getRealPayMoney() {
		return realPayMoney;
	}
	public void setRealPayMoney(BigDecimal realPayMoney) {
		this.realPayMoney = realPayMoney;
	}
	public Date getRealReturnDate() {
		return realReturnDate;
	}
	public void setRealReturnDate(Date realReturnDate) {
		this.realReturnDate = realReturnDate;
	}
	
}
