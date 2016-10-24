package com.sxt.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sxt.inter.dto.RepayDetailDto;
import com.sxt.models.RepaymentDetail;

public interface RepaymentDetailService {
	public void finsertrepaydetail(RepaymentDetail repaymentdetail);
	public Date fqueryprouid(String proid,int uid);
	
	public BigDecimal fQueryRepayMoneyState1(Map<String,Object> map);
	
	public Map<String,Object> fQueryMoneyInterestBybid(int borrow_uid);//根据用户ID 查询投资的利息 和投资的金额
	
	public int updateRepaymentDetail(RepaymentDetail repaymentdetail);
	
	public List<RepaymentDetail> queryRepaymentPlan(String productid);
	
	public Date queryMaxRepayTime(String productid);
	
	public List<RepaymentDetail> queryRepaymentPlanByMap(Map<String,Object> para);
	
	public void updateRepaymentDetailByMap(Map<String,Object> param);
	
	public List<RepayDetailDto> queryRepaymentDetailByuid(Map<String,Object> para);
	
	public Integer queryCountRepaymentDetailByuid(Map<String,Object> para);
	
	public Map<String,Object> queryRepaySumMoney(Map<String,Object> para);
	
	public BigDecimal queryExpectIncome(Map<String,Object> para);
	
	public Integer queryTotalCount(Map<String,Object> para);
	
	public Integer queryAlDetailCountByUid(Map<String,Object> para);
	
	public List<RepayDetailDto> queryAlDetailByUid(Map<String,Object> para);
	
}
