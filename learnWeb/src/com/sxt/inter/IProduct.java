package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.inter.dto.IndexProductDto;

public interface IProduct
{
	public List<IndexProductDto> fQueryAllProduct(Map<String,Object> param);
	
	public int fCountAllProduct(Map<String,Object> param);
	
	public List<IndexProductDto> fQueryAllSiproduct(Map<String,Object> param);
	
	public List<IndexProductDto> fQueryExperience(Map<String,Object> param);
	
	public List<IndexProductDto> getInvestCiproduct(Map<String, Object> param);
	
	public List<IndexProductDto> getSiAndPeProduct(Map<String, Object> param);
	
	public Integer getSiAndPeProductCount(Map<String, Object> param);
}
