package com.sxt.models;

import java.util.Date;
import java.math.BigDecimal;

import java.io.Serializable;

/**
 * 代销产品表类 ld_sale_proxy_product
 * @author 
 * @date 2016-05-19
 */
public class LdSaleProxyProduct  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 产品名称
	 */
	private String productName;

	/**
	 * 代理商产品ID
	 */
	private String merchantProductId;

	/**
	 * 产品募集金额
	 */
	private BigDecimal borrowMoney;

	/**
	 * 产品年利率
	 */
	private BigDecimal borrowRate;

	/**
	 * 产品状态
	 */
	private Integer borrowStatus;

	/**
	 * 产品到期时间
	 */
	private Date productEndTime;

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

	public BigDecimal getBorrowMoney() {
		return borrowMoney;
	}

	public void setBorrowMoney(BigDecimal borrowMoney) {
		this.borrowMoney = borrowMoney;
	}

	public BigDecimal getBorrowRate() {
		return borrowRate;
	}

	public void setBorrowRate(BigDecimal borrowRate) {
		this.borrowRate = borrowRate;
	}

	public Integer getBorrowStatus() {
		return borrowStatus;
	}

	public void setBorrowStatus(Integer borrowStatus) {
		this.borrowStatus = borrowStatus;
	}

	public Date getProductEndTime() {
		return productEndTime;
	}

	public void setProductEndTime(Date productEndTime) {
		this.productEndTime = productEndTime;
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

}
