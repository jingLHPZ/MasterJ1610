package com.sxt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.IBankInfo;
import com.sxt.models.BankInfo;
import com.sxt.service.BankInfoService;
@Service
public class BankInfoServiceImpl implements BankInfoService {
	@Autowired
	private IBankInfo iBankInfo;
	public List<BankInfo> fquerybankinfo() {
		return iBankInfo.fquerybankinfo();
	}
	@Override
	public BankInfo getBankInfoByName(Map<String, Object> param) {
		
		return iBankInfo.getBankInfoByName(param);
	}

}
