package com.sxt.models;

import java.math.BigDecimal;
import java.util.Date;

public class CashAccountDetailDto {
	private static final long serialVersionUID = 1L;
	
    private Integer id;

    private Integer cashId;

    private Integer rateId;
    
    private Integer uid;

    private BigDecimal cashAmount;

    private BigDecimal cashIncome;

    private Date cashTime;

    private Float cashRate;

    private Integer cashType;

    private Integer cashStatus;
    
    private Float cashAvgRate;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCashId() {
        return cashId;
    }

    public void setCashId(Integer cashId) {
        this.cashId = cashId;
    }

    public Integer getRateId() {
		return rateId;
	}

	public void setRateId(Integer rateId) {
		this.rateId = rateId;
	}

	public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    public BigDecimal getCashIncome() {
        return cashIncome;
    }

    public void setCashIncome(BigDecimal cashIncome) {
        this.cashIncome = cashIncome;
    }

    public Date getCashTime() {
        return cashTime;
    }

    public void setCashTime(Date cashTime) {
        this.cashTime = cashTime;
    }

    public Float getCashRate() {
        return cashRate;
    }

    public void setCashRate(Float cashRate) {
        this.cashRate = cashRate;
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

	public Float getCashAvgRate() {
		return cashAvgRate;
	}

	public void setCashAvgRate(Float cashAvgRate) {
		this.cashAvgRate = cashAvgRate;
	}

}