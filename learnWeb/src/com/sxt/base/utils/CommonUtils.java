package com.sxt.base.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;


public class  CommonUtils{
	
	private static final String SOURCE = "PC";
	
	private static final String SOURCEPHONE = "PHONE";
    /**
     * 生成流水号
     * @param primaryKey
     * @return
     */
    public static String createSystemTraceNo(Integer primaryKey){
    	if(primaryKey == null){
    		primaryKey = 1;
    	}
    	return SOURCE.concat(String.valueOf(System.currentTimeMillis()).concat(createRandomNum()).concat(String.valueOf(primaryKey)));
    }
    
    /**
     * 生成流水号
     * @param primaryKey
     * @return
     */
    public static String createSystemTraceNo(HttpServletRequest request, Integer primaryKey){
    	if(primaryKey == null){
    		primaryKey = 1;
    	}
    	if(HttpRequestDeviceUtils.isMobileDevice(request)){
    		return SOURCEPHONE.concat(String.valueOf(System.currentTimeMillis()).concat(createRandomNum()).concat(String.valueOf(primaryKey)));
    	}
    	return createSystemTraceNo(primaryKey);
    }
    /**
     * 生成四位数字随机数
     * @return
     */
    public static String createRandomNum(){
    	 int max=9999;
         int min=1000;
         Random random = new Random();
         int s = random.nextInt(max)%(max-min+1) + min;
         return String.valueOf(s);
    }
    /**
     * 验证手机号
     * @param mobile
     * @return
     */
    public static boolean isMobile(String mobile) {
        if (StringUtils.isBlank(mobile)) {
            return false;
        }
        Pattern p = Pattern.compile("^((14[5,7])|(17[0,1,6-8])|(13[0-9])|(15[0-3,5-9])|(18[0-3,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobile);
        return m.matches();
    }
    
    /**
	 * 获取客户端IP地址
	 * 
	 * @param request
	 * @return
	 */
    public static String getRemoteAddr(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("x-client-ip");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
					ipAddress = inet.getHostAddress();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}

			}
		}
		// 多级反向代理
		if (null != ipAddress && !"".equals(ipAddress.trim())) {
			StringTokenizer st = new StringTokenizer(ipAddress, ",");
			if (st.countTokens() > 1) {
				ipAddress = st.nextToken();
			}
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = "获取不到客户端IP请检查网络配置";
		}
		return ipAddress;
	}

}
