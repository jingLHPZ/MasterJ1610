package com.sxt.inter;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sxt.models.CiProduct;
import com.sxt.models.RepaymentRecord;
import com.sxt.models.SiProduct;
import com.sxt.models.SumMoney;

public interface IRepaymentRecord {

	public Date fQueryTimeByuid(Map<String,Object> params);
	
	public List<SumMoney> fQueryRecord();
	public int fQueryTimeByPid(String product_id);
}
