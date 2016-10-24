package com.sxt.service;

import java.util.List;
import java.util.Map;

import com.sxt.models.PeProductOffInfo;
import com.sxt.models.SbProductOffInfo;

public interface PeProductOffInfoService {

	public List<PeProductOffInfo> queryPeProduct(Map<String, Object> param);
	
	public Integer queryPeProductCount();
	
}
