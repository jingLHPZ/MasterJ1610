package com.sxt.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.base.exception.ServiceException;
import com.sxt.base.utils.FormatHelper;
import com.sxt.enums.UserAwardTypeEnum;
import com.sxt.inter.IBorrowInvestor;
import com.sxt.inter.ILdMemberFirstAward;
import com.sxt.inter.ILdMessageLog;
import com.sxt.inter.ILdMessageTemplate;
import com.sxt.inter.ILdParameter;
import com.sxt.inter.IMemberExperienceGoldDetail;
import com.sxt.inter.IMemberInfo;
import com.sxt.inter.IMemberMoney;
import com.sxt.inter.IMemberMoneyDetail;
import com.sxt.inter.IMemberRecommenderDetail;
import com.sxt.inter.IMemberScoreDetail;
import com.sxt.inter.IMembers;
import com.sxt.inter.IRewardRecord;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.inter.dto.MemberMoneyDto;
import com.sxt.models.LdMemberScoreDetail;
import com.sxt.models.LdMessageLog;
import com.sxt.models.LdMessageTemplate;
import com.sxt.models.LdParameter;
import com.sxt.models.MemberExperienceGoldDetail;
import com.sxt.models.MemberInfo;
import com.sxt.models.MemberMoney;
import com.sxt.models.MemberMoneyDetail;
import com.sxt.models.MemberRecommenderDetail;
import com.sxt.models.MemberReward;
import com.sxt.models.Members;
import com.sxt.models.RewardRecord;
import com.sxt.service.MemberMoneyService;
import com.sxt.service.MessageService;
import com.sxt.util.ModelConvertToVo;
@Service
public class MemberMoneyServiceImpl implements MemberMoneyService{
	
	private static Log logger = LogFactory.getLog(MemberMoneyServiceImpl.class);
	
	@Autowired
	private IMemberMoney iMemberMoney;
	@Autowired
	private IMemberMoneyDetail iMemberMoneyDetail;
	@Autowired
	private IMemberScoreDetail iMemberScoreDetail;
	@Autowired
	private IMemberExperienceGoldDetail iMemberExperienceGoldDetail;
	@Autowired
	private ILdMessageLog iLdMessageLog;
	@Autowired
	private IMembers iMembers;
	@Autowired
	private ILdMessageTemplate iLdMessageTemplate;
	@Autowired
	private IRewardRecord iRewardRecord;
	@Autowired
	private MessageService messageService;
	@Autowired
	private IMemberRecommenderDetail iMemberRecommenderDetail;
	@Autowired
	private IMemberInfo iMemberInfo;
	@Autowired
	private ILdParameter iLdParameter;
	@Autowired
	private IBorrowInvestor iBorrowInvestor;
	@Autowired
	private ILdMemberFirstAward iLdMemberFirstAward;
	
	public MemberMoney queryMemberMoneyByMap(Map<String,Object> param){
		return iMemberMoney.queryMemberMoneyByMap(param);
	}
	public MemberMoneyDto queryMemberMoney(Integer uid) {
		return ModelConvertToVo.convertToMemberMoneyDto((iMemberMoney.queryMemberMoney(uid)));
	}
	
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public int updateMoneyByMap(BigDecimal moneyFreeze, BigDecimal moneyCollect, 
			BigDecimal accountMoney, BigDecimal backMoney, BigDecimal freeWithdraw, Integer uid) {
		MemberMoney memberMoney = iMemberMoney.queryMemberMoney(uid);
		Map<String,Object> map=new HashMap<String, Object>();
		if(moneyFreeze != null){
			map.put("money_freeze", moneyFreeze);
		}
		if(moneyCollect != null){
			map.put("money_collect", moneyCollect);
		}
		if(accountMoney != null){
			map.put("account_money", accountMoney);
		}
		if(backMoney != null){
			map.put("back_money", backMoney);
		}
		if(freeWithdraw != null){
			map.put("free_withdraw", freeWithdraw);
		}
		map.put("uid", uid);
		map.put("version", memberMoney.getVersion());
		int result = iMemberMoney.updateMoneyByMap(map);
		if(result < 1){
			logger.info("update member money exception ! "+ new Date() +"  "+ uid);
			throw new ServiceException("update member money exception ! ");
		}
		return result;
	}
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public void add(MemberMoney money) {
		iMemberMoney.add(money);
	}


	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public int update(MemberMoney memberMoney) {
		int result = iMemberMoney.update(memberMoney);
		if(result < 1){
			logger.info("update member money exception ! "+ new Date() +"  "+ memberMoney.getUid());
			throw new ServiceException("update member money exception ! ");
		}
		return result;
	}


	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public void updateTotalScore(Integer totalScore,BigDecimal experienceGold,Integer uid) {
		iMemberMoney.updateTotalScore(totalScore,experienceGold, uid);
	}

	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, rollbackFor={RuntimeException.class, Exception.class})
	@Override
	public void awardMoneyScore(Map<String, Object> param, HttpServletRequest request) 
			throws ApplicationException {
		
	}
	
	public MemberMoney getMemberMoneyByUid(Integer uid) {
		return iMemberMoney.queryMemberMoney(uid);
	}

}
