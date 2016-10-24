package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.LdMemberCertificateCheck;

public interface ILdMemberCertificateCheck {
	public void add(LdMemberCertificateCheck check);
	public void update(LdMemberCertificateCheck check);
	public List queryCertificateCheck(Map<String,Object> map);
}
