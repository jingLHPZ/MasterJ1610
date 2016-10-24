package com.sxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.inter.ILdProductAppointmentInfo;
import com.sxt.models.LdProductAppointmentInfo;
import com.sxt.models.LdProductOffInfo;
import com.sxt.service.LdProductAppointmentInfoService;

@Service
public class LdProductAppointmentInfoServiceImpl implements LdProductAppointmentInfoService{

	@Autowired
	private ILdProductAppointmentInfo iLdProductAppointmentInfo ;
	
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public Integer insertProductAppointmentInfo(LdProductAppointmentInfo productAppointmentInfo) {
		// TODO Auto-generated method stub
		return iLdProductAppointmentInfo.insertProductAppointmentInfo(productAppointmentInfo);
	}
	
	@Override
	public Integer queryQuestionByUid(Integer uid){
		return iLdProductAppointmentInfo.queryQuestionByUid(uid);
	}
	
	@Override
	public String queryIsRealNameByUid(Integer uid){
		return iLdProductAppointmentInfo.queryIsRealNameByUid(uid);
	}

	@Override
	public LdProductOffInfo queryProductOffInfoByProductId(String productId){
		return iLdProductAppointmentInfo.queryProductOffInfoByProductId(productId);
	}
	@Override
	public Integer querySalesUidByUid(Integer uid){
		return iLdProductAppointmentInfo.querySalesUidByUid(uid);
	}
}
