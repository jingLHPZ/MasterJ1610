package com.sxt.inter;

import java.util.List;

import com.sxt.models.LdYingxiangProductDetail;

import java.util.Map;

public interface ILdYingxiangProductDetail {

	/**
	 * 添加一个盈享理财产品详情表，并且给它分配ID
	 * @param ldYingxiangProductDetail
	 * @return 影响行数
	 */
	public int insert(LdYingxiangProductDetail ldYingxiangProductDetail);

	/**
	 * 编辑盈享理财产品详情表
	 * @param ldYingxiangProductDetail
	 * @return 影响行数
	 */
	public int update(LdYingxiangProductDetail ldYingxiangProductDetail);

	/**
	 * 根据ID删除盈享理财产品详情表
	 * @param id
	 * @return 影响行数
	 */
	public int delete(Long id);

	/**
	 * 根据条件查询List盈享理财产品详情表
	 * @param maps
	 * @return 
	 */
	public List<LdYingxiangProductDetail> queryLdYingxiangProductDetailList(Map<String, Object> params);

	/**
	 * 根据条件查询盈享理财产品详情表
	 * @param ldYingxiangProductDetail
	 * @return 
	 */
	public LdYingxiangProductDetail queryLdYingxiangProductDetailByCondition(LdYingxiangProductDetail ldYingxiangProductDetail);

	/**
	 * 根据条件查询盈享理财产品详情表总个数
	 * @param ldYingxiangProductDetail
	 * @return 
	 */
	public int queryLdYingxiangProductDetailCount(LdYingxiangProductDetail ldYingxiangProductDetail);

}
