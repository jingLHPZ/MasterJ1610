package com.sxt.service.product.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.enums.BorrowInvestorStatusEnum;
import com.sxt.enums.MessageTypeEnum;
import com.sxt.inter.IBorrowInvestor;
import com.sxt.inter.IBorrowPlan;
import com.sxt.inter.ICiProduct;
import com.sxt.inter.ICiProductDetail;
import com.sxt.inter.IMemberMoney;
import com.sxt.inter.IMemberMoneyDetail;
import com.sxt.inter.IMembers;
import com.sxt.inter.IRepaymentDetail;
import com.sxt.inter.IRewardRecord;
import com.sxt.inter.ISiProduct;
import com.sxt.inter.dto.IndexProductDto;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.models.CiProduct;
import com.sxt.models.CiProductDetail;
import com.sxt.models.Members;
import com.sxt.models.RewardRecord;
import com.sxt.models.SiProduct;
import com.sxt.service.LdContractService;
import com.sxt.service.LdParameterService;
import com.sxt.service.MessageService;
import com.sxt.service.product.CiProductService;
@Service
public class CiProductServiceImpl implements CiProductService {
	
	private static Log logger = LogFactory.getLog(CiProductServiceImpl.class);
	@Autowired
	private ICiProduct iCiProduct;
	@Autowired
	private ICiProductDetail iCiProductDetail;
	
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
	private ISiProduct iSiProduct;
	@Autowired
	private MessageService messageService;
	@Autowired
	LdContractService ldContractService;
	
	@Override
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void payProduct(String productId, BigDecimal investmoney, String systemtradeno, LocalUserDto lud, String ip){
	}
	
	

	/**
	 * update borrowInvestor status 1
	 * @param productId
	 */
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void updateBorrowInvestorStatus(String productId){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("status",BorrowInvestorStatusEnum.WAIT.getCode());
		param.put("productId", productId);
		iBorrowInvestor.updateStatusByProductId(param);	
	}
	
	
	@Override
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void payProductByReward(String productId, BigDecimal investmoney, String systemtradeno, RewardRecord rewardRecord, LocalUserDto lud, String ip){
	}
	/**
	 * 处理公司发放的红包，加息券
	 * @param product
	 */
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void payCommonFee(CiProduct product,CiProductDetail productdetail){
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
	/**
	 * 给借款人发送短信
	 * @param messageService
	 * @param product
	 */
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void sendMessageFullProduct(MessageService messageService,CiProduct product){
		Members borrowMember = iMembers.fQueryNameByUid(product.getBorrowUid());
		Map<String, Object> para = new HashMap<String, Object>();
		para.put("userName", borrowMember.getUserName());
		para.put("id", product.getProductId());
		messageService.sendMessage(borrowMember.getUserPhone(), MessageTypeEnum.FULL_SCALE, para, borrowMember.getUid().toString());
	}
	
	
	public List<CiProduct> fQueryAllPro() {
		return	iCiProduct.fQueryAllPro();
	}
	public CiProduct fQueryProById(String product_id) {
		return	iCiProduct.fQueryProById(product_id);
	}
	public CiProduct fQueryCiProByUid(int borrow_uid) {
		return iCiProduct.fQueryCiProByUid(borrow_uid);
	}
	
	public List<String> fqueryProductIds(){
		return iCiProduct.fqueryProductIds();
	}

	public List<CiProduct> fqueryalltype(){
		return iCiProduct.fqueryalltype();
	}
	public List<IndexProductDto> fqueryAllProduct(Map<String,Object> param){
		return iCiProduct.fqueryAllProduct(param);
	}

	public List<CiProduct> queryCiproductByMap(Map<String,Object> param){
		return iCiProduct.queryCiproductByMap(param);
	}
	public Integer queryCiproductCount(){
		return iCiProduct.queryCiproductCount();
	}
	public List<IndexProductDto> queryAllCiProduct(){
		return iCiProduct.queryAllCiProduct();
	}
	public String queryCiproductByProid(String productId){
		return iCiProduct.queryCiproductByProid(productId);
	}
	public IndexProductDto queryHotProduct(){
		return iCiProduct.queryHotProduct();
	}
	
	public Integer queryQuestionByUid(Integer uid){
		return iCiProduct.queryQuestionByUid(uid);
	}
	public IndexProductDto queryQuestionDateByUid(Integer uid){
		return iCiProduct.queryQuestionDateByUid(uid);
	}
	public List<IndexProductDto> queryIndexProduct(){
		return iCiProduct.queryIndexProduct();
	}
	public String queryRiskTipBook(String productId){
		return iCiProduct.queryRiskTipBook(productId);
	}
	public Integer queryCountRisk(Map<String,Object> param){
		return iCiProduct.queryCountRisk(param);
	}
	public IndexProductDto queryRiskDate(Map<String,Object> param){
		return iCiProduct.queryRiskDate(param);
	}
	
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void insertRisk(Map<String,Object> param){
		iCiProduct.insertRisk(param);
	}
}
