package com.sxt.models.thirdInteraction;

public class TransactionResponseQP0007 extends TransactionResponseBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2197450361379703904L;

	private String cardType;
	
	private String bankNo;
	
	private String bankNm;

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getBankNm() {
		return bankNm;
	}

	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
	}
	
	
}
