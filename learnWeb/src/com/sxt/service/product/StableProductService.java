package com.sxt.service.product;

import java.util.List;

import com.sxt.models.StableProduct;

public interface StableProductService {
	public List<StableProduct> fQuerySpPro();
	public StableProduct fQuerySpProById(String product_id);
}
