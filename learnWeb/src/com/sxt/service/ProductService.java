package com.sxt.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sxt.inter.dto.IndexProductDto;

public interface ProductService
{
	public List<IndexProductDto> fQueryAllProduct(Map<String,Object> param);
	
	public int fCountAllProduct(Map<String,Object> param);
	
	public List<IndexProductDto> fQueryAllSiproduct(Map<String,Object> param);
	
	public List<IndexProductDto> fQueryExperience(Map<String,Object> param);
	
	public List<IndexProductDto> getInvestCiproduct(Map<String,Object> param);
	
	/**
	 * 用户购买后产品奖励
	 * 
	 * @param uid
	 * 				用户uid
	 * @param productId
	 * 				产品id
	 * @param buyMoney
	 * 				用户购买本金
	 * @param ip
	 * 				ip地址
	 */
	public void userBuyProductAward(int uid, String productId, BigDecimal buyMoney, String ip);
	
	public List<IndexProductDto> getSiAndPeProduct(Map<String,Object> param);
	
	public Integer getSiAndPeProductCount(Map<String, Object> param);
}
