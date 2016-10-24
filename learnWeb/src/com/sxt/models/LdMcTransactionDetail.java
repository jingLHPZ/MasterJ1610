package com.sxt.models;

import java.math.BigDecimal;
import java.util.Date;

import com.sxt.util.Util;

public class LdMcTransactionDetail {
    private Integer id;

    private String merOrderId;

    private String subject;

    private String bankNo;

    private String cardNo;

    private Date expiredDate;

    private String cvv2;

    private BigDecimal amount;

    private String custName;

    private String custIdNo;

    private Integer custIdType;

    private Integer saveCustFlag;

    private Integer custId;

    private String phoneNo;

    private String phoneVercode;

    private String phonetoken;

    private String storableCardNo;

    private String backurl;

    private String msgExt;

    private Date createTime;
    
    private Integer status;
    
    private String ip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMerOrderId() {
        return Util.maskString(merOrderId);
    }

    public void setMerOrderId(String merOrderId) {
        this.merOrderId = Util.maskString(merOrderId);
    }

    public String getSubject() {
        return Util.maskString(subject);
    }

    public void setSubject(String subject) {
        this.subject = Util.maskString(subject);
    }

    public String getBankNo() {
        return Util.maskString(bankNo);
    }

    public void setBankNo(String bankNo) {
        this.bankNo = Util.maskString(bankNo);
    }

    public String getCardNo() {
        return Util.maskString(cardNo);
    }

    public void setCardNo(String cardNo) {
        this.cardNo = Util.maskString(cardNo);
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getCvv2() {
        return Util.maskString(cvv2);
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCustName() {
        return Util.maskString(custName);
    }

    public void setCustName(String custName) {
        this.custName = Util.maskString(custName);
    }

    public String getCustIdNo() {
        return Util.maskString(custIdNo);
    }

    public void setCustIdNo(String custIdNo) {
        this.custIdNo = Util.maskString(custIdNo);
    }

    public Integer getCustIdType() {
        return Util.maskInteger(custIdType);
    }

    public void setCustIdType(Integer custIdType) {
        this.custIdType = Util.maskInteger(custIdType);
    }

    public Integer getSaveCustFlag() {
        return saveCustFlag;
    }

    public void setSaveCustFlag(Integer saveCustFlag) {
        this.saveCustFlag = saveCustFlag;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getPhoneNo() {
		return Util.maskString(phoneNo);
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = Util.maskString(phoneNo);
	}

	public String getPhoneVercode() {
        return Util.maskString(phoneVercode);
    }

    public void setPhoneVercode(String phoneVercode) {
        this.phoneVercode = Util.maskString(phoneVercode);
    }

    public String getPhonetoken() {
        return Util.maskString(phonetoken);
    }

    public void setPhonetoken(String phonetoken) {
        this.phonetoken = Util.maskString(phonetoken);
    }

    public String getStorableCardNo() {
        return Util.maskString(storableCardNo);
    }

    public void setStorableCardNo(String storableCardNo) {
        this.storableCardNo = Util.maskString(storableCardNo);
    }

    public String getBackurl() {
        return Util.maskString(backurl);
    }

    public void setBackurl(String backurl) {
        this.backurl = Util.maskString(backurl);
    }

    public String getMsgExt() {
        return Util.maskString(msgExt);
    }

    public void setMsgExt(String msgExt) {
        this.msgExt = Util.maskString(msgExt);
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getIp() {
		return Util.maskString(ip);
	}

	public void setIp(String ip) {
		this.ip = Util.maskString(ip);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
    
    
}