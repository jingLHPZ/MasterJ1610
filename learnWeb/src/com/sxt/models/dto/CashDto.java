package com.sxt.models.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * CashDto.java
 * 
 * @Description 现金理财申购/赎回请求实体
 * @author 
 * @date 2016年2月29日 下午2:04:35
 * @version 1.0
 */
public class CashDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer uid;
	private BigDecimal cashMoney;
	private String ip;
	private Integer cashType;
	private String systemTradeNo;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public BigDecimal getCashMoney() {
		return cashMoney;
	}

	public void setCashMoney(BigDecimal cashMoney) {
		this.cashMoney = cashMoney;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getCashType() {
		return cashType;
	}

	public void setCashType(Integer cashType) {
		this.cashType = cashType;
	}

	public String getSystemTradeNo() {
		return systemTradeNo;
	}

	public void setSystemTradeNo(String systemTradeNo) {
		this.systemTradeNo = systemTradeNo;
	}
	
}
