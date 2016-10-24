package com.sxt.inter;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sxt.models.MemberMoney;

public interface IMemberMoney {

	public MemberMoney queryMemberMoney(Integer uid);
	
	public MemberMoney queryMemberMoneyByMap(Map<String,Object> param);
	
	public int updateMoneyByMap(Map<String,Object> param);
	
	public void add(MemberMoney money);
	
	public int update(MemberMoney memberMoney);
	
	public void updateTotalScore(@Param(value = "totalScore") Integer totalScore,@Param(value = "experienceGold") BigDecimal experienceGold,@Param(value = "uid") Integer uid);
	
}
