package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class InvestorMoney implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal investorCapital;
	private BigDecimal investorInterest;
	private BigDecimal assignmentMoney;// 转让了多少钱

	public BigDecimal getInvestorCapital() {
		return investorCapital;
	}

	public void setInvestorCapital(BigDecimal investorCapital) {
		this.investorCapital = investorCapital;
	}

	public BigDecimal getInvestorInterest() {
		return investorInterest;
	}

	public BigDecimal getAssignmentMoney() {
		return assignmentMoney;
	}

	public void setAssignmentMoney(BigDecimal assignmentMoney) {
		this.assignmentMoney = assignmentMoney;
	}

	public void setInvestorInterest(BigDecimal investorInterest) {
		this.investorInterest = investorInterest;
	}

}
