package com.sxt.inter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sxt.models.MemberPay;
import com.sxt.models.MemberWithdraw;

public interface IMemberPay {

	public void  fInvestPay(MemberPay  memberpay);
	
	public BigDecimal fSumPayMoney(int uid);
	
	public List<MemberPay> fSelectPay(int uid);
	
	public List<MemberPay> fQueryPagePay(Map<String,Object> params);
	
	public Integer fQueryPageCountPay(Map<String,Object> params);
	
	public void add(MemberPay  memberpay);
	
	public void update(MemberPay  memberpay);
	
	public MemberPay selectPayBySystemTraceNo(String systemTraceNo);
}
