package com.sxt.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sxt.inter.dto.BorrowPlanDto;
import com.sxt.models.BorrowPlan;

public interface BorrowPlanService {
	public void finsertborrowplan(BorrowPlan borrowplan);
	
	public Map<String,Object> fqueryborrowmoney(int uid);
	
	public List<BorrowPlanDto> queryBorrowPlanByMap(Map<String,Object> param);
	
	public Integer queryBorrowPlanCountByMap(Map<String,Object> param);
	
	public BorrowPlanDto queryBorrowMoneyByMap(Map<String,Object> param);
	
	/**
	 * 通过产品参数取得借款计划
	 * @param param
	 * @return
	 */
	public List<BorrowPlan> getBorrowPlanByPara(Map<String,Object> param);
	
	public void updateBorrowPlanByid(Map<String,Object> param);
	
	public BorrowPlan getBorrowPlanByBorrowId(Map<String,Object> param);
	
	
	public List<BorrowPlanDto> querySettleProductPage(Map<String,Object> param);
	
	public Integer querySettleProductCount(Map<String,Object> param);
	
	public List<BorrowPlan> getBorrowPlanByProductIdAndStatus (Map<String,Object> param);
	
	public BorrowPlanDto sumBorrowPlanById (Map<String,Object> param);
	
	public Date queryNextPaymentTime(Integer investorUid);
	
	public List<BorrowPlanDto> queryPaymentTime(Map<String,Object> param);
	
	public Integer queryBorrowPlanByUid(Integer param);
	
	public BigDecimal queryTotalMoney(Map<String, Object> param);
}
