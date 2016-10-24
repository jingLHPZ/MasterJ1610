package com.sxt.base.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
/**
 * 
 * @author jl
 *
 */
public class PatternHelper {
	private static final String XX = "****";
	private static final String PHONE = "^((14[5,7])|(17[0,1,6-8])|(13[0-9])|(15[0-3,5-9])|(18[0-3,5-9]))\\d{8}$";
	private static final String MONEY = "^(([1-9]\\d{0,9})|0)(\\.\\d{1,2})?$";
	
	/**
	 * @param name
	 * @return 
		Assert.assertEquals(PatternHelper.getFormatName("15900550445"),"159****0445");
		Assert.assertEquals(PatternHelper.getFormatName("小希"),"小**");
		Assert.assertEquals(PatternHelper.getFormatName("momokojgy"),"m**okojgy");
		Assert.assertEquals(PatternHelper.getFormatName(null),"**");
	 * 
	 */
	public static String getFormatName(String name){
        if (StringUtils.isBlank(name)) {
            return XX;
        }
        Pattern p = Pattern.compile(PHONE);
        Matcher m = p.matcher(name);
		if(m.matches()){
			return name.replaceFirst(name.substring(3, 7), XX);
		}
		if(name.length() <=2){
			return name.substring(0,1) + XX;
		}
	 	return name.substring(0,1) + XX + name.substring(name.length()-1,name.length());
	}
	
	/**
	 * 验证是否是金额
	 * @param money
	 * @return
	 */
	public static boolean isMoney(String money) {
		Pattern p = Pattern.compile(MONEY);
        Matcher m = p.matcher(money.toString());
        if(m.matches()) {
        	return true;
        } else {
        	return false;
        }
	}
	
	public static void main(String[] args) {
		//System.out.println(getFormatName("8888"));
		//System.out.println(getFormatName("谭阳菊"));
		//System.out.println(getFormatName("逍遥"));
		System.out.println(getFormatName("13612881288"));
	}
}
