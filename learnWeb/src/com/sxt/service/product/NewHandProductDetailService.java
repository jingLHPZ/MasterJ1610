package com.sxt.service.product;

import java.util.Map;

import com.sxt.models.NewHandProductDetail;

public interface NewHandProductDetailService {
	public NewHandProductDetail fQueryMaxMinByPid(String productId);
	
	public Integer queryCountByType(Map<String,Object> param);
}
