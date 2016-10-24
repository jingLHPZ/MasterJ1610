package com.sxt.inter;

import java.util.List;

import com.sxt.models.LdSaleProxyMembers;

import java.util.Map;

public interface ILdSaleProxyMembers {

	/**
	 * 添加一个代销商家用户，并且给它分配ID
	 * @param ldSaleProxyMembers
	 * @return 影响行数
	 */
	public int insert(LdSaleProxyMembers ldSaleProxyMembers);

	/**
	 * 编辑代销商家用户
	 * @param ldSaleProxyMembers
	 * @return 影响行数
	 */
	public int update(LdSaleProxyMembers ldSaleProxyMembers);

	/**
	 * 根据ID删除代销商家用户
	 * @param id
	 * @return 影响行数
	 */
	public int delete(Long id);

	/**
	 * 根据条件查询List代销商家用户
	 * @param maps
	 * @return 
	 */
	public List<LdSaleProxyMembers> queryLdSaleProxyMembersList(Map<String, Object> params);

	/**
	 * 根据条件查询代销商家用户
	 * @param ldSaleProxyMembers
	 * @return 
	 */
	public LdSaleProxyMembers queryLdSaleProxyMembersByCondition(LdSaleProxyMembers ldSaleProxyMembers);

	/**
	 * 根据条件查询代销商家用户总个数
	 * @param ldSaleProxyMembers
	 * @return 
	 */
	public int queryLdSaleProxyMembersCount(LdSaleProxyMembers ldSaleProxyMembers);

}
