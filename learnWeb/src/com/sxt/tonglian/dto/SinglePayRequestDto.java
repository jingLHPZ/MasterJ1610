package com.sxt.tonglian.dto;


/**
 * 单笔实时代付DTO
 * @author 
 * @date：2016年1月9日 上午11:02:58
 * 
 */
public class SinglePayRequestDto {

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
	 * 处理级别
	 */
	private Integer level;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 用户密码
	 */
	private String userPass;

	/**
	 * 交易流水号
	 */
	private String reqSn;

	/**
	 * 签名信息
	 */
	private String signedMsg;

	/**
	 * 业务代码
	 */
	private String businessCode;

	/**
	 * 商户代码
	 */
	private String merchantId;

	/**
	 * 提交时间
	 */
	private String submitTime;

	/**
	 * 用户编号
	 */
	private String eUserCode;

	/**
	 * 有效期
	 */
	private String validate;

	/**
	 * 信用卡CVV2
	 */
	private String cvv2;

	/**
	 * 银行代码
	 */
	private String bankCode;

	/**
	 * 账号类型:00银行卡，01存折，02信用卡。不填默认为银行卡00
	 */
	private String accountType;

	/**
	 * 账号
	 */
	private String accountNo;

	/**
	 * 账号名
	 */
	private String accountName;

	/**
	 * 账号属性:0私人，1公司。不填时，默认为私人0。
	 */
	private String accountProp;

	/**
	 * 金额,单位分
	 */
	private Long amount;

	/**
	 * 货币类型
	 */
	private String currency;

	/**
	 * 开户证件类型
	 */
	private String idType;

	/**
	 * 证件号
	 */
	private String id;
	
	/**
	 * 本交易结算户
	 */
	private String settacct;
	
	/**
	 * 手机号/小灵通
	 */
	private String tel;
	
	/**
	 * 自定义用户号
	 */
	private String custUserid;
	
	/**
	 * 分组清算标志
	 */
	private String settgroupflag;
	
	/**
	 * 交易附言
	 */
	private String summary;
	
	/**
	 * 备注
	 */
	private String remark;

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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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

	public String getReqSn() {
		return reqSn;
	}

	public void setReqSn(String reqSn) {
		this.reqSn = reqSn;
	}

	public String getSignedMsg() {
		return signedMsg;
	}

	public void setSignedMsg(String signedMsg) {
		this.signedMsg = signedMsg;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public String geteUserCode() {
		return eUserCode;
	}

	public void seteUserCode(String eUserCode) {
		this.eUserCode = eUserCode;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public String getCvv2() {
		return cvv2;
	}

	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
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

	public String getAccountProp() {
		return accountProp;
	}

	public void setAccountProp(String accountProp) {
		this.accountProp = accountProp;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSettacct() {
		return settacct;
	}

	public void setSettacct(String settacct) {
		this.settacct = settacct;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCustUserid() {
		return custUserid;
	}

	public void setCustUserid(String custUserid) {
		this.custUserid = custUserid;
	}

	public String getSettgroupflag() {
		return settgroupflag;
	}

	public void setSettgroupflag(String settgroupflag) {
		this.settgroupflag = settgroupflag;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
