package com.sxt.service.product.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.enums.MessageTypeEnum;
import com.sxt.inter.IBorrowInvestor;
import com.sxt.inter.IBorrowPlan;
import com.sxt.inter.IMemberMoney;
import com.sxt.inter.IMemberMoneyDetail;
import com.sxt.inter.IMembers;
import com.sxt.inter.IPeProduct;
import com.sxt.inter.IPeProductDetail;
import com.sxt.inter.IRepaymentDetail;
import com.sxt.inter.IRewardRecord;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.models.BorrowInvestor;
import com.sxt.models.Members;
import com.sxt.models.PeProduct;
import com.sxt.models.RewardRecord;
import com.sxt.service.LdContractService;
import com.sxt.service.LdMemberRewardService;
import com.sxt.service.LdParameterService;
import com.sxt.service.MessageService;
import com.sxt.service.ProductService;
import com.sxt.service.product.PeProductService;
@Service
public class PeProductServiceImpl implements PeProductService {
	private static Log logger = LogFactory.getLog(PeProductServiceImpl.class);
	@Autowired
	private IPeProduct iPeProduct;
	
	@Autowired
	private IPeProductDetail iPeProductDetail;
	
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
	
	public PeProduct fQueryProById(String product_id) {
		PeProduct siProduct=iPeProduct.fQueryProById(product_id);
		List<BorrowInvestor> bilist= iBorrowInvestor.fQuerySiproByPid(product_id);
		if(bilist.size()>0){
			siProduct.setCaninvest(siProduct.getBorrowMoney().subtract(iBorrowInvestor.querySumMoney(product_id)));
		}
		siProduct=iPeProduct.fQueryProById(product_id);
		return siProduct;
	}
	
	public List<PeProduct> fQueryListSiProByUid(int borrow_uid) {
		return iPeProduct.fQueryListSiProByUid(borrow_uid);
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
	public void sendMessageFullProduct(MessageService messageService,PeProduct product){
		Members borrowMember = iMembers.fQueryNameByUid(product.getBorrowUid());
		Map<String, Object> para = new HashMap<String, Object>();
		para.put("userName", borrowMember.getUserName());
		para.put("id", product.getProductId());
		messageService.sendMessage(borrowMember.getUserPhone(), MessageTypeEnum.FULL_SCALE, para, borrowMember.getUid().toString());
	}
	
	@Override
	public Integer fqueryCountbyCiProductId(String ci_product_id) {
		// TODO Auto-generated method stub
		return iPeProduct.fqueryCountbyCiProductId(ci_product_id);
	}
	
	public List<PeProduct> fqueryPeProductbyCiProductId(Map<String,Object> param){
		return iPeProduct.fqueryPeProductbyCiProductId(param);
	}
	
	public PeProduct getProductById(String productId){
		return iPeProduct.getProductById(productId);
	}
	public String querySiproductByProid(String productId){
		return iPeProduct.querySiproductByProid(productId);
	}

	@Override
	public void update(PeProduct product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByProductIdAndStatus(Map<String, Object> param) {
		// TODO Auto-generated method stub
		
	}
}
