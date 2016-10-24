package com.sxt.tonglian;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.sxt.base.utils.HttpClientUtil;
import com.sxt.tonglian.dto.PayQueryRequestDto;
import com.sxt.tonglian.dto.PayQueryResponseDto;
import com.sxt.util.StringUtil;

/**
 * 单笔交易结果查询
 * @author 
 * @date：2016年1月19日 上午10:20:07
 * 
 */
public class PayQuery {

	public static List<PayQueryResponseDto> payQuery(PayQueryRequestDto dto) throws Exception {
		
		//	组装报文
		String xmlStr = loadXml(dto);
		
		//	加密报文
		String xml = singlePaySignature(xmlStr);
		
		//	请求接口
		String result = HttpClientUtil.httpsPost(TLConstants.TL_URL, xml);
		
		//	验签
		if (verify(result)) {
			return parseXml(result);
		} else {
			return null;
		}
	}
	
	/**
	 * 组装xml报文
	 * @param singlePay
	 * @return
	 */
	private static String loadXml(PayQueryRequestDto dto) {
		
		
		StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"GBK\"?><AIPG>");
		
		StringBuffer infoXml = new StringBuffer("<INFO>");
		infoXml.append("<TRX_CODE>200004</TRX_CODE>");
		infoXml.append("<VERSION>03</VERSION>");
		infoXml.append("<DATA_TYPE>2</DATA_TYPE>");
		infoXml.append("<REQ_SN></REQ_SN>");
		infoXml.append("<USER_NAME>" + TLConstants.TL_USER_NAME + "</USER_NAME>");
		infoXml.append("<USER_PASS>" + TLConstants.TL_USER_PASS + "</USER_PASS>");
		infoXml.append("<SIGNED_MSG></SIGNED_MSG>");
		infoXml.append("</INFO>");
		
		
		StringBuffer qtransreqXml = new StringBuffer();
		qtransreqXml.append("<QTRANSREQ>");
		qtransreqXml.append("<MERCHANT_ID>200004</MERCHANT_ID>");
		qtransreqXml.append("<QUERY_SN>" + dto.getReqSn() + "</QUERY_SN>");
		qtransreqXml.append("<STATUS>2</STATUS>");
		qtransreqXml.append("<TYPE>1</TYPE>");
		qtransreqXml.append("<START_DAY></START_DAY>");
		qtransreqXml.append("<END_DAY></END_DAY>");
		qtransreqXml.append("</QTRANSREQ>");
		
