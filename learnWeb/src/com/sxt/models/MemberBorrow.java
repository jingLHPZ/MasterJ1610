package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MemberBorrow implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer uid;
	private String telphoneNumber;
	private Integer isVouch;
	private String memo;
	private Integer borrowDuration;
	private BigDecimal borrowMoney;
	private String borrowTitle;
	private Date createTime;
	private String province;
	private String city;
	private Integer borrowStatus;
	private String realName;
	
	public String getRealName()
	{
		return realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getTelphoneNumber() {
		return telphoneNumber;
	}

	public void setTelphoneNumber(String telphoneNumber) {
		this.telphoneNumber = telphoneNumber;
	}

	public Integer getIsVouch() {
		return isVouch;
	}

	public void setIsVouch(Integer isVouch) {
		this.isVouch = isVouch;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getBorrowDuration() {
		return borrowDuration;
	}

	public void setBorrowDuration(Integer borrowDuration) {
		this.borrowDuration = borrowDuration;
	}

	public BigDecimal getBorrowMoney() {
		return borrowMoney;
	}

	public void setBorrowMoney(BigDecimal borrowMoney) {
		this.borrowMoney = borrowMoney;
	}

	public String getBorrowTitle() {
		return borrowTitle;
	}

	public void setBorrowTitle(String borrowTitle) {
		this.borrowTitle = borrowTitle;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getBorrowStatus() {
		return borrowStatus;
	}

	public void setBorrowStatus(Integer borrowStatus) {
		this.borrowStatus = borrowStatus;
	}

}
