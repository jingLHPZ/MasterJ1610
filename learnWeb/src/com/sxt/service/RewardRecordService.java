package com.sxt.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sxt.inter.dto.RewardRecordDto;
import com.sxt.models.RewardRecord;

public interface RewardRecordService {

	public List<RewardRecord> fselectredbyuid(int uid);
	
	public List<RewardRecord> queryRewardByUid(int uid);
	
	public RewardRecord queryRewardById(int id);
	
	public int queryCountRewardByMap(Map<String,Object> param);
	
	public RewardRecord queryNoGetCashRed(Map<String,Object> param);
	
	public void updateUid(RewardRecord rewardRecord);
	
	public List<RewardRecord> queryAlreadyGetCashRed(Map<String,Object> param);
	
	public List<RewardRecord> queryInvestRedNo(Map<String,Object> param);
	
	public List<RewardRecordDto> queryInvestRedUsed(Map<String,Object> param);
	
	public List<RewardRecord> queryAddInterestNo(Map<String,Object> param);
	
	public List<RewardRecordDto> queryAddInterestUsed(Map<String,Object> param);
	
	public BigDecimal queryProval(String systemtraceno);
	
	public void updateRewardRecordById(Map<String,Object> param, String ip);
	
	public int queryAlreadyGetCashRedCount(Map<String,Object> param);
	
	public int queryInvestRedUsedCount(Map<String,Object> param);
	
	public int queryAddInterestNoCount(Map<String,Object> param);
	
	public int queryAddInterestUsedCount(Map<String,Object> param);
	
	public int  queryInvestRedNoCount(Map<String,Object> param);
	
	public void add(RewardRecord reward);

	public RewardRecord queryRewardRecord(String systemTraceNo);
	
	public RewardRecord getRewardRecordByType(Map<String,Object> param);
}
