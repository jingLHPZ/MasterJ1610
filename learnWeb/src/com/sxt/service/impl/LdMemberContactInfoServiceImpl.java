package com.sxt.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.ILdMemberContactInfo;
import com.sxt.models.LdMemberContactInfo;
import com.sxt.service.LdMemberContactInfoService;


@Service
public class LdMemberContactInfoServiceImpl implements LdMemberContactInfoService {
	@Autowired
	private ILdMemberContactInfo iLdMemberContactInfo;

	@Override
	public LdMemberContactInfo getContactInfo(Integer uid) {
		// TODO Auto-generated method stub
		return iLdMemberContactInfo.getContactInfo(uid);
	}

	@Override
	public void add(LdMemberContactInfo info) {
		// TODO Auto-generated method stub
		iLdMemberContactInfo.add(info);
	}

	@Override
	public void update(LdMemberContactInfo info) {
		// TODO Auto-generated method stub
		iLdMemberContactInfo.update(info);
	}

	
	
}
