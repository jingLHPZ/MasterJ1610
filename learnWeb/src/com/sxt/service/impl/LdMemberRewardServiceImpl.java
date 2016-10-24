package com.sxt.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.base.utils.FormatHelper;
import com.sxt.enums.UserAwardTypeEnum;
import com.sxt.inter.IMemberInfo;
import com.sxt.inter.IMemberReward;
import com.sxt.models.MemberInfo;
import com.sxt.models.MemberReward;
import com.sxt.service.LdMemberRewardService;
import com.sxt.service.MemberExperienceGoldDetailService;
import com.sxt.service.MemberMoneyService;
import com.sxt.service.MemberScoreDetailService;

/**
 * 用户奖励
 * @author 
 * @date：2015年11月10日 下午4:00:15
 * 
 */
@Service
public class LdMemberRewardServiceImpl implements LdMemberRewardService {
	
	private static Log logger = LogFactory.getLog(LdMemberRewardServiceImpl.class);
	
	@Autowired
	private IMemberReward iMemberReward;
	@Autowired
	private MemberMoneyService memberMoneyService;
	@Autowired
	private MemberExperienceGoldDetailService memberExperienceGoldDetailService;
	@Autowired
	private MemberScoreDetailService memberScoreDetailService;
	@Autowired
	private IMemberInfo iMemberInfo;

	@Override
	public List<MemberReward> findMemberRewardList(MemberReward memberReward) {
		return iMemberReward.findMemberRewardList(memberReward);
	}
	
	@Override
	public int affordUserAward(int type, int userId, String remoteAddr, 
			HttpServletRequest request) {
		return 0;
	}

	@Override
	public int userBuyAward(Map<String, Object> paramMap, HttpServletRequest request) {
		return 0;
	}
}
