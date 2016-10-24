package com.sxt.service.product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sxt.inter.dto.LocalUserDto;
import com.sxt.models.RewardRecord;
import com.sxt.models.PeProduct;

public interface PeProductService {
	
	public PeProduct fQueryProById(String product_id);
	
	public List<PeProduct> fQueryListSiProByUid(int borrow_uid);
	
	public void payProduct(String productId, BigDecimal investmoney, String systemtradeno,
			LocalUserDto lud, String ip, HttpServletRequest request);
	
	public void payProductByReward(String productId, BigDecimal investmoney, String systemtradeno, 
			RewardRecord rewardRecord, LocalUserDto lud, String ip, HttpServletRequest request);
	
	public Integer fqueryCountbyCiProductId(String ci_product_id);
	
	public List<PeProduct> fqueryPeProductbyCiProductId(Map<String,Object> param);
	
	public void update(PeProduct product);
	
	public PeProduct getProductById(String productId);
	
	public String querySiproductByProid(String productId);
	
	public void updateByProductIdAndStatus(Map<String,Object> param);
}
