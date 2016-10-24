package com.sxt.inter;

import java.util.Map;

import com.sxt.models.NewHandProductDetail;

public interface INewHandProductDetail {

	public NewHandProductDetail fQueryMaxMinByPid(String productId);
	
	public Integer queryCountByType(Map<String,Object> param);
}
