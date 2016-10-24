package com.sxt.models.thirdInteraction;

import com.sxt.util.Util;

public class TransactionResponseQP0005 extends TransactionResponseBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5674290149003899644L;

	private String transTime;
	
	private String merOrderId;
	
	private String refNo;
	
	private String tranRespCode;
	
	private String storableCardNo;

	public String getMerOrderId() {
		return Util.maskString(merOrderId);
	}

	public void setMerOrderId(String merOrderId) {
		this.merOrderId = Util.maskString(merOrderId);
	}

	public String getTransTime() {
		return Util.maskString(transTime);
	}

	public void setTransTime(String transTime) {
		this.transTime = Util.maskString(transTime);
	}

	public String getRefNo() {
		return Util.maskString(refNo);
	}

	public void setRefNo(String refNo) {
		this.refNo = Util.maskString(refNo);
	}

	public String getTranRespCode() {
		return Util.maskString(tranRespCode);
	}

	public void setTranRespCode(String tranRespCode) {
		this.tranRespCode = Util.maskString(tranRespCode);
	}

	public String getStorableCardNo() {
		return Util.maskString(storableCardNo);
	}

	public void setStorableCardNo(String storableCardNo) {
		this.storableCardNo = Util.maskString(storableCardNo);
	}
	

	
}
