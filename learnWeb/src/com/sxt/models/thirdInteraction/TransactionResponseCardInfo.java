package com.sxt.models.thirdInteraction;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sxt.util.Util;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TransactionResponseCardInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3942210598526570589L;

	private String storableCardNo;
	
	private String bankNo;
	
	private String cardType;
	
	private String  phoneNo;

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

	public String getCardType() {
		return Util.maskString(cardType);
	}

	public void setCardType(String cardType) {
		this.cardType = Util.maskString(cardType);
	}

	public String getPhoneNo() {
		return Util.maskString(phoneNo);
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = Util.maskString(phoneNo);
	}
	
	
}
