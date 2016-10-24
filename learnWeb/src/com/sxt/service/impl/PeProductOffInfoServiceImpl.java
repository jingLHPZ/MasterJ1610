package com.sxt.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sxt.inter.IPeProductOffInfo;
import com.sxt.models.PeProductOffInfo;
import com.sxt.service.PeProductOffInfoService;

@Service
public class PeProductOffInfoServiceImpl implements PeProductOffInfoService {

	@Autowired
	private IPeProductOffInfo iPeProductOffInfo;
	
	public List<PeProductOffInfo> queryPeProduct(Map<String, Object> param) {
		return iPeProductOffInfo.queryPeProduct(param);
	}
	
	public Integer queryPeProductCount() {
		return iPeProductOffInfo.queryPeProductCount();
	}

}
