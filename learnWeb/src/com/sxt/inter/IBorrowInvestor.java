package com.sxt.inter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sxt.inter.dto.AssignmentDebtDto;
import com.sxt.inter.dto.InvestRecordDto;
import com.sxt.models.BorrowInvestor;
import com.sxt.models.InvestorMoney;
import com.sxt.models.OffProductTransaction;
import com.sxt.models.dto.InvestRewardDto;

public interface IBorrowInvestor {
	public BigDecimal querySumMoney(String product_id);//根据项目ID 查询已经借款多少钱！
	
	public BigDecimal querySumInterest(String product_id);//根据项目ID 查询总投资利息
	
	public BigDecimal fQueryBypiduid(Map<String,Object> param) ;//根据项目ID 和用户ID 查询投资的利息！
	
	public BorrowInvestor fQueryInvestorByBid(int borrow_uid);
	
	public Map<String,Object> fQueryInvestorByIid(int investor_uid);
	
	public BorrowInvestor fQueryNullByBid(String product_id);
	
	public List<InvestorMoney> fInvestorMoney(Map<String,Object> params);
	
	public List<BorrowInvestor> fQueryDebt(int investor_uid);
	
	public List<BorrowInvestor> fQuerySiproByPid(String product_id);
	
	public void fInsertInvestRecord(BorrowInvestor borrowinvestor);
	
	public List<BorrowInvestor> fQueryisinvest(int invest_uid);
	
	public List<BorrowInvestor> fQuerySiproPageByPid(Map<String,Object> param);
	
	public Integer fQuerySiproPageCountByPid(Map<String,Object> param);
	
	
	public Integer fqueryBorrowInvestorCount(Map<String,Object> param);
	
	public Integer fqueryInvestorCountByProductId(String product_id);
	
	public List<InvestRecordDto> fqueryInvestRecodeByMap(Map<String,Object> param);
	public Integer fqueryInvestRecodeCountByMap(Map<String,Object> param);
	
	public int fquerycountinvestuid(String proid);
	
	public List<AssignmentDebtDto> queryAssignmentDebt(Map<String,Object> param);
	
	public Integer queryAssignmentDebtCount(Map<String,Object> param);
	
	public void updateDebtStatusByTraceNo(Map<String,Object> param);
	
	public BigDecimal queryRestMoneyByTraceNo(String param);
	
	public AssignmentDebtDto queryProductInfo(String param);

	
	public List<BorrowInvestor> queryInvestorForRepayment(String productId);
	
	public BorrowInvestor queryInvestorInfo(Integer param);
	
	public void updateOriginAssign(Map<String,Object> param);
	
	public void insertAssignmentDebt(BorrowInvestor param);
	
	public void updateUidByTraceNo(Map<String,Object> param);

	
	public BigDecimal queryExperienceGoldByProid(Map<String,Object> param);
	
	/**
	 * 通过产品id更新投资记录状态
	 * @param para
	 */
	public void updateStatusByProductId(Map<String,Object> para);
	
	public List<AssignmentDebtDto> queryDeadLine(int para);
	
	//查询转让中和已转让的数据
	public List<AssignmentDebtDto> queryToSaleDebt(Map<String,Object> param);
	
	public Integer queryUidByTraceNo(String param);
	
	public AssignmentDebtDto checkAssignable(String param);
	
	public AssignmentDebtDto payDetailByTraceNo(String param);
	
	public AssignmentDebtDto queryDebtPrice(Map<String, Object> param);
	
	public Integer queryAssignCount(Map<String,Object> param);
	
	public List<BorrowInvestor> queryBorrowInvest(Map<String,Object> param);

	public BigDecimal getCollectMoneyByTraceNo(Map<String, Object> param);
	
	public Map<String, Object> getProductInfoById(String param);
	
	public InvestRecordDto getExperGoldByNoAndId(Map<String, Object> param);
	
	public InvestRecordDto getProductById(String param);
	
	/**
	 * 通过手机号查询用户的投资金额
	 * @param param
	 * @return
	 */
	public Map<String, Object> queryInvestMoneyByPhone(Map<String,Object> param);
	
	public int queryCountInvestorByProductId(String productId);
	
	public List<InvestRecordDto> getSiAndNewProductInfo(Map<String, Object> param);
	
	public Integer getSiAndNewProductInfoCount(Map<String, Object> param);
	
	public AssignmentDebtDto getCapAndInterByTraceNo(Map<String, Object> param);
	
	public List<InvestRewardDto> queryInvestRewardList(Map<String, Object> map);
	
	public List<InvestRecordDto> fqueryExInvestRecodeByMap(Map<String, Object> param);
	
	public List<InvestRecordDto> fqueryNewInvestRecodeByMap(Map<String,Object> param);
	
	/**
	 * 统计投资金额
	 * @param param
	 * @return
	 */
	public Map<String, Object> queryInvestMoneySum(Map<String,Object> param);
	
	public List<InvestRecordDto> fqueryYxInvestRecodeByMap(Map<String, Object> param);
	
	public Integer queryBorrowInvestByUid(Integer param);
}


