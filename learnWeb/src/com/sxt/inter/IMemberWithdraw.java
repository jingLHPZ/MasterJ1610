package com.sxt.inter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sxt.models.MemberWithdraw;

public interface IMemberWithdraw {

	public BigDecimal fSumWithdrawMoney(int uid);
	
	public List<MemberWithdraw> fSelectWithdraw(int uid);

	public void fInsertWithdraw(MemberWithdraw memberwithdraw);
	
	public String fwithdrawtraceno(int uid);
	
	public String fquerysequence();
	
	public List<MemberWithdraw> fQueryPageWithdraw(Map<String,Object> param);
	
	public Integer fQueryPageCountWithdraw(Map<String,Object> param);
	
	public List<MemberWithdraw> getWithdrawByStatus(Map<String, Object> param);
	
	public BigDecimal getWithdrawMoneyByUid(Integer param);
	
	public BigDecimal queryCountWithdrawFreezeMoney(Integer uid);
	
	public void updateStatusBySystemTraceNo(Map<String,Object> param);
	
	public Integer queryStatusById(Integer id);
}
