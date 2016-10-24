package com.sxt.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.controller.AbstractGeneralController;
import com.sxt.enums.UserAwardTypeEnum;
import com.sxt.inter.ILdUserSignInLog;
import com.sxt.inter.dto.MemberMoneyDto;
import com.sxt.models.LdMemberScoreDetail;
import com.sxt.models.LdUserSignInLog;
import com.sxt.service.LdUserSignInLogService;
import com.sxt.service.MemberMoneyService;
import com.sxt.service.MemberScoreDetailService;

@Service
public class LdUserSignInLogServiceImpl extends AbstractGeneralController implements LdUserSignInLogService {

	@Autowired
	ILdUserSignInLog iLdUserSignInLog;
	@Autowired
	private MemberScoreDetailService memberScoreDetailService;
	@Autowired
	private MemberMoneyService memberMoneyService;
	@Override
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void add(LdUserSignInLog log) {
		// TODO Auto-generated method stub
		iLdUserSignInLog.add(log);
	}

	@Override
	public List queryLdUserSignInLogList(Integer uid) {
		// TODO Auto-generated method stub
		return iLdUserSignInLog.queryLdUserSignInLogList(uid);
	}

	@Override
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public String addSign(HttpServletRequest request,Integer singTotal) {
		// TODO Auto-generated method stub
				//记录用户签到
				List list=iLdUserSignInLog.queryLdUserSignInLogList(super.getLocalUser(request).getUid());
				//当天是否签到
				if(list.size()==0&&super.getLocalUser(request).getSignFlag()==0){
					LdUserSignInLog log=new LdUserSignInLog();
					log.setUid(super.getLocalUser(request).getUid());
					log.setStatus("1");
					log.setCreateTime(new Date());
					log.setUpdateTime(new Date());
					iLdUserSignInLog.add(log);
					MemberMoneyDto money=memberMoneyService.queryMemberMoney(super.getLocalUser(request).getUid());
					int totalScore=0;
					if(money!=null){
						 //签到之后的总积分
						totalScore=money.getTotalScore()==null?0:money.getTotalScore()+singTotal;
						memberMoneyService.updateTotalScore(totalScore,null, super.getLocalUser(request).getUid());
					}
					//积分记录
					LdMemberScoreDetail detail=new LdMemberScoreDetail();
					detail.setUid(super.getLocalUser(request).getUid());
					detail.setType(1);
					detail.setAffectScore(singTotal);
					detail.setTotalScore(totalScore);
					detail.setInfo("签到+"+singTotal+"分");
					detail.setAddIp(super.getRemoteAddr(request));
					detail.setCreateTime(new Date());
					detail.setSystemTraceNo("");
					detail.setOperateMode(UserAwardTypeEnum.SIGN.getCode());
					memberScoreDetailService.add(detail);
					super.getLocalUser(request).setTotalScore(totalScore);
					super.getLocalUser(request).setSignFlag(1);
					return "success";
				}
				return "error";
	}

	

}
