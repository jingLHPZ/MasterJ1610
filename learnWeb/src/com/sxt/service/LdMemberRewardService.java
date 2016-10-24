package com.sxt.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sxt.models.MemberReward;

/**
 * 用户奖励
 * @author 
 * @date：2015年11月10日 下午3:59:35
 * 
 */
public interface LdMemberRewardService {

	/**
	 * 查询奖励list
	 * @param memberReward
	 * @return
	 */
	public List<MemberReward> findMemberRewardList(MemberReward memberReward);
	
	/**
	 * 给以用户奖励
	 * @param type 奖励类型
	 * @param userId uid
	 * @param remoteAddr ip地址
	 * @param request
	 * @return
	 */
	public int affordUserAward(int type, int userId, String remoteAddr, HttpServletRequest request);
	
	/**
	 * 用户购买奖励
	 * @param paramMap
	 * @param request
	 * @return
	 */
	public int userBuyAward(Map<String, Object> paramMap, HttpServletRequest request);
}
