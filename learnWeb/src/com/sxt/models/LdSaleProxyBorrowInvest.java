package com.sxt.models;

import java.util.Date;
import java.math.BigDecimal;

import java.io.Serializable;

/**
 * 代销产品投资记录类 ld_sale_proxy_borrow_invest
 * @author 
 * @date 2016-05-19
 */
public class LdSaleProxyBorrowInvest  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 投资ID
	 */
	private String investId;

	/**
	 * 
	 */
	private String productName;

	/**
	 * 
	 */
	private String merchantProductId;

	/**
	 * 
	 */
	private BigDecimal borrowRate;

	/**
	 * 
	 */
	private String serialNumber;

	/**
	 * 
	 */
	private String merchantUid;

	/**
	 * 
	 */
	private BigDecimal investMoney;

	/**
	 * 
	 */
	private BigDecimal expectMoney;

	/**
	 * 
	 */
	private Date borrowEndTime;

	/**
	 * 
	 */
	private Integer borrowStatus;

	/**
	 * 
	 */
	private String remark;

	/**
	 * 
	 */
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getBorrowRate() {
		return borrowRate;
	}

	public void setBorrowRate(BigDecimal borrowRate) {
		this.borrowRate = borrowRate;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public BigDecimal getInvestMoney() {
		return investMoney;
	}

	public void setInvestMoney(BigDecimal investMoney) {
		this.investMoney = investMoney;
	}

	public BigDecimal getExpectMoney() {
		return expectMoney;
	}

	public void setExpectMoney(BigDecimal expectMoney) {
		this.expectMoney = expectMoney;
	}

	public Date getBorrowEndTime() {
		return borrowEndTime;
	}

	public void setBorrowEndTime(Date borrowEndTime) {
		this.borrowEndTime = borrowEndTime;
	}

	public Integer getBorrowStatus() {
		return borrowStatus;
	}

	public void setBorrowStatus(Integer borrowStatus) {
		this.borrowStatus = borrowStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMerchantProductId() {
		return merchantProductId;
	}

	public void setMerchantProductId(String merchantProductId) {
		this.merchantProductId = merchantProductId;
	}

	public String getMerchantUid() {
		return merchantUid;
	}

	public void setMerchantUid(String merchantUid) {
		this.merchantUid = merchantUid;
	}

	public String getInvestId() {
		return investId;
	}

	public void setInvestId(String investId) {
		this.investId = investId;
	}

}
