package com.sxt.inter;

import java.util.List;

import com.sxt.models.LdSaleProxyMerchant;

import java.util.Map;

public interface ILdSaleProxyMerchant {

	/**
	 * 添加一个代销商家表，并且给它分配ID
	 * @param ldSaleProxyMerchant
	 * @return 影响行数
	 */
	public int insert(LdSaleProxyMerchant ldSaleProxyMerchant);

	/**
	 * 编辑代销商家表
	 * @param ldSaleProxyMerchant
	 * @return 影响行数
	 */
	public int update(LdSaleProxyMerchant ldSaleProxyMerchant);

	/**
	 * 根据ID删除代销商家表
	 * @param id
	 * @return 影响行数
	 */
	public int delete(Long id);

	/**
	 * 根据条件查询List代销商家表
	 * @param maps
	 * @return 
	 */
	public List<LdSaleProxyMerchant> queryLdSaleProxyMerchantList(Map<String, Object> params);

	/**
	 * 根据条件查询代销商家表
	 * @param ldSaleProxyMerchant
	 * @return 
	 */
	public LdSaleProxyMerchant queryLdSaleProxyMerchantByCondition(LdSaleProxyMerchant ldSaleProxyMerchant);

	/**
	 * 根据条件查询代销商家表总个数
	 * @param ldSaleProxyMerchant
	 * @return 
	 */
	public int queryLdSaleProxyMerchantCount(LdSaleProxyMerchant ldSaleProxyMerchant);

}
