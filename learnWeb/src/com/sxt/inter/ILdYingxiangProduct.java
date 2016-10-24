package com.sxt.inter;

import java.util.List;

import com.sxt.models.LdYingxiangProduct;

import java.util.Map;

public interface ILdYingxiangProduct {

	/**
	 * 添加一个盈享理财产品表，并且给它分配ID
	 * @param ldYingxiangProduct
	 * @return 影响行数
	 */
	public int insert(LdYingxiangProduct ldYingxiangProduct);

	/**
	 * 编辑盈享理财产品表
	 * @param ldYingxiangProduct
	 * @return 影响行数
	 */
	public int update(LdYingxiangProduct ldYingxiangProduct);
	
	/**
	 * 更新还款金额
	 * @param ldYingxiangProduct
	 * @return
	 */
	public int updateRepaymentMoney(LdYingxiangProduct ldYingxiangProduct);
	
	/**
	 * 更新状态
	 * @param para
	 * @return
	 */
	public int updateYxByProductIdAndStatus(Map<String,Object> para);

	/**
	 * 根据ID删除盈享理财产品表
	 * @param id
	 * @return 影响行数
	 */
	public int delete(Long id);

	/**
	 * 根据条件查询List盈享理财产品表
	 * @param maps
	 * @return 
	 */
	public List<LdYingxiangProduct> queryLdYingxiangProductList(Map<String, Object> params);

	/**
	 * 根据条件查询盈享理财产品表
	 * @param ldYingxiangProduct
	 * @return 
	 */
	public LdYingxiangProduct queryLdYingxiangProductByCondition(LdYingxiangProduct ldYingxiangProduct);

	/**
	 * 根据条件查询盈享理财产品表总个数
	 * @param ldYingxiangProduct
	 * @return 
	 */
	public int queryLdYingxiangProductCount(Map<String, Object> params);

}
