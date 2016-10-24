package com.sxt.service.project.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.ISurplusProduct;
import com.sxt.models.SurplusProduct;
import com.sxt.service.product.SurplusProductService;
@Service
public class SurplusProductServiceImpl implements SurplusProductService {
	@Autowired
	private ISurplusProduct  iSurplusProduct;
	public List<SurplusProduct> fQuerySurplusPro() {
		return iSurplusProduct.fQuerySurplusPro();
	}
	public SurplusProduct fQuerySurplusProById(String product_id) {
		return iSurplusProduct.fQuerySurplusProById(product_id);
	}

}
