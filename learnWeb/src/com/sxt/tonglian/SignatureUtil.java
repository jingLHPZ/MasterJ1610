package com.sxt.tonglian;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Enumeration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 签名工具类
 * @author 
 * @date：2016年1月9日 下午3:08:22
 * 
 */
public class SignatureUtil {

	private static Log logger = LogFactory.getLog(SignatureUtil.class);
	
	/**
	 * 对字符串进行签名
	 * 
	 * @param msg
	 *            需要进行签名的字符串
	 * @return 签名成功返回签名信息
	 */
	public static String SignMsg(final String msg) throws Exception {
		
		
		FileInputStream fiKeyFile = new FileInputStream(TLConstants.PRIVATE_KEY_PATH);
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		
		try {
			keyStore.load(fiKeyFile, TLConstants.PRIVATE_KEY_PASSWARD.toCharArray());
		} catch(Exception e) {
			if(fiKeyFile != null) fiKeyFile.close();
			e.printStackTrace();
			logger.error("加载通联私钥错误" + e.getMessage());
			throw new Exception("加载通联私钥错误");
		}
		
		Enumeration<String> myEnum = keyStore.aliases();
		String keyAlias = null; RSAPrivateCrtKey prikey = null;
		
		while (myEnum.hasMoreElements()) {
			keyAlias = (String) myEnum.nextElement();
			if (keyStore.isKeyEntry(keyAlias)) {
				prikey = (RSAPrivateCrtKey) keyStore.getKey(keyAlias, 
						TLConstants.PRIVATE_KEY_PASSWARD.toCharArray());
				break;
			}
		}
		
		if (prikey == null) {
			throw new Exception("没有找到匹配私钥");
		} else {
			Signature sign = Signature.getInstance("SHA1withRSA");
			sign.initSign(prikey);
			sign.update(msg.getBytes("GBK"));
			byte signed[] = sign.sign();
			byte sign_asc[] = new byte[signed.length * 2];
			Hex2Ascii(signed.length, signed, sign_asc);
			return new String(sign_asc);
		}
	}
	
	/**
	 * 验签
	 * @param ciphertext
	 * 				密文
	 * @param plaintext
	 * 				明文
	 * @param certFile
	 * 				公钥文件地址
	 * @return
	 * @throws Exception
	 */
	public static boolean VerifyMsg(String ciphertext, String plaintext) throws Exception {
		boolean result = false;
		FileInputStream certfile = null;
		certfile = new FileInputStream(TLConstants.COMMON_KEY_PATH);
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		
		X509Certificate x509cert = null;
		try {
			x509cert = (X509Certificate) cf.generateCertificate(certfile);
		} catch(Exception ex) {
			if(certfile != null) certfile.close(); throw ex;
		}

		RSAPublicKey pubkey = (RSAPublicKey) x509cert.getPublicKey();
		Signature verify = Signature.getInstance("SHA1withRSA");
		verify.initVerify(pubkey);
		byte signeddata[] = new byte[ciphertext.length() / 2];
		Ascii2Hex(ciphertext.length(), ciphertext.getBytes("gbk"), signeddata);
		verify.update(plaintext.getBytes("gbk"));
		
		if (verify.verify(signeddata)) {
			result = true;
		} else {
			result = false;
		}
		return result;
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
	private static void Hex2Ascii(int len, byte data_in[], byte data_out[]) {
		
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
	private static void Ascii2Hex(int len, byte data_in[], byte data_out[])
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
