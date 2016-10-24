package com.sxt.models.thirdInteraction;

import com.sxt.util.Util;

public class TransactionResponseQP0006 extends TransactionResponseBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8641146749907092333L;

	private String txnType;
	
	private String txnStat;
	
	private String amount;
	
	private String merTransTime;
	
	private String merOrderId;
	
	private String custId;
	
	private String transTime;
	
	private String voidFlag;
	
	private String refNo;
	
	private String bankName;
	
	private String storableCardNo;
	
	private String macRec;

	public String getTxnType() {
		return Util.maskString(txnType);
	}

	public void setTxnType(String txnType) {
		this.txnType = Util.maskString(txnType);
	}

	public String getTxnStat() {
		return Util.maskString(txnStat);
	}

	public void setTxnStat(String txnStat) {
		this.txnStat = Util.maskString(txnStat);
	}

	public String getAmount() {
		return Util.maskString(amount);
	}

	public void setAmount(String amount) {
		this.amount = Util.maskString(amount);
	}

	public String getMerTransTime() {
		return Util.maskString(merTransTime);
	}

	public void setMerTransTime(String merTransTime) {
		this.merTransTime = Util.maskString(merTransTime);
	}

	public String getMerOrderId() {
		return merOrderId;
	}

	public void setMerOrderId(String merOrderId) {
		this.merOrderId = Util.maskString(merOrderId);
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = Util.maskString(custId);
	}

	public String getTransTime() {
		return Util.maskString(transTime);
	}

	public void setTransTime(String transTime) {
		this.transTime = Util.maskString(transTime);
	}

	public String getVoidFlag() {
		return Util.maskString(voidFlag);
	}

	public void setVoidFlag(String voidFlag) {
		this.voidFlag = Util.maskString(voidFlag);
	}

	public String getRefNo() {
		return Util.maskString(refNo);
	}

	public void setRefNo(String refNo) {
		this.refNo = Util.maskString(refNo);
	}

	public String getBankName() {
		return Util.maskString(bankName);
	}

	public void setBankName(String bankName) {
		this.bankName = Util.maskString(bankName);
	}

	public String getStorableCardNo() {
		return Util.maskString(storableCardNo);
	}

	public void setStorableCardNo(String storableCardNo) {
		this.storableCardNo = Util.maskString(storableCardNo);
	}

	public String getMacRec() {
		return Util.maskString(macRec);
	}

	public void setMacRec(String macRec) {
		this.macRec = Util.maskString(macRec);
	}
	
	
	
}
