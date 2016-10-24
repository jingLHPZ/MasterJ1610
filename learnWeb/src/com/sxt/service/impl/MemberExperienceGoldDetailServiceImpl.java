package com.sxt.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.inter.IMemberExperienceGoldDetail;
import com.sxt.models.MemberExperienceGoldDetail;
import com.sxt.service.MemberExperienceGoldDetailService;
@Service
public class MemberExperienceGoldDetailServiceImpl implements
		MemberExperienceGoldDetailService
{
	@Autowired
	private IMemberExperienceGoldDetail iMemberExperienceGoldDetail;

	public BigDecimal fSumExperienceGold(int uid)
	{
		return iMemberExperienceGoldDetail.fSumExperienceGold(uid);
	}
	public BigDecimal fQueryInvestGold(int uid){
		return iMemberExperienceGoldDetail.fQueryInvestGold(uid);
	}
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public void insert(MemberExperienceGoldDetail memberExperienceGoldDetail) {
		// TODO Auto-generated method stub
		iMemberExperienceGoldDetail.insert(memberExperienceGoldDetail);
	}

	@Override
	public List<MemberExperienceGoldDetail> fQueryExperience(
			Map<String, Object> maps)
	{
		return iMemberExperienceGoldDetail.fQueryExperience(maps);
	}

	@Override
	public int fQueryCountExperience(Map<String, Object> maps)
	{
		return iMemberExperienceGoldDetail.fQueryCountExperience(maps);
	}
	@Override
	//体验中的金额
	public BigDecimal queryInvestgoldByUid(Integer uid) {
		return iMemberExperienceGoldDetail.queryInvestgoldByUid(uid);
	}
}
