package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.MemberRecommenderDetail;

public interface IMemberRecommenderDetail
{
	public List<MemberRecommenderDetail> fQueryRecordByUid(Map<String,Object> map);
	
	public List<MemberRecommenderDetail> fQueryRecordByMap(Map<String,Object> map);
	
	public int fCountRecord(int uid);
	
	public void add(MemberRecommenderDetail detail);
	
	/**
	 * 查询推荐人所有的uid
	 * @param maps
	 * @return
	 */
	public List<Map<String, Object>> queryRecommenderUid(Map<String, Object> maps);

}
