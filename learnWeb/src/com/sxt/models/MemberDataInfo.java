package com.sxt.models;

import java.io.Serializable;
import java.util.Date;

public class MemberDataInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Members members;// uid
	private String dataUrl;
	private Integer type;
	private Integer status;
	private Date addTime;
	private String dataName;
	private Integer size;
	private String ext;
	private String dealInfo;
	private Integer dealCredits;
	private Integer dealUser;// 交易人
	private Date dealTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Members getMembers() {
		return members;
	}
	public void setMembers(Members members) {
		this.members = members;
	}
	public String getDataUrl() {
		return dataUrl;
	}
	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public String getDealInfo() {
		return dealInfo;
	}
	public void setDealInfo(String dealInfo) {
		this.dealInfo = dealInfo;
	}
	public Integer getDealCredits() {
		return dealCredits;
	}
	public void setDealCredits(Integer dealCredits) {
		this.dealCredits = dealCredits;
	}
	public Integer getDealUser() {
		return dealUser;
	}
	public void setDealUser(Integer dealUser) {
		this.dealUser = dealUser;
	}
	public Date getDealTime() {
		return dealTime;
	}
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

}
