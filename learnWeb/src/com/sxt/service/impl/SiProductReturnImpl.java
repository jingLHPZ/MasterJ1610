package com.sxt.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.base.exception.ServiceException;
import com.sxt.enums.AccountTypeEnum;
import com.sxt.enums.BorrowInvestorStatusEnum;
import com.sxt.enums.BorrowPlanStatusEnum;
import com.sxt.enums.CiProductBorrowStatusEnum;
import com.sxt.enums.MessageTypeEnum;
import com.sxt.enums.ProductAccountEnum;
import com.sxt.enums.RepaymentStatusEnum;
import com.sxt.enums.ReturnTypeEnum;
import com.sxt.inter.dto.BorrowPlanDto;
import com.sxt.models.BorrowPlan;
import com.sxt.models.LdYingxiangProduct;
import com.sxt.models.MemberMoney;
import com.sxt.models.MemberMoneyDetail;
import com.sxt.models.Members;
import com.sxt.models.PeProduct;
import com.sxt.models.RepaymentDetail;
import com.sxt.models.SiProduct;
import com.sxt.service.BorrowInvestorService;
import com.sxt.service.BorrowPlanService;
import com.sxt.service.LdParameterService;
import com.sxt.service.MemberMoneyDetailService;
import com.sxt.service.MemberMoneyService;
import com.sxt.service.MemberService;
import com.sxt.service.MessageService;
import com.sxt.service.RepaymentDetailService;
import com.sxt.service.batch.ISiProductReturnService;
import com.sxt.service.product.PeProductService;
import com.sxt.service.product.SiProductService;
import com.sxt.service.product.YingXiangProductService;

@Service
public class SiProductReturnImpl implements ISiProductReturnService{
	
	private static Log logger = LogFactory.getLog(SiProductReturnImpl.class);
	
	@Autowired
	private LdParameterService ldParameterService;
	
	@Autowired
	private BorrowPlanService ldBorrowPlanService;
	
	@Autowired
	private RepaymentDetailService ldRepaymentDetailService;
	
	@Autowired
	private MemberMoneyService ldMemberMoneyService;
	
	@Autowired
	private MemberMoneyDetailService ldMemberMoneyDetailService;
	
	@Autowired
	SiProductService siProductService;
	
	@Autowired
	PeProductService peProductService;
	
	@Autowired
	YingXiangProductService yingXiangProductService;
	
	@Autowired
	private BorrowInvestorService ldBorrowInvestorService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MessageService messageService;
	
	/**
	 * 手动还款
	 */
	@Override
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void  handwork(String productId,Integer sortOrder) throws Exception{
		// TODO Auto-generated method stub
	}

}
