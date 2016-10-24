package com.sxt.service;

import java.util.List;
import java.util.Map;

import com.sxt.enums.MessageTypeEnum;
import com.sxt.enums.MessageVerifyCodeTypeEnum;
import com.sxt.models.LdMessageLog;
import com.sxt.models.LdMessageTemplate;
import com.sxt.models.LdMobileVerifyCode;

public interface MessageService {

	public String sendMessageVerifyCode(String phone,MessageTypeEnum messageType,Map<String,Object> para,String uid,MessageVerifyCodeTypeEnum verifyCodeEnum);

	/**
	 * 生成手机验证码字符
	 * @param numberFlag
	 * @param length
	 * @return
	 */
	public String createRandomMessage(boolean numberFlag, int length);
	 /**
	  * 新增验证码
	  * @param mobileVerifycode
	  */
	public void insertMobileVerifycode(LdMobileVerifyCode mobileVerifycode);
	
	/**
	 * 保存发送日志
	 * @param messageLog
	 */
	public void saveMessageLog(LdMessageLog messageLog);
	
	/*
	 * 取得短信模板
	 */
	public LdMessageTemplate selectMessageTemplate(int messageType,int type);
	public List checkCode(Map<String,Object> map);
	
	public List<LdMessageLog> selectMessageByPage(Map<String,Object> para);
	
	public Integer selectMessageByPageCount(Map<String,Object> para);
	
	public void updateStatusMessage(Map<String,Object> para);
	
	public LdMessageLog fQueryMessageLogById(String id);
	
	public LdMessageLog fQueryMessageLogByStep(Map<String,Object> para);
	
	public List<LdMessageLog> fqueryMessageLogListPage(Map<String,Object> para);
	public Integer fqueryMessageLogListPageCount(Map<String,Object> para);
	
	public int  fQueryMessagebyUid(int uid);
	
	/**
	 * 模板变量替换
	 * @param content
	 * 				模板内容
	 * @param paramMap
	 * 				传值变量要跟替换变量字母一样，如userName替换#USERNAME#
	 * @return
	 */
	public String replaceStr2(String content, Map<String, Object> paramMap);
	
	public String sendMessage(String phone,MessageTypeEnum messageType,Map<String,Object> para,String uid);
	
	public LdMobileVerifyCode getVerifycodeByMobile(Map<String, Object> param);
}