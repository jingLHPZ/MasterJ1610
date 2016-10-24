package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.SiProduct;

public interface ISiProduct {
	public List<SiProduct> fQuerySiPro();
	
	public SiProduct fQueryProById(String product_id);
	
	public List<SiProduct> fQuerySiProObj(Map<String,Object> map);
	
	public int fquerycountsipro();
	
	public List<SiProduct> fquerybyparam(Map<String,Object> map);
	
	public int fquerycountbypara(Map<String,Object> map);
	
	public void fUpdateStateByProid(String product_id);
	
	public List<SiProduct> fQueryListSiProByUid(int borrow_uid);
	
	public SiProduct fQuerySiProByUid(int borrow_uid);
	
	public List<SiProduct> fQueryPageByMap(Map<String,Object> param);
	
	public Integer fQueryPageCountByMap(Map<String,Object> param);
	
	public List<SiProduct> fQueryNewHandProductByMap(Map<String,Object> param);
	
	public List<SiProduct> fQueryExperienceProductByMap(Map<String,Object> param);
	
	public Integer fqueryCountbyCiProductId(String ci_product_id);
	
	public List<SiProduct> fquerySiProductbyCiProductId(Map<String,Object> param);
	
	public List<SiProduct> fquerysiproduct(Map<String,Object> param);
	
	public List<SiProduct> fquerySiproductByMap(Map<String,Object> param);
	
	public List<SiProduct> querySiProductbyCiProductId(String ci_product_id);
	
	public String[] queryProductIdbyCiProductId(String ci_product_id);
	
	public void updateStateByProid(Map<String,Object> param);
	
	public void update(SiProduct product);
	
	public SiProduct getProductById(String productId);
	
	public String querySiproductByProid(String productId);
	
	public void updateByProductIdAndStatus(Map<String,Object> param);
}
