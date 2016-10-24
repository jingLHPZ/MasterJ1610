package com.sxt.models;

import java.math.BigDecimal;
import java.util.Date;

public class CashAccount {
	private static final long serialVersionUID = 1L;
	
    private Integer id;

    private Integer uid;

    private BigDecimal accountMoney;

    private BigDecimal cashFreeze;

    private BigDecimal cashIncome;
    
    private BigDecimal cashYesterIncome;

    private Integer cashStatus;

    private Date createTime;

    private Date updateTime;

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

    public BigDecimal getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(BigDecimal accountMoney) {
        this.accountMoney = accountMoney;
    }

    public BigDecimal getCashFreeze() {
        return cashFreeze;
    }

    public void setCashFreeze(BigDecimal cashFreeze) {
        this.cashFreeze = cashFreeze;
    }

    public BigDecimal getCashIncome() {
        return cashIncome;
    }

    public void setCashIncome(BigDecimal cashIncome) {
        this.cashIncome = cashIncome;
    }

    public BigDecimal getCashYesterIncome() {
		return cashYesterIncome;
	}

	public void setCashYesterIncome(BigDecimal cashYesterIncome) {
		this.cashYesterIncome = cashYesterIncome;
	}

	public Integer getCashStatus() {
        return cashStatus;
    }

    public void setCashStatus(Integer cashStatus) {
        this.cashStatus = cashStatus;
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
}