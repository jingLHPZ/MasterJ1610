package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.SbProductOffInfo;

public interface ISbProductOffInfo {

	public List<SbProductOffInfo> querySbProduct(Map<String, Object> param);
	
	public Integer querySbProductCount();
	
}
