package com.sxt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.ISbProductOffInfo;
import com.sxt.models.SbProductOffInfo;
import com.sxt.service.SbProductOffInfoService;

@Service
public class SbProductOffInfoServiceImpl implements SbProductOffInfoService {

	@Autowired
	private ISbProductOffInfo iSbProductOffInfo;
	
	public List<SbProductOffInfo> querySbProduct(Map<String, Object> param) {
		return iSbProductOffInfo.querySbProduct(param);
	}

	public Integer querySbProductCount() {
		return iSbProductOffInfo.querySbProductCount();
	}
}
