package com.sxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.IUid;
import com.sxt.models.Uid;
import com.sxt.service.GenerateUid;

@Service
public class GenerateUidImpl implements GenerateUid {

	@Autowired
	IUid iuid;

	public int generateUid() {
		iuid.updateUid(iuid.selectUid().getUid() + 1);
		return iuid.selectUid().getUid() + 1;
	}

}
