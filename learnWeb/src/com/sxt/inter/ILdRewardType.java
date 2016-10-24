package com.sxt.inter;

import java.util.List;

import com.sxt.models.LdRewardType;

import java.util.Map;

public interface ILdRewardType {

	/**
	 * 添加一个，并且给它分配ID
	 * @param ldRewardType
	 * @return 影响行数
	 */
	public int insert(LdRewardType ldRewardType);

	/**
	 * 编辑
	 * @param ldRewardType
	 * @return 影响行数
	 */
	public int update(LdRewardType ldRewardType);

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
	public List<LdRewardType> queryLdRewardTypeList(Map<String, Object> params);

	/**
	 * 根据条件查询
	 * @param ldRewardType
	 * @return 
	 */
	public LdRewardType queryLdRewardTypeByCondition(LdRewardType ldRewardType);

	/**
	 * 根据条件查询总个数
	 * @param ldRewardType
	 * @return 
	 */
	public int queryLdRewardTypeCount(LdRewardType ldRewardType);

}
