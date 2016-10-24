package com.sxt.service;

import java.util.List;
import java.util.Map;

import com.sxt.models.SbProductOffInfo;

public interface SbProductOffInfoService {

	public List<SbProductOffInfo> querySbProduct(Map<String, Object> param);
	
	public Integer querySbProductCount();
}
