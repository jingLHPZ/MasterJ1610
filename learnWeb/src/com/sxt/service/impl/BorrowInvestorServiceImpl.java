package com.sxt.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
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

import com.sxt.base.constant.Constant;
import com.sxt.base.exception.ServiceException;
import com.sxt.enums.AccountTypeEnum;
import com.sxt.enums.ProductTypeEnum;
import com.sxt.inter.IBorrowInvestor;
import com.sxt.inter.ICiProduct;
import com.sxt.inter.IEiProduct;
import com.sxt.inter.IMemberMoneyDetail;
import com.sxt.inter.IOffProductTransaction;
import com.sxt.inter.ISiProduct;
import com.sxt.inter.IStableProduct;
import com.sxt.inter.ISurplusProduct;
import com.sxt.inter.dto.AssignmentDebtDto;
import com.sxt.inter.dto.InvestRecordDto;
import com.sxt.models.BorrowInvestor;
import com.sxt.models.MemberMoney;
import com.sxt.models.MemberMoneyDetail;
import com.sxt.models.OffProductTransaction;
import com.sxt.models.SumMoney;
import com.sxt.models.dto.InvestRewardDto;
import com.sxt.service.Base64Encrypt;
import com.sxt.service.BorrowInvestorService;
import com.sxt.service.LdParameterService;
import com.sxt.service.MemberMoneyService;
import com.sxt.service.MemberService;
import com.sxt.util.SHAUtil;

@Service
public class BorrowInvestorServiceImpl implements BorrowInvestorService {
	@Autowired
	private IBorrowInvestor iBorrowInvestor;
	@Autowired
	private ICiProduct  iCiProduct;
	@Autowired
	private ISiProduct iSiProduct;
	@Autowired
	private IStableProduct  iStableProduct;
	@Autowired
	private ISurplusProduct iSurplusProduct;
	@Autowired
	private IEiProduct  iEiProduct; 
	@Autowired
	private Base64Encrypt base64Encrypt;
	@Autowired
	private MemberMoneyService memberMoneyService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private IMemberMoneyDetail iMemberMoneyDetail;
	@Autowired
	private LdParameterService ldParameterService;
	@Autowired
	private IOffProductTransaction iOffProductTransaction;

	private static Log logger = LogFactory.getLog(BorrowInvestorServiceImpl.class);
	 
	public BigDecimal querySumMoney(String product_id) {
		BigDecimal sumMoney = iBorrowInvestor.querySumMoney(product_id);
		if(sumMoney != null){
			return sumMoney;
		}
		return BigDecimal.ZERO;
	}
	public BigDecimal fQueryBypiduid(String product_id, int uid) {
		Map<String,Object> map=new HashMap<String, Object>();
		if(product_id!=null){
			map.put("product_id", product_id);
		}
		if(uid!=0){
			map.put("uid", uid);
		}
		return	iBorrowInvestor.fQueryBypiduid(map);
	}
	
	public BorrowInvestor fQueryInvestorByBid(int borrow_uid) {
		return iBorrowInvestor.fQueryInvestorByBid(borrow_uid);
	}
	public Map<String, Object> fQueryInvestorByIid(int investor_uid) {
		return iBorrowInvestor.fQueryInvestorByIid(investor_uid);
	}

	public BorrowInvestor fQueryNullByBid(String product_id) {
		return iBorrowInvestor.fQueryNullByBid(product_id);
	}
	
	public List<SumMoney> fQueryDebt(int investor_uid) {
		return null;
	}
	public List<BorrowInvestor> fQuerySiproByPid(String product_id) {
		return iBorrowInvestor.fQuerySiproByPid(product_id);
	}
	public List<BorrowInvestor> fQuerySiproPageByPid(Map<String,Object> param) {
		return iBorrowInvestor.fQuerySiproPageByPid(param);
	}
	public Integer fQuerySiproPageCountByPid(Map<String,Object> param){
		return iBorrowInvestor.fQuerySiproPageCountByPid(param);
	}
	public void fInsertInvestRecord(BorrowInvestor borrowinvestor) {
		iBorrowInvestor.fInsertInvestRecord(borrowinvestor);
	}
	public List<BorrowInvestor> fQueryisinvest(int invest_uid) {
		return iBorrowInvestor.fQueryisinvest(invest_uid);
	}
	
	public Integer fqueryBorrowInvestorCount(Map<String,Object> param){
		return iBorrowInvestor.fqueryBorrowInvestorCount(param);
	}
	public Integer fqueryInvestorCountByProductId(String product_id){
		return iBorrowInvestor.fqueryInvestorCountByProductId(product_id);
	}
	
