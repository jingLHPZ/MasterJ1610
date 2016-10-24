package com.sxt.service;

import java.util.List;
import java.util.Map;

import com.sxt.models.LdMemberCertificateCheck;
import com.sxt.models.NewsNotice;

public interface LdMemberCertificateCheckService
{
	public void add(LdMemberCertificateCheck check);
	public void update(LdMemberCertificateCheck check);
	public List queryCertificateCheck(Map<String,Object> map);
}
