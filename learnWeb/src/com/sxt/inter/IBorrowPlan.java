package com.sxt.inter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sxt.inter.dto.BorrowPlanDto;
import com.sxt.models.BorrowPlan;

public interface IBorrowPlan {

	public void finsertborrowplan(BorrowPlan borrowplan);
	
	public int insertBorrowPlanBatch(List<BorrowPlan> borrowPlans);
	
	public Map<String,Object> fqueryborrowmoney(int uid);
	
	public List<BorrowPlanDto> queryBorrowPlanByMap(Map<String,Object> param);
	
	public Integer queryBorrowPlanCountByMap(Map<String,Object> param);
	
	public BorrowPlanDto queryBorrowMoneyByMap(Map<String,Object> param);
	
	public List<BorrowPlan> getBorrowPlanByProductId(Map<String,Object> param);
	
	public void updateBorrowPlanByid(Map<String,Object> param);
	
	public BorrowPlan getBorrowPlanByBorrowId(Map<String,Object> param);
	
	public List<BorrowPlanDto> querySettleProductPage(Map<String,Object> param);
	
	public Integer querySettleProductCount(Map<String,Object> param);
	
	public List<BorrowPlan> getBorrowPlanByProductIdAndStatus (Map<String,Object> param);
	
	public BorrowPlanDto sumBorrowPlanById(Map<String,Object> param);
	
	public Date queryNextPaymentTime(Integer investorUid);
	
	public List<BorrowPlanDto> queryPaymentTime(Map<String,Object> param);
	
	public Integer queryBorrowPlanByUid(Integer param);
	
	public BigDecimal queryTotalMoney(Map<String, Object> param);
}

