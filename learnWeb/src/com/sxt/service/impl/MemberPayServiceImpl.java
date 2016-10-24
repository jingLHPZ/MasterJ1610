package com.sxt.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.inter.IMemberPay;
import com.sxt.models.MemberPay;
import com.sxt.service.MemberPayService;
import com.sxt.util.StringUtil;

@Service
public class MemberPayServiceImpl implements MemberPayService {
	@Autowired
	private IMemberPay iMemberPay;

	@Override
	public void fInvestPay(MemberPay memberpay) {
		iMemberPay.fInvestPay(memberpay);
	}

	@Override
	public BigDecimal fSumPayMoney(int uid) {
		return iMemberPay.fSumPayMoney(uid);
	}
	
	@Override
	public List<MemberPay> fSelectPay(int uid) {
		if (uid != 0) {
			return iMemberPay.fSelectPay(uid);
		}
		return null;
	}
	
	@Override
	public List<MemberPay> fQueryPagePay(Map<String, Object> params) {
		return iMemberPay.fQueryPagePay(params);
	}
	
	@Override
	public Integer fQueryPageCountPay(Map<String, Object> param) {
		return iMemberPay.fQueryPageCountPay(param);
	}

	@Override
	public void add(MemberPay memberpay) {
		iMemberPay.add(memberpay);
	}
	
	@Override
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void update(MemberPay  memberpay){
		iMemberPay.update(memberpay);
	}
	
	public MemberPay selectPayBySystemTraceNo(String systemTraceNo){
		return iMemberPay.selectPayBySystemTraceNo(systemTraceNo);
	}

	@Override
	public String encryptBankCardNo(String bankCardNo) {
		String sumStr = "";
		if(!StringUtil.isEmpty(bankCardNo)) {
			int a = bankCardNo.length() - 7;
			StringBuffer buffer = new StringBuffer();
			for (int j = 0; j < a; j++) {
				buffer.append("*");
			}
			sumStr = bankCardNo.substring(0, 3)+ buffer.toString()+ bankCardNo.substring(bankCardNo.length() - 4,bankCardNo.length());
		}
		return sumStr;
	}

}
