package com.sxt.inter;

import java.util.List;

import com.sxt.models.LdRewardCode;

import java.util.Map;

public interface ILdRewardCode {

	/**
	 * 添加一个，并且给它分配ID
	 * @param ldRewardCode
	 * @return 影响行数
	 */
	public int insert(LdRewardCode ldRewardCode);

	/**
	 * 编辑
	 * @param ldRewardCode
	 * @return 影响行数
	 */
	public int update(LdRewardCode ldRewardCode);

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
	public List<LdRewardCode> queryLdRewardCodeList(Map<String, Object> params);

	/**
	 * 根据条件查询
	 * @param ldRewardCode
	 * @return 
	 */
	public LdRewardCode queryLdRewardCodeByCondition(LdRewardCode ldRewardCode);

	/**
	 * 根据条件查询总个数
	 * @param ldRewardCode
	 * @return 
	 */
	public int queryLdRewardCodeCount(LdRewardCode ldRewardCode);

}
