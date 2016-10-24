package com.sxt.inter;

import com.sxt.models.LdMemberContactInfo;



public interface ILdMemberContactInfo {
	public LdMemberContactInfo getContactInfo(Integer uid);
	public void add(LdMemberContactInfo info);
	public void update(LdMemberContactInfo info);
}
