package com.sxt.service.product;

import java.util.List;
import java.util.Map;

import com.sxt.models.LdYingxiangProduct;
import com.sxt.models.LdYingxiangProductDetail;


/**
 *
 * @author 
 * @date：2016年4月15日 上午9:50:18
 * 
 */
public interface YingXiangProductService {

	/**
	 * 查询理财列表
	 * @param maps
	 * @return
	 */
	public List<LdYingxiangProduct> queryYingxiangProductList(Map<String, Object> maps);
	
	/**
	 * 查询列表总数
	 * @param maps
	 * @return
	 */
	public Integer queryYingxiangProductCount(Map<String, Object> maps);
	
	/**
	 * 查询产品信息
	 * @param productId
	 * @return
	 */
	public LdYingxiangProduct queryYingxiangProduct(String productId);
	
	/**
	 * 查询产品明细
	 * @param productId
	 * @return
	 */
	public LdYingxiangProductDetail queryYingxiangProductDetail(String productId);
	
	public LdYingxiangProduct queryLdYingxiangProductByCondition(LdYingxiangProduct ldYingxiangProduct);
	
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
}
