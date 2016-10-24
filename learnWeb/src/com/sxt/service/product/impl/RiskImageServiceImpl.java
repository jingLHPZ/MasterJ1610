package com.sxt.service.product.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.ILdRiskImage;
import com.sxt.models.LdRiskImage;
import com.sxt.service.product.ILdRiskImageService;
@Service
public class RiskImageServiceImpl implements ILdRiskImageService {
	
	private static Log logger = LogFactory.getLog(RiskImageServiceImpl.class);
	@Autowired
	private ILdRiskImage ldRiskImage;
	
	@Override
	public List<LdRiskImage> queryRiskImageList(Integer productId) {
		// TODO Auto-generated method stub
		Integer count = queryRiskImageCount(productId);
		if(count == 0){
			logger.info(productId+"no have risk image config");
			return null;
		}
		return ldRiskImage.queryRiskImageList(productId);
	}

	@Override
	public Integer queryRiskImageCount(Integer productId) {
		// TODO Auto-generated method stub
		return ldRiskImage.queryRiskImageCount(productId);
	}
	
	
}
