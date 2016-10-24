package com.sxt.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.ICiProductDetail;
import com.sxt.models.CiProductDetail;
import com.sxt.service.product.CiProductDetailService;
@Service
public class CiProductDetailServiceImpl implements CiProductDetailService {
	@Autowired
	private ICiProductDetail ciProductDetail;
	
	public CiProductDetail fQueryMaxMinByPid(String productId) {
		return ciProductDetail.fQueryMaxMinByPid(productId);
	}

}
