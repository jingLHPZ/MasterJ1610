package com.sxt.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.enums.MessageTypeEnum;
import com.sxt.enums.MessageVerifyCodeTypeEnum;
import com.sxt.enums.UserTypeEnum;
import com.sxt.inter.ILdMessageLog;
import com.sxt.inter.ILdMessageTemplate;
import com.sxt.inter.ILdMobileVerifyCode;
import com.sxt.models.LdMessageLog;
import com.sxt.models.LdMessageTemplate;
import com.sxt.models.LdMobileVerifyCode;
import com.sxt.service.LdParameterService;
import com.sxt.service.MemberService;
import com.sxt.service.MessageService;
import com.sxt.util.PropertiesRead;
import com.sxt.zhenao.SmsClientBanlance;
import com.sxt.zhenao.SmsClientSend;
import com.sxt.zhenao.SmsUtil;
import com.masapay.common.lang.StringUtil;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private ILdMessageTemplate iLdMessageTemplate;

	@Autowired
	private ILdMessageLog iLdMessageLog;
	@Autowired
	ILdMobileVerifyCode iMobileVerifycode;
	@Autowired
	LdParameterService ldParameterService;
	
	@Autowired
	MemberService memberService;
	
	@Override
	public String sendMessageVerifyCode(String phone,MessageTypeEnum messageType,Map<String,Object> para,String uid,MessageVerifyCodeTypeEnum verifyCodeEnum){
		String content = buildContent(para,messageType);
		
		if(StringUtil.isBlank(content)){
			return null;
		}		
		try {
			 String sendFlag = PropertiesRead.use_classLoador().getProperty("MESSAGE_SEND");
			 String result = null;
			 
			 //	通道信息：1为正奥 2为正奥补充通道
			 String msgType = ldParameterService.getParameterByName("messageType", "1").getValue();
			 
			 if ("1".equals(msgType)) {
				 //如果发送标志为 true 而且不为内部用户发送短信
				 if(messageType==MessageTypeEnum.NEW_MEMBER_MOBILE_VERIFY_CODE)
					 result = sendsZhenao(phone,content);
				 else if("1".equals(sendFlag) && !UserTypeEnum.INSIDER.getCode().equals(memberService.fquerybyphone(phone).getUserType()))
					 result = sendsZhenao(phone,content);
			 } else if ("2".equals(msgType)) {
				 result = SmsUtil.sendSmsByPost(phone, content);
			 }
			 
			 String status ="F";
             if ("0".equals(result))
			    status ="S";
             else
            	status ="F";
             
			insertMessageLog(uid,content,phone,status);
			
			String code = (String) para.get("code");
			
			if (null!=code && !"".equals(code)){
				insertVerCode(uid,code,phone,verifyCodeEnum.getCode());
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}

		return "OK";
	}
	
	@Override
	public String sendMessage(String phone,MessageTypeEnum messageType,Map<String,Object> para,String uid) {
		String content = buildContent(para,messageType);
		
		if(StringUtil.isBlank(content)){
			return null;
		}		
		try {
			 String sendFlag = PropertiesRead.use_classLoador().getProperty("MESSAGE_SEND");
			 String result = null;
			 
			 //	通道信息：1为正奥 2为正奥补充通道
			 String msgType = ldParameterService.getParameterByName("messageType", "1").getValue();
			 
			 if ("1".equals(msgType)) {
				 //如果发送标志为 true 而且不为内部用户发送短信
				 if(messageType==MessageTypeEnum.NEW_MEMBER_MOBILE_VERIFY_CODE)
					 result = sendsZhenao(phone,content);
				 else if("1".equals(sendFlag) && !UserTypeEnum.INSIDER.getCode().equals(memberService.fquerybyphone(phone).getUserType()))
					 result = sendsZhenao(phone,content);
			 } else if ("2".equals(msgType)) {
				 result = SmsUtil.sendSmsByPost(phone, content);
			 }
			 
			 String status ="F";
             if ("0".equals(result))
			    status ="S";
             else
            	status ="F";
             
			insertMessageLog(uid,content,phone,status);
			
			String code = (String) para.get("code");
			
			if (null!=code && !"".equals(code)){
				insertVerCode(uid,code,phone,Integer.valueOf(messageType.getCode()));
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}

		return "OK";
	}
	
	
	
	private String sendsOther(String phone,String content){
		PostMethod post = new PostMethod(
				"http://cloud.baiwutong.com:8080/post_sms.do");
		post.addRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
		NameValuePair[] data = {
				new NameValuePair("id", "5ebs002"),
				new NameValuePair("MD5_td_code",
						"7e17666a1558f4abef0fb5a7b86ac3c4"),
				new NameValuePair("mobile", phone),
				new NameValuePair("msg_content",content),
				new NameValuePair("msg_id", ""), new NameValuePair("ext", "") };
		post.setRequestBody(data);
		String status ="I";
		try {
			HttpClient client = new HttpClient();
			client.executeMethod(post);
			Header[] headers = post.getResponseHeaders();
			int statusCode = post.getStatusCode();
			System.out.println("statusCode:" + statusCode);
			for (Header h : headers) {
				System.out.println(h.toString());
			}
			
			String result = new String(post.getResponseBodyAsString());
			System.out.println(result);
			//if ("0".equals(result))
			status ="S";
			//else
			//	status = "F";
				
			post.releaseConnection();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return status;
	}
	
	
	/**
	 * 调用正奥短信接口
	 */
	private String sendsZhenao(String phonenumber,String msgContent){
		String sendsmsurl = "http://139.129.128.71:8086/msgHttp/json/mt";	
		String account = "zhangbei106";
		String password = "123456";
		//String banlanceResult = SmsClientBanlance.queryBanlance(banlanceurl,account,password);
		String sendResult = SmsClientSend.sendSms(sendsmsurl,account,password,phonenumber,msgContent);
		System.out.println("account sendResult  "+sendResult);
		String[] strArr = sendResult.split(":");
		String[] resultArr = strArr[2].split(",");
		
		return resultArr[0];
	}
	
	private void insertMessageLog(String uid,String content,String phone,String status){
		LdMessageLog messageLog = new LdMessageLog();
		messageLog.setCreateTime(new Date());
		messageLog.setUid(Integer.valueOf(uid));
		messageLog.setUpdateTime(new Date());
		messageLog.setMessageContent(content);
		messageLog.setMobile(phone);
		messageLog.setSendDate(new Date());
		messageLog.setSendStatus(status);
		messageLog.setType(1);
		saveMessageLog(messageLog);
	}
	
	private void insertVerCode(String uid,String verifyCode,String phone,Integer messageVerifyCodeType){
		LdMobileVerifyCode mobileVerifycode = new LdMobileVerifyCode();
		mobileVerifycode.setCreateTime(new Date());
		mobileVerifycode.setInvalidTime(new Date());
		mobileVerifycode.setMobile(phone);
		mobileVerifycode.setVerifyCode(verifyCode);
		mobileVerifycode.setStatus("1");
		mobileVerifycode.setUpdateTime(new Date());
		mobileVerifycode.setMessageType(messageVerifyCodeType);
		insertMobileVerifycode(mobileVerifycode);
	}
	
	/**
	 * 组装短信内容
	 * @param para
	 * @return
	 */
	private String buildContent(Map<String,Object> para,MessageTypeEnum messageType){
		String content = null;
		/**
		 * 如果手工群发，直接发送内容
		 */
		if(messageType == MessageTypeEnum.MANUAL_INPUT_TEMPLATE){
			content = (String)para.get("content");
		}else{
			LdMessageTemplate temp = selectMessageTemplate(1,Integer.valueOf(messageType.getCode()));
			
			if(null==temp)
				return null;
			
			String messageStr = temp.getMessageContent();
			
			content = replaceStr2(messageStr, para);
		}
		
		return content;
	}

	/**
	 * 创建指定数量的随机字符串
	 * 
	 * @param numberFlag
	 *            是否是数字 true为数字
	 * @param length
	 *            指定长度
	 * @return retStr 返回生成的短信码
	 */
	@Override
	public String createRandomMessage(boolean numberFlag, int length) {
		String retStr = "";
		String strTable = numberFlag ? "1234567890"
				: "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);

		return retStr;
	}

	@Override
	public LdMessageTemplate selectMessageTemplate(int messageType,int type) {
		List<LdMessageTemplate> messageTemplates = iLdMessageTemplate.queryMessageTemplateList(messageType);
		if (null!=messageTemplates && !messageTemplates.isEmpty()){
			for(LdMessageTemplate m :messageTemplates){
				if (m.getType()==type)
					return m;
			}
		}
		return null;
	}

	@Override
	public void saveMessageLog(LdMessageLog messageLog){
		iLdMessageLog.add(messageLog);
	}

	@Override
	public void insertMobileVerifycode(LdMobileVerifyCode mobileVerifycode) {
		iMobileVerifycode.add(mobileVerifycode);
	}

	@Override
	public List checkCode(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return iMobileVerifycode.checkCode(map);
	}
	
	/**
	 * 站内信分页
	 */
	@Override
	public List<LdMessageLog> selectMessageByPage(Map<String,Object> para){
		return iLdMessageLog.queryMessageLogListPage(para);
	}
	
	public Integer selectMessageByPageCount(Map<String,Object> para){
		return iLdMessageLog.queryMessageLogListPageCount(para);
	}
	

	@Override
	public List<LdMessageLog> fqueryMessageLogListPage(Map<String,Object> para){
		return iLdMessageLog.fqueryMessageLogListPage(para);
	}
	
	public Integer fqueryMessageLogListPageCount(Map<String,Object> para){
		return iLdMessageLog.fqueryMessageLogListPageCount(para);
	}
	
	//update message 
	public void updateStatusMessage(Map<String,Object> para){
		String updateIds = (String)para.get("updateIds");
		String send_status = (String)para.get("read_status");
		Map<String,Object> maps = new HashMap<String,Object>();
		if(StringUtil.isNotEmpty(updateIds)){
			String[] ids = updateIds.split("_");
			maps.put("ids", ids);
			maps.put("read_status", send_status);
			iLdMessageLog.updateStatusMessage(maps);
		}
	}
	
	//find message by id
	public LdMessageLog fQueryMessageLogById(String id){
		return iLdMessageLog.fQueryMessageLogById(id);
	}
	
	public LdMessageLog fQueryMessageLogByStep(Map<String,Object> para){
		return iLdMessageLog.fQueryMessageLogByStep(para);
	}

	public int fQueryMessagebyUid(int uid)
	{
		return iLdMessageLog.fQueryMessagebyUid(uid);
	}
	
	/**
	 * 模板变量替换
	 * @param content
	 * 				模板内容
	 * @param paramMap
	 * 				传值变量要跟替换变量字母一样，如userName替换#USERNAME#
	 * @return
	 */
	public String replaceStr2(String content, Map<String, Object> paramMap) {
		
		for (String key : paramMap.keySet()) {
			
			StringBuffer info = new StringBuffer();
			info.append("#");
			info.append(key.toUpperCase());
			info.append("#");
			
			if (paramMap.get(key) == null) {
				content = content.replace(info, " ");
			} else {
				content = content.replace(info, paramMap.get(key).toString());
			}
		}
		return content;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sendsmsurl = "http://139.129.128.71:8086/msgHttp/json/mt";
		String banlanceurl = "http://139.129.128.71:8086/msgHttp/json/balance";
		
		String account = "zhangbei106";
		String password = "123456";
		String phonenumber = "18616031288";
		String msgContent = "JAVA接口测试短信";
		String banlanceResult = SmsClientBanlance.queryBanlance(banlanceurl,account,password);
		
		System.out.println("account banlance value "+banlanceResult);
		
		/*String sendResult = SmsClientSend.sendSms(sendsmsurl,account,password,phonenumber,msgContent);
		String[] strArr = sendResult.split(":");
		String[] resultArr = strArr[2].split(",");
		System.out.println("account sendResult  "+sendResult);*/
	}

	@Override
	public LdMobileVerifyCode getVerifycodeByMobile(Map<String, Object> param) {
		return iMobileVerifycode.getVerifycodeByMobile(param);
	}

}