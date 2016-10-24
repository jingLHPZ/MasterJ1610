package com.sxt.inter;

import java.util.List;

import com.sxt.models.LdRiskImage;

public interface ILdRiskImage {
	
	public List<LdRiskImage> queryRiskImageList(Integer productId);
	
	public Integer queryRiskImageCount(Integer productId);
	
}
