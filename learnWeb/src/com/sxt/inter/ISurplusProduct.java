package com.sxt.inter;

import java.util.List;

import com.sxt.models.CiProduct;
import com.sxt.models.SiProduct;
import com.sxt.models.SurplusProduct;

public interface ISurplusProduct {
	public List<SurplusProduct> fQuerySurplusPro();
	public SurplusProduct fQuerySurplusProById(String product_id);
}
