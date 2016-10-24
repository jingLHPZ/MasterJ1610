package com.sxt.service;

import java.util.List;
import java.util.Map;

import com.sxt.models.BankInfo;

public interface BankInfoService {
	public List<BankInfo> fquerybankinfo();
	
	public BankInfo getBankInfoByName(Map<String, Object> param);
}
