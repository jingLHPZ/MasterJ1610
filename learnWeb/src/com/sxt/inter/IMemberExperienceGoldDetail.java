package com.sxt.inter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sxt.models.MemberExperienceGoldDetail;

public interface IMemberExperienceGoldDetail
{
	public List<MemberExperienceGoldDetail> fQueryExperience(Map<String, Object> maps);
	
	public int fQueryCountExperience(Map<String, Object> maps);	
	
	public BigDecimal fSumExperienceGold(int uid);
	
	public BigDecimal fQueryInvestGold(int uid);
	
	public void insert(MemberExperienceGoldDetail memberExperienceGoldDetail);
	
	/**
	 * 查询体验金明细
	 * @param maps
	 * @return
	 */
	public List<MemberExperienceGoldDetail> queryExperienceGoldDetail(Map<String, Object> maps);
	
	public BigDecimal queryInvestgoldByUid(Integer uid);
}
