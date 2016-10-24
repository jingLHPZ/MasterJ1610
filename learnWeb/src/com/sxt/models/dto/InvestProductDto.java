package com.sxt.models.dto;

import java.math.BigDecimal;

/**
 *
 * @author 
 * @date：2016年5月11日 下午6:01:11
 * 
 */
public class InvestProductDto {

	private String productId;
	private Integer rewardId;
	private BigDecimal investMoney;
	private String payPass;
	private Integer uid;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getRewardId() {
		return rewardId;
	}
	public void setRewardId(Integer rewardId) {
		this.rewardId = rewardId;
	}
	public BigDecimal getInvestMoney() {
		return investMoney;
	}
	public void setInvestMoney(BigDecimal investMoney) {
		this.investMoney = investMoney;
	}
	public String getPayPass() {
		return payPass;
	}
	public void setPayPass(String payPass) {
		this.payPass = payPass;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
}
