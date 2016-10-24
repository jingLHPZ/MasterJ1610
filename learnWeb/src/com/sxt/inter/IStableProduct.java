package com.sxt.inter;

import java.util.List;

import com.sxt.models.CiProduct;
import com.sxt.models.SiProduct;
import com.sxt.models.StableProduct;

public interface IStableProduct {
	public List<StableProduct> fQuerySpPro();
	public StableProduct fQuerySpProById(String product_id);
}
