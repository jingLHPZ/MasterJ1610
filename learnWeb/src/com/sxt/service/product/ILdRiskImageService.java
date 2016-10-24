package com.sxt.service.product;

import java.util.List;

import com.sxt.models.LdRiskImage;

public interface ILdRiskImageService {
	
	public List<LdRiskImage> queryRiskImageList(Integer productId);
	
	public Integer queryRiskImageCount(Integer productId);
	
}
