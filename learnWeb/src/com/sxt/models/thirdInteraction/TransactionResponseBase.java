package com.sxt.models.thirdInteraction;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sxt.util.Util;
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TransactionResponseBase implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7159977211827665687L;

	private String respCode;
	
	private String respMsg;

	public String getRespCode() {
		return Util.maskString(respCode);
	}

	public void setRespCode(String respCode) {
		this.respCode = Util.maskString(respCode);
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = Util.maskString(respMsg);
	}
	
	
}
