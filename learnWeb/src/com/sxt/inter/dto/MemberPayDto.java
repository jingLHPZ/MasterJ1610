package com.sxt.inter.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class MemberPayDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal rechargeMoney;
	private BigDecimal rechargeFee;

	public BigDecimal getRechargeMoney() {
		return rechargeMoney;
	}

	public void setRechargeMoney(BigDecimal rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}

	public BigDecimal getRechargeFee() {
		return rechargeFee;
	}

	public void setRechargeFee(BigDecimal rechargeFee) {
		this.rechargeFee = rechargeFee;
	}

}
