package com.sxt.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.base.utils.CalculatorHelper;
import com.sxt.enums.RepaymentTypeEnum;
import com.sxt.inter.IBorrowPlan;
import com.sxt.inter.dto.BorrowPlanDto;
import com.sxt.models.BorrowPlan;
import com.sxt.service.BorrowPlanService;
@Service
public class BorrowPlanServiceImpl implements BorrowPlanService {
	@Autowired
	private IBorrowPlan  iBorrowPlan;

	public void finsertborrowplan(BorrowPlan borrowplan) {
		iBorrowPlan.finsertborrowplan(borrowplan);
	}

	public Map<String, Object> fqueryborrowmoney(int uid)
	{
		return iBorrowPlan.fqueryborrowmoney(uid);
	}
	
	public List<BorrowPlanDto> queryBorrowPlanByMap(Map<String,Object> param){
		List<BorrowPlanDto> borrowPlanDtos = iBorrowPlan.queryBorrowPlanByMap(param);
		if(borrowPlanDtos!=null){
			for(BorrowPlanDto borrowPlanDto : borrowPlanDtos){
				if(borrowPlanDto.getRepaymentTime().getTime() < new Date().getTime()){
					//显示中的用途 class="bw_zt_3" 3:代表逾期中 
					borrowPlanDto.setStatus(3);
				}
			}
		}
		return borrowPlanDtos;
	}
	
	public Integer queryBorrowPlanCountByMap(Map<String,Object> param){
		return iBorrowPlan.queryBorrowPlanCountByMap(param);
	}
	
	public BorrowPlanDto queryBorrowMoneyByMap(Map<String,Object> param){
		BorrowPlanDto borrowPlanDto = iBorrowPlan.queryBorrowMoneyByMap(param);
		if(borrowPlanDto != null){
			return borrowPlanDto;
		}
		return new BorrowPlanDto(BigDecimal.ZERO,BigDecimal.ZERO);
	}
	/**
	 * 通过产品参数取得借款计划
	 * @param param
	 * @return
	 */
	public List<BorrowPlan> getBorrowPlanByPara(Map<String,Object> param){
		return iBorrowPlan.getBorrowPlanByProductId(param);
	}
	
	/**
	 * 更新借款计划状态
	 */
	public void updateBorrowPlanByid(Map<String,Object> param){
		iBorrowPlan.updateBorrowPlanByid(param);
	}
	
	public BorrowPlan getBorrowPlanByBorrowId(Map<String,Object> param){
		return iBorrowPlan.getBorrowPlanByBorrowId(param);
	}

	
	public List<BorrowPlanDto> querySettleProductPage(Map<String,Object> param){
		List<BorrowPlanDto> bps = iBorrowPlan.querySettleProductPage(param);
		if(bps == null){
			return null;
		}
		Map<String, Object> queryMap = new HashMap<String, Object>();
		for (BorrowPlanDto borrowPlanDto : bps) {
			queryMap.put("productId", borrowPlanDto.getProductId());
			queryMap.put("borrowUid", borrowPlanDto.getBorrowUid());
			borrowPlanDto.setRealPayMoney(queryTotalMoney(queryMap));
		}
		return bps;
	}
	
	public Integer querySettleProductCount(Map<String,Object> param){
		return iBorrowPlan.querySettleProductCount(param);
	}
	
	public List<BorrowPlan> getBorrowPlanByProductIdAndStatus (Map<String,Object> param){
		return iBorrowPlan.getBorrowPlanByProductIdAndStatus(param);
	}
	
	public BorrowPlanDto sumBorrowPlanById (Map<String,Object> param){
		return iBorrowPlan.sumBorrowPlanById(param);
	}
	
	public Date queryNextPaymentTime(Integer investorUid){
		return iBorrowPlan.queryNextPaymentTime(investorUid);
	}
	
	public List<BorrowPlanDto> queryPaymentTime(Map<String,Object> param){
		List<BorrowPlanDto> result = iBorrowPlan.queryPaymentTime(param);
		if(result != null){
			for (Iterator<BorrowPlanDto> iterator = result.iterator(); iterator.hasNext();) {
				BorrowPlanDto borrowPlanDto = (BorrowPlanDto) iterator.next();
				Date repaymentTime = borrowPlanDto.getRepaymentTime();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(repaymentTime);
				borrowPlanDto.setSortOrder(calendar.get(Calendar.DAY_OF_MONTH));
			}
		}
		return result;
	}

	public Integer queryBorrowPlanByUid(Integer param) {
		return iBorrowPlan.queryBorrowPlanByUid(param);
	}

	public BigDecimal queryTotalMoney(Map<String, Object> param) {
		return iBorrowPlan.queryTotalMoney(param);
	}
}
