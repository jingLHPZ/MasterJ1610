package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.PeProduct;

public interface IPeProduct {
	public List<PeProduct> fQuerySiPro();
	
	public PeProduct fQueryProById(String product_id);
	
	public List<PeProduct> fQuerySiProObj(Map<String,Object> map);
	
	public int fquerycountsipro();
	
	public List<PeProduct> fquerybyparam(Map<String,Object> map);
	
	public int fquerycountbypara(Map<String,Object> map);
	
	public void fUpdateStateByProid(String product_id);
	
	public List<PeProduct> fQueryListSiProByUid(int borrow_uid);
	
	public PeProduct fQuerySiProByUid(int borrow_uid);
	
	public List<PeProduct> fQueryPageByMap(Map<String,Object> param);
	
	public Integer fQueryPageCountByMap(Map<String,Object> param);
	
	public List<PeProduct> fQueryNewHandProductByMap(Map<String,Object> param);
	
	public List<PeProduct> fQueryExperienceProductByMap(Map<String,Object> param);
	
	public Integer fqueryCountbyCiProductId(String ci_product_id);
	
	public List<PeProduct> fqueryPeProductbyCiProductId(Map<String,Object> param);
	
	public List<PeProduct> fquerysiproduct(Map<String,Object> param);
	
	public List<PeProduct> fquerySiproductByMap(Map<String,Object> param);
	
	public List<PeProduct> queryPeProductbyCiProductId(String ci_product_id);
	
	public String[] queryProductIdbyCiProductId(String ci_product_id);
	
	public void updateStateByProid(Map<String,Object> param);
	
	public void update(PeProduct product);
	
	public PeProduct getProductById(String productId);
	
	public String querySiproductByProid(String productId);
	
	public void updateByProductIdAndStatus(Map<String,Object> param);
}
