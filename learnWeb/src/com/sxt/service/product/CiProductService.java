package com.sxt.service.product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sxt.inter.dto.IndexProductDto;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.models.CiProduct;
import com.sxt.models.RewardRecord;

public interface CiProductService {
	
	public List<CiProduct> fQueryAllPro();
	
	public CiProduct fQueryProById(String product_id);
	
	public CiProduct fQueryCiProByUid(int borrow_uid);
	
	public void payProduct(String productId, BigDecimal investmoney, String systemtradeno, LocalUserDto lud, String ip);
	
	public void payProductByReward(String productId, BigDecimal investmoney, String systemtradeno, RewardRecord rewardRecord, LocalUserDto lud, String ip);
	
	public List<String> fqueryProductIds();
	
	public List<CiProduct> fqueryalltype();
	
	public List<IndexProductDto> fqueryAllProduct(Map<String,Object> param);
	
	public List<CiProduct> queryCiproductByMap(Map<String,Object> param);
	public Integer queryCiproductCount();
	
	public List<IndexProductDto> queryAllCiProduct();
	
	public String queryCiproductByProid(String productId);
	
	public IndexProductDto queryHotProduct();
	
	public Integer queryQuestionByUid(Integer uid);
	public IndexProductDto queryQuestionDateByUid(Integer uid);
	public List<IndexProductDto> queryIndexProduct();
	public String queryRiskTipBook(String productId);
	public Integer queryCountRisk(Map<String,Object> param);
	public IndexProductDto queryRiskDate(Map<String,Object> param);
	public void insertRisk(Map<String,Object> param);
}
