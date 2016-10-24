package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.inter.dto.IndexProductDto;
import com.sxt.models.CiProduct;

public interface ICiProduct {
	public List<CiProduct> fQueryAllPro();
	public CiProduct fQueryProById(String product_id);
	public CiProduct fQueryCiProByUid(int borrow_uid);
	public void fUpdateStateByProid(String productId);
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
