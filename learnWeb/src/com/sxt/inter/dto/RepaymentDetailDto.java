package com.sxt.inter.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 复投收款计划
 * @version 1.0.0
 */
public class RepaymentDetailDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 产品id */
	private String productId;
	private Integer investorUid;
	private Integer borrowUid;
	private BigDecimal capital;
	private Date repaymentTime;
	private String systemTraceNo;
	//复投利率
	private Float recastRate;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getInvestorUid() {
		return investorUid;
	}
	public void setInvestorUid(Integer investorUid) {
		this.investorUid = investorUid;
	}
	public Integer getBorrowUid() {
		return borrowUid;
	}
	public void setBorrowUid(Integer borrowUid) {
		this.borrowUid = borrowUid;
	}
	public BigDecimal getCapital() {
		return capital;
	}
	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}
	public Date getRepaymentTime() {
		return repaymentTime;
	}
	public void setRepaymentTime(Date repaymentTime) {
		this.repaymentTime = repaymentTime;
	}
	public String getSystemTraceNo() {
		return systemTraceNo;
	}
	public void setSystemTraceNo(String systemTraceNo) {
		this.systemTraceNo = systemTraceNo;
	}
	public Float getRecastRate() {
		return recastRate;
	}
	public void setRecastRate(Float recastRate) {
		this.recastRate = recastRate;
	}
}
