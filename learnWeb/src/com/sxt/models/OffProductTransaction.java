package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OffProductTransaction implements Serializable{
	
	private static final long serialVersionUID = 3741096855558693472L;
	private Integer id;
	private Integer uid;
	private String productName;
	private String userName;
	private Integer borrowMonthDuration;
	private Integer borrowDayDuration;
	private BigDecimal investMoney;
	private Float investInterestRate;
	private Integer repaymentType;
	private BigDecimal freezeMoney;
	private String investPhone;
	private Date createTime;
	private Date updateTime;
	private Date valueDate;
	private Date lastReturnTime;
	private Integer borrowDays;
	private BigDecimal income;
	private Integer borrowDuration;

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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public BigDecimal getInvestMoney() {
		return investMoney;
	}

	public void setInvestMoney(BigDecimal investMoney) {
		this.investMoney = investMoney;
	}

	public Float getInvestInterestRate() {
		return investInterestRate;
	}

	public void setInvestInterestRate(Float investInterestRate) {
		this.investInterestRate = investInterestRate;
	}

	public Integer getRepaymentType() {
		return repaymentType;
	}

	public void setRepaymentType(Integer repaymentType) {
		this.repaymentType = repaymentType;
	}

	public BigDecimal getFreezeMoney() {
		return freezeMoney;
	}

	public void setFreezeMoney(BigDecimal freezeMoney) {
		this.freezeMoney = freezeMoney;
	}

	public String getInvestPhone() {
		return investPhone;
	}

	public void setInvestPhone(String investPhone) {
		this.investPhone = investPhone;
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

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public Date getLastReturnTime() {
		return lastReturnTime;
	}

	public void setLastReturnTime(Date lastReturnTime) {
		this.lastReturnTime = lastReturnTime;
	}

	public Integer getBorrowDays() {
		return borrowDays;
	}

	public void setBorrowDays(Integer borrowDays) {
		this.borrowDays = borrowDays;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public Integer getBorrowDuration() {
		return borrowDuration;
	}

	public void setBorrowDuration(Integer borrowDuration) {
		this.borrowDuration = borrowDuration;
	}


}
