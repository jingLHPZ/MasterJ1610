package com.sxt.service;

import com.sxt.models.LdMemberContactInfo;


public interface LdMemberContactInfoService {
	public LdMemberContactInfo getContactInfo(Integer uid);
	public void add(LdMemberContactInfo info);
	public void update(LdMemberContactInfo info);
}
