package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.OffProductTransaction;

public interface IOffProductTransaction {
	
	public List<OffProductTransaction> queryOffProductTransaction(Map<String, Object> param);
	
	public Integer queryOffProductTransactionCount(Map<String, Object> param);
	
}
