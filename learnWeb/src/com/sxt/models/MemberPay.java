package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MemberPay implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Members members;
	private String systemTraceNo;
	private BigDecimal rechargeMoney;// decimal;
	private BigDecimal rechargeFee;
	private String way;
	private Integer status;
	private Date createTime;
	private String rechargeIp;
	private String bankCard;
	private String offBank;
	private String offBranchBank;
	private String offUser;
	private Integer dealUid;
	private String payImgUrl;
	private Date updateTime;
	private String checkMemo;
	private Integer type;
	private String bankSign;
	private Integer uid;
	private String thirdSystemTraceNo;
	

	public String getThirdSystemTraceNo() {
		return thirdSystemTraceNo;
	}
	public void setThirdSystemTraceNo(String thirdSystemTraceNo) {
		this.thirdSystemTraceNo = thirdSystemTraceNo;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getBankSign() {
		return bankSign;
	}
	public void setBankSign(String bankSign) {
		this.bankSign = bankSign;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Members getMembers() {
		return members;
	}
	public void setMembers(Members members) {
		this.members = members;
	}
	public String getSystemTraceNo() {
		return systemTraceNo;
	}
	public void setSystemTraceNo(String systemTraceNo) {
		this.systemTraceNo = systemTraceNo;
	}
	public BigDecimal getRechargeMoney() {
		return rechargeMoney;
	}
	public void setRechargeMoney(BigDecimal rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}
	public BigDecimal getRechargeFee() {
		return rechargeFee;
	}
	public void setRechargeFee(BigDecimal rechargeFee) {
		this.rechargeFee = rechargeFee;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRechargeIp() {
		return rechargeIp;
	}
	public void setRechargeIp(String rechargeIp) {
		this.rechargeIp = rechargeIp;
	}
	public String getBankCard() {
		return bankCard;
	}
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	public String getOffBank() {
		return offBank;
	}
	public void setOffBank(String offBank) {
		this.offBank = offBank;
	}
	public String getOffBranchBank() {
		return offBranchBank;
	}
	public void setOffBranchBank(String offBranchBank) {
		this.offBranchBank = offBranchBank;
	}
	public String getOffUser() {
		return offUser;
	}
	public void setOffUser(String offUser) {
		this.offUser = offUser;
	}
	public Integer getDealUid() {
		return dealUid;
	}
	public void setDealUid(Integer dealUid) {
		this.dealUid = dealUid;
	}
	public String getPayImgUrl() {
		return payImgUrl;
	}
	public void setPayImgUrl(String payImgUrl) {
		this.payImgUrl = payImgUrl;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getCheckMemo() {
		return checkMemo;
	}
	public void setCheckMemo(String checkMemo) {
		this.checkMemo = checkMemo;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	
}