		xml.append(infoXml);
		xml.append(qtransreqXml);
		xml.append("</AIPG>");
		return xml.toString();
	}
	
	/**
	 * 给xml报文签名
	 * @param xml
	 * @return
	 * @throws Exception 
	 */
	private static String singlePaySignature(String xml) throws Exception {
		
		//	加密信息
		String info = null;
		info = xml.replace("<SIGNED_MSG></SIGNED_MSG>", "");
		String encryptInfo = SignatureUtil.SignMsg(info);
		
		//	返回加了密的报文xml
		return xml.replace("<SIGNED_MSG></SIGNED_MSG>", "<SIGNED_MSG>" + encryptInfo + "</SIGNED_MSG>");
	}
	
	/**
	 * 验签返回结果
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	private static boolean verify(String xml) throws Exception {
		int startIndex = xml.indexOf("<SIGNED_MSG>");
		int endIndex = xml.indexOf("</SIGNED_MSG>");
		
		//	密文
		String ciphertext = xml.substring(startIndex + 12, endIndex);
		//	明文
		String plaintext = xml.substring(0, startIndex) + xml.substring(endIndex + 13, xml.length());
		return SignatureUtil.VerifyMsg(ciphertext, plaintext);
	}
	
	/**
	 * 解析xml，返回响应数据
	 * @param xml
	 * @return
	 * @throws DocumentException
	 */
	@SuppressWarnings("unchecked")
	private static List<PayQueryResponseDto> parseXml(String xml) throws DocumentException {
		
		//	string转xml
		Document document = DocumentHelper.parseText(xml);
		Element root = (Element) document.getRootElement();
		
		Integer dateType = 2;
		String trxCode = "", version = "", reqSn = "", retCode = "", errMsg = "";
		
		List<PayQueryResponseDto> payQueryList = new ArrayList<PayQueryResponseDto>();
		
		for (Iterator<Element> iterator = root.elementIterator(); iterator.hasNext();) {
            Element ele = (Element) iterator.next();
            if ("INFO".equals(ele.getName())) {
            	for (Iterator<Element> iterator2 = ele.elementIterator(); iterator2.hasNext();) {
                    Element childEle = (Element) iterator2.next();
                    if ("TRX_CODE".equals(childEle.getName())) {
                    	trxCode = childEle.getTextTrim();
                    } else if ("VERSION".equals(childEle.getName())) {
                    	version = childEle.getTextTrim();
                    } else if ("DATA_TYPE".equals(childEle.getName())) {
                    	dateType = Integer.valueOf(childEle.getTextTrim());
                    } else if ("REQ_SN".equals(childEle.getName())) {
                    	reqSn = childEle.getTextTrim();
                    } else if ("RET_CODE".equals(childEle.getName())) {
                    	retCode = childEle.getTextTrim();
                    } else if ("ERR_MSG".equals(childEle.getName())) {
                    	errMsg = childEle.getTextTrim();
                    }
        		}
            } else if ("QTRANSRSP".equals(ele.getName())) {
            	for (Iterator<Element> iterator2 = ele.elementIterator(); iterator2.hasNext();) {
                    Element childEle = (Element) iterator2.next();
                    
                    if ("QTDETAIL".equals(childEle.getName())) {
                    	
                    	PayQueryResponseDto dto = new PayQueryResponseDto();
                    	dto.setTrxCode(trxCode); dto.setVersion(version);
                    	dto.setDateType(dateType); dto.setReqSn(reqSn);
                    	dto.setRetCode(retCode); dto.setErrMsg(errMsg);
                    	
                    	for (Iterator<Element> iterator3 = childEle.elementIterator(); iterator3.hasNext();) {
                            Element childEle2 = (Element) iterator3.next();
                            
                            if ("BATCHID".equals(childEle2.getName())) {
                            	dto.setBatchId(childEle2.getTextTrim());
                            } else if ("SN".equals(childEle2.getName())) {
                            	dto.setSn(childEle2.getTextTrim());
                            } else if ("TRXDIR".equals(childEle2.getName())) {
                            	dto.setTrxdir(childEle2.getTextTrim());
                            } else if ("SETTDAY".equals(childEle2.getName())) {
                            	dto.setSettday(childEle2.getTextTrim());
                            } else if ("FINTIME".equals(childEle2.getName())) {
                            	dto.setFintime(childEle2.getTextTrim());
                            } else if ("SUBMITTIME".equals(childEle2.getName())) {
                            	dto.setSubmitTime(childEle2.getTextTrim());
                            } else if ("ACCOUNT_NO".equals(childEle2.getName())) {
                            	dto.setAccountNo(childEle2.getTextTrim());
                            } else if ("ACCOUNT_NAME".equals(childEle2.getName())) {
                            	dto.setAccountName(childEle2.getTextTrim());
                            } else if ("AMOUNT".equals(childEle2.getName())) {
                            	dto.setAmount(StringUtil.isEmpty(childEle2.getTextTrim()) ? 0l : 
                    				Long.valueOf(childEle2.getTextTrim()));
                            } else if ("CUST_USERID".equals(childEle2.getName())) {
                            	dto.setCustUserId(childEle2.getTextTrim());
                            } else if ("REMARK".equals(childEle2.getName())) {
                            	dto.setRemark(childEle2.getTextTrim());
                            } else if ("RET_CODE".equals(childEle2.getName())) {
                            	dto.setRetCode2(childEle2.getTextTrim());
                            } else if ("ERR_MSG".equals(childEle2.getName())) {
                            	dto.setErrMsg2(childEle2.getTextTrim());
                            }
                    	}
                    	payQueryList.add(dto);
                    }
        		}
            }
		}
		
		if (payQueryList.size() == 0) {
			if (StringUtil.isNotEmpty(retCode)) {
				PayQueryResponseDto dto = new PayQueryResponseDto();
				dto.setTrxCode(trxCode); dto.setVersion(version);
				dto.setDateType(dateType); dto.setReqSn(reqSn);
				dto.setRetCode(retCode); dto.setErrMsg(errMsg);
				payQueryList.add(dto);
				return payQueryList;
			} else {
				return null;
			}
		} else {
			return payQueryList;
		}
	}
	
	/**
	 * 通联代码结果判断
	 * @param code
	 * @return
	 */
	public static String codeConvertResult(String code) {
		
		if (StringUtil.isEmpty(code)) {
			return null;
		}
		
		if ("0000".equals(code) || "4000".equals(code)) {
			return "success";
		} else if ("2000".equals(code) || "0003".equals(code) 
				|| "2001".equals(code) || "2003".equals(code) 
				|| "2005".equals(code) || "2007".equals(code) 
				|| "2008".equals(code) || "0014".equals(code)) {
			return "process";
		} else {
			return "fail";
		}
	}
	
	public static void main(String[] args) throws Exception {
		PayQueryRequestDto dto = new PayQueryRequestDto();
		dto.setReqSn("145854305601297941000000380");
		List<PayQueryResponseDto> list = payQuery(dto);
		System.out.println(list.size());
	}
}
