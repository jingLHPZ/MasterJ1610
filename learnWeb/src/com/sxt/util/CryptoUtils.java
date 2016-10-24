package com.sxt.util;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;



/**
 * 支持 DES对称加密的工具类.
 * 
 * 支持Hex与Base64两种编码方式.
 * 
 * @author wangwch
 */
public class CryptoUtils {

	private static final String DES = "DES";
	private static final String DEFAULT_ENCODING = "UTF-8";
	/** 加密算法 */
	private final static String ALGORITHM = "DES/CBC/PKCS5Padding";

	/**
	 * 传输的关键数据加密
	 * @param keyData 需加密值
	 * @param timestamp  时间戳
	 * @param dataSecret  密钥
	 * @return String 加密数据
	 *//*
	public static String encryptKeyData(String keyData, Long timestamp, String dataSecret) {

		DateFormat df = new SimpleDateFormat(DateTimeUtils.DATETIME_FORMAT_YYYYMMDDHHMMSS);
		df.setTimeZone(TimeZone.getTimeZone(DateTimeUtils.DATE_TIMEZONE));
		keyData = df.format(new Date(timestamp)) + keyData;
		return desEncryptToBase64(keyData, dataSecret.getBytes());
	}
	*//**
	 * 传输的关键数据加密
	 * @param keyData 需加密值
	 * @param timestamp  时间戳
	 * @param dataSecret  密钥
	 * @return String 加密数据
	 *//*
	public static String encryptKeyData(String keyData, String timestamp, String dataSecret) {
		keyData = timestamp + keyData;
		return desEncryptToBase64(keyData, dataSecret.getBytes());
	}
	//-- DES function --//
	*//**
	 * 使用DES加密原始字符串, 返回Hex编码的结果.
	 * 
	 * @param input 原始输入字符串
	 * @param keyBytes 符合DES要求的密钥
	 *//*
	public static String desEncryptToHex(String input, byte[] keyBytes) {
		byte[] encryptResult = null;
		try {
			encryptResult = des(input.getBytes(DEFAULT_ENCODING), keyBytes, Cipher.ENCRYPT_MODE);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return EncodeUtils.hexEncode(encryptResult);
	}*/

