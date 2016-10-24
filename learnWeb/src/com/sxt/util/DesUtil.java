package com.sxt.util;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DesUtil {
	
	private final static String DES = "DES";
	
	private static byte[] iv = { 1, 2, 3, 4, 5, 6, 7, 8, };    
	 
	public static void main(String[] args) throws Exception {
		
/*		LdMembersDto ldMembersDto = new LdMembersDto();
		ldMembersDto.setRecommender("976577");
		ldMembersDto.setUserPhone("18118300200");
		ldMembersDto.setUserPass("123456");*/
		
	/*	LdMembersDto ldMembersDto = new LdMembersDto();
		ldMembersDto.setUserPhone("18118300200");
		ldMembersDto.setNewUserPass("654321");
		ldMembersDto.setNotarizeUserPass("654321");
*/
		//"{\"user_phone\":18118100100,"+"\"user_pass\":123456,"+"\"recommender\":100100"+"}"
		//"{\"user_phone\":18118100200,"+"\"user_pass\":123456,"+"\"recommender\":100100"+"}"
		//"{\"user_phone\":18118100300,"+"\"user_pass\":123456,"+"\"recommender\":100100"+"}";
		//"{\"user_phone\":18118100300,"+"\"user_pass\":123456"+"}";
		//"{\"user_phone\":18118100300,"+"\"new_user_pass\":123456,"+"\"notarize_user_pass\":123456,"+"\"recommender\":100100"+"}";
		
/*		 QuickPaymentDto quickPaymentDto = new QuickPaymentDto();
		 quickPaymentDto.setExpiredDate("");
		 quickPaymentDto.setCvv2("");
		 quickPaymentDto.setCustId("1000000138");
		 quickPaymentDto.setCustName("宗元");
		 quickPaymentDto.setCustIdNo("320323199112027010");
		 quickPaymentDto.setCustIdType("0");
		 quickPaymentDto.setCardNo("622908211620892015");
		 quickPaymentDto.setAmount("5");
		 quickPaymentDto.setPhoneNo("18118300200");
		 quickPaymentDto.setBankNo("03090000");*/
		
		 /*Map<String, Object> map = new HashMap<String, Object>();
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
		 map.put("custId", "2423412341324");*/
		 
		 
		 
/*		 QuickPaymentDto quickPaymentDto = new QuickPaymentDto();
		 quickPaymentDto.setExpiredDate("");
		 quickPaymentDto.setPhoneNo("18373906094");
		 quickPaymentDto.setCustName("杨一");
		 quickPaymentDto.setBankNo("01050000");
		 quickPaymentDto.setAmount("5");
		 quickPaymentDto.setCardNo("6227002960070369604");
		 quickPaymentDto.setCustIdNo("610114199210203577");
		 quickPaymentDto.setStorableCardNo("");
		 quickPaymentDto.setCvv2("");
		 quickPaymentDto.setCustIdType("0");
		 quickPaymentDto.setCustId("2423412341324");
*/
		 


		
		
		/* LdMcTransactionDetail ldMcTransactionDetail  = new LdMcTransactionDetail();
		 ldMcTransactionDetail.setMerOrderId("144670953826383141000000138");
		 ldMcTransactionDetail.setCardNo("622908211620892015");
		 ldMcTransactionDetail.setAmount(new BigDecimal("5"));
		 ldMcTransactionDetail.setCustName("宗元");
		 ldMcTransactionDetail.setCustIdNo("320323199112027010");
		 ldMcTransactionDetail.setCustIdType(0);
		 ldMcTransactionDetail.setCustId(1000000138);
		 ldMcTransactionDetail.setPhoneNo("18118300200");
		 ldMcTransactionDetail.setPhoneVercode("243709");
		 ldMcTransactionDetail.setPhonetoken("243709");
		 ldMcTransactionDetail.setBankNo("03090000");
		 ldMcTransactionDetail.setBackurl("http://www.baidu.com");*/
		
		/*
		QuickPaymentDto quickPaymentDto = new QuickPaymentDto();
		quickPaymentDto.setMerOrderId("144627999905229681000000031");
		quickPaymentDto.setCustId("1000000031");
		quickPaymentDto.setCardNo("6222021001103493174");
		quickPaymentDto.setStorableCardNo("6222023174");*/
		
		//关闭快捷支付
		/*QuickPaymentDto quickPaymentDto = new QuickPaymentDto();
		quickPaymentDto.setCustId("1000000031");
		quickPaymentDto.setStorableCardNo("6229082015");
		quickPaymentDto.setBankNo("03090000");*/
		/*String cardNo =  "{\"cardNo\":622908211620892015"+"}";*/
		
		//快捷支付退款
	/*	LdMcRefundDetail ldMcRefundDetail = new LdMcRefundDetail();
		ldMcRefundDetail.setCustId("1000000031");
		ldMcRefundDetail.setOriMerorderId("144644236785327811000000031");
		ldMcRefundDetail.setAmount(new BigDecimal("5"));*/
		
		//查询绑卡信息
		/*QuickPaymentDto quickPaymentDto = new QuickPaymentDto();
		quickPaymentDto.setCustId("1000000031");*/
		 
		 //查询流水
		/* String merOderNo =  "{\"merOderNo\":144670405254646701000000138"+"}";*/
		 //400000003
		/* String productId =  "{\"productId\":400000003"+"}";*/
		
		 String cardIdString = "{\"idName\":\"肖尧\","+"\"idNum\":430321199112277418"+"}";
		/* 
		 TransactionResponseSC0002 tr = new TransactionResponseSC0002();
		 tr.setIdName("肖尧");
		 tr.setIdNum("430321199112277418");*/
		 
/*		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("borrowUid", 1000000031);
		 map.put("start", 0);
		 map.put("limit", 5);
		 
		 
		 Object jsonClose = JSONObject.toJSON(tr);
		 String strClose = jsonClose.toString();	
		 String plaintext = cardIdString;
		      String ciphertext = encryptDES(plaintext, CoreConstant.DES_KEY);
		      System.out.println("明文：" + plaintext);
		      System.out.println("密钥：" + CoreConstant.DES_KEY);
		      System.out.println("密文：" + ciphertext);
		      System.out.println("解密后：" + decryptDES(ciphertext, CoreConstant.DES_KEY));
		      String bean = decryptDES("/JMK4okOFZU01PcqqayhY8+8p2FkSGxlFzTsDQfKQuovmOsx7UfL+ECagKw1 60T5", CoreConstant.DES_KEY);
		      System.out.println(bean);*/
	}  
      

	public static String decryptDES(String decryptString, String decryptKey)
            throws Exception {
        byte[] byteMi = Base64.decode(decryptString);
        IvParameterSpec zeroIv = new IvParameterSpec(iv);
        SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), DES);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
        byte decryptedData[] = cipher.doFinal(byteMi);

        return new String(decryptedData,"UTF-8");
    }
	
	 public static String encryptDES(String encryptString, String encryptKey)
	            throws Exception {
	        IvParameterSpec zeroIv = new IvParameterSpec(iv);
	        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), DES);
	        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
	        byte[] encryptedData = cipher.doFinal(encryptString.getBytes("UTF-8"));
	        return Base64.encode(encryptedData);
	 }
	 
	  

}
