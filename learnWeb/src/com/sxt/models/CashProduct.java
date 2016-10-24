package com.sxt.models;

import java.math.BigDecimal;

public class CashProduct {
	private static final long serialVersionUID = 1L;
	
    private Integer id;

    private BigDecimal moneyLimit;

    private Integer collectStatus;

    private String borrowPhone;

    private Integer borrowUid;

    private BigDecimal investMax;

    private BigDecimal investMin;

    private BigDecimal increaseProgressively;

    private String productContract;
    
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoneyLimit() {
        return moneyLimit;
    }

    public void setMoneyLimit(BigDecimal moneyLimit) {
        this.moneyLimit = moneyLimit;
    }

    public Integer getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(Integer collectStatus) {
        this.collectStatus = collectStatus;
    }

    public String getBorrowPhone() {
        return borrowPhone;
    }

    public void setBorrowPhone(String borrowPhone) {
        this.borrowPhone = borrowPhone;
    }

    public Integer getBorrowUid() {
        return borrowUid;
    }

    public void setBorrowUid(Integer borrowUid) {
        this.borrowUid = borrowUid;
    }

    public BigDecimal getInvestMax() {
        return investMax;
    }

    public void setInvestMax(BigDecimal investMax) {
        this.investMax = investMax;
    }

    public BigDecimal getInvestMin() {
        return investMin;
    }

    public void setInvestMin(BigDecimal investMin) {
        this.investMin = investMin;
    }

    public BigDecimal getIncreaseProgressively() {
        return increaseProgressively;
    }

    public void setIncreaseProgressively(BigDecimal increaseProgressively) {
        this.increaseProgressively = increaseProgressively;
    }

	public String getProductContract() {
		return productContract;
	}

	public void setProductContract(String productContract) {
		this.productContract = productContract;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}