package com.sxt.models;

import java.io.Serializable;
import java.util.Date;

public class LdProductExtendInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String productId;
	private String productName;
	private String systemTraceNo;
	private Integer investUid;
	private Float borrowInterestRate;
	private Integer investLimit;
	private Date createTime;
	private Date updateTime;
	private Integer productAdaptedType;
	
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
	public Integer getInvestUid() {
		return investUid;
	}
	public void setInvestUid(Integer investUid) {
		this.investUid = investUid;
	}
	public Float getBorrowInterestRate() {
		return borrowInterestRate;
	}
	public void setBorrowInterestRate(Float borrowInterestRate) {
		this.borrowInterestRate = borrowInterestRate;
	}
	public Integer getInvestLimit() {
		return investLimit;
	}
	public void setInvestLimit(Integer investLimit) {
		this.investLimit = investLimit;
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
	public Integer getProductAdaptedType() {
		return productAdaptedType;
	}
	public void setProductAdaptedType(Integer productAdaptedType) {
		this.productAdaptedType = productAdaptedType;
	}
	public String getSystemTraceNo() {
		return systemTraceNo;
	}
	public void setSystemTraceNo(String systemTraceNo) {
		this.systemTraceNo = systemTraceNo;
	}

}
