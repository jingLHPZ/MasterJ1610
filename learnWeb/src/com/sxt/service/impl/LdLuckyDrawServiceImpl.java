package com.sxt.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.enums.AccountTypeEnum;
import com.sxt.enums.LuckyDrawTypeEnum;
import com.sxt.enums.UserAwardTypeEnum;
import com.sxt.inter.ILdLuckyDraw;
import com.sxt.inter.ILdMessageLog;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.inter.dto.MemberMoneyDto;
import com.sxt.models.LdLuckyDraw;
import com.sxt.models.LdMemberScoreDetail;
import com.sxt.models.LdMessageLog;
import com.sxt.models.MemberExperienceGoldDetail;
import com.sxt.models.MemberMoneyDetail;
import com.sxt.models.RewardRecord;
import com.sxt.service.LdLuckyDrawService;
import com.sxt.service.LdParameterService;
import com.sxt.service.MemberExperienceGoldDetailService;
import com.sxt.service.MemberMoneyDetailService;
import com.sxt.service.MemberMoneyService;
import com.sxt.service.MemberScoreDetailService;
import com.sxt.service.RewardRecordService;
import com.sxt.util.Money;
import com.sxt.util.PropertiesRead;

@Service
public class LdLuckyDrawServiceImpl implements LdLuckyDrawService {

	@Autowired
	ILdLuckyDraw iLdLuckyDraw;
	@Autowired
	private MemberMoneyService memberMoneyService;
	@Autowired
	private MemberScoreDetailService memberScoreDetailSevice;
	@Autowired
	private RewardRecordService rewardRecordService;
	@Autowired
	private MemberExperienceGoldDetailService memberExperienceGoldDetailService;
	@Autowired
	private MemberMoneyDetailService memberMoneyDetailService;
	@Autowired
	private LdParameterService ldParameterService; 
	@Autowired
	private ILdMessageLog iLdMessageLog;
	@Override
	public List queryLuckyDrawList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return iLdLuckyDraw.queryLuckyDrawList(map);
	}

	@Override
	public Integer queryLuckyDrawCount(Integer uid) {
		// TODO Auto-generated method stub
		return iLdLuckyDraw.queryLuckyDrawCount(uid);
	}
	/**
	 * 得到几天后的时间
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateAfter(Date d, int day) {
		  Calendar now = Calendar.getInstance();
		  now.setTime(d);
		  now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		  return now.getTime();
	}

	@Override
	public Integer queryLuckyDrawNum(Integer uid) {
		// TODO Auto-generated method stub
		return iLdLuckyDraw.queryLuckyDrawNum(uid);
	}

	@Override
	public Integer add(LdLuckyDraw lucky) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLuckyDrawMethod(LocalUserDto dto, Integer awardType,
			String ip) {
		// TODO Auto-generated method stub
		
	}

}
