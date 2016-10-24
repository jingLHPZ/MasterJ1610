package com.sxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.IMemberlogin;
import com.sxt.models.Memberlogin;
import com.sxt.service.MemberLoginService;
@Service
public class MemberLoginServiceImpl implements MemberLoginService{
	@Autowired
	private IMemberlogin iMemberLogin;

	@Override
	public void add(Memberlogin login) {
		// TODO Auto-generated method stub
		iMemberLogin.add(login);
	}
	
}
