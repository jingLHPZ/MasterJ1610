package com.sxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.inter.ILdMemberPidInfo;
import com.sxt.models.LdMemberPidInfo;
import com.sxt.service.LdMemberPidInfoService;

@Service
public class LdMemberPidInfoServiceImpl implements LdMemberPidInfoService {
	
	@Autowired
	ILdMemberPidInfo iLdMemberPidInfo;
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public void add(LdMemberPidInfo info) {
		// TODO Auto-generated method stub
		iLdMemberPidInfo.add(info);
	}

	@Override
	public LdMemberPidInfo getPidInfo(Integer uid) {
		// TODO Auto-generated method stub
		return iLdMemberPidInfo.getPidInfo(uid);
	}

}
