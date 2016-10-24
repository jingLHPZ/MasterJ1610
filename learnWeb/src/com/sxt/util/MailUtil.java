package com.sxt.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sxt.models.Mail;
import com.sxt.service.LdParameterService;

public class MailUtil {

	private static Log logger = LogFactory.getLog(MailUtil.class);
	@Autowired
	private LdParameterService ldParameterService;
	private static Properties props;
	
	public static void sendMail(Mail mail) throws AddressException, MessagingException, UnsupportedEncodingException {
		if(props == null) {
			props = PropertiesRead.use_classLoador("mail");
		}
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		String from = props.getProperty("from");
		Session session = Session.getInstance(props,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mail.getTo()));
		message.setSubject(mail.getSubject());
		message.setContent(mail.getContent(),"text/html;charset=UTF-8");
		Transport.send(message);
	}
	
	public static Mail createMail(String to,String content) {
		if(props == null) {
			props = PropertiesRead.use_classLoador("mail");
		}
		Mail mail = new Mail();
		mail.setSubject(props.getProperty("subject"));
		mail.setContent(content);
		mail.setTo(to);
		return mail;
	}
	
	public static String createContent(String userPhone,Date createTime,String to) {
		if(props == null) {
			props = PropertiesRead.use_classLoador("mail");
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String content = props.getProperty("content");
		content = content.replace("userPhone", Base64.encode(userPhone.getBytes()));
		content = content.replace("createTime", Base64.encode(String.valueOf(createTime.getTime()).getBytes()));
		content = content.replace("zhangbeiparam2", sdf.format(createTime));
		content = content.replace("userEmail", Base64.encode(to.getBytes()));
		return content;
	}
	
	public static String toMailLogin(String email) {
		String login = "http://";
		String splitStr = email.split("@")[1];
		if (splitStr.equals("163.com")) {
			login += "mail.163.com";
		}
		if (splitStr.equals("vip.163.com")) {
			login += "vip.163.com";
		}
		if (splitStr.equals("126.com")) {
			login += "mail.126.com";
		}
		if (splitStr.equals("qq.com")
				|| splitStr.equals("vip.qq.com")
				|| splitStr.equals("foxmail.com")) {
			login += "mail.qq.com";
		}
		if (splitStr.equals("gmail.com")) {
			login += "mail.google.com";
		}
		if (splitStr.equals("sohu.com")) {
			login += "mail.sohu.com";
		}
		if (splitStr.equals("tom.com")) {
			login += "mail.tom.com";
		}
		if (splitStr.equals("vip.sina.com")) {
			login += "vip.sina.com";
		}
		if (splitStr.equals("sina.com.cn")
				|| splitStr.equals("sina.com")) {
			login += "mail.sina.com.cn";
		}
		if (splitStr.equals("tom.com")) {
			login += "mail.tom.com";
		}
		if (splitStr.equals("yahoo.com.cn")
				|| splitStr.equals("yahoo.cn")) {
			login += "mail.cn.yahoo.com";
		}
		if (splitStr.equals("tom.com")) {
			login += "mail.tom.com";
		}
		if (splitStr.equals("yeah.net")) {
			login += "www.yeah.net";
		}
		if (splitStr.equals("21cn.com")) {
			login += "mail.21cn.com";
		}
		if (splitStr.equals("hotmail.com")) {
			login += "www.hotmail.com";
		}
		if (splitStr.equals("sogou.com")) {
			login += "mail.sogou.com";
		}
		if (splitStr.equals("188.com")) {
			login += "www.188.com";
		}
		if (splitStr.equals("139.com")) {
			login += "mail.10086.cn";
		}
		if (splitStr.equals("189.cn")) {
			login += "webmail15.189.cn/webmail";
		}
		if (splitStr.equals("wo.com.cn")) {
			login += "mail.wo.com.cn/smsmail";
		}
		if (splitStr.equals("139.com")) {
			login += "mail.10086.cn";
		}
		return login;
	}
//	public static void main(String[] args) {
//		try {
//			createMail("yzhm007@163.com","")
//			<a href="http://localhost:8080/assetWeb/person/mailVerify.htm?user=hao123&time=1451292294006>请点击验证</a>
//			
//			sendMail();
//		} catch (AddressException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//	}
	
}
