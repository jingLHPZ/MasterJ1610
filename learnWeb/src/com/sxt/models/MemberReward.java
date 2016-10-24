package com.sxt.models;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户奖励
 * @author 
 * @date：2015年11月10日 下午4:09:55
 * 
 */
public class MemberReward implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Integer id;
	public Integer type;
	public String pro_name;
	public Integer pro_value;
	public Date create_time;
	public Date update_time;
	public String status;
	public Integer reward_type;
	public Integer proObject;
	public Integer proWay;
	public Integer rewardLimit;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public Integer getPro_value() {
		return pro_value;
	}
	public void setPro_value(Integer pro_value) {
		this.pro_value = pro_value;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getReward_type() {
		return reward_type;
	}
	public void setReward_type(Integer reward_type) {
		this.reward_type = reward_type;
	}
	public Integer getProObject() {
		return proObject;
	}
	public void setProObject(Integer proObject) {
		this.proObject = proObject;
	}
	public Integer getProWay() {
		return proWay;
	}
	public void setProWay(Integer proWay) {
		this.proWay = proWay;
	}
	public Integer getRewardLimit() {
		return rewardLimit;
	}
	public void setRewardLimit(Integer rewardLimit) {
		this.rewardLimit = rewardLimit;
	}


}
