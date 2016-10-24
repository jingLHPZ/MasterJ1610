package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MemberMoneyDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer uid;
	private Integer type;
	private BigDecimal affectMoney;
	private BigDecimal accountMoney;
	private BigDecimal backMoney;
	private BigDecimal collectMoney;
	private BigDecimal freezeMoney;
	private String info;
	private Date createTime;
	private String addIp;
	private Integer targetUid;
	private String targetUname;
	private Date updateTime;
	private String systemTraceNo;
	private BigDecimal incomeMoney;
	
	private String showType;
	private String showAffectMoney;
	private BigDecimal availableMoney;//可用金额
	
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public BigDecimal getAffectMoney() {
		return affectMoney;
	}
	public void setAffectMoney(BigDecimal affectMoney) {
		this.affectMoney = affectMoney;
	}
	public BigDecimal getAccountMoney() {
		return accountMoney;
	}
	public void setAccountMoney(BigDecimal accountMoney) {
		this.accountMoney = accountMoney;
	}
	public BigDecimal getBackMoney() {
		return backMoney;
	}
	public void setBackMoney(BigDecimal backMoney) {
		this.backMoney = backMoney;
	}
	public BigDecimal getCollectMoney() {
		return collectMoney;
	}
	public void setCollectMoney(BigDecimal collectMoney) {
		this.collectMoney = collectMoney;
	}
	public BigDecimal getFreezeMoney() {
		return freezeMoney;
	}
	public void setFreezeMoney(BigDecimal freezeMoney) {
		this.freezeMoney = freezeMoney;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
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
	public Integer getTargetUid() {
		return targetUid;
	}
	public void setTargetUid(Integer targetUid) {
		this.targetUid = targetUid;
	}
	public String getTargetUname() {
		return targetUname;
	}
	public void setTargetUname(String targetUname) {
		this.targetUname = targetUname;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getSystemTraceNo() {
		return systemTraceNo;
	}
	public void setSystemTraceNo(String systemTraceNo) {
		this.systemTraceNo = systemTraceNo;
	}
	public BigDecimal getIncomeMoney() {
		return incomeMoney;
	}
	public void setIncomeMoney(BigDecimal incomeMoney) {
		this.incomeMoney = incomeMoney;
	}
	public String getShowType() {
		return showType;
	}
	public void setShowType(String showType) {
		this.showType = showType;
	}
	public String getShowAffectMoney() {
		return showAffectMoney;
	}
	public void setShowAffectMoney(String showAffectMoney) {
		this.showAffectMoney = showAffectMoney;
	}
	public BigDecimal getAvailableMoney() {
		return availableMoney;
	}
	public void setAvailableMoney(BigDecimal availableMoney) {
		this.availableMoney = availableMoney;
	}
	
	
}
