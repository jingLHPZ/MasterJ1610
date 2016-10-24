package com.sxt.inter;

import java.util.List;

import com.sxt.models.CiProduct;
import com.sxt.models.EiProduct;
import com.sxt.models.SiProduct;

public interface IEiProduct {
	public List<EiProduct> fQueryEpPro();
	public EiProduct fQueryEpProById(String product_id);
}