	/**
	 * 使用DES加密原始字符串, 返回Base64编码的结果.
	 * 
	 * @param input 原始输入字符串
	 * @param keyBytes 符合DES要求的密钥
	 * @throws Exception 
	 */
	public static String desEncryptToBase64(String input, byte[] keyBytes) {
		try {
			byte[] encryptResult = des(input.getBytes(DEFAULT_ENCODING), keyBytes, Cipher.ENCRYPT_MODE);
			
			return new String(Base64.encodeBase64String(encryptResult));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 使用DES解密Hex编码的加密字符串, 返回原始字符串.
	 * 
	 * @param input Hex编码的加密字符串
	 * @param keyBytes 符合DES要求的密钥
	 */
	/*public static String desDecryptFromHex(String input, byte[] keyBytes) {
		byte[] decryptResult = des(EncodeUtils.hexDecode(input), keyBytes, Cipher.DECRYPT_MODE);
		String decryptString = null;
		try {
			decryptString = new String(decryptResult, DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return decryptString;
	}

	*//**
	 * 使用DES解密Base64编码的加密字符串, 返回原始字符串.
	 * 
	 * @param input Base64编码的加密字符串
	 * @param keyBytes 符合DES要求的密钥
	 * @throws AppException 
	 *//*
	public static String desDecryptFromBase64(String input, byte[] keyBytes) throws AppException {
		try {
			byte[] decryptResult = des(Base64.decodeBase64(input), keyBytes, Cipher.DECRYPT_MODE);
			String decryptString = new String(decryptResult, DEFAULT_ENCODING);
			return decryptString;
		} catch (Exception e) {
			throw new AppException("des解密失败！");
			
//			throw new AppException("E999999999","des解密失败！");
		}
	}

	*//**
	 * 使用DES加密或解密无编码的原始字节数组, 返回无编码的字节数组结果.
	 * 通用的java .net php
	 * @param inputBytes 原始字节数组
	 * @param keyBytes 符合DES要求的密钥
	 * @param mode Cipher.ENCRYPT_MODE 或 Cipher.DECRYPT_MODE
	 * @throws GeneralSecurityException 
	 */
	private static byte[] des(byte[] inputBytes, byte[] keyBytes, int mode) 
			throws GeneralSecurityException {
		try {
			DESKeySpec desKeySpec = new DESKeySpec(keyBytes);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			//密钥
			SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
			// 偏移量
			IvParameterSpec iv = new IvParameterSpec(keyBytes);
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(mode, secretKey, iv);
			return cipher.doFinal(inputBytes);
		} catch (GeneralSecurityException e) {
			throw e;
		}
	}

	/**
	 * 生成符合DES要求的密钥, 长度为64位(8字节).
	 *//*
	public static byte[] generateDesKey() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(DES);
			SecretKey secretKey = keyGenerator.generateKey();
			return secretKey.getEncoded();
		} catch (GeneralSecurityException e) {
			throw convertRuntimeException(e);
		}
	}

	*//**
	 * 生成符合DES要求的Hex编码密钥, 长度为16字符.
	 *//*
	public static String generateDesHexKey() {
		return EncodeUtils.hexEncode(generateDesKey());
	}

	private static IllegalStateException convertRuntimeException(GeneralSecurityException e) {
		return new IllegalStateException("Security exception", e);
	}
	
	*//**
	 * 获取关键数据的原值
	 * @param encryptKeyData
	 * @param appKey
	 * @param signV 签名版本号
	 * @param timestamp
	 * @return keyData  原始值为空,返回为空,否则取原始值
	 * @throws ApiException
	 *//*
	public static String getKeyData(String encryptKeyData, String dataSecret, String timestamp){
		if (encryptKeyData == null) {
			return null;
		}
		String keyData = null;
		
		keyData = CryptoUtils.desDecryptFromBase64(encryptKeyData, dataSecret.getBytes());
		//返回原始数据,去除固定的 时间戳+aop,共17位
		keyData = keyData.substring(14, keyData.length());
		return keyData;
	}
	
	public static void main(String[] args) {
		
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("expiredDate", "");
		 map.put("phoneNo", "18373906094");
		 map.put("custName", "杨一");
		 map.put("bankNo", "01050000");
		 map.put("amount", "5");
		 map.put("cardNo", "6227002960070369604");
		 map.put("custIdNo", "610114199210203577");
		 map.put("storableCardNo", "");
		 map.put("cvv2", "");
		 map.put("custIdType", "0");
		 map.put("custId", "2423412341324");
		 
		 Object jsonClose = JSONObject.toJSON(map);
		 String strClose = jsonClose.toString();	
		 String plaintext = strClose;
		      String ciphertext = desEncryptToBase64(plaintext, CoreConstant.DES_KEY.getBytes());
		      System.out.println("明文：" + plaintext);
		      System.out.println("密钥：" + CoreConstant.DES_KEY);
		      System.out.println("密文：" + ciphertext);
		      System.out.println("解密后：" + desDecryptFromBase64(ciphertext, CoreConstant.DES_KEY.getBytes()));
		      String bean = desDecryptFromBase64("PdzZV0pFOQNf1NWqGqirrw==", CoreConstant.DES_KEY.getBytes());
		      System.out.println(bean);
		//20151028170337
		String s = CryptoUtils.desEncryptToBase64("", CoreConstant.DATA_SECRET_KEY.getBytes());
		//String s2 = CryptoUtils.desEncryptToHex("201510281731396222021001103493174", CoreConstant.DATA_SECRET_KEY.getBytes());
		System.out.println(s);
		
		String m = CryptoUtils.desDecryptFromBase64("PdzZV0pFOQNf1NWqGqirrw==", CoreConstant.DATA_SECRET_KEY.getBytes());
		System.out.println(m);
		//20151031110810 20151031110810 1000000031 1000000031
	}*/
}