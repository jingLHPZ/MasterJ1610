package com.sxt.models;

import java.io.Serializable;
import java.util.Date;

public class LdMemberScoreDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer uid;
	private Integer type;
	private Integer affectScore;
	private Integer totalScore;
	private String info;
	private Date createTime;
	private String addIp;
	private String systemTraceNo;
	private Integer operateMode;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getAffectScore() {
		return affectScore;
	}
	public void setAffectScore(Integer affectScore) {
		this.affectScore = affectScore;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getAddIp() {
		return addIp;
	}
	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}
	public String getSystemTraceNo() {
		return systemTraceNo;
	}
	public void setSystemTraceNo(String systemTraceNo) {
		this.systemTraceNo = systemTraceNo;
	}
	public Integer getOperateMode() {
		return operateMode;
	}
	public void setOperateMode(Integer operateMode) {
		this.operateMode = operateMode;
	}
	
	
}
