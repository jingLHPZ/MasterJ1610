package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.LdMobileVerifyCode;


public interface ILdMobileVerifyCode {
	public void add(LdMobileVerifyCode verifyCode);
	public List checkCode(Map<String,Object> map);
	
	public int checkMoblieCode(Map<String,Object> map);
	
	public void updateMobileCode(Map<String,Object> map);
	
	public LdMobileVerifyCode getVerifycodeByMobile(Map<String, Object> param);
}
