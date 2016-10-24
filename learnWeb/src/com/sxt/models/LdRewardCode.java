package com.sxt.models;

import java.util.Date;

import java.io.Serializable;

/**
 * 类 ld_reward_code
 * @author 
 * @date 2016-03-02
 */
public class LdRewardCode  implements Serializable {

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
	 * 奖励发送码
	 */
	private String code;

	/**
	 * 奖励使用类型
	 */
	private Integer rewardTypeId;

	/**
	 * 是否被使用，0：未使用；1：已使用
	 */
	private String isUsed;

	/**
	 * 
	 */
	private Date createTime;

	/**
	 * 使用时间
	 */
	private Date useTime;

	/**
	 * 来源渠道
	 */
	private String source;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getRewardTypeId() {
		return rewardTypeId;
	}

	public void setRewardTypeId(Integer rewardTypeId) {
		this.rewardTypeId = rewardTypeId;
	}

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUseTime() {
		return useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
