package com.sxt.service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sxt.inter.dto.AssignmentDebtDto;
import com.sxt.inter.dto.InvestRecordDto;
import com.sxt.models.BorrowInvestor;
import com.sxt.models.MemberMoney;
import com.sxt.models.OffProductTransaction;
import com.sxt.models.SumMoney;
import com.sxt.models.dto.InvestRewardDto;

public interface BorrowInvestorService {
	
	public BigDecimal querySumMoney(String product_id);
	
	public BigDecimal fQueryBypiduid(String product_id,int uid);
	
	public BorrowInvestor fQueryInvestorByBid(int borrow_uid);
	
	public Map<String,Object> fQueryInvestorByIid(int investor_uid);
	
	public BorrowInvestor fQueryNullByBid(String product_id);
	
	public List<SumMoney> fQueryDebt(int investor_uid );
	
	public List<BorrowInvestor> fQuerySiproByPid(String product_id);
	
	public void fInsertInvestRecord(BorrowInvestor borrowinvestor);
	
	public List<BorrowInvestor> fQueryisinvest(int invest_uid);
	
	public List<BorrowInvestor> fQuerySiproPageByPid(Map<String,Object> params);
	
	public Integer fQuerySiproPageCountByPid(Map<String,Object> params);
	
	public Integer fqueryBorrowInvestorCount(Map<String,Object> param);
	
	public Integer fqueryInvestorCountByProductId(String product_id);
	
	public List<InvestRecordDto> fqueryInvestRecodeByMap(Map<String,Object> param);
	
	public List<InvestRecordDto>  getSiAndNewProductInfo(Map<String,Object> param);
	
	public Integer  getSiAndNewProductInfoCount(Map<String,Object> param);
	
	public Integer fqueryInvestRecodeCountByMap(Map<String,Object> param);
	
	public int fquerycountinvestuid(String proid);
	
	public List<AssignmentDebtDto> queryAssignmentDebt(Map<String,Object> param);
	
	public Integer queryAssignmentDebtCount(Map<String,Object> param);
	
	//检验交易密码
	public String checkPayPass(String payPass,String checkPass) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	
	public void updateDebtStatusByTraceNo(Map<String,Object> param);
	
	public BigDecimal queryRestMoneyByTraceNo(String param);
	
	public AssignmentDebtDto queryProductInfo(String param);
	

	public BigDecimal getAssignChargesRate();
	
	public BorrowInvestor queryInvestorInfo(Integer param);

	public void updateOriginAssign(Map<String,Object> param);
	
	public void insertAssignmentDebt(BorrowInvestor param);
	
	public void insertAssignMemberMoneyDetail(MemberMoney memberMoney,BorrowInvestor borrowInvestor,String ip,Integer localUid,Integer platUid);
	
	public void insertInvestMemberMoneyDetail(MemberMoney memberMoney,BorrowInvestor borrowInvestor,String ip);
	
	public void insertPlatMemberMoneyDetail(MemberMoney memberMoney,BorrowInvestor borrowInvestor,String ip);
	
	public void assignmentDebtSuccess(String systemTraceNo,Integer uid,String ip,Integer id) throws Exception;
	

	public BigDecimal queryExperienceGoldByProid(Map<String,Object> param);
	
	/**
	 * 通过产品id更新投资记录状态
	 * @param para
	 */
	public void updateStatusByProductId(Map<String,Object> para);
	
	public List<AssignmentDebtDto> queryAssigningDebt(int startRow,int pageSize);
	
	public List<AssignmentDebtDto> queryDeadLine(int para);
	
	public List<AssignmentDebtDto> queryToSaleDebt(Map<String,Object> param);
	
	public Integer queryUidByTraceNo(String param);
	
	public AssignmentDebtDto checkAssignable(String param);
	
	public AssignmentDebtDto payDetailByTraceNo(String param);
	
	public AssignmentDebtDto queryDebtPrice(Map<String, Object> param);
	
	public Integer queryAssignCount(Map<String,Object> param);
	
	/**
	 * 条件查询投资记录
	 * @param param
	 * @return
	 */
	public List<BorrowInvestor> queryBorrowInvest(Map<String,Object> param);
	
	public Float calcSubscriptionRate(String systemTraceNo,Date updateTime,BigDecimal debtPrice);
	
	public Float calcRewardRate(Integer restDays,Date updateTime,BigDecimal debtPrice,String rewardTraceNo,Integer returnType);

	public Map<String,Object> getProductInfoById(String param);
	
	public InvestRecordDto getExperGoldByNoAndId(Map<String,Object> param);
	
	public InvestRecordDto getProductById(String param);
	
	/**
	 * 通过手机号查询用户的投资金额
	 * @param param
	 * @return
	 */
	public Map<String, Object> queryInvestMoneyByPhone(Map<String,Object> param);
	
	public int queryCountInvestorByProductId(String productId);
	
	public AssignmentDebtDto getCapAndInterByTraceNo(Map<String,Object> param);
	
	public List<InvestRewardDto> queryInvestRewardList(Map<String, Object> map);
	
	public List<InvestRecordDto> fqueryExInvestRecodeByMap(Map<String,Object> param);
	
	public List<InvestRecordDto> fqueryNewInvestRecodeByMap(Map<String,Object> param);
	
	/**
	 * 统计投资金额
	 * @param param
	 * @return
	 */
	public Map<String, Object> queryInvestMoneySum(Map<String,Object> param);
	
	public List<InvestRecordDto> fqueryYxInvestRecodeByMap(Map<String, Object> param);
	
	public List<OffProductTransaction> queryOffProductTransaction(Map<String, Object> param);
	
	public Integer queryOffProductTransactionCount(Map<String, Object> param);
	
	public Integer queryBorrowInvestByUid(Integer param);
	
}
