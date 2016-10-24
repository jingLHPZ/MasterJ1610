package com.sxt.inter;

import java.util.List;

import com.sxt.models.LdSaleProxyProduct;

import java.util.Map;

public interface ILdSaleProxyProduct {

	/**
	 * 添加一个代销产品表，并且给它分配ID
	 * @param ldSaleProxyProduct
	 * @return 影响行数
	 */
	public int insert(LdSaleProxyProduct ldSaleProxyProduct);

	/**
	 * 编辑代销产品表
	 * @param ldSaleProxyProduct
	 * @return 影响行数
	 */
	public int update(LdSaleProxyProduct ldSaleProxyProduct);

	/**
	 * 根据ID删除代销产品表
	 * @param id
	 * @return 影响行数
	 */
	public int delete(Long id);

	/**
	 * 根据条件查询List代销产品表
	 * @param maps
	 * @return 
	 */
	public List<LdSaleProxyProduct> queryLdSaleProxyProductList(Map<String, Object> params);

	/**
	 * 根据条件查询代销产品表
	 * @param ldSaleProxyProduct
	 * @return 
	 */
	public LdSaleProxyProduct queryLdSaleProxyProductByCondition(LdSaleProxyProduct ldSaleProxyProduct);

	/**
	 * 根据条件查询代销产品表总个数
	 * @param ldSaleProxyProduct
	 * @return 
	 */
	public int queryLdSaleProxyProductCount(LdSaleProxyProduct ldSaleProxyProduct);

}
