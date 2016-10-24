package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MemberHouseInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uid;
	private String houseAddress;
	private Float houseSize;
	private String housePictureUrl;
	private BigDecimal housePrice;
	private String houseFiled1;
	private String houseFiled2;
	private Integer houseLoan;
	private BigDecimal houseMonthlyPayment;
	private String houseLoanBank;
	private Date createTime;
	private Date updateTime;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public Float getHouseSize() {
		return houseSize;
	}

	public void setHouseSize(Float houseSize) {
		this.houseSize = houseSize;
	}

	public String getHousePictureUrl() {
		return housePictureUrl;
	}

	public void setHousePictureUrl(String housePictureUrl) {
		this.housePictureUrl = housePictureUrl;
	}

	public BigDecimal getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(BigDecimal housePrice) {
		this.housePrice = housePrice;
	}

	public String getHouseFiled1() {
		return houseFiled1;
	}

	public void setHouseFiled1(String houseFiled1) {
		this.houseFiled1 = houseFiled1;
	}

	public String getHouseFiled2() {
		return houseFiled2;
	}

	public void setHouseFiled2(String houseFiled2) {
		this.houseFiled2 = houseFiled2;
	}

	public Integer getHouseLoan() {
		return houseLoan;
	}

	public void setHouseLoan(Integer houseLoan) {
		this.houseLoan = houseLoan;
	}

	public BigDecimal getHouseMonthlyPayment() {
		return houseMonthlyPayment;
	}

	public void setHouseMonthlyPayment(BigDecimal houseMonthlyPayment) {
		this.houseMonthlyPayment = houseMonthlyPayment;
	}

	public String getHouseLoanBank() {
		return houseLoanBank;
	}

	public void setHouseLoanBank(String houseLoanBank) {
		this.houseLoanBank = houseLoanBank;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	
}
