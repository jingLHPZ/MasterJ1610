package com.sxt.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sxt.models.MemberPay;

public interface MemberPayService {
	
	public void  fInvestPay(MemberPay  memberpay);
	
	public BigDecimal fSumPayMoney(int uid);
	
	public List<MemberPay> fSelectPay(int uid);
	
	public List<MemberPay> fQueryPagePay(Map<String,Object> param);
	
	public Integer fQueryPageCountPay(Map<String,Object> param);
	
	public void add(MemberPay  memberpay);
	
	public void update(MemberPay  memberpay);
	
	public MemberPay selectPayBySystemTraceNo(String systemTraceNo);
	
	public String encryptBankCardNo(String bankCardNo);
	
}
