package com.sxt.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.IPeProductDetail;
import com.sxt.models.PeProductDetail;
import com.sxt.service.product.PeProductDetailService;
@Service
public class PeProductDetailServiceImpl implements PeProductDetailService {
	@Autowired
	private IPeProductDetail iPeProductDetail;
	public PeProductDetail fQueryMaxMinByPid(String proid) {
		return iPeProductDetail.fQueryMaxMinByPid(proid);
	}

}
