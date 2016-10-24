package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.BankInfo;

public interface IBankInfo {
	public List<BankInfo> fquerybankinfo();
	
	public BankInfo getBankInfoByName(Map<String, Object> param);
}
