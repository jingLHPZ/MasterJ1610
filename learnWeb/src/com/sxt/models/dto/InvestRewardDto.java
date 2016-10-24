package com.sxt.models.dto;

import java.math.BigDecimal;

import com.sxt.util.Util;

public class InvestRewardDto {
	private Integer investorUid;
	private BigDecimal investorCapital;
	private Integer investorCount; 
	private String userName;
	private String objName;
	
	
	public String getObjName() {
		return objName;
	}
	public void setObjName(String objName) {
		this.objName = objName;
	}
	public Integer getInvestorCount() {
		return investorCount;
	}
	public void setInvestorCount(Integer investorCount) {
		this.investorCount = investorCount;
	}
	public Integer getInvestorUid() {
		return investorUid;
	}
	public void setInvestorUid(Integer investorUid) {
		this.investorUid = investorUid;
	}
	public BigDecimal getInvestorCapital() {
		return investorCapital;
	}
	public void setInvestorCapital(BigDecimal investorCapital) {
		this.investorCapital = investorCapital;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
