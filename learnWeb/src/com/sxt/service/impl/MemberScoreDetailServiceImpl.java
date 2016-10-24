package com.sxt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.inter.IMemberScoreDetail;
import com.sxt.models.LdMemberScoreDetail;
import com.sxt.service.MemberScoreDetailService;
@Service
public class MemberScoreDetailServiceImpl implements MemberScoreDetailService
{
	@Autowired
	private IMemberScoreDetail iMemberScoreDetail;
	public List<LdMemberScoreDetail> fQueryScoreByUid(Map<String,Object> map)
	{
		return iMemberScoreDetail.fQueryScoreByUid(map);
	}
	public int fCountByUid(int uid)
	{
		return iMemberScoreDetail.fCountByUid(uid);
	}
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public void add(LdMemberScoreDetail detail) {
		// TODO Auto-generated method stub
		iMemberScoreDetail.add(detail);
	}
	@Override
	public Integer getScoreByUidAndTime(Map<String, Object> map) {
		
		return iMemberScoreDetail.getScoreByUidAndTime(map);
	}

}
