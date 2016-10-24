package com.sxt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.ILdMemberCertificateCheck;
import com.sxt.models.LdMemberCertificateCheck;
import com.sxt.service.LdMemberCertificateCheckService;

@Service
public class LdMemberCertificateCheckServiceImpl implements LdMemberCertificateCheckService {

	@Autowired
	ILdMemberCertificateCheck iLdMemberCertificateCheck;

	@Override
	public void add(LdMemberCertificateCheck check) {
		// TODO Auto-generated method stub
		iLdMemberCertificateCheck.add(check);
	}

	@Override
	public void update(LdMemberCertificateCheck check) {
		// TODO Auto-generated method stub
		iLdMemberCertificateCheck.update(check);
	}

	@Override
	public List queryCertificateCheck(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		return iLdMemberCertificateCheck.queryCertificateCheck(map);
	}
	
}
