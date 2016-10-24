package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.LdUserSignInLog;

public interface ILdUserSignInLog {
	public void add(LdUserSignInLog log);
	public List queryLdUserSignInLogList(Integer uid);
}
