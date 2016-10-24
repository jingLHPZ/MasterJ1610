package com.sxt.service.project.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.IStableProduct;
import com.sxt.models.StableProduct;
import com.sxt.service.product.StableProductService;
@Service
public class StableProductServiceImpl implements StableProductService {
	@Autowired
	private IStableProduct iStableProduct;
	public List<StableProduct> fQuerySpPro() {
		return iStableProduct.fQuerySpPro();
	}

	public StableProduct fQuerySpProById(String product_id) {
		return iStableProduct.fQuerySpProById(product_id);
	}

}
