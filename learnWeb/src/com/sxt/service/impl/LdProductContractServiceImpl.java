package com.sxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.ILdProductContract;
import com.sxt.models.LdProductContract;
import com.sxt.service.LdProductContractService;

@Service
public class LdProductContractServiceImpl implements LdProductContractService{

	@Autowired
	private ILdProductContract iLdProductContract;

	@Override
	public LdProductContract queryContractById(String id) {
		// TODO Auto-generated method stub
		return iLdProductContract.queryContractById(id);
	}
	
	
}
