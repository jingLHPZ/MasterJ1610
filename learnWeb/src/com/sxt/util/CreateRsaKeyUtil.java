package com.sxt.util;

/**
 *
 * @author 
 * @date：2016年5月19日 上午11:29:12
 * 
 */
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;
  
public class CreateRsaKeyUtil {
	
	/** *//** 
     * RSA最大加密明文大小 
     */  
    private static final int MAX_ENCRYPT_BLOCK = 117;  
      
    /** *//** 
     * RSA最大解密密文大小 
     */  
    private static final int MAX_DECRYPT_BLOCK = 128;
  
    public static void makekeyfile(String pubkeyfile, String privatekeyfile)  
            throws NoSuchAlgorithmException, FileNotFoundException, IOException {  
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象  
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");  
        // 初始化密钥对生成器，密钥大小为1024位  
        keyPairGen.initialize(1024);  
        // 生成一个密钥对，保存在keyPair中  
        KeyPair keyPair = keyPairGen.generateKeyPair();  
  
        // 得到私钥  
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();  
  
        // 得到公钥  
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  
  
        // 生成私钥  
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(  
                privatekeyfile));  
        oos.writeObject(privateKey);  
        oos.flush();  
        oos.close();  
  
        oos = new ObjectOutputStream(new FileOutputStream(pubkeyfile));  
        oos.writeObject(publicKey);  
        oos.flush();  
        oos.close();  
  
