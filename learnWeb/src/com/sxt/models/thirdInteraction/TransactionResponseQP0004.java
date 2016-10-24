package com.sxt.models.thirdInteraction;

import java.util.Set;

import com.sxt.util.Util;

public class TransactionResponseQP0004  extends TransactionResponseBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1390440134201192581L;

	private String custId;
	
	private String cardNum;
	
	private Set<TransactionResponseCardInfo> setTransactionResponseCardInfo;

	public String getCustId() {
		return Util.maskString(custId);
	}

	public void setCustId(String custId) {
		this.custId = Util.maskString(custId);
	}

	public String getCardNum() {
		return Util.maskString(cardNum);
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public Set<TransactionResponseCardInfo> getSetTransactionResponseCardInfo() {
		return setTransactionResponseCardInfo;
	}

	public void setSetTransactionResponseCardInfo(
			Set<TransactionResponseCardInfo> setTransactionResponseCardInfo) {
		this.setTransactionResponseCardInfo = setTransactionResponseCardInfo;
	}

	

}
