package com.sxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.inter.ILdCheckUserNameLog;
import com.sxt.models.LdCheckUserNameLog;
import com.sxt.service.LdCheckUserNameLogService;

@Service
public class LdCheckUserNameLogServiceImpl implements LdCheckUserNameLogService {

	@Autowired
	ILdCheckUserNameLog iLdCheckUserNameLog;
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public void add(LdCheckUserNameLog log) {
		// TODO Auto-generated method stub
		iLdCheckUserNameLog.add(log);
	}

}
