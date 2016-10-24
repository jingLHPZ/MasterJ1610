package com.sxt.inter;

import com.sxt.models.LdProductAppointmentInfo;
import com.sxt.models.LdProductOffInfo;

public interface ILdProductAppointmentInfo {
	
	public Integer insertProductAppointmentInfo(LdProductAppointmentInfo ldProductAppointmentInfo);
	
	public Integer queryQuestionByUid(Integer uid);
	
	public String queryIsRealNameByUid(Integer uid);
	
	public LdProductOffInfo queryProductOffInfoByProductId(String productId);
	
	public Integer querySalesUidByUid(Integer uid);

}
