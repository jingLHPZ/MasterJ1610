package com.sxt.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sxt.models.SumMoney;

public interface RepaymentRecordService {
	public Date fQueryTimeByuid(Map<String,Object> params);
	
	public List<SumMoney>  fQueryRecord();
}
