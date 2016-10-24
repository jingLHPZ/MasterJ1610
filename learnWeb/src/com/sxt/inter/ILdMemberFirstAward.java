package com.sxt.inter;

import java.util.List;

import com.sxt.models.LdMemberFirstAward;

import java.util.Map;

public interface ILdMemberFirstAward {

	/**
	 * 添加一个，并且给它分配ID
	 * @param ldMemberFirstAward
	 * @return 影响行数
	 */
	public int insert(LdMemberFirstAward ldMemberFirstAward);

	/**
	 * 编辑
	 * @param ldMemberFirstAward
	 * @return 影响行数
	 */
	public int update(LdMemberFirstAward ldMemberFirstAward);

	/**
	 * 根据ID删除
	 * @param id
	 * @return 影响行数
	 */
	public int delete(Long id);

	/**
	 * 根据条件查询List
	 * @param maps
	 * @return 
	 */
	public List<LdMemberFirstAward> queryLdMemberFirstAwardList(Map<String, Object> params);

	/**
	 * 根据条件查询
	 * @param ldMemberFirstAward
	 * @return 
	 */
	public LdMemberFirstAward queryLdMemberFirstAwardByCondition(LdMemberFirstAward ldMemberFirstAward);

	/**
	 * 根据条件查询总个数
	 * @param ldMemberFirstAward
	 * @return 
	 */
	public int queryLdMemberFirstAwardCount(Map<String, Object> params);

}
