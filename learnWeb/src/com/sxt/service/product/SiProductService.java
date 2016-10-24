package com.sxt.service.product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sxt.inter.dto.LocalUserDto;
import com.sxt.models.RewardRecord;
import com.sxt.models.SiProduct;

public interface SiProductService {
	
	public SiProduct fQueryProById(String product_id);
	
	public List<SiProduct> fQueryListSiProByUid(int borrow_uid);
	
	public void payProduct(String productId, BigDecimal investmoney, String systemtradeno,
			LocalUserDto lud, String ip, HttpServletRequest request);
	
	public void payProductByReward(String productId, BigDecimal investmoney, String systemtradeno, 
			RewardRecord rewardRecord, LocalUserDto lud, String ip, HttpServletRequest request);
	
	public Integer fqueryCountbyCiProductId(String ci_product_id);
	
	public List<SiProduct> fquerySiProductbyCiProductId(Map<String,Object> param);
	
	public void update(SiProduct product);
	
	public SiProduct getProductById(String productId);
	
	public String querySiproductByProid(String productId);
	
	public void updateByProductIdAndStatus(Map<String,Object> param);
}
