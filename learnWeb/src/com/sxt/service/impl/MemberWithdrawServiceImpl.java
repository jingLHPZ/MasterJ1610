package com.sxt.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.IMemberWithdraw;
import com.sxt.models.MemberWithdraw;
import com.sxt.service.MemberWithdrawService;
@Service
public class MemberWithdrawServiceImpl implements MemberWithdrawService {
	@Autowired
	private IMemberWithdraw  iMemberWithdraw;
	public BigDecimal fSumWithdrawMoney(int uid) {
			return iMemberWithdraw.fSumWithdrawMoney(uid);
	}
	public List<MemberWithdraw> fSelectWithdraw(int uid) {
		if(uid!=0){
			return iMemberWithdraw.fSelectWithdraw(uid);
		}
		return null;
	}
	public void fInsertWithdraw(MemberWithdraw memberwithdraw) {
		iMemberWithdraw.fInsertWithdraw(memberwithdraw);
	}
	public String fwithdrawtraceno(int uid) {
		return iMemberWithdraw.fwithdrawtraceno(uid);
	}
	public String fquerysequence() {
		return iMemberWithdraw.fquerysequence();
	}

	public List<MemberWithdraw> fQueryPageWithdraw(Map<String,Object> param){
		return iMemberWithdraw.fQueryPageWithdraw(param);
	}
	
	public Integer fQueryPageCountWithdraw(Map<String,Object> param){
		return iMemberWithdraw.fQueryPageCountWithdraw(param);
	}

	public List<MemberWithdraw> getWithdrawByStatus(Map<String, Object> param) {
		return iMemberWithdraw.getWithdrawByStatus(param);
	}
	
	public BigDecimal getWithdrawMoneyByUid(Integer param) {
		return iMemberWithdraw.getWithdrawMoneyByUid(param);
	}
	public BigDecimal queryCountWithdrawFreezeMoney(Integer uid) {
		BigDecimal withdrawMoney = iMemberWithdraw.queryCountWithdrawFreezeMoney(uid);
		if(withdrawMoney == null){
			return BigDecimal.ZERO;
		}
		return withdrawMoney;
	}
	public void updateStatusBySystemTraceNo(Map<String,Object> param) {
		iMemberWithdraw.updateStatusBySystemTraceNo(param);
	}
	public Integer queryStatusById(Integer id)
	{
		return iMemberWithdraw.queryStatusById(id);
	}
}
