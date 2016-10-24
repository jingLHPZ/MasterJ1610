package com.sxt.inter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sxt.models.Members;

public interface IMembers {
	public Members fquerybyphone(String user_phone);

	public void finsert(Members member);

	public Members flogin(Members member);

	public Members login(String username);

	public void addMembers(Members member);

	public Members fQueryNameByUid(int uid);

	public Members selectMember(String username);
	
	public String  fQueryRnByState(int uid);
	
	public String fquerycardbystate(int uid);
	
	public void fupdatecard(int uid);
	
	public Members getMembers(int uid);
	
	public void update(Members member);
	
	public Members validatePass(Map<String,Object> map);
	
	public void updatePassword(Members member);
	
	public void updateIsRealName(int uid);
	
	public void updateErrorCount(int uid);
	
	public List queryJobNumber(Map<String, Object> maps);
	
	public Integer queryJobNumberCount(Map<String, Object> maps);
	
	public void updateUserName(@Param(value = "userName") String userName,@Param(value = "uid") Integer uid);
}
