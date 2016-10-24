package com.sxt.tonglian.dto;


/**
 * 交易结果查询响应DTO
 * @author 
 * @date：2016年1月19日 上午10:40:39
 * 
 */
public class PayQueryResponseDto {

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
	 * 交易批次号
	 */
	private String batchId;
	
	/**
	 * 记录序号
	 */
	private String sn;
	
	/**
	 * 交易方向
	 */
	private String trxdir;
	
	/**
	 * 清算日期
	 */
	private String settday;
	
	/**
	 * 完成时间
	 */
	private String fintime;
	
	/**
	 * 提交时间
	 */
	private String submitTime;
	
	/**
	 * 账号
	 */
	private String accountNo;
	
	/**
	 * 账号名
	 */
	private String accountName;
	
	/**
	 * 金额
	 */
	private Long amount;
	
	/**
	 * 自定义用户号
	 */
	private String custUserId;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 返回码
	 */
	private String retCode2;
	
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

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getTrxdir() {
		return trxdir;
	}

	public void setTrxdir(String trxdir) {
		this.trxdir = trxdir;
	}

	public String getSettday() {
		return settday;
	}

	public void setSettday(String settday) {
		this.settday = settday;
	}

	public String getFintime() {
		return fintime;
	}

	public void setFintime(String fintime) {
		this.fintime = fintime;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getCustUserId() {
		return custUserId;
	}

	public void setCustUserId(String custUserId) {
		this.custUserId = custUserId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRetCode2() {
		return retCode2;
	}

	public void setRetCode2(String retCode2) {
		this.retCode2 = retCode2;
	}

	public String getErrMsg2() {
		return errMsg2;
	}

	public void setErrMsg2(String errMsg2) {
		this.errMsg2 = errMsg2;
	}

}
