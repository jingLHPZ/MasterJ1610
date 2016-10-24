package com.sxt.service.product.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.base.exception.ServiceException;
import com.sxt.base.utils.CalculatorHelper;
import com.sxt.base.utils.FormatHelper;
import com.sxt.enums.AccountTypeEnum;
import com.sxt.enums.BorrowInvestorStatusEnum;
import com.sxt.enums.BorrowPlanStatusEnum;
import com.sxt.enums.MessageTypeEnum;
import com.sxt.enums.ProductTypeEnum;
import com.sxt.enums.QuerterTypeEnum;
import com.sxt.enums.RepaymentStatusEnum;
import com.sxt.enums.RepaymentTypeEnum;
import com.sxt.enums.ReturnTypeEnum;
import com.sxt.enums.RewardUseStatusEnum;
import com.sxt.enums.TransferStatusEnum;
import com.sxt.enums.UserAwardTypeEnum;
import com.sxt.inter.IBorrowInvestor;
import com.sxt.inter.IBorrowPlan;
import com.sxt.inter.IMemberMoney;
import com.sxt.inter.IMemberMoneyDetail;
import com.sxt.inter.IMembers;
import com.sxt.inter.IRepaymentDetail;
import com.sxt.inter.IRewardRecord;
import com.sxt.inter.ISiProduct;
import com.sxt.inter.ISiProductDetail;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.inter.dto.MemberMoneyDto;
import com.sxt.models.BorrowInvestor;
import com.sxt.models.BorrowPlan;
import com.sxt.models.MemberMoney;
import com.sxt.models.MemberMoneyDetail;
import com.sxt.models.Members;
import com.sxt.models.RepaymentDetail;
import com.sxt.models.RewardRecord;
import com.sxt.models.SiProduct;
import com.sxt.models.SiProductDetail;
import com.sxt.service.LdContractService;
import com.sxt.service.LdMemberRewardService;
import com.sxt.service.LdParameterService;
import com.sxt.service.MessageService;
import com.sxt.service.ProductService;
import com.sxt.service.product.SiProductService;
import com.sxt.util.DateUtil;
import com.sxt.util.ModelConvertToVo;
@Service
public class SiProductServiceImpl implements SiProductService {
	private static Log logger = LogFactory.getLog(SiProductServiceImpl.class);
	@Autowired
	private ISiProduct iSiProduct;
	
	@Autowired
	private ISiProductDetail iSiProductDetail;
	
	@Autowired
	private IBorrowInvestor iBorrowInvestor;
	
	@Autowired
	private IMemberMoney iMemberMoney;
	
	@Autowired
	private IMembers iMembers;
	
	@Autowired
	private IMemberMoneyDetail iMemberMoneyDetail;
	
	@Autowired
	private IBorrowPlan  iBorrowPlan;
	
	@Autowired
	private IRepaymentDetail  iRepaymentDetail;
	
	@Autowired
	private LdParameterService  ldParameterService;
	
	@Autowired
	private IRewardRecord  iRewardRecord;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private LdMemberRewardService ldMemberRewardService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	LdContractService ldContractService;
	
	public SiProduct fQueryProById(String product_id) {
		SiProduct siProduct=iSiProduct.fQueryProById(product_id);
		List<BorrowInvestor> bilist= iBorrowInvestor.fQuerySiproByPid(product_id);
		if(bilist.size()>0){
			siProduct.setCaninvest(siProduct.getBorrowMoney().subtract(iBorrowInvestor.querySumMoney(product_id)));
		}
		siProduct=iSiProduct.fQueryProById(product_id);
		return siProduct;
	}
	
	public List<SiProduct> fQueryListSiProByUid(int borrow_uid) {
		return iSiProduct.fQueryListSiProByUid(borrow_uid);
	}

	
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public void  payProduct(String productId, BigDecimal investmoney, String systemtradeno, 
			LocalUserDto lud, String ip, HttpServletRequest request){
	}
	
	
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public void payProductByReward(String productId, BigDecimal investmoney, String systemtradeno, 
			RewardRecord rewardRecord, LocalUserDto lud, String ip, HttpServletRequest request){
	}
	
	/**
	 * 给借款人发送短信
	 * @param messageService
	 * @param product
	 */
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void sendMessageFullProduct(MessageService messageService,SiProduct product){
		Members borrowMember = iMembers.fQueryNameByUid(product.getBorrowUid());
		Map<String, Object> para = new HashMap<String, Object>();
		para.put("userName", borrowMember.getUserName());
		para.put("id", product.getProductId());
		messageService.sendMessage(borrowMember.getUserPhone(), MessageTypeEnum.FULL_SCALE, para, borrowMember.getUid().toString());
	}
	
	@Override
	public Integer fqueryCountbyCiProductId(String ci_product_id) {
		// TODO Auto-generated method stub
		return iSiProduct.fqueryCountbyCiProductId(ci_product_id);
	}
	
	public List<SiProduct> fquerySiProductbyCiProductId(Map<String,Object> param){
		return iSiProduct.fquerySiProductbyCiProductId(param);
	}
	
	public SiProduct getProductById(String productId){
		return iSiProduct.getProductById(productId);
	}
	public String querySiproductByProid(String productId){
		return iSiProduct.querySiproductByProid(productId);
	}

	@Override
	public void update(SiProduct product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByProductIdAndStatus(Map<String, Object> param) {
		// TODO Auto-generated method stub
		
	}
}
