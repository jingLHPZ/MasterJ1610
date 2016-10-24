package com.sxt.service.product;

import java.util.List;

import com.sxt.models.SurplusProduct;

public interface SurplusProductService {
	public List<SurplusProduct> fQuerySurplusPro();
	public SurplusProduct fQuerySurplusProById(String product_id);
}
