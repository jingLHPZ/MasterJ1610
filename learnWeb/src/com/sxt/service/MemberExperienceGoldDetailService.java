package com.sxt.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sxt.models.MemberExperienceGoldDetail;

public interface MemberExperienceGoldDetailService
{
    public List<MemberExperienceGoldDetail> fQueryExperience(Map<String, Object> maps);
	
	public int fQueryCountExperience(Map<String, Object> maps);	
	
	public BigDecimal fSumExperienceGold(int uid);
	
	public BigDecimal fQueryInvestGold(int uid);
	
	public void insert(MemberExperienceGoldDetail memberExperienceGoldDetail);
	
	public BigDecimal queryInvestgoldByUid(Integer uid);
}
