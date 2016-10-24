package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class SumMoney implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer investorUid;
	private String productId;
	private BigDecimal receiveCapital;
	private BigDecimal receiveInterest;
	private BigDecimal allincome;// 到期收益金额。
	private BigDecimal assignmentMoney;// 转让金额。
	private BigDecimal yearrate;// 年华收益 ；
	private Integer day;// 收到还款日。
	private BigDecimal beforeassignmentMoney;// 原始年华收益
	private BigDecimal restcapital;// 剩余本金
	private String proname;

	public Integer getInvestorUid() {
		return investorUid;
	}

	public void setInvestorUid(Integer investorUid) {
		this.investorUid = investorUid;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public BigDecimal getReceiveCapital() {
		return receiveCapital;
	}

	public void setReceiveCapital(BigDecimal receiveCapital) {
		this.receiveCapital = receiveCapital;
	}

	public BigDecimal getReceiveInterest() {
		return receiveInterest;
	}

	public void setReceiveInterest(BigDecimal receiveInterest) {
		this.receiveInterest = receiveInterest;
	}

	public BigDecimal getAllincome() {
		return allincome;
	}

	public void setAllincome(BigDecimal allincome) {
		this.allincome = allincome;
	}

	public BigDecimal getAssignmentMoney() {
		return assignmentMoney;
	}

	public void setAssignmentMoney(BigDecimal assignmentMoney) {
		this.assignmentMoney = assignmentMoney;
	}

	public BigDecimal getYearrate() {
		return yearrate;
	}

	public void setYearrate(BigDecimal yearrate) {
		this.yearrate = yearrate;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public BigDecimal getBeforeassignmentMoney() {
		return beforeassignmentMoney;
	}

	public void setBeforeassignmentMoney(BigDecimal beforeassignmentMoney) {
		this.beforeassignmentMoney = beforeassignmentMoney;
	}

	public BigDecimal getRestcapital() {
		return restcapital;
	}

	public void setRestcapital(BigDecimal restcapital) {
		this.restcapital = restcapital;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

}
