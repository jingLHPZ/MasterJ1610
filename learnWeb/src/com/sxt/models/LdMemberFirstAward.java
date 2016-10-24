package com.sxt.models;

import java.util.Date;

import java.io.Serializable;

/**
 * 类 ld_member_first_award
 * @author 
 * @date 2016-04-22
 */
public class LdMemberFirstAward  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	private Integer uid;

	/**
	 * 
	 */
	private Integer awardType;
	
	/**
	 * 
	 */
	private Integer operateMode;

	/**
	 * 
	 */
	private Date createTime;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getOperateMode() {
		return operateMode;
	}

	public void setOperateMode(Integer operateMode) {
		this.operateMode = operateMode;
	}

}
