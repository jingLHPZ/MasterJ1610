package com.sxt.models.thirdInteraction;

import com.sxt.util.Util;

public class TransactionResponseSC0002 extends TransactionResponseBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3432302743709602068L;

	private String idName;
	
	private String idNum;

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

}
