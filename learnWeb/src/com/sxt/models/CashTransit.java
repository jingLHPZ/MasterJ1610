package com.sxt.models;

import java.math.BigDecimal;
import java.util.Date;

public class CashTransit {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer uid;
	
	private BigDecimal cashMoney;
	
	private Date createTime;
	
	private Date updateTime;
	
	private Integer cashType;
	
	private Integer cashStatus;
	
	private Integer checkUid;
	
	private String specialDate;
	
	private String systemTraceNo;
	
	private String remark;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public BigDecimal getCashMoney() {
		return cashMoney;
	}

	public void setCashMoney(BigDecimal cashMoney) {
		this.cashMoney = cashMoney;
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

	public Integer getCashType() {
		return cashType;
	}

	public void setCashType(Integer cashType) {
		this.cashType = cashType;
	}

	public Integer getCashStatus() {
		return cashStatus;
	}

	public void setCashStatus(Integer cashStatus) {
		this.cashStatus = cashStatus;
	}

	public Integer getCheckUid() {
		return checkUid;
	}

	public void setCheckUid(Integer checkUid) {
		this.checkUid = checkUid;
	}

	public String getSpecialDate() {
		return specialDate;
	}

	public void setSpecialDate(String specialDate) {
		this.specialDate = specialDate;
	}

	public String getSystemTraceNo() {
		return systemTraceNo;
	}

	public void setSystemTraceNo(String systemTraceNo) {
		this.systemTraceNo = systemTraceNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
