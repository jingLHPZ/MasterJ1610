package com.sxt.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * xml工具类
 * @author 
 * @date：2016年1月6日 下午1:53:21
 * 
 */
public class XmlUtil {
	
	/**
	 * 字符串转xml
	 * @param str
	 */
	public void str2Xml(String str) {
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(new ByteArrayInputStream(str.getBytes()));   
		    OutputFormat format = OutputFormat.createPrettyPrint();
		    format.setEncoding("GB2312");
		    XMLWriter writer = new XMLWriter(new FileWriter(new File("cctv.xml")),format);
		    writer.write(document);
		    writer.close();
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
	}

	public static Document read(String xmlFile) throws DocumentException{
		SAXReader reader = new SAXReader();
		return reader.read(XmlUtil.class.getResourceAsStream(xmlFile));
	}
	
	public static Document createDocument(){
		return DocumentHelper.createDocument();
	}
	
	public static void write(Document doc,String xmlFile) throws IOException{
		FileWriter fw = new FileWriter(xmlFile);
		OutputFormat xmlFormat = OutputFormat.createPrettyPrint();
		xmlFormat.setNewlines(true);
		xmlFormat.setEncoding("UTF-8");
		XMLWriter xmlWriter = new XMLWriter(fw, xmlFormat);
		xmlWriter.write(doc);
		xmlWriter.flush();
		xmlWriter.close();
	}
	
	public static void main(String[] args) {
		
		String str = "<?xml version=\"1.0\" encoding=\"GBK\"?><AIPG><INFO><TRX_CODE>100014</TRX_CODE><VERSION>03</VERSION><DATA_TYPE>2</DATA_TYPE><REQ_SN>145250751474682541000000145</REQ_SN><RET_CODE>0000</RET_CODE><ERR_MSG>处理成功</ERR_MSG></INFO><TRANSRET><RET_CODE>0000</RET_CODE><SETTLE_DAY>20160111</SETTLE_DAY><ERR_MSG>处理成功</ERR_MSG></TRANSRET></AIPG>";
	}
}
