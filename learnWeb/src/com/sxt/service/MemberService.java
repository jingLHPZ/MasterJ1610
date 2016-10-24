package com.sxt.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sxt.models.Members;

public interface MemberService {

	public Members fquerybyphone(String user_phone);
	
	public void  finsert(Members  member);
	
	public Members flogin(Members  member);
	
	public Members fQueryNameByUid(int uid);
	
	public String  fQueryRnByState(int uid);
	
	public String fquerycardbystate(int uid);
	
	public void fupdatecard(int uid);
	
	public Members getMembers(int uid);
	
	public void update(Members member);
	
	public Members validatePass(Map<String,Object> map);
	
	public void updatePassword(Members member);
	
	public void updateIsRealName(int uid);
	
	public void updateErrorCount(int uid);
	
	public Members login(String username);
	
	public Members registor(String user_phone,String user_pass,String recommender,String user_name,HttpServletRequest request,String addIp)throws NoSuchAlgorithmException, UnsupportedEncodingException;
	
	public List queryJobNumber(Map<String, Object> maps);
	
	public Integer queryJobNumberCount(Map<String, Object> maps);
	
	public void updateUserName(String userName,Integer uid);
}
