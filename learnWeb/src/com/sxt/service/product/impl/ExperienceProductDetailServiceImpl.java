package com.sxt.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.IExperienceProductDetail;
import com.sxt.models.ExperienceProductDetail;
import com.sxt.service.product.ExperienceProductDetailService;
@Service
public class ExperienceProductDetailServiceImpl implements ExperienceProductDetailService {
	@Autowired
	private IExperienceProductDetail experienceProductDetail;
	
	public ExperienceProductDetail fQueryMaxMinByPid(String productId) {
		return experienceProductDetail.fQueryMaxMinByPid(productId);
	}

}
