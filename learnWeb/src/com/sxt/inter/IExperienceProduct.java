package com.sxt.inter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sxt.models.ExperienceProduct;

public interface IExperienceProduct {
	public List<ExperienceProduct> fQueryProduct();
	public ExperienceProduct fqueryProductById(String productId);
	public void fUpdateStateByProid(String productId);
	
	public List<ExperienceProduct> fQueryProid();
	
	public String queryExperienceProductByProid(String productId);
	
	public List<String> querySystemTraceNos(Map<String, Object> param);
	
	public BigDecimal queryAffectExperienceGold(Map<String, Object> param);
	
	public List<String> querySystemTraceNosByUid(Map<String, Object> param);
	
	public String queryExProductNameByTraceNo(String productId);
}
