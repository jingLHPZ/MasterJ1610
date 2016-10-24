package com.sxt.service;

import com.sxt.models.LdProductAppointmentInfo;
import com.sxt.models.LdProductOffInfo;

public interface LdProductAppointmentInfoService {
	
	public Integer insertProductAppointmentInfo(LdProductAppointmentInfo productAppointmentInfo);
	
	public Integer queryQuestionByUid(Integer uid);
	
	public String queryIsRealNameByUid(Integer uid);

	public LdProductOffInfo queryProductOffInfoByProductId(String productId);
	
	public Integer querySalesUidByUid(Integer uid);
}
