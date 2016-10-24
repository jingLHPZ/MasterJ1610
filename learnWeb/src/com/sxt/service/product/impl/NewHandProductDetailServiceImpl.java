package com.sxt.service.product.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.INewHandProductDetail;
import com.sxt.models.NewHandProductDetail;
import com.sxt.service.product.NewHandProductDetailService;
@Service
public class NewHandProductDetailServiceImpl implements NewHandProductDetailService {
	@Autowired
	private INewHandProductDetail newHandProductDetail;
	
	public NewHandProductDetail fQueryMaxMinByPid(String productId) {
		return newHandProductDetail.fQueryMaxMinByPid(productId);
	}
	
	public Integer queryCountByType(Map<String,Object> param){
		return newHandProductDetail.queryCountByType(param);
	}
}
