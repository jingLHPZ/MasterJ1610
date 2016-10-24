package com.sxt.tonglian.dto;

/**
 * 交易结果请求DTO
 * @author 
 * @date：2016年1月19日 上午10:29:52
 * 
 */
public class PayQueryRequestDto {

	/**
	 * 交易代码
	 */
	private String trxCode;
	
	/**
	 * 版本
	 */
	private String version;
	
	/**
	 * 数据格式
	 */
	private Integer dateType;
	
	/**
	 * 交易批次号
	 */
	private String reqSn;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 用户密码
	 */
	private String userPass;
	
	/**
	 * 签名信息
	 */
	private String signedMsg;
	
	/**
	 * 商户代码
	 */
	private String merchantId;
	
	/**
	 * 要查询的交易流水
	 */
	private String querySn;
	
	/**
	 * 状态
	 */
	private String status;
	
	/**
	 * 查询类型
	 */
	private String type;
	
	/**
	 * 开始日
	 */
	private String startDay;
	
	/**
	 * 结束日
	 */
	private String endDay;

	public String getTrxCode() {
		return trxCode;
	}

	public void setTrxCode(String trxCode) {
		this.trxCode = trxCode;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getDateType() {
		return dateType;
	}

	public void setDateType(Integer dateType) {
		this.dateType = dateType;
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

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getSignedMsg() {
		return signedMsg;
	}

	public void setSignedMsg(String signedMsg) {
		this.signedMsg = signedMsg;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getQuerySn() {
		return querySn;
	}

	public void setQuerySn(String querySn) {
		this.querySn = querySn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

}