	public List<InvestRecordDto> fqueryInvestRecodeByMap(Map<String,Object> param){
		return iBorrowInvestor.fqueryInvestRecodeByMap(param);
	}
	
	public Integer fqueryInvestRecodeCountByMap(Map<String,Object> param){
		return iBorrowInvestor.fqueryInvestRecodeCountByMap(param);
	}
	public int fquerycountinvestuid(String proid)
	{
		return iBorrowInvestor.fquerycountinvestuid(proid);
	}
	
	public List<AssignmentDebtDto> queryAssignmentDebt(Map<String,Object> param) {
		return iBorrowInvestor.queryAssignmentDebt(param);
	}
	
	public Integer queryAssignmentDebtCount(Map<String,Object> param) {
		return iBorrowInvestor.queryAssignmentDebtCount(param);
	}
	
	public String checkPayPass(String payPass,String checkPass) throws NoSuchAlgorithmException, UnsupportedEncodingException { 
		if(checkPass != null && !"".equals(checkPass)) {
			checkPass = SHAUtil.encryptSHA1(base64Encrypt.encrypt(checkPass));// 加密后的交易密码
			if(checkPass.equals(payPass)) {
				return "success";
			}
		}
		return "fail";
	}
	
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void updateDebtStatusByTraceNo(Map<String,Object> param) {
		
		iBorrowInvestor.updateDebtStatusByTraceNo(param);
	}
	
	public BigDecimal queryRestMoneyByTraceNo(String param) {
		return iBorrowInvestor.queryRestMoneyByTraceNo(param);
	}
	
	public AssignmentDebtDto queryProductInfo(String param) {
		return iBorrowInvestor.queryProductInfo(param);
	}

	
	public BigDecimal getAssignChargesRate() {
		BigDecimal chargesRate = new BigDecimal(ldParameterService.getParameterByName("assignChargesRate","0.005").getValue(),new MathContext(4, RoundingMode.HALF_UP));
		return chargesRate;
	}
	
	public BorrowInvestor queryInvestorInfo(Integer param) {
		return iBorrowInvestor.queryInvestorInfo(param);
	}
	
	public void updateOriginAssign(Map<String,Object> param) {
		iBorrowInvestor.updateOriginAssign(param);
	}


	public BigDecimal queryExperienceGoldByProid(Map<String, Object> param)
	{
		return iBorrowInvestor.queryExperienceGoldByProid(param);
	}
	
	/**
	 * 通过产品id更新投资记录状态
	 * @param para
	 */
	public void updateStatusByProductId(Map<String,Object> para){
		iBorrowInvestor.updateStatusByProductId(para);
	}
	
