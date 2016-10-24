package com.sxt.models.dto;

import com.sxt.util.Util;

public class QuickPaymentDto {
	
	private String merOrderId;
	
	private String custId;
	
	private String custName;
	
	private String custIdNo;
	
	private String custIdType;
	
	private String cardNo;
	
	private String storableCardNo;
	
	private String bankNo;
	
	private String expiredDate;
	
	private String cvv2;
	
	private String amount;
	
	private String phoneNo;
	
	private String refNo;
	
	private String merTransDate;
	
	private String txnType;
	
	private String oriRefNo;
	
	private String oriMerOrderId;
	
	private String oriTransDate;
	
	private String idName;
	
	private String idNum;
	
	private String cardType;
	
	private String merOderNo;
	
	
	public String getIdName() {
		return Util.maskString(idName);
	}
	public void setIdName(String idName) {
		this.idName = Util.maskString(idName);
	}
	public String getIdNum() {
		return Util.maskString(idNum);
	}
	public void setIdNum(String idNum) {
		this.idNum = Util.maskString(idNum);
	}
	public String getMerOrderId() {
		return Util.maskString(merOrderId);
	}
	public void setMerOrderId(String merOrderId) {
		this.merOrderId = Util.maskString(merOrderId);
	}
	public String getCustId() {
		return Util.maskString(custId);
	}
	public void setCustId(String custId) {
		this.custId = Util.maskString(custId);
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
	public String getCustIdType() {
		return Util.maskString(custIdType);
	}
	public void setCustIdType(String custIdType) {
		this.custIdType = Util.maskString(custIdType);
	}
	public String getCardNo() {
		return Util.maskString(cardNo);
	}
	public void setCardNo(String cardNo) {
		this.cardNo = Util.maskString(cardNo);
	}
	public String getStorableCardNo() {
		return Util.maskString(storableCardNo);
	}
	public void setStorableCardNo(String storableCardNo) {
		this.storableCardNo = Util.maskString(storableCardNo);
	}
	public String getBankNo() {
		return Util.maskString(bankNo);
	}
	public void setBankNo(String bankNo) {
		this.bankNo = Util.maskString(bankNo);
	}
	public String getExpiredDate() {
		return Util.maskString(expiredDate);
	}
	public void setExpiredDate(String expiredDate) {
		this.expiredDate = Util.maskString(expiredDate);
	}
	public String getCvv2() {
		return Util.maskString(cvv2);
	}
	public void setCvv2(String cvv2) {
		this.cvv2 = Util.maskString(cvv2);
	}
	public String getAmount() {
		return Util.maskString(amount);
	}
	public void setAmount(String amount) {
		this.amount = Util.maskString(amount);
	}
	public String getPhoneNo() {
		return Util.maskString(phoneNo);
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = Util.maskString(phoneNo);
	}
	public String getRefNo() {
		return Util.maskString(refNo);
	}
	public void setRefNo(String refNo) {
		this.refNo = Util.maskString(refNo);
	}
	public String getMerTransDate() {
		return Util.maskString(merTransDate);
	}
	public void setMerTransDate(String merTransDate) {
		this.merTransDate = Util.maskString(merTransDate);
	}
	public String getTxnType() {
		return Util.maskString(txnType);
	}
	public void setTxnType(String txnType) {
		this.txnType = Util.maskString(txnType);
	}
	public String getOriRefNo() {
		return Util.maskString(oriRefNo);
	}
	public void setOriRefNo(String oriRefNo) {
		this.oriRefNo = Util.maskString(oriRefNo);
	}
	public String getOriMerOrderId() {
		return Util.maskString(oriMerOrderId);
	}
	public void setOriMerOrderId(String oriMerOrderId) {
		this.oriMerOrderId = Util.maskString(oriMerOrderId);
	}
	public String getOriTransDate() {
		return Util.maskString(oriTransDate);
	}
	public void setOriTransDate(String oriTransDate) {
		this.oriTransDate = Util.maskString(oriTransDate);
	}
	public String getCardType() {
		return Util.maskString(cardType);
	}
	public void setCardType(String cardType) {
		this.cardType = Util.maskString(cardType);
	}
	public String getMerOderNo() {
		return Util.maskString(merOderNo);
	}
	public void setMerOderNo(String merOderNo) {
		this.merOderNo = Util.maskString(merOderNo);
	}
	
	
	
	

}
