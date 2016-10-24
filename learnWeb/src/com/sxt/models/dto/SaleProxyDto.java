package com.sxt.models.dto;

import java.util.Date;

import com.sxt.util.DateUtil;

/**
 * 代销产品dto
 * @author 
 * @date：2016年5月25日 下午4:39:59
 * 
 */
public class SaleProxyDto {
	
	/**
	 * 交易代码
	 */
	private String transactionCode;
	
	/**
	 * 交易流水号
	 */
	private String reqSn;
	
	/**
	 * 商户账号
	 */
	private String userName;
	
	/**
	 * 商户密码
	 */
	private String password;
	
	/**
	 * 投资用户id
	 */
	private String userId;
	
	/**
	 * 投资用户真实姓名
	 */
	private String realName;
	
	/**
	 * 手机号
	 */
	private String mobilePhone;
	
	/**
	 * 用户证件号码
	 */
	private String certificateNo;
	
	/**
	 * 投资id
	 */
	private String investId;
	
	/**
	 * 投资金额
	 */
	private Long investMoney;
	
	/**
	 * 投资时间
	 */
	private Date investTime;
	
	/**
	 * 产品ID
	 */
	private String productId;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 产品金额
	 */
	private Long productMoney;
	
	/**
	 * 产品年利率
	 */
	private String productRate;
	
	/**
	 * 预期收益
	 */
	private Long expectProfit;
	
	/**
	 * 产品最后还款日
	 */
	private Date productEndTime;
	
	/**
	 * 产品状态
	 */
	private Integer productStatus;
	
	/**
	 * 产品备注
	 */
	private String remark;
	
	private String sigedMsg;

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getReqSn() {
		return reqSn;
	}

	public void setReqSn(String reqSn) {
		this.reqSn = reqSn;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getInvestId() {
		return investId;
	}

	public void setInvestId(String investId) {
		this.investId = investId;
	}

	public Long getInvestMoney() {
		return investMoney;
	}

	public void setInvestMoney(Long investMoney) {
		this.investMoney = investMoney;
	}

	public Date getInvestTime() {
		return investTime;
	}

	public void setInvestTime(Date investTime) {
		this.investTime = investTime;
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

	public Long getProductMoney() {
		return productMoney;
	}

	public void setProductMoney(Long productMoney) {
		this.productMoney = productMoney;
	}

	public String getProductRate() {
		return productRate;
	}

	public void setProductRate(String productRate) {
		this.productRate = productRate;
	}

	public Long getExpectProfit() {
		return expectProfit;
	}

	public void setExpectProfit(Long expectProfit) {
		this.expectProfit = expectProfit;
	}

	public Date getProductEndTime() {
		return productEndTime;
	}

	public void setProductEndTime(Date productEndTime) {
		this.productEndTime = productEndTime;
	}

	public Integer getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSigedMsg() {
		StringBuffer msg = new StringBuffer();
		if (this.userId != null) msg.append(this.userId);
		if (this.realName != null) msg.append(this.realName);
		if (this.mobilePhone != null) msg.append(this.mobilePhone);
		if (this.certificateNo != null) msg.append(this.certificateNo);
		if (this.investId != null) msg.append(this.investId);
		if (this.investMoney != null) msg.append(this.investMoney);
		if (this.investTime != null) msg.append(DateUtil.simpleFormat(this.investTime));
		if (this.productId != null) msg.append(this.productId);
		if (this.productName != null) msg.append(this.productName);
		if (this.productMoney != null) msg.append(this.productMoney);
		if (this.productRate != null) msg.append(this.productRate);
		if (this.expectProfit != null) msg.append(this.expectProfit);
		if (this.productEndTime != null) msg.append(DateUtil.simpleFormat(this.productEndTime));
		if (this.remark != null) msg.append(this.remark);
		return msg.toString();
	}

	public void setSigedMsg(String sigedMsg) {
		this.sigedMsg = sigedMsg;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
}
