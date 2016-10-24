package com.sxt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.inter.IMemberMoneyDetail;
import com.sxt.models.MemberMoneyDetail;
import com.sxt.service.MemberMoneyDetailService;
@Service
public class MemberMoneyDetailServiceImpl implements MemberMoneyDetailService {
	
	@Autowired
	private IMemberMoneyDetail iMemberMoneyDetail;

	
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void fInsertMoneyDetail(MemberMoneyDetail membermoneydetail) {
		iMemberMoneyDetail.fInsertMoneyDetail(membermoneydetail);
	}
	public List<MemberMoneyDetail> fquerymonbytype(Map<String,Object> map){
		return iMemberMoneyDetail.fquerymonbytype(map);
	}
	public int fQueryMmPageCountByPid(int uid){
		return iMemberMoneyDetail.fQueryMmPageCountByPid(uid);
	}
	/*
	 * 通过systemTraceNo得到资金日志
	 */
	public MemberMoneyDetail getMoneyDetailBySystemTraceNo(String systemTraceNo){
		return iMemberMoneyDetail.getMoneyDetailBySystemTraceNo(systemTraceNo);
	}
	public int fquerycount(Map<String, Object> map){
		return iMemberMoneyDetail.fquerycount(map);
	}
	
}
