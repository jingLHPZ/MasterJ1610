package com.sxt.service;


import com.sxt.models.LdMemberPidInfo;


public interface LdMemberPidInfoService {
	public void add(LdMemberPidInfo info);
	public LdMemberPidInfo getPidInfo(Integer uid);
}
