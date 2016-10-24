package com.sxt.models;

import java.util.Date;

import java.io.Serializable;

/**
 * 代销商家表类 ld_sale_proxy_merchant
 * @author 
 * @date 2016-05-26
 */
public class LdSaleProxyMerchant  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 商家名称
	 */
	private String merchantName;

	/**
	 * 商家商户号
	 */
	private String merchantNo;

	/**
	 * 商户密码
	 */
	private String password;

	/**
	 * 
	 */
	private Integer status;

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

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
