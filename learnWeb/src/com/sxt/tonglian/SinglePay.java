package com.sxt.tonglian;

import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.sxt.base.utils.HttpClientUtil;
import com.sxt.tonglian.dto.SinglePayRequestDto;
import com.sxt.tonglian.dto.SinglePayResponseDto;
import com.sxt.util.DateUtil;

/**
 * 通联支付单笔代付
 * @author 
 * @date：2016年1月9日 上午11:00:43
 * 
 */
public class SinglePay {

	/**
	 * 单笔实时代付
	 * @return
	 * @throws Exception 
	 */
	public static SinglePayResponseDto pay(SinglePayRequestDto singlePay) throws Exception {
		//	组装报文
		String xmlStr = loadXml(singlePay);
		
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
	private static String loadXml(SinglePayRequestDto singlePay) {
		
		if (singlePay.getCustUserid() == null) {
			throw new RuntimeException("该用户不存在");
		}
		
		StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"GBK\"?><AIPG>");
		
		StringBuffer infoXml = new StringBuffer("<INFO>");
		infoXml.append("<TRX_CODE>100014</TRX_CODE>");
		infoXml.append("<VERSION>03</VERSION>");
		infoXml.append("<DATA_TYPE>2</DATA_TYPE>");
		infoXml.append("<LEVEL>9</LEVEL>");
		infoXml.append("<USER_NAME>" + TLConstants.TL_USER_NAME + "</USER_NAME>");
		infoXml.append("<USER_PASS>" + TLConstants.TL_USER_PASS + "</USER_PASS>");
		infoXml.append("<REQ_SN>" + singlePay.getReqSn() + "</REQ_SN>");
		infoXml.append("<SIGNED_MSG></SIGNED_MSG>");
		infoXml.append("</INFO>");
		
		
		StringBuffer transXml = new StringBuffer();
		transXml.append("<TRANS>");
		transXml.append("<BUSINESS_CODE>09400</BUSINESS_CODE>");
		transXml.append("<MERCHANT_ID>" + TLConstants.TL_BUSINESS_NO + "</MERCHANT_ID>");
		transXml.append("<SUBMIT_TIME>" + DateUtil.longDate(new Date()) + "</SUBMIT_TIME>");
		transXml.append("<E_USER_CODE></E_USER_CODE>");
		transXml.append("<VALIDATE></VALIDATE>");
		transXml.append("<CVV2></CVV2>");
		transXml.append("<BANK_CODE>" + singlePay.getBankCode() + "</BANK_CODE>");
		transXml.append("<ACCOUNT_TYPE>" + singlePay.getAccountType() + "</ACCOUNT_TYPE>");
		transXml.append("<ACCOUNT_NO>" + singlePay.getAccountNo() + "</ACCOUNT_NO>");
		transXml.append("<ACCOUNT_NAME>" + singlePay.getAccountName() + "</ACCOUNT_NAME>");
		transXml.append("<ACCOUNT_PROP>" + singlePay.getAccountProp() + "</ACCOUNT_PROP>");
		transXml.append("<AMOUNT>" + singlePay.getAmount() + "</AMOUNT>");
		transXml.append("<CURRENCY>CNY</CURRENCY>");
		transXml.append("<ID_TYPE>" + singlePay.getIdType() + "</ID_TYPE>");
		transXml.append("<ID>" + singlePay.getId() + "</ID>");
		transXml.append("<SETTACCT></SETTACCT>");
		transXml.append("<TEL></TEL>");
		transXml.append("<CUST_USERID>" + singlePay.getCustUserid() + "</CUST_USERID>");
		transXml.append("<SETTGROUPFLAG></SETTGROUPFLAG>");
		transXml.append("<SUMMARY>" + singlePay.getSummary() + "</SUMMARY>");
		transXml.append("<REMARK>" + singlePay.getRemark() + "</REMARK>");
		transXml.append("</TRANS>");
		
		xml.append(infoXml);
		xml.append(transXml);
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
	private static SinglePayResponseDto parseXml(String xml) throws DocumentException {
		
		//	string转xml
		SinglePayResponseDto dto = new SinglePayResponseDto();
		Document document = DocumentHelper.parseText(xml); 
		Element root = (Element) document.getRootElement();
		
		for (Iterator<Element> iterator = root.elementIterator(); iterator.hasNext();) {
            Element ele = (Element) iterator.next();
            if ("INFO".equals(ele.getName())) {
            	for (Iterator<Element> iterator2 = ele.elementIterator(); iterator2.hasNext();) {
                    Element childEle = (Element) iterator2.next();
                    if ("TRX_CODE".equals(childEle.getName())) {
                    	dto.setTrxCode(childEle.getTextTrim());
                    } else if ("VERSION".equals(childEle.getName())) {
                    	dto.setVersion(childEle.getTextTrim());
                    } else if ("DATA_TYPE".equals(childEle.getName())) {
                    	dto.setDateType(Integer.valueOf(childEle.getTextTrim()));
                    } else if ("REQ_SN".equals(childEle.getName())) {
                    	dto.setReqSn(childEle.getTextTrim());
                    } else if ("RET_CODE".equals(childEle.getName())) {
                    	dto.setRetCode(childEle.getTextTrim());
                    } else if ("ERR_MSG".equals(childEle.getName())) {
                    	dto.setErrMsg(childEle.getTextTrim());
                    }
        		}
            } else if ("TRANSRET".equals(ele.getName())) {
            	for (Iterator<Element> iterator2 = ele.elementIterator(); iterator2.hasNext();) {
                    Element childEle = (Element) iterator2.next();
                    if ("RET_CODE".equals(childEle.getName())) {
                    	dto.setRetCode2(childEle.getTextTrim());
                    } else if ("SETTLE_DAY".equals(childEle.getName())) {
                    	dto.setSettleDay(childEle.getTextTrim());
                    } else if ("ERR_MSG".equals(childEle.getName())) {
                    	dto.setErrMsg2(childEle.getTextTrim());
                    }
        		}
            }
		}
		return dto;
	}
	
	/**
	 * 生产流水号
	 * @param uid
	 * @return
	 */
	public static String makeSystemTraceNo(String uid) {
		int max=9999;
		int min=1000;
		Random random = new Random();
		int s = random.nextInt(max)%(max-min+1) + min;
		return String.valueOf(System.currentTimeMillis()).concat(String.valueOf(s)).concat(uid);
	}
	
}
