package com.sxt.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.ISiProductDetail;
import com.sxt.models.SiProductDetail;
import com.sxt.service.product.SiProductDetailService;
@Service
public class SiProductDetailServiceImpl implements SiProductDetailService {
	@Autowired
	private ISiProductDetail iSiProductDetail;
	public SiProductDetail fQueryMaxMinByPid(String proid) {
		return iSiProductDetail.fQueryMaxMinByPid(proid);
	}

}
