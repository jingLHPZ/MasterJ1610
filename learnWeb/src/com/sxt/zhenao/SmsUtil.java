package com.sxt.zhenao;

import java.net.URLEncoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 正奥短信发送接口
 * @author 
 * @date：2015年12月28日 上午11:29:19
 * 
 */
public class SmsUtil {
	
	private static Log logger = LogFactory.getLog(SmsUtil.class);
	
	private final static String URL = "http://www.591duanxin.com/sms.aspx";
	private final static String USER_ID = "650";
	private final static String ACCOUNT = "zhangbei";
	private final static String PASSWORD = "123456";
	
	/**
	 * post发送短信息
	 * 
	 * @param mobile
	 *            ：必填--发送的手机号码，多个可以用逗号隔比如>13512345678,13612345678
	 * @param content
	 *            ：必填--实际发送内容
	 * @return 返回发送之后收到的信息
	 */
	public static String sendSmsByPost(String mobile, String content) {

		try {
			StringBuffer send = new StringBuffer();
			send.append("action=send");
			send.append("&userid=").append(USER_ID);
			send.append("&account=").append(URLEncoder.encode(ACCOUNT, "UTF-8"));
			send.append("&password=").append(URLEncoder.encode(PASSWORD, "UTF-8"));
			send.append("&mobile=").append(mobile);
			send.append("&content=").append(URLEncoder.encode(content, "UTF-8"));

			String result = SmsClientAccessTool.getInstance().doAccessHTTPPost(URL,
					send.toString(), "UTF-8");
			logger.info(result);
			return "0";
		} catch (Exception e) {
			logger.error("未发送，编码异常!" + e.getMessage());
			e.printStackTrace();
			return "1";
		}
	}

	/**
	 * 企业短信账户余额获取方法
	 * 
	 * 其一：发送方式，默认为POST<br/>
	 * 其二：发送内容编码方式，默认为UTF-8
	 * 
	 * @return 返回余额查询字符串
	 */
	public static String queryOverage(String url, String userid, String account, String password) {

		try {
			StringBuffer sendParam = new StringBuffer();
			sendParam.append("action=overage");
			sendParam.append("&userid=").append(USER_ID);
			sendParam.append("&account=").append(URLEncoder.encode(ACCOUNT, "UTF-8"));
			sendParam.append("&password=").append(URLEncoder.encode(PASSWORD, "UTF-8"));
			
			String result = SmsClientAccessTool.getInstance().doAccessHTTPPost(URL,sendParam.toString(), "UTF-8");
			logger.info(result);
			return "0";
		} catch (Exception e) {
			logger.error("未发送，异常!" + e.getMessage());
			e.printStackTrace();
			return "1";
		}
	}
	
	/**
	 * 
	 * 是否包含关键字获取方法
	 * 
	 * 其一：发送方式，默认为POST<br/>
	 * 其二：发送内容编码方式，默认为UTF-8
	 * 
	 * @param checkWord
	 *            ：必填--需要检查的字符串--比如：这个字符串中是否包含了屏蔽字
	 * @return 返回需要查询的字符串中是否包含关键字
	 */
	public static String queryKeyWord(String checkWord) {

		try {
			StringBuffer sendParam = new StringBuffer();
			sendParam.append("action=checkkeyword");
			sendParam.append("&userid=").append(USER_ID);
			sendParam.append("&account=").append(URLEncoder.encode(ACCOUNT, "UTF-8"));
			sendParam.append("&password=").append(URLEncoder.encode(PASSWORD, "UTF-8"));
			if (checkWord != null && !checkWord.equals("")) {
				sendParam.append("&content=").append(URLEncoder.encode(checkWord, "UTF-8"));
			} else {
				return "1";
			}
			
			String result = SmsClientAccessTool.getInstance().doAccessHTTPPost(URL, sendParam.toString(), "UTF-8");
			logger.info(result);
			return "0";
		} catch (Exception e) {
			logger.error("未发送，异常!" + e.getMessage());
			e.printStackTrace();
			return "1";
		}
	}
	
}
