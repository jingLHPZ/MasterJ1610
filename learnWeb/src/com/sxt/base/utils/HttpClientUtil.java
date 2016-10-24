package com.sxt.base.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.log4j.Logger;

public class HttpClientUtil {
	private static Logger logger = Logger.getLogger(HttpClientUtil.class);
	private static HttpClient client = null;
	private static final SSLHandler simpleVerifier = new SSLHandler();
	private static SSLSocketFactory sslFactory;

	// 构造单例
	private HttpClientUtil() {

		MultiThreadedHttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
		HttpConnectionManagerParams params = new HttpConnectionManagerParams();
		// 默认连接超时时间
		params.setConnectionTimeout(5000);
		// 默认读取超时时间
		params.setSoTimeout(10000);
		// 默认单个host最大连接数
		params.setDefaultMaxConnectionsPerHost(100);// very important!!
		// 最大总连接数
		params.setMaxTotalConnections(256);// very important!!
		httpConnectionManager.setParams(params);

		client = new HttpClient(httpConnectionManager);

		client.getParams().setConnectionManagerTimeout(3000);
		// client.getParams().setIntParameter("http.socket.timeout", 10000);
		// client.getParams().setIntParameter("http.connection.timeout", 5000);
	}

	private static class ClientUtilInstance {
		private static final HttpClientUtil ClientUtil = new HttpClientUtil();
	}

	public static HttpClientUtil getInstance() {
		return ClientUtilInstance.ClientUtil;
	}

	/**
	 * 发送http GET请求，并返回http响应字符串
	 * 
	 * @param urlstr
	 *            完整的请求url字符串
	 * @return
	 */
	public String doGetRequest(String urlstr) {
		String response = "";

		HttpMethod httpmethod = new GetMethod(urlstr);
		try {
			int statusCode = client.executeMethod(httpmethod);
			InputStream _InputStream = null;
			if (statusCode == HttpStatus.SC_OK) {
				_InputStream = httpmethod.getResponseBodyAsStream();
			}
			if (_InputStream != null) {
				response = GetResponseString(_InputStream, "UTF-8");
			}
		} catch (HttpException e) {
			logger.error("获取响应错误，原因：" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("获取响应错误，原因1：" + e.getMessage());
			e.printStackTrace();
		} finally {
			httpmethod.releaseConnection();

		}
		return response;
	}

	/**
	 * 
	 * @param _InputStream
	 * @param Charset
	 * @return
	 */
	public String GetResponseString(InputStream _InputStream, String Charset) {
		String response = "";
		try {
			if (_InputStream != null) {
				StringBuffer buffer = new StringBuffer();
				InputStreamReader isr = new InputStreamReader(_InputStream,
						Charset);
				Reader in = new BufferedReader(isr);
				int ch;
				while ((ch = in.read()) > -1) {
					buffer.append((char) ch);
				}
				response = buffer.toString();
				buffer = null;
			}
		} catch (Exception e) {
			logger.error("获取响应错误，原因：" + e.getMessage());
			response = response + e.getMessage();
			e.printStackTrace();
		}
		return response;
	}

	/** 
     * 发送https请求
     * @param httpsUrl 
     *            请求的地址 
     * @param xmlStr 
     *            请求的数据 
	 * @throws Exception 
     */  
    public static String httpsPost(String httpsUrl, String xmlStr) throws Exception {
    	OutputStream reqStream=null;
		InputStream resStream =null;
		
		byte[] postData;
		try {
			postData = xmlStr.getBytes("GBK");
			
			URL url = new URL(httpsUrl);
			URLConnection conn = url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			HttpsURLConnection httpsConn = (HttpsURLConnection) conn;
			httpsConn.setRequestMethod("POST");
			httpsConn.setSSLSocketFactory(getSSLSF());
			httpsConn.setHostnameVerifier(simpleVerifier);
	
			httpsConn.setRequestProperty("Content-type", "application/tlt-notify");
			httpsConn.setRequestProperty("Content-length", String.valueOf(postData.length));
			httpsConn.setRequestProperty("Keep-alive", "false");
	
			reqStream = httpsConn.getOutputStream();
			reqStream.write(postData);
			reqStream.close();
	
			ByteArrayOutputStream ms = null;
			resStream = httpsConn.getInputStream();
			ms = new ByteArrayOutputStream();
			byte[] buf = new byte[4096];
			int count;
			while ((count = resStream.read(buf, 0, buf.length)) > 0) {
				ms.write(buf, 0, count);
			}
			resStream.close();
			return new String(ms.toByteArray(), "GBK");
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if(reqStream != null) reqStream.close();
			} catch(Exception ex) {
				throw ex;
			}
		}
    }
    
    public static synchronized SSLSocketFactory getSSLSF() throws Exception
	{
		if(sslFactory!=null) return sslFactory; 
		SSLContext sc = SSLContext.getInstance("SSLv3");
		sc.init(null, new TrustManager[]{simpleVerifier}, null);
		sslFactory = sc.getSocketFactory();
		return sslFactory;
	}
    
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String doGetRequest(String url, String charset) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            
            //	打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            
            //	设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            
            //	定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) { in.close(); }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    
    private static class SSLHandler implements X509TrustManager,HostnameVerifier
	{	
		private SSLHandler()
		{
		}
		
		public void checkClientTrusted(X509Certificate[] arg0, String arg1)
				throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] arg0, String arg1)
				throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean verify(String arg0, SSLSession arg1)
		{
			return true;
		}
	}
	
	public static void main(String[] args) {
		String url = "http://esms.etonenet.com/sms/mt?spid=3060&sppassword=hbkj3060&das=8618611178949&command=MULTI_MT_REQUEST&sm=a1beccd4b1a6a1bf20cda8b5c0bdd3c8ebcdeab3c9a3a1&dc=15";
		// System.out.println(doGetRequest(url));
	}
}