	/**
	 * 首页查询转让中的债权记录
	 */
	public List<AssignmentDebtDto> queryAssigningDebt(int startRow,int pageSize) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("pageSize", pageSize);
		List<AssignmentDebtDto> list = iBorrowInvestor.queryToSaleDebt(map);
		if(list != null && list.size() > 0) {
			for(AssignmentDebtDto dto:list) {
				//获取转让时的剩余待收
				Date updateTime = dto.getUpdateTime();
				BigDecimal debtPrice = dto.getDebtPrice();
				String systemTraceNo = dto.getSystemTraceNo();
				Float subscriptionRate = calcSubscriptionRate(systemTraceNo,updateTime,debtPrice);
				dto.setSubscriptionRate(subscriptionRate);
			}
		}
		return list;
	}
	
	public List<AssignmentDebtDto> queryDeadLine(int para) {
		return iBorrowInvestor.queryDeadLine(para);
	}
	
	public List<AssignmentDebtDto> queryToSaleDebt(Map<String,Object> param) {
		return iBorrowInvestor.queryToSaleDebt(param);
	}
	
	public Integer queryUidByTraceNo(String param) {
		return iBorrowInvestor.queryUidByTraceNo(param);
	}
	
	public AssignmentDebtDto checkAssignable(String param) {
		return iBorrowInvestor.checkAssignable(param);
	}
	public AssignmentDebtDto payDetailByTraceNo(String param) {
		return iBorrowInvestor.payDetailByTraceNo(param);
	}

	public AssignmentDebtDto queryDebtPrice(Map<String, Object> param) {
		return iBorrowInvestor.queryDebtPrice(param);
	}
	
	public Integer queryAssignCount(Map<String,Object> param) {
		return iBorrowInvestor.queryAssignCount(param);
	}
	
	public Float calcSubscriptionRate(String systemTraceNo,Date updateTime,BigDecimal debtPrice) {
		AssignmentDebtDto dto = iBorrowInvestor.queryProductInfo(systemTraceNo);
		if(dto == null) {
			return null;
		}
		Integer restDays = dto.getRestDays();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("systemTraceNo", systemTraceNo);
		map.put("repaymentTime", updateTime);
		BigDecimal collectMoney = iBorrowInvestor.getCollectMoneyByTraceNo(map);
		if(collectMoney == null || debtPrice == null || restDays == null) {
			return null;
		}
		return (collectMoney.subtract(debtPrice)).divide(debtPrice,4,RoundingMode.HALF_UP ).divide(new BigDecimal(restDays),4,RoundingMode.HALF_UP).multiply(new BigDecimal(365)).floatValue();
	}
	
	public Float calcRewardRate(Integer restDays,Date updateTime,BigDecimal debtPrice,String rewardTraceNo,Integer returnType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("systemTraceNo", rewardTraceNo);
		map.put("repaymentTime", updateTime);
		map.put("returnType", returnType);
		BigDecimal collectMoney = iBorrowInvestor.getCollectMoneyByTraceNo(map);
		if(collectMoney == null || debtPrice == null || restDays == null) {
			return null;
		}
		return (collectMoney.divide(debtPrice,4,RoundingMode.HALF_UP)).divide(new BigDecimal(restDays),4,RoundingMode.HALF_UP ).multiply(new BigDecimal(365)).floatValue();
	}

	public Map<String, Object> getProductInfoById(String param) {
		return iBorrowInvestor.getProductInfoById(param);
	}
	
	@Override
	public List<BorrowInvestor> queryBorrowInvest(Map<String, Object> param) {
		return iBorrowInvestor.queryBorrowInvest(param);
	}
	@Override
	public InvestRecordDto getExperGoldByNoAndId(Map<String, Object> param) {
		return iBorrowInvestor.getExperGoldByNoAndId(param);
	}
	@Override
	public InvestRecordDto getProductById(String param) {
		return iBorrowInvestor.getProductById(param);
	}
	
	@Override
	public Map<String, Object> queryInvestMoneyByPhone(Map<String, Object> param) {
		return iBorrowInvestor.queryInvestMoneyByPhone(param);
	}
	
	@Override
	public int queryCountInvestorByProductId(String productId){
		return iBorrowInvestor.queryCountInvestorByProductId(productId);
	}
	@Override
	public List<InvestRecordDto> getSiAndNewProductInfo(Map<String, Object> param) {
		return iBorrowInvestor.getSiAndNewProductInfo(param);
	}
	@Override
	public Integer getSiAndNewProductInfoCount(Map<String, Object> param) {
		return iBorrowInvestor.getSiAndNewProductInfoCount(param);
	}
	@Override
	public AssignmentDebtDto getCapAndInterByTraceNo(Map<String, Object> param) {
		return iBorrowInvestor.getCapAndInterByTraceNo(param);
	}
	@Override
	public List<InvestRewardDto> queryInvestRewardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return iBorrowInvestor.queryInvestRewardList(map);
	}
	@Override
	public List<InvestRecordDto> fqueryExInvestRecodeByMap(Map<String, Object> param) {
		return iBorrowInvestor.fqueryExInvestRecodeByMap(param);
	}
	@Override
	public List<InvestRecordDto> fqueryNewInvestRecodeByMap(Map<String, Object> param) {
		return iBorrowInvestor.fqueryNewInvestRecodeByMap(param);
	}
	@Override
	public Map<String, Object> queryInvestMoneySum(Map<String, Object> param) {
		return iBorrowInvestor.queryInvestMoneySum(param);
	}
	@Override
	public List<InvestRecordDto> fqueryYxInvestRecodeByMap(
			Map<String, Object> param) {
		return iBorrowInvestor.fqueryYxInvestRecodeByMap(param);
	}
	@Override
	public List<OffProductTransaction> queryOffProductTransaction(
			Map<String, Object> param) {
		return iOffProductTransaction.queryOffProductTransaction(param);
	}
	@Override
	public Integer queryOffProductTransactionCount(Map<String, Object> param) {
		return iOffProductTransaction.queryOffProductTransactionCount(param);
	}
	@Override
	public Integer queryBorrowInvestByUid(Integer param) {
		return iBorrowInvestor.queryBorrowInvestByUid(param);
	}
	@Override
	public void insertAssignmentDebt(BorrowInvestor param) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertAssignMemberMoneyDetail(MemberMoney memberMoney,
			BorrowInvestor borrowInvestor, String ip, Integer localUid,
			Integer platUid) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertInvestMemberMoneyDetail(MemberMoney memberMoney,
			BorrowInvestor borrowInvestor, String ip) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertPlatMemberMoneyDetail(MemberMoney memberMoney,
			BorrowInvestor borrowInvestor, String ip) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void assignmentDebtSuccess(String systemTraceNo, Integer uid,
			String ip, Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
 }
