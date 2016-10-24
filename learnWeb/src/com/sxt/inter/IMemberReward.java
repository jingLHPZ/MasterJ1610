package com.sxt.inter;

import java.util.List;

import com.sxt.models.MemberReward;

/**
 * 用户奖励
 * @author 
 * @date：2015年11月10日 下午4:35:53
 * 
 */
public interface IMemberReward {

	/**
	 * 查询用户奖励
	 * @param memberReward
	 * @return
	 */
	public List<MemberReward> findMemberRewardList(MemberReward memberReward);
}
