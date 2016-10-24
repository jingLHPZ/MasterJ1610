package com.sxt.inter.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 首页产品
 * @version 1.0.0
 */
public class IndexProductDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 产品id */
	private String productId;
	/** 产品名  */
	private String productName;
	/** 投资利率 */
	private Float borrowInterestRate;
	/** 还款方式*/
	private Integer repaymentType;
	/** 投资期限 */
	private Integer borrowMonthDuration;
	private Integer borrowDayDuration;
	/** 投资状态*/
	private Integer borrowStatus;
	/** 产品排序*/
	private Integer productSort;
	/** 是否有红包*/
	private Integer canBonus;
	private BigDecimal borrowMoney;
	/** 是否有加息券*/
	private Integer canAddInterest;
	private BigDecimal haveInvestMoney;//累计投资
	private Integer haveInvestorCount;//多少人参与投资
	private BigDecimal surplusmon;
	private BigDecimal caninvest;
	private Integer productType;
	private BigDecimal investMin;
	
	private Date collectStartTime;
	private Date collectEndTime;
	private Date createTime;
	private Integer productAdaptedType;
	
	public BigDecimal getInvestMin()
	{
		return investMin;
	}
	public void setInvestMin(BigDecimal investMin)
	{
		this.investMin = investMin;
	}
	public int getProductType()
	{
		return productType;
	}
	public void setProductType(int productType)
	{
		this.productType = productType;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getBorrowInterestRate() {
		return borrowInterestRate;
	}
	public void setBorrowInterestRate(Float borrowInterestRate) {
		this.borrowInterestRate = borrowInterestRate;
	}
	public Integer getRepaymentType() {
		return repaymentType;
	}
	public void setRepaymentType(Integer repaymentType) {
		this.repaymentType = repaymentType;
	}
	public Integer getBorrowDayDuration() {
		return borrowDayDuration;
	}
	public void setBorrowDayDuration(Integer borrowDayDuration) {
		this.borrowDayDuration = borrowDayDuration;
	}
	public Integer getBorrowMonthDuration() {
		return borrowMonthDuration;
	}
	public void setBorrowMonthDuration(Integer borrowMonthDuration) {
		this.borrowMonthDuration = borrowMonthDuration;
	}
	public Integer getBorrowStatus() {
		return borrowStatus;
	}
	public void setBorrowStatus(Integer borrowStatus) {
		this.borrowStatus = borrowStatus;
	}
	public Integer getProductSort() {
		return productSort;
	}
	public void setProductSort(Integer productSort) {
		this.productSort = productSort;
	}
	public Integer getCanBonus() {
		return canBonus;
	}
	public void setCanBonus(Integer canBonus) {
		this.canBonus = canBonus;
	}
	public Integer getCanAddInterest() {
		return canAddInterest;
	}
	public void setCanAddInterest(Integer canAddInterest) {
		this.canAddInterest = canAddInterest;
	}
	public BigDecimal getHaveInvestMoney() {
		return haveInvestMoney;
	}
	public void setHaveInvestMoney(BigDecimal haveInvestMoney) {
		this.haveInvestMoney = haveInvestMoney;
	}
	public int getHaveInvestorCount() {
		return haveInvestorCount;
	}
	public void setHaveInvestorCount(Integer haveInvestorCount) {
		this.haveInvestorCount = haveInvestorCount;
	}
	public BigDecimal getSurplusmon() {
		return surplusmon;
	}
	public void setSurplusmon(BigDecimal surplusmon) {
		this.surplusmon = surplusmon;
	}
	public BigDecimal getCaninvest() {
		return caninvest;
	}
	public void setCaninvest(BigDecimal caninvest) {
		this.caninvest = caninvest;
	}
	public BigDecimal getBorrowMoney() {
		return borrowMoney;
	}
	public void setBorrowMoney(BigDecimal borrowMoney) {
		this.borrowMoney = borrowMoney;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	public Date getCollectStartTime() {
		return collectStartTime;
	}
	public void setCollectStartTime(Date collectStartTime) {
		this.collectStartTime = collectStartTime;
	}
	public Date getCollectEndTime() {
		return collectEndTime;
	}
	public void setCollectEndTime(Date collectEndTime) {
		this.collectEndTime = collectEndTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getProductAdaptedType() {
		return productAdaptedType;
	}
	public void setProductAdaptedType(Integer productAdaptedType) {
		this.productAdaptedType = productAdaptedType;
	}
	
	
}
