package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BorrowInvestor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String fromSource;
	private String productId;
	private Integer investorUid;
	private Integer borrowUid;
	private BigDecimal investorCapital = BigDecimal.ZERO;
	private BigDecimal investorInterest = BigDecimal.ZERO;
	private BigDecimal receiveCapital = BigDecimal.ZERO;
	private BigDecimal receiveInterest = BigDecimal.ZERO;
	private BigDecimal substituteMoney = BigDecimal.ZERO;
	private BigDecimal expiredMoney = BigDecimal.ZERO;
	private BigDecimal investFee = BigDecimal.ZERO;
	private Date createTime;
	private Date deadline;
	private Integer isAuto;
	private BigDecimal rewardMoney = BigDecimal.ZERO;
	private Integer debtStatus;
	private Date updateTime;
	private String systemTraceNo;
	private Integer status;
	private BigDecimal assignmentMoney = BigDecimal.ZERO;
	private Integer debtUid;
	private BigDecimal caninvest;
	
	private String borrowUname;
	
	private Integer productType;
	
	private BigDecimal debtPrice;
	
	private String investIp;
	
	private Integer salesUid;
	private String extField;
	
	
	public BigDecimal getDebtPrice() {
		return debtPrice;
	}
	public void setDebtPrice(BigDecimal debtPrice) {
		this.debtPrice = debtPrice;
	}
	public Integer getProductType() {
		return productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFromSource() {
		return fromSource;
	}

	public void setFromSource(String fromSource) {
		this.fromSource = fromSource;
	}

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

	public BigDecimal getInvestorCapital() {
		return investorCapital;
	}

	public void setInvestorCapital(BigDecimal investorCapital) {
		this.investorCapital = investorCapital;
	}

	public BigDecimal getInvestorInterest() {
		return investorInterest;
	}

	public void setInvestorInterest(BigDecimal investorInterest) {
		this.investorInterest = investorInterest;
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

	public BigDecimal getSubstituteMoney() {
		return substituteMoney;
	}

	public void setSubstituteMoney(BigDecimal substituteMoney) {
		this.substituteMoney = substituteMoney;
	}

	public BigDecimal getExpiredMoney() {
		return expiredMoney;
	}

	public void setExpiredMoney(BigDecimal expiredMoney) {
		this.expiredMoney = expiredMoney;
	}

	public BigDecimal getInvestFee() {
		return investFee;
	}

	public void setInvestFee(BigDecimal investFee) {
		this.investFee = investFee;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Integer getIsAuto() {
		return isAuto;
	}

	public void setIsAuto(Integer isAuto) {
		this.isAuto = isAuto;
	}

	public BigDecimal getRewardMoney() {
		return rewardMoney;
	}

	public void setRewardMoney(BigDecimal rewardMoney) {
		this.rewardMoney = rewardMoney;
	}

	public Integer getDebtStatus() {
		return debtStatus;
	}

	public void setDebtStatus(Integer debtStatus) {
		this.debtStatus = debtStatus;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getAssignmentMoney() {
		return assignmentMoney;
	}

	public void setAssignmentMoney(BigDecimal assignmentMoney) {
		this.assignmentMoney = assignmentMoney;
	}

	public Integer getDebtUid() {
		return debtUid;
	}

	public void setDebtUid(Integer debtUid) {
		this.debtUid = debtUid;
	}

	public BigDecimal getCaninvest() {
		return caninvest;
	}

	public void setCaninvest(BigDecimal caninvest) {
		this.caninvest = caninvest;
	}

	public String getBorrowUname() {
		return borrowUname;
	}

	public void setBorrowUname(String borrowUname) {
		this.borrowUname = borrowUname;
	}
	public String getInvestIp() {
		return investIp;
	}
	public void setInvestIp(String investIp) {
		this.investIp = investIp;
	}
	public Integer getSalesUid() {
		return salesUid;
	}
	public void setSalesUid(Integer salesUid) {
		this.salesUid = salesUid;
	}
	public String getExtField() {
		return extField;
	}
	public void setExtField(String extField) {
		this.extField = extField;
	}
	
	
}
