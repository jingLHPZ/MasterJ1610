package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BorrowPlan implements Serializable{

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
	
	
}
