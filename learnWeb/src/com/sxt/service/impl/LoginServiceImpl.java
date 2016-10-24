package com.sxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.IMembers;
import com.sxt.models.Members;
import com.sxt.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	IMembers members;

	@Override
	public Members selectMember(String username) {
		Members member = members.selectMember(username);
		return member;
	}

}
