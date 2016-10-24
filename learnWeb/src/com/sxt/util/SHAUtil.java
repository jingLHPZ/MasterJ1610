package com.sxt.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA处理
 * @author pillar liu
 * @version $Id: SHAUtils.java, v 0.1 2013-3-6 下午3:19:02 pillar liu $
 */
public class SHAUtil {

    public static String encryptSHA1(String text) throws NoSuchAlgorithmException,
                                                 UnsupportedEncodingException {
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        sha1.update(text.getBytes("GB2312"));
        return StringCipherUtils.bytesToHexString(sha1.digest()).toLowerCase();
    }

    private static class StringCipherUtils {

        static String bytesToHexString(byte[] src) {
            StringBuilder stringBuilder = new StringBuilder("");
            if (src == null || src.length <= 0) {
                return null;
            }
            for (int i = 0; i < src.length; i++) {
                int v = src[i] & 0xFF;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    stringBuilder.append(0);
                }
                stringBuilder.append(hv);
            }
            return stringBuilder.toString();
        }

    }
    
    public static String md5(String source) {
    	StringBuffer sb = new StringBuffer(32);
    	try {
	    	MessageDigest md = MessageDigest.getInstance("MD5");
	    	byte[] array = md.digest(source.getBytes("utf-8"));
	    	for (int i = 0; i < array.length; i++) {
	    		sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1, 3));
	    	}
    	} catch (Exception e) {
    	    e.printStackTrace();
    		return null;
    	}

    	return sb.toString();
    	}
    
    public static void main(String[] args){
    	//System.out.println(new Money(0,(new Money(0,12).getCent() - new Money(0,120).getCent()),Currency.getInstance("CNY")));
    	//System.out.println(new Money(0,120).getCent(),Currency.getInstance("CNY"));
    	System.out.println(md5("admin"));
    	System.out.println(md5("admin"));
    }
}
