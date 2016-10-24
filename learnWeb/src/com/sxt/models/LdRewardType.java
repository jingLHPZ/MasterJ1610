package com.sxt.models;

import java.util.Date;

import java.io.Serializable;

/**
 * 类 ld_reward_type
 * @author 
 * @date 2016-03-03
 */
public class LdRewardType  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	private Date createTime;

	/**
	 * 奖品码类型
	 */
	private Integer rewardType;

	/**
	 * 奖品码内容
	 */
	private String rewardDesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getRewardType() {
		return rewardType;
	}

	public void setRewardType(Integer rewardType) {
		this.rewardType = rewardType;
	}

	public String getRewardDesc() {
		return rewardDesc;
	}

	public void setRewardDesc(String rewardDesc) {
		this.rewardDesc = rewardDesc;
	}

}
