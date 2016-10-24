package com.sxt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.inter.IMemberRecommenderDetail;
import com.sxt.models.MemberRecommenderDetail;
import com.sxt.service.MemberRecommenderDetailService;
@Service
public class MemberRecommenderDetailServiceImpl implements	MemberRecommenderDetailService
{
	@Autowired
	private IMemberRecommenderDetail iMemberRecommenderDetail;

	public List<MemberRecommenderDetail> fQueryRecordByUid(
			Map<String, Object> map)
	{
		return iMemberRecommenderDetail.fQueryRecordByUid(map);
	}
	
	public List<MemberRecommenderDetail> fQueryRecordByMap(Map<String, Object> map) {
		return iMemberRecommenderDetail.fQueryRecordByMap(map);
	}

	public int fCountRecord(int uid)
	{
		return iMemberRecommenderDetail.fCountRecord(uid);
	}
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public void add(MemberRecommenderDetail detail) {
		// TODO Auto-generated method stub
		iMemberRecommenderDetail.add(detail);
	}

	@Override
	public List<Map<String, Object>> queryRecommenderUid(
			Map<String, Object> maps) {
		return iMemberRecommenderDetail.queryRecommenderUid(maps);
	}

}
