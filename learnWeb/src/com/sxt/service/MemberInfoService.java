package com.sxt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sxt.models.LdMemberBankCardInfo;
import com.sxt.models.MemberInfo;
import com.sxt.models.Members;

public interface MemberInfoService {
	
	public  void fAddMemberInfo(MemberInfo memberInfo);
	
	public MemberInfo fQueryMemberInfoByUid(int uid);
	
	public  void fUpdateMemberInfo(MemberInfo memberinfo);

	public void add(MemberInfo memberinfo);
	
	public void update(MemberInfo memberinfo);
	
	public void addRealName(MemberInfo memberinfo);
	
	public void updateRealName(MemberInfo memberinfo);
	
	public void addRegister(MemberInfo memberinfo);
	
	public void updateTwoDimensionCodeUrl(MemberInfo memberinfo);
	
	public List queryIdCard(String idcard);
	
	public void updateBankCardByUid(Members members,MemberInfo memberInfo,LdMemberBankCardInfo bankCardInfo,HttpServletRequest request,String ip);
}
