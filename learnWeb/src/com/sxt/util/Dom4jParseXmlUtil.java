package com.sxt.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.sxt.models.thirdInteraction.TransactionResponseCardInfo;
public class Dom4jParseXmlUtil {

	 public static void main(String[] args) throws Exception {
	  String xml ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
			  "<message>"+
						  "<head>"+
			        "<version>01</version>"+
			        "<msgType>0002</msgType>"+
			        "<chanId>99</chanId>"+
			        "<merchantNo>1173</merchantNo>"+
			        "<clientDate>20151102165253</clientDate>"+
			        "<serverDate>20151102163930</serverDate>"+
			        "<tranFlow>1173201511021652595292343309</tranFlow>"+
			        "<tranCode>QP0004</tranCode>"+
			        "<respCode>EMB0000022</respCode>"+
			        "<respMsg>客户号不存在</respMsg>"+
			    "</head>"+
			    "<body></body>"+
			"</message>";
	  Map<String, Object> map = doXMLParse(xml);
	  System.out.println(map);
	 }
	 
	 public static Map<String, Object> doXMLParse(String xml) throws DocumentException{
		 Map<String,Object> returnMap = new HashMap<String, Object>();
	  	 Document doc = null;
	 	         
	    doc = DocumentHelper.parseText(xml); // 将字符串转为XML
	    Element rootElt = doc.getRootElement(); // 获取根节点
	    System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称
	    Iterator iter = rootElt.elementIterator("head"); // 获取根节点下的子节点head    
	    while (iter.hasNext()) {	            	
	        Element recordEle = (Element) iter.next();
	        String version = recordEle.elementTextTrim("version");
	        String msgType = recordEle.elementTextTrim("msgType");
	        String tranCode = recordEle.elementTextTrim("tranCode");
	        String respCode = recordEle.elementTextTrim("respCode");
	        String respMsg = recordEle.elementTextTrim("respMsg");	                     
	        returnMap.put("version", version);
	        returnMap.put("msgType", msgType);
	        returnMap.put("tranCode", tranCode);
	        returnMap.put("respCode", respCode);
	        returnMap.put("respMsg", respMsg);
	                
	    }
	    Iterator iterss = rootElt.elementIterator("body"); ///获取根节点下的子节点body	        
	        while (iterss.hasNext()) {
	          Element recordEless = (Element) iterss.next();
	          String custId = recordEless.elementTextTrim("custId"); // 拿到body节点下的子节点result值
	          String cardNum = recordEless.elementTextTrim("cardNum");
	          returnMap.put("custId", custId);
	          returnMap.put("cardNum", cardNum);
	          Iterator itersElIterator = recordEless.elementIterator("cardInfos"); // 获取子节点body下的子节点cardInfos
	          // 遍历body节点下的list节点
	          Set<TransactionResponseCardInfo> setTransactionResponseCardInfo = new HashSet<TransactionResponseCardInfo>();
	          while (itersElIterator.hasNext()) {	                	
	            Element itemEle = (Element) itersElIterator.next();
	            Iterator row = itemEle.elementIterator("cardInfo");
	 
	            while(row.hasNext()){
	              TransactionResponseCardInfo transactionResponseCardInfo  = new TransactionResponseCardInfo();
	              Element tableItem = (Element) row.next();
	              String storableCardNo = tableItem.elementTextTrim("storableCardNo"); 
	              String bankNo = tableItem.elementTextTrim("bankNo");
	              String cardType = tableItem.elementTextTrim("cardType");
	              String phoneNo = tableItem.elementTextTrim("phoneNo");
	              transactionResponseCardInfo.setStorableCardNo(storableCardNo);
	              transactionResponseCardInfo.setBankNo(bankNo);
	              transactionResponseCardInfo.setCardType(cardType);
	              transactionResponseCardInfo.setCardType(cardType);
	              transactionResponseCardInfo.setPhoneNo(phoneNo);
	              setTransactionResponseCardInfo.add(transactionResponseCardInfo);
	              	                   
	            }	                    
	          }
	          returnMap.put("setTransactionResponseCardInfo", setTransactionResponseCardInfo);	
	        }
	     return returnMap;
	 }
}