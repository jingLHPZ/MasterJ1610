package com.sxt.tonglian;

import com.sxt.util.PropertiesRead;

/**
 * 通联常量
 * @author 
 * @date：2016年1月9日 下午5:00:05
 * 
 */
public class TLConstants {
	
	//	请求路径
	public static final String TL_URL = PropertiesRead.use_classLoador().getProperty("tl_url");

	//	商户号
	public static final String TL_BUSINESS_NO = PropertiesRead.use_classLoador().getProperty("tl_businessNo");
	
	//	用户名
	public static final String TL_USER_NAME = PropertiesRead.use_classLoador().getProperty("tl_userName");
	
	//	密码
	public static final String TL_USER_PASS = PropertiesRead.use_classLoador().getProperty("tl_userPass");
	
	//	私钥证书路径
	public static final String PRIVATE_KEY_PATH = PropertiesRead.use_classLoador().getProperty("private_key_path");
	
	//	公钥证书路径
	public static final String COMMON_KEY_PATH = PropertiesRead.use_classLoador().getProperty("common_key_path");;

	//	私钥保护密码
	public static final String PRIVATE_KEY_PASSWARD = "111111";
}
