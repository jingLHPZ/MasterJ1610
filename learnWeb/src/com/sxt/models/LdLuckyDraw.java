package com.sxt.models;

import java.io.Serializable;
import java.util.Date;

public class LdLuckyDraw implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer uid;
	private Integer awardType;
	private Date awardTime;
	private String userName;
	private Integer consumeCore;
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
	public Integer getAwardType() {
		return awardType;
	}
	public void setAwardType(Integer awardType) {
		this.awardType = awardType;
	}
	public Date getAwardTime() {
		return awardTime;
	}
	public void setAwardTime(Date awardTime) {
		this.awardTime = awardTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getConsumeCore() {
		return consumeCore;
	}
	public void setConsumeCore(Integer consumeCore) {
		this.consumeCore = consumeCore;
	}
	
}
