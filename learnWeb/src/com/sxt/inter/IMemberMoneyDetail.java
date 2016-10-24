package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.MemberMoneyDetail;

public interface IMemberMoneyDetail {

	public void fInsertMoneyDetail(MemberMoneyDetail membermoneydetail);
	
	public List<MemberMoneyDetail>  fquerymonbytype(Map<String,Object> map);
	
	public  int fQueryMmPageCountByPid(int uid);

	public MemberMoneyDetail getMoneyDetailBySystemTraceNo(String systemTraceNo);

	public List<MemberMoneyDetail>  fquerymonbytype(int type);
	
	public int fquerycount(Map<String,Object> map);
	
	/**
	 * 条件查询资金明细
	 * @param map
	 * @return
	 */
	public List<MemberMoneyDetail> getMoneyDetailByMap(Map<String,Object> map);
}
