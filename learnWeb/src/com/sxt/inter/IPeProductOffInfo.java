package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.PeProductOffInfo;

public interface IPeProductOffInfo {

	public List<PeProductOffInfo> queryPeProduct(Map<String, Object> param);
	
	public Integer queryPeProductCount();
}
