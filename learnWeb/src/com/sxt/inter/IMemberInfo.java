package com.sxt.inter;

import java.util.List;

import com.sxt.models.MemberInfo;
import com.sxt.models.Members;

public interface IMemberInfo {

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
	
	public void updateBankCardByUid(Members members, MemberInfo memberInfo);
	
	/**
	 * 通过销售uid查询销售人员信息
	 * @param uid
	 * @return
	 */
	public MemberInfo querySalemanBySaleUid(Integer saleUid);
	
	public void updateExtfiled(Integer uid);
	
}
