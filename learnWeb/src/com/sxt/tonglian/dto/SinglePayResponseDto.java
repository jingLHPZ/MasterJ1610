package com.sxt.tonglian.dto;

/**
 * 单笔实时代付响应DTO
 * @author 
 * @date：2016年1月9日 上午11:30:09
 * 
 */
public class SinglePayResponseDto {

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
	 * 交易流水号
	 */
	private String reqSn;
	
	/**
	 * 返回代码
	 */
	private String retCode;
	
	/**
	 * 错误信息
	 */
	private String errMsg;
	
	/**
	 * 签名信息
	 */
	private String signedMsg;
	
	/**
	 * 商户代码
	 */
	private String merchantId;
	
	/**
	 * 返回码
	 */
	private String retCode2;
	
	/**
	 * 清算日期
	 */
	private String settleDay;
	
	/**
	 * 错误文本
	 */
	private String errMsg2;

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

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
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

	public String getRetCode2() {
		return retCode2;
	}

	public void setRetCode2(String retCode2) {
		this.retCode2 = retCode2;
	}

	public String getSettleDay() {
		return settleDay;
	}

	public void setSettleDay(String settleDay) {
		this.settleDay = settleDay;
	}

	public String getErrMsg2() {
		return errMsg2;
	}

	public void setErrMsg2(String errMsg2) {
		this.errMsg2 = errMsg2;
	}
	
}
