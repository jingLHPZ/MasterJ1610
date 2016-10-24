package com.sxt.service;

import java.util.List;
import java.util.Map;

import com.sxt.models.LdMemberScoreDetail;

public interface MemberScoreDetailService
{
	public List<LdMemberScoreDetail> fQueryScoreByUid(Map<String,Object> map);
	
	public int fCountByUid(int uid);
	
	public void add(LdMemberScoreDetail detail);
	
	public Integer getScoreByUidAndTime(Map<String, Object> map);
}
