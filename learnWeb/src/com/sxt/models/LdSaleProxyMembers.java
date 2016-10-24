package com.sxt.models;

import java.util.Date;

import java.io.Serializable;

/**
 * 代销商家用户类 ld_sale_proxy_members
 * @author 
 * @date 2016-05-19
 */
public class LdSaleProxyMembers  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 商户用户ID
	 */
	private String merchantUid;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 手机号
	 */
	private String mobilePhone;

	/**
	 * 证件类型
	 */
	private Integer certificateType;

	/**
	 * 证件号码
	 */
	private String certificateNo;

	/**
	 * 
	 */
	private Date createTime;

	/**
	 * 代理商户号
	 */
	private String proxyMerchantNo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Integer getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(Integer certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getProxyMerchantNo() {
		return proxyMerchantNo;
	}

	public void setProxyMerchantNo(String proxyMerchantNo) {
		this.proxyMerchantNo = proxyMerchantNo;
	}

	public String getMerchantUid() {
		return merchantUid;
	}

	public void setMerchantUid(String merchantUid) {
		this.merchantUid = merchantUid;
	}

}
