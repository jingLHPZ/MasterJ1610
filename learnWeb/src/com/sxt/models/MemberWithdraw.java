package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MemberWithdraw implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer uid;
	private BigDecimal withdrawMoney;
	private Integer withdrawStatus;
	private BigDecimal withdrawFee;
	private Date createTime;
	private String addIp;
	private Date checkTime;
	private String checkUser;
	private String dealInfo;
	private BigDecimal secondFee;
	private BigDecimal successMoney;
	private String systemTraceNo;
	private Date updateTime;
	private BigDecimal freeWithdrawMoney;
	private String bankCardNo;
	private String cardBank;
	private String cardBranchBank;
	private BigDecimal freeMoneyCurrent;
	
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
	public BigDecimal getWithdrawMoney() {
		return withdrawMoney;
	}
	public void setWithdrawMoney(BigDecimal withdrawMoney) {
		this.withdrawMoney = withdrawMoney;
	}
	public Integer getWithdrawStatus() {
		return withdrawStatus;
	}
	public void setWithdrawStatus(Integer withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}
	public BigDecimal getWithdrawFee() {
		return withdrawFee;
	}
	public void setWithdrawFee(BigDecimal withdrawFee) {
		this.withdrawFee = withdrawFee;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAddIp() {
		return addIp;
	}
	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public String getCheckUser() {
		return checkUser;
	}
	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}
	public String getDealInfo() {
		return dealInfo;
	}
	public void setDealInfo(String dealInfo) {
		this.dealInfo = dealInfo;
	}
	public BigDecimal getSecondFee() {
		return secondFee;
	}
	public void setSecondFee(BigDecimal secondFee) {
		this.secondFee = secondFee;
	}
	public BigDecimal getSuccessMoney() {
		return successMoney;
	}
	public void setSuccessMoney(BigDecimal successMoney) {
		this.successMoney = successMoney;
	}
	public String getSystemTraceNo() {
		return systemTraceNo;
	}
	public void setSystemTraceNo(String systemTraceNo) {
		this.systemTraceNo = systemTraceNo;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public BigDecimal getFreeWithdrawMoney() {
		return freeWithdrawMoney;
	}
	public void setFreeWithdrawMoney(BigDecimal freeWithdrawMoney) {
		this.freeWithdrawMoney = freeWithdrawMoney;
	}
	public String getBankCardNo() {
		return bankCardNo;
	}
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	public String getCardBank() {
		return cardBank;
	}
	public void setCardBank(String cardBank) {
		this.cardBank = cardBank;
	}
	public String getCardBranchBank() {
		return cardBranchBank;
	}
	public void setCardBranchBank(String cardBranchBank) {
		this.cardBranchBank = cardBranchBank;
	}
	public BigDecimal getFreeMoneyCurrent() {
		return freeMoneyCurrent;
	}
	public void setFreeMoneyCurrent(BigDecimal freeMoneyCurrent) {
		this.freeMoneyCurrent = freeMoneyCurrent;
	}
	
}
