package com.sxt.util;

import java.util.HashMap;
import java.util.Map;

public class SingleOnline {
	 private static Map<Integer, String> mapOnline = new HashMap<Integer, String>();

	    /**
	     * 将用户添加到在线列表
	     * @param userCode
	     * @param sessionId
	     */
	    public static synchronized void addUser(Integer userCode,String sessionIdIP) {
	        if (mapOnline.containsKey(userCode))
	            mapOnline.remove(userCode);           
	        
	        mapOnline.put(userCode, sessionIdIP);
	    }

	    /**
	     * 是否为合法用户
	     * @param userCode
	     * @param sessionId
	     * @return
	     */
	    public static boolean isValidUser(Integer userCode, String sessionIdIP) {
	        if (!mapOnline.containsKey(userCode))
	            return false;
	        
	        if (!mapOnline.get(userCode).equals(sessionIdIP))
	            return false;

	        return true;
	    }
}
