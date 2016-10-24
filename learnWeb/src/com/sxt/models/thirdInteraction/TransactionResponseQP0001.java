package com.sxt.models.thirdInteraction;

import com.sxt.util.Util;

public class TransactionResponseQP0001 extends TransactionResponseBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8213132670162894209L;

	private String tranRespCode;
	
	private String merOrderId;
	
	private String custId;
	
	private String refNo;
	
	private String storableCardNo;
	
	private String amount;
	
	private String macRec;
	
	private String clientDate;
	
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
	
	public String getStorableCardNo() {
		return Util.maskString(storableCardNo);
	}

	public void setStorableCardNo(String storableCardNo) {
		this.storableCardNo = Util.maskString(storableCardNo);
	}

	public String getTranRespCode() {
		return Util.maskString(tranRespCode);
	}

	public void setTranRespCode(String tranRespCode) {
		this.tranRespCode = Util.maskString(tranRespCode);
	}

	public String getRefNo() {
		return Util.maskString(refNo);
	}

	public void setRefNo(String refNo) {
		this.refNo = Util.maskString(refNo);
	}

	public String getAmount() {
		return Util.maskString(amount);
	}

	public void setAmount(String amount) {
		this.amount = Util.maskString(amount);
	}
	
	public String getMacRec() {
		return  Util.maskString(macRec);
	}

	public void setMacRec(String macRec) {
		this.macRec =  Util.maskString(macRec);
	}

	public String getClientDate() {
		return Util.maskString(clientDate);
	}

	public void setClientDate(String clientDate) {
		this.clientDate = Util.maskString(clientDate);
	}
	
	
	
}
