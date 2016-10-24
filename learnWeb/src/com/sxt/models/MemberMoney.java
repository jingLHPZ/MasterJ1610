package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.sxt.base.utils.MemberMoneyHelper;
import com.sxt.enums.AdminAccountEnum;

public class MemberMoney implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uid;
	private BigDecimal moneyFreeze;
	private BigDecimal moneyCollect;
	private BigDecimal accountMoney;
	private BigDecimal backMoney;
	private BigDecimal creditLimit;
	private BigDecimal creditCuse;
	private BigDecimal borrowVouchLimit;
	private BigDecimal borrowVouchCuse;
	private BigDecimal investVouchLimit;
	private BigDecimal investVouchCuse;
	private Integer totalScore;
	private Date createTime;
	private Date updateTime;
	private BigDecimal experienceGold;
	private BigDecimal incomeMoney;
	private BigDecimal freeWithdraw;
    private BigDecimal canusemoney = BigDecimal.ZERO;
    private Integer version;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public BigDecimal getMoneyFreeze() {
		return moneyFreeze;
	}
	public void setMoneyFreeze(BigDecimal moneyFreeze) {
		this.moneyFreeze = moneyFreeze;
		if(AdminAccountEnum.getByCode(this.uid) == null){
			MemberMoneyHelper.checkAmount(moneyFreeze, "冻结余额不足");
			this.moneyFreeze = moneyFreeze;
		}
	}
	public BigDecimal getMoneyCollect() {
		return moneyCollect;
	}
	public void setMoneyCollect(BigDecimal moneyCollect) {
		this.moneyCollect = moneyCollect;
	}
	public BigDecimal getAccountMoney() {
		return accountMoney;
	}
	public void setAccountMoney(BigDecimal accountMoney) {
		this.accountMoney = accountMoney;
		if(AdminAccountEnum.getByCode(this.uid) == null){
			MemberMoneyHelper.checkAmount(accountMoney, "余额不足");
			this.accountMoney = accountMoney;
		}
	}
	public BigDecimal getBackMoney() {
		return backMoney;
	}
	public void setBackMoney(BigDecimal backMoney) {
		this.backMoney = backMoney;
	}
	public BigDecimal getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}
	public BigDecimal getCreditCuse() {
		return creditCuse;
	}
	public void setCreditCuse(BigDecimal creditCuse) {
		this.creditCuse = creditCuse;
	}
	public BigDecimal getBorrowVouchLimit() {
		return borrowVouchLimit;
	}
	public void setBorrowVouchLimit(BigDecimal borrowVouchLimit) {
		this.borrowVouchLimit = borrowVouchLimit;
	}
	public BigDecimal getBorrowVouchCuse() {
		return borrowVouchCuse;
	}
	public void setBorrowVouchCuse(BigDecimal borrowVouchCuse) {
		this.borrowVouchCuse = borrowVouchCuse;
	}
	public BigDecimal getInvestVouchLimit() {
		return investVouchLimit;
	}
	public void setInvestVouchLimit(BigDecimal investVouchLimit) {
		this.investVouchLimit = investVouchLimit;
	}
	public BigDecimal getInvestVouchCuse() {
		return investVouchCuse;
	}
	public void setInvestVouchCuse(BigDecimal investVouchCuse) {
		this.investVouchCuse = investVouchCuse;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
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
	public BigDecimal getExperienceGold() {
		return experienceGold;
	}
	public void setExperienceGold(BigDecimal experienceGold) {
		this.experienceGold = experienceGold;
		if(AdminAccountEnum.getByCode(this.uid) == null){
			MemberMoneyHelper.checkAmount(experienceGold, "可用体验金不足");
			this.experienceGold = experienceGold;
		}
	}
	public BigDecimal getIncomeMoney() {
		return incomeMoney;
	}
	public void setIncomeMoney(BigDecimal incomeMoney) {
		this.incomeMoney = incomeMoney;
	}
	public BigDecimal getFreeWithdraw() {
		return freeWithdraw;
	}
	public void setFreeWithdraw(BigDecimal freeWithdraw) {
		this.freeWithdraw = freeWithdraw;
	}
	public BigDecimal getCanusemoney() {
		return canusemoney;
	}
	public void setCanusemoney(BigDecimal canusemoney) {
		MemberMoneyHelper.checkAmount(canusemoney, "可用余额不足");
		this.canusemoney = canusemoney;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
	
}
