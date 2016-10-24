package com.sxt.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.IRepaymentDetail;
import com.sxt.inter.dto.RepayDetailDto;
import com.sxt.models.RepaymentDetail;
import com.sxt.service.RepaymentDetailService;
@Service
public class RepaymentDetailServiceImpl implements RepaymentDetailService {
	@Autowired
	private IRepaymentDetail  iRepaymentDetail;
	public void finsertrepaydetail(RepaymentDetail repaymentdetail) {
		iRepaymentDetail.finsertrepaydetail(repaymentdetail);
	}
	public Date fqueryprouid(String proid, int uid) {
		Map<String,Object> map=new HashMap<String, Object>();
		if(proid!=null){
			map.put("proid",proid);
		}
		if(uid!=0){
			map.put("uid",uid);
		}
		return iRepaymentDetail.fqueryprouid(map);
	}
	public BigDecimal fQueryRepayMoneyState1(Map<String,Object> map)
	{
		return iRepaymentDetail.fQueryRepayMoneyState1(map);
	}
	public Map<String, Object> fQueryMoneyInterestBybid(int borrow_uid){
		return iRepaymentDetail.fQueryMoneyInterestBybid(borrow_uid);
	}
	
	public int updateRepaymentDetail(RepaymentDetail repaymentdetail){
		return iRepaymentDetail.updateRepaymentDetail(repaymentdetail);
	}
	public List<RepaymentDetail> queryRepaymentPlan(String productid)
	{
		return iRepaymentDetail.queryRepaymentPlan(productid);
	}
	public Date queryMaxRepayTime(String productid)
	{
		return iRepaymentDetail.queryMaxRepayTime(productid);
	}
	
	public List<RepaymentDetail> queryRepaymentPlanByMap(Map<String,Object> para){
		return iRepaymentDetail.queryRepaymentPlanByMap(para);
	}
	
	public void updateRepaymentDetailByMap(Map<String,Object> param){
		iRepaymentDetail.updateRepaymentDetailByMap(param);
	}
	public List<RepayDetailDto> queryRepaymentDetailByuid(Map<String, Object> para){
		return iRepaymentDetail.queryRepaymentDetailByuid(para);
	}
	public Integer queryCountRepaymentDetailByuid(Map<String, Object> para)
	{
		return iRepaymentDetail.queryCountRepaymentDetailByuid(para);
	}
	public Map<String, Object> queryRepaySumMoney(Map<String, Object> para)
	{
		return iRepaymentDetail.queryRepaySumMoney(para);
	}
	public BigDecimal queryExpectIncome(Map<String, Object> para) {
		return iRepaymentDetail.queryExpectIncome(para);
	}
	@Override
	public Integer queryTotalCount(Map<String, Object> para) {
		return iRepaymentDetail.queryTotalCount(para);
	}
	@Override
	public Integer queryAlDetailCountByUid(Map<String, Object> para) {
		return iRepaymentDetail.queryAlDetailCountByUid(para);
	}
	@Override
	public List<RepayDetailDto> queryAlDetailByUid(Map<String, Object> para) {
		return iRepaymentDetail.queryAlDetailByUid(para);
	}

}
