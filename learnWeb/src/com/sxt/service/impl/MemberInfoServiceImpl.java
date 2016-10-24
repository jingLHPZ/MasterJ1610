package com.sxt.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.enums.UserAwardTypeEnum;
import com.sxt.inter.ILdMemberBankCardInfo;
import com.sxt.inter.IMemberInfo;
import com.sxt.inter.IMembers;
import com.sxt.models.LdMemberBankCardInfo;
import com.sxt.models.MemberInfo;
import com.sxt.models.Members;
import com.sxt.service.LdMemberRewardService;
import com.sxt.service.MemberInfoService;
@Service
public class MemberInfoServiceImpl implements MemberInfoService{
	private static Logger logger = LoggerFactory.getLogger(MemberInfoServiceImpl.class);
	@Autowired
	private IMemberInfo iMemberInfo;
	@Autowired
	private IMembers iMembers;
	@Autowired
	private ILdMemberBankCardInfo iLdMemberBankCardInfo;
	@Autowired
	private LdMemberRewardService ldMemberRewardService;
	
	
	public void fAddMemberInfo(MemberInfo memberInfo) {
		iMemberInfo.fAddMemberInfo(memberInfo);
	}
	public MemberInfo fQueryMemberInfoByUid(int uid) {
		if(uid!=0){
			return iMemberInfo.fQueryMemberInfoByUid(uid);
		}
		return null;
	}
	public void fUpdateMemberInfo(MemberInfo memberinfo) {
		iMemberInfo.fUpdateMemberInfo(memberinfo);
	}
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public void add(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		iMemberInfo.add(memberinfo);
	}
	@Override
	public void update(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		iMemberInfo.update(memberinfo);
	}
	@Override
	public void addRealName(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		iMemberInfo.addRealName(memberinfo);
	}
	@Override
	public void updateRealName(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		iMemberInfo.updateRealName(memberinfo);
	}
	@Override
	public void addRegister(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		iMemberInfo.addRegister(memberinfo);
	}
	@Override
	public void updateTwoDimensionCodeUrl(MemberInfo memberinfo) {
		// TODO Auto-generated method stub
		iMemberInfo.updateTwoDimensionCodeUrl(memberinfo);
	}
	@Override
	public List queryIdCard(String idcard) {
		// TODO Auto-generated method stub
		return iMemberInfo.queryIdCard(idcard);
	}
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void updateBankCardByUid(Members members, MemberInfo memberInfo,LdMemberBankCardInfo bankCardInfo,HttpServletRequest request,String ip) {

	}

}
