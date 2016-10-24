package com.sxt.models.thirdInteraction;

import com.sxt.util.Util;

public class TransactionResponseQP0003 extends TransactionResponseBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5118210976097620551L;

	private String merOrderId;
	
	private String custId;

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
