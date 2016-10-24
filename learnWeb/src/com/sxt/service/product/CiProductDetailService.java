package com.sxt.service.product;

import com.sxt.models.CiProductDetail;

public interface CiProductDetailService {
	public CiProductDetail fQueryMaxMinByPid(String productId);
}
