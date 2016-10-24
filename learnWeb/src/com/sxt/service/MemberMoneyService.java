package com.sxt.service;

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.portable.ApplicationException;

import com.sxt.inter.dto.MemberMoneyDto;
import com.sxt.models.MemberMoney;

public interface MemberMoneyService {
	
	public MemberMoneyDto queryMemberMoney(Integer uid);
	
	public MemberMoney queryMemberMoneyByMap(Map<String,Object> param);
	
	public int updateMoneyByMap(BigDecimal moneyFreeze, BigDecimal moneyCollect, BigDecimal accountMoney, BigDecimal backMoney, BigDecimal freeWithdraw, Integer uid);
	
	public void add(MemberMoney money);
	
	public int update(MemberMoney memberMoney);
	
	public void updateTotalScore(Integer totalScore,BigDecimal experienceGold,Integer uid);
	
	/**
	 * 用户奖励
	 * @param param
	 * @param request
	 * @throws ApplicationException
	 */
	public void awardMoneyScore(Map<String,Object> param, HttpServletRequest request) 
			throws ApplicationException;
	
	public MemberMoney getMemberMoneyByUid(Integer uid);
	
}
