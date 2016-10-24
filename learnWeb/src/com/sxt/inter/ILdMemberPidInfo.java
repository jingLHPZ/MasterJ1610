package com.sxt.inter;


import com.sxt.models.LdMemberPidInfo;

public interface ILdMemberPidInfo {
	public void add(LdMemberPidInfo info);
	public LdMemberPidInfo getPidInfo(Integer uid);
}
