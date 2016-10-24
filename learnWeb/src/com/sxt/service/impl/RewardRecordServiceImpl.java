package com.sxt.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.inter.IMemberMoney;
import com.sxt.inter.IMemberMoneyDetail;
import com.sxt.inter.IRewardRecord;
import com.sxt.inter.dto.RewardRecordDto;
import com.sxt.models.MemberMoney;
import com.sxt.models.MemberMoneyDetail;
import com.sxt.models.RewardRecord;
import com.sxt.service.RewardRecordService;
@Service
public class RewardRecordServiceImpl implements RewardRecordService {
	
	@Autowired
	private IRewardRecord iRewardRecord;
	@Autowired
	private IMemberMoney iMemberMoney;
	@Autowired
	private IMemberMoneyDetail iMemberMoneyDetail;

	public List<RewardRecord> fselectredbyuid(int uid) {
		return iRewardRecord.fselectredbyuid(uid);
	}
	
	public List<RewardRecord> queryRewardByUid(int uid){
		return iRewardRecord.queryRewardByUid(uid);
	}
	
	public RewardRecord queryRewardById(int id){
		return iRewardRecord.queryRewardById(id);
	}
	
	public int queryCountRewardByMap(Map<String,Object> param){
		return iRewardRecord.queryCountRewardByMap(param);
	}

	public RewardRecord queryNoGetCashRed(Map<String,Object> param)
	{
		return iRewardRecord.queryNoGetCashRed(param);
	}

	public void updateUid(RewardRecord rewardRecord)
	{
		iRewardRecord.updateUid(rewardRecord);
	}

	public List<RewardRecord> queryAlreadyGetCashRed(Map<String,Object> param)
	{
		return iRewardRecord.queryAlreadyGetCashRed(param);
	}

	public List<RewardRecord> queryInvestRedNo(Map<String,Object> param)
	{
		return iRewardRecord.queryInvestRedNo(param);
	}

	public List<RewardRecordDto> queryInvestRedUsed(Map<String,Object> param)
	{
		return iRewardRecord.queryInvestRedUsed(param);
	}

	public List<RewardRecord> queryAddInterestNo(Map<String,Object> param)
	{
		return iRewardRecord.queryAddInterestNo(param);
	}

	public List<RewardRecordDto> queryAddInterestUsed(Map<String,Object> param)
	{
		return iRewardRecord.queryAddInterestUsed(param);
	}

	public BigDecimal queryProval(String systemtraceno)
	{
		return iRewardRecord.queryProval(systemtraceno);
	}

	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void updateRewardRecordById(Map<String, Object> param, String ip) {
	}

	@Override
	public int queryAlreadyGetCashRedCount(Map<String, Object> param) {
		
		return iRewardRecord.queryAlreadyGetCashRedCount(param);
	}

	@Override
	public int queryInvestRedUsedCount(Map<String, Object> param) {
		
		return iRewardRecord.queryInvestRedUsedCount(param);
	}

	@Override
	public int queryAddInterestNoCount(Map<String, Object> param) {
		
		return iRewardRecord.queryAddInterestNoCount(param);
	}

	@Override
	public int queryAddInterestUsedCount(Map<String, Object> param) {
		
		return iRewardRecord.queryAddInterestUsedCount(param);
	}

	@Override
	public int queryInvestRedNoCount(Map<String, Object> param) {
		
		return iRewardRecord.queryInvestRedNoCount(param);
	}
	
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public void add(RewardRecord reward) {
		// TODO Auto-generated method stub
		iRewardRecord.add(reward);
	}
	
	public RewardRecord queryRewardRecord(String systemTraceNo){
		return iRewardRecord.queryRewardRecord(systemTraceNo);
	}

	@Override
	public RewardRecord getRewardRecordByType(Map<String, Object> param) {
		return iRewardRecord.getRewardRecordByType(param);
	}
	
}