        System.out.println("make file ok!");  
    }  
  
    public static byte[] handleData(Key k, byte[] data, int encrypt)  
            throws Exception {  
  
        if (k != null) {  
  
            Cipher cipher = Cipher.getInstance("RSA");
            if (encrypt == 1) {
            	cipher.init(Cipher.ENCRYPT_MODE, k);
            	int inputLen = data.length;  
                ByteArrayOutputStream out = new ByteArrayOutputStream();  
                int offSet = 0;  
                byte[] cache;  
                int i = 0;  
                // 对数据分段加密  
                while (inputLen - offSet > 0) {  
                    if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {  
                        cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);  
                    } else {  
                        cache = cipher.doFinal(data, offSet, inputLen - offSet);  
                    }  
                    out.write(cache, 0, cache.length);  
                    i++;  
                    offSet = i * MAX_ENCRYPT_BLOCK;  
                }  
                byte[] encryptedData = out.toByteArray();  
                out.close();  
                return encryptedData;
            } else if (encrypt == 0) {
            	cipher.init(Cipher.DECRYPT_MODE, k);
            	int inputLen = data.length;  
                ByteArrayOutputStream out = new ByteArrayOutputStream();  
                int offSet = 0;  
                byte[] cache;  
                int i = 0;  
                // 对数据分段解密  
                while (inputLen - offSet > 0) {  
                    if (inputLen - offSet > MAX_DECRYPT_BLOCK) {  
                        cache = cipher.doFinal(data, offSet, MAX_DECRYPT_BLOCK);  
                    } else {  
                        cache = cipher.doFinal(data, offSet, inputLen - offSet);  
                    }  
                    out.write(cache, 0, cache.length);  
                    i++;  
                    offSet = i * MAX_DECRYPT_BLOCK;  
                }  
                byte[] decryptedData = out.toByteArray();  
                out.close();  
                return decryptedData;
            } else {  
                System.out.println("参数必须为: 1 加密 0解密");  
            }  
        }  
        return null;  
    }
  
    public static void main(String[] args) throws Exception {  
  
        String pubfile = "d:/pub1.key";
        String prifile = "d:/pri2.key";
  
        //makekeyfile(pubfile, prifile);  
  
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                pubfile));  
        RSAPublicKey pubkey = (RSAPublicKey) ois.readObject();  
        ois.close();  
  
        ois = new ObjectInputStream(new FileInputStream(prifile));  
        RSAPrivateKey prikey = (RSAPrivateKey) ois.readObject();  
        ois.close();  
  
        // 使用公钥加密  
        String msg = "~O(∩_∩)O哈哈~";  
        String enc = "UTF-8";  
  
        // 使用公钥加密私钥解密  
        System.out.println("原文: " + msg);  
        byte[] result = handleData(pubkey, msg.getBytes(enc), 1);  
        System.out.println("加密: " + new String(result, enc));  
        byte[] deresult = handleData(prikey, result, 0);  
        System.out.println("解密: " + new String(deresult, enc));  
  
        msg = "嚯嚯";  
        // 使用私钥加密公钥解密  
        System.out.println("原文: " + msg);  
        byte[] result2 = handleData(prikey, msg.getBytes(enc), 1);  
        System.out.println("加密: " + new String(result2, enc));  
        byte[] deresult2 = handleData(pubkey, result2, 0);  
        System.out.println("解密: " + new String(deresult2, enc));  
  
    }
    
    /**
	 * 将十六进制数据转换成ASCII字符串
	 * 
	 * @param len
	 *            十六进制数据长度
	 * @param data_in
	 *            待转换的十六进制数据
	 * @param data_out
	 *            已转换的ASCII字符串
	 */
	public static void Hex2Ascii(int len, byte data_in[], byte data_out[]) {
		
		byte temp1[] = new byte[1];
		byte temp2[] = new byte[1];
		
		for (int i = 0, j = 0; i < len; i++) {
			temp1[0] = data_in[i];
			temp1[0] = (byte) (temp1[0] >>> 4);
			temp1[0] = (byte) (temp1[0] & 0x0f);
			temp2[0] = data_in[i];
			temp2[0] = (byte) (temp2[0] & 0x0f);
			
			if (temp1[0] >= 0x00 && temp1[0] <= 0x09) {
				(data_out[j]) = (byte) (temp1[0] + '0');
			} else if (temp1[0] >= 0x0a && temp1[0] <= 0x0f) {
				(data_out[j]) = (byte) (temp1[0] + 0x57);
			}

			if (temp2[0] >= 0x00 && temp2[0] <= 0x09) {
				(data_out[j + 1]) = (byte) (temp2[0] + '0');
			} else if (temp2[0] >= 0x0a && temp2[0] <= 0x0f) {
				(data_out[j + 1]) = (byte) (temp2[0] + 0x57);
			}
			j += 2;
		}
	}
	
	/**
	 * 将ASCII字符串转换成十六进制数据
	 * 
	 * @param len
	 *            ASCII字符串长度
	 * @param data_in
	 *            待转换的ASCII字符串
	 * @param data_out
	 *            已转换的十六进制数据
	 */
	public static void Ascii2Hex(int len, byte data_in[], byte data_out[])
	{
		byte temp1[] = new byte[1];
		byte temp2[] = new byte[1];
		for (int i = 0, j = 0; i < len; j++)
		{
			temp1[0] = data_in[i];
			temp2[0] = data_in[i + 1];
			if (temp1[0] >= '0' && temp1[0] <= '9')
			{
				temp1[0] -= '0';
				temp1[0] = (byte) (temp1[0] << 4);

				temp1[0] = (byte) (temp1[0] & 0xf0);

			}
			else if (temp1[0] >= 'a' && temp1[0] <= 'f')
			{
				temp1[0] -= 0x57;
				temp1[0] = (byte) (temp1[0] << 4);
				temp1[0] = (byte) (temp1[0] & 0xf0);
			}

			if (temp2[0] >= '0' && temp2[0] <= '9')
			{
				temp2[0] -= '0';

				temp2[0] = (byte) (temp2[0] & 0x0f);

			}
			else if (temp2[0] >= 'a' && temp2[0] <= 'f')
			{
				temp2[0] -= 0x57;

				temp2[0] = (byte) (temp2[0] & 0x0f);
			}
			data_out[j] = (byte) (temp1[0] | temp2[0]);

			i += 2;
		}

	}
}
