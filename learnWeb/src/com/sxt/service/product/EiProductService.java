package com.sxt.service.product;

import java.util.List;

import com.sxt.models.EiProduct;

public interface EiProductService {
	public List<EiProduct> fQueryEpPro();
	public EiProduct fQueryEpProById(String product_id);
}
