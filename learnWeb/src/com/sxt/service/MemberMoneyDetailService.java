package com.sxt.service;

import java.util.List;
import java.util.Map;

import com.sxt.models.MemberMoneyDetail;

public interface MemberMoneyDetailService {
	
	public void fInsertMoneyDetail(MemberMoneyDetail membermoneydetail);
	
	public List<MemberMoneyDetail>  fquerymonbytype(Map<String,Object> map);
	
	public  int fQueryMmPageCountByPid(int uid);
	
	public int fquerycount(Map<String,Object> map);

	/*
	 * 通过systemTraceNo得到资金日志
	 */
	public MemberMoneyDetail getMoneyDetailBySystemTraceNo(String systemTraceNo);

}
