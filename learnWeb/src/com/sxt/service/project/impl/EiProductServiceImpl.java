package com.sxt.service.project.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.IEiProduct;
import com.sxt.models.EiProduct;
import com.sxt.service.product.EiProductService;
@Service
public class EiProductServiceImpl implements EiProductService  {
	@Autowired
	private IEiProduct iEiProduct;
	public List<EiProduct> fQueryEpPro() {
		return iEiProduct.fQueryEpPro();
	}
	public EiProduct fQueryEpProById(String product_id) {
		return iEiProduct.fQueryEpProById(product_id);
	}

}
