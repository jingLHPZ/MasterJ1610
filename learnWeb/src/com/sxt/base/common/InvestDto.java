package com.sxt.base.common;

import java.io.Serializable;
import java.math.BigDecimal;

public class InvestDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String productId;
	private BigDecimal investMoney;
	private String ip;
	private String systemTradeNo;
	private String rewardId;
	private Integer uid;
	private Integer type;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public BigDecimal getInvestMoney() {
		return investMoney;
	}
	public void setInvestMoney(BigDecimal investMoney) {
		this.investMoney = investMoney;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getSystemTradeNo() {
		return systemTradeNo;
	}
	public void setSystemTradeNo(String systemTradeNo) {
		this.systemTradeNo = systemTradeNo;
	}
	public String getRewardId() {
		return rewardId;
	}
	public void setRewardId(String rewardId) {
		this.rewardId = rewardId;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public InvestDto(String productId, BigDecimal investMoney, String ip,
			String systemTradeNo, String rewardId, Integer uid, Integer type) {
		super();
		this.productId = productId;
		this.investMoney = investMoney;
		this.ip = ip;
		this.systemTradeNo = systemTradeNo;
		this.rewardId = rewardId;
		this.uid = uid;
		this.type = type;
	}
	
	
	
	
}
