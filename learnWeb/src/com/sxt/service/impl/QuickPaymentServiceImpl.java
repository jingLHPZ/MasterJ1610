package com.sxt.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.base.exception.ServiceException;
import com.sxt.enums.AccountTypeEnum;
import com.sxt.enums.PayStatusEnum;
import com.sxt.enums.PayWayEnum;
import com.sxt.enums.UserAwardTypeEnum;
import com.sxt.inter.ILdMcTransactionDetail;
import com.sxt.inter.IMemberInfo;
import com.sxt.inter.IMembers;
import com.sxt.inter.dto.MemberMoneyDto;
import com.sxt.models.LdMcTransactionDetail;
import com.sxt.models.MemberInfo;
import com.sxt.models.MemberMoneyDetail;
import com.sxt.models.MemberPay;
import com.sxt.models.Members;
import com.sxt.models.dto.QuickPaymentDto;
import com.sxt.models.thirdInteraction.TransactionResponseBase;
import com.sxt.models.thirdInteraction.TransactionResponseQP0001;
import com.sxt.models.thirdInteraction.TransactionResponseQP0002;
import com.sxt.models.thirdInteraction.TransactionResponseQP0003;
import com.sxt.models.thirdInteraction.TransactionResponseQP0004;
import com.sxt.page.util.ObjectUtils;
import com.sxt.service.LdMemberRewardService;
import com.sxt.service.MemberMoneyDetailService;
import com.sxt.service.MemberMoneyService;
import com.sxt.service.MemberPayService;
import com.sxt.service.QuickPaymentService;
import com.sxt.util.CoreConstant;
import com.sxt.util.CryptoUtils;
import com.sxt.util.DateUtil;
import com.sxt.util.Dom4jParseXmlUtil;
import com.sxt.util.Money;
import com.sxt.util.PayUtil;
import com.sxt.util.Util;

/**
 * 快捷支付
 * @author 
 * @date：2015年12月30日 下午4:37:58
 * 
 */
@Service
public class QuickPaymentServiceImpl implements QuickPaymentService {
	
	private static Logger logger = LoggerFactory.getLogger(QuickPaymentServiceImpl.class);
	
	@Autowired
    private MemberPayService memberPayService;
	@Autowired
    private ILdMcTransactionDetail ildMcTransactionDetail;
	@Autowired
	private MemberMoneyService memberMoneyService;
	@Autowired
	private MemberMoneyDetailService memberMoneyDetailService;
	@Autowired
	private IMemberInfo iMemberInfo;
	@Autowired
	private IMembers iMembers;
	@Autowired
	private LdMemberRewardService ldMemberRewardService;
	
	String clientDate = Util.getOrderNum();

	@Override
	public TransactionResponseQP0001 purchaseTransaction(
			LdMcTransactionDetail ldMcTransactionDetail,
			HttpServletRequest request) throws JDOMException, HttpException,
			IOException, DocumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionResponseQP0002 sendDynamicAuthentication(
			QuickPaymentDto quickPaymentDto) throws JDOMException,
			HttpException, IOException, DocumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionResponseQP0003 closeQuickPay(
			QuickPaymentDto quickPaymentDto) throws JDOMException, IOException,
			DocumentException {
		// TODO Auto-generated method stub
		return null;
	}
}
