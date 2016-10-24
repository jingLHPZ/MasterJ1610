package com.sxt.models.thirdInteraction;

import com.sxt.util.Util;

public class TransactionResponseQP0002 extends TransactionResponseBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3213965214919382959L;

	private String phoneToken;
	
	private String merOrderId;
	
	private String custId;

	public String getPhoneToken() {
		return Util.maskString(phoneToken);
	}

	public void setPhoneToken(String phoneToken) {
		this.phoneToken = Util.maskString(phoneToken);
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
	
	
	
	
}
