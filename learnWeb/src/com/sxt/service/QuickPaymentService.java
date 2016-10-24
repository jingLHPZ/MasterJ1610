package com.sxt.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpException;
import org.dom4j.DocumentException;
import org.jdom.JDOMException;

import com.sxt.models.LdMcTransactionDetail;
import com.sxt.models.dto.QuickPaymentDto;
import com.sxt.models.thirdInteraction.TransactionResponseQP0001;
import com.sxt.models.thirdInteraction.TransactionResponseQP0002;
import com.sxt.models.thirdInteraction.TransactionResponseQP0003;

/**
 * 快捷支付
 * @author 
 * @date：2015年12月30日 下午4:36:59
 * 
 */
public interface QuickPaymentService {

	/**
	 * 快捷支付消费交易
	 */
	public TransactionResponseQP0001 purchaseTransaction(LdMcTransactionDetail ldMcTransactionDetail,
			HttpServletRequest request) throws JDOMException, HttpException, IOException, 
			DocumentException;
	
	/**
	 * 快捷支付动态鉴权
	 */
	public TransactionResponseQP0002 sendDynamicAuthentication(QuickPaymentDto quickPaymentDto) 
    		throws JDOMException, HttpException, IOException, DocumentException;
	
	/**
	 * 关闭快捷支付
	 */
	public TransactionResponseQP0003 closeQuickPay(QuickPaymentDto quickPaymentDto) throws JDOMException, IOException, DocumentException;
}
