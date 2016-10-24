package com.sxt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sxt.models.LdUserSignInLog;

public interface LdUserSignInLogService {
	public void add(LdUserSignInLog log);
	public List queryLdUserSignInLogList(Integer uid);
	public String addSign(HttpServletRequest request,Integer singTotal);
}
