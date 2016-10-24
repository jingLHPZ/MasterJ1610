package com.sxt.service.product.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.ILdYingxiangProduct;
import com.sxt.inter.ILdYingxiangProductDetail;
import com.sxt.models.LdYingxiangProduct;
import com.sxt.models.LdYingxiangProductDetail;
import com.sxt.service.product.YingXiangProductService;

/**
 *
 * @author 
 * @date：2016年4月15日 上午10:35:59
 * 
 */
@Service
public class YingXiangProductServiceImpl implements YingXiangProductService {

	@Autowired
	private ILdYingxiangProduct yingxiangProduct;
	@Autowired
	private ILdYingxiangProductDetail yingxiangProductDetail;
	
	@Override
	public List<LdYingxiangProduct> queryYingxiangProductList(
			Map<String, Object> maps) {
		return yingxiangProduct.queryLdYingxiangProductList(maps);
	}

	@Override
	public LdYingxiangProduct queryYingxiangProduct(String productId) {
		LdYingxiangProduct product = new LdYingxiangProduct();
		product.setProductId(productId);
		product = yingxiangProduct.queryLdYingxiangProductByCondition(product);
		return product;
	}

	@Override
	public LdYingxiangProductDetail queryYingxiangProductDetail(
			String productId) {
		LdYingxiangProductDetail product = new LdYingxiangProductDetail();
		product.setProductId(productId);
		product = yingxiangProductDetail.queryLdYingxiangProductDetailByCondition(product);
		return product;
	}

	@Override
	public Integer queryYingxiangProductCount(Map<String, Object> maps) {
		return yingxiangProduct.queryLdYingxiangProductCount(maps);
	}

	public LdYingxiangProduct queryLdYingxiangProductByCondition(LdYingxiangProduct ldYingxiangProduct) {
		return yingxiangProduct.queryLdYingxiangProductByCondition(ldYingxiangProduct);
	}
	
	/**
	 * 更新还款金额
	 * @param ldYingxiangProduct
	 * @return
	 */
	@Override
	public int updateRepaymentMoney(LdYingxiangProduct ldYingxiangProduct){
		return yingxiangProduct.updateRepaymentMoney(ldYingxiangProduct);
	}
	
	
	/**
	 * 更新状态
	 * @param para
	 * @return
	 */
	@Override
	public int updateYxByProductIdAndStatus(Map<String,Object> para){
		return yingxiangProduct.updateYxByProductIdAndStatus(para);
	}

}
