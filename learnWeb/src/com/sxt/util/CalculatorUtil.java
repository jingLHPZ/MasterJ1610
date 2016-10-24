package com.sxt.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sxt.base.utils.CalculatorHelper;
import com.sxt.enums.QuerterTypeEnum;
import com.sxt.enums.RepaymentTypeEnum;

/**
 * 计算器工具类
 * @author 
 * @date：2015年11月12日 下午4:38:11
 * 
 */
public class CalculatorUtil {

	/**
	 * 首页计算器：计算不同还款方式的利息
	 * 
	 * @param repaymentType
	 * 					支付方式
	 * @param duration
	 * 					期限（天/月）
	 * @param money
	 * 					投资金额
	 * @param rate
	 * 					年利率
	 * @param durationType
	 * 					期限类型（day/month）
	 * @return
	 */
	public static List<Map<String, String>> calculator(int repaymentType , int duration, BigDecimal money, 
			BigDecimal rate, String durationType) {
		
		//	还款记录list
		List<Map<String, String>> repaymentMapList = new ArrayList<Map<String, String>>();
		//	本息总额
		Map<String, String> totalMap = new HashMap<String, String>();
		
		//	每月还利息、到期还本息
		if(repaymentType == RepaymentTypeEnum.REPAYMENTTYPE1.getCode()) {
			
			BigDecimal interest = calculateMonthRate(rate, money);						//	每月利息
			BigDecimal totalInterest = interest.multiply(BigDecimal.valueOf(duration));	//	全部利息
			BigDecimal hasInterest = BigDecimal.ZERO;									//	已还利息
			BigDecimal totalMoney = BigDecimal.ZERO;
			
			for (int i = 1; i <= duration; i++) {
				hasInterest = hasInterest.add(interest);
				
				Map<String, String> remapment = new HashMap<String, String>();
				remapment.put("sortOrder", i + "/" + duration);
				if (i == duration) {
					remapment.put("repaymentMoney", money.add(interest).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
					remapment.put("capital", money.toString());
					remapment.put("remainMoney", "0.0");
					totalMoney = totalMoney.add(money.add(interest.setScale(2, BigDecimal.ROUND_HALF_UP)));
				} else {
					remapment.put("repaymentMoney", interest.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
					remapment.put("capital", "0.0");
					remapment.put("remainMoney", totalInterest.subtract(hasInterest).add(money)
							.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
					totalMoney = totalMoney.add(interest.setScale(2, BigDecimal.ROUND_HALF_UP));
				}
				
				remapment.put("interest", interest.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
				repaymentMapList.add(remapment);
				
				//	本息总额
				totalMap.put("totalMoney", totalMoney.toString());
			}
		}
		
		//	一次性还款
		else if (repaymentType == RepaymentTypeEnum.REPAYMENTTYPE2.getCode()) {
			
			BigDecimal interest = BigDecimal.ZERO;
			if ("day".equals(durationType)) {
				interest = calculateDayRate(rate, money);
			} else {
				interest = calculateMonthRate(rate, money);
			}
			interest = interest.multiply(BigDecimal.valueOf(duration));
			
			Map<String, String> remapment = new HashMap<String, String>();
			remapment.put("sortOrder", "1/1");
			remapment.put("repaymentMoney", money.add(interest).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			remapment.put("capital", money.toString());
			remapment.put("interest", interest.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			remapment.put("remainMoney", "0.0");
			repaymentMapList.add(remapment);
			
			totalMap.put("totalMoney", money.add(interest).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		}
		
		//	等额本息
		else if (repaymentType == RepaymentTypeEnum.REPAYMENTTYPE3.getCode()) {
			//	已还本金
			BigDecimal hasCapital = BigDecimal.ZERO;
			//	月利率
			BigDecimal monthRate = rate.divide(new BigDecimal(12), 10, RoundingMode.HALF_UP);
			//	每月还款金额
			BigDecimal repayMoneyMonth = monthRate.multiply(BigDecimal.valueOf(Math.pow(monthRate.add(BigDecimal.ONE).doubleValue(), duration)))
					.divide(BigDecimal.valueOf(Math.pow(monthRate.add(BigDecimal.ONE).doubleValue(), duration) - 1), 10, BigDecimal.ROUND_HALF_UP)
					.multiply(money);
			
			for (int i = 1; i <= duration; i++) {
				
				Map<String, String> remapment = new HashMap<String, String>();
				remapment.put("sortOrder", i + "/" + duration);
				remapment.put("repaymentMoney", repayMoneyMonth.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
				BigDecimal interest = money.subtract(hasCapital).multiply(monthRate);
				remapment.put("interest", interest.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
				remapment.put("capital", repayMoneyMonth.subtract(interest).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
				remapment.put("remainMoney", repayMoneyMonth.multiply(BigDecimal.valueOf(Double.valueOf(duration - i)))
						.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
				
				repaymentMapList.add(remapment);
				hasCapital = hasCapital.add(repayMoneyMonth.subtract(interest));
			}
			
			totalMap.put("totalMoney", repayMoneyMonth.multiply(BigDecimal.valueOf(Double.valueOf(duration)))
					.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		}
		
		//	按天计算利息
		else if (repaymentType == RepaymentTypeEnum.REPAYMENTTYPE5.getCode()
				|| repaymentType == RepaymentTypeEnum.REPAYMENTTYPE6.getCode()
				|| repaymentType == RepaymentTypeEnum.REPAYMENTTYPE7.getCode()) {
			
			//	总利息
			BigDecimal income = calculateDayRate(rate, money).multiply(BigDecimal.valueOf(duration))
					.setScale(2, BigDecimal.ROUND_HALF_UP);
			totalMap.put("totalMoney", money.add(income).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			Calendar calendar = Calendar.getInstance();
			
			//	当次周期
			int querter = QuerterTypeEnum.ONE.getCode();
			if(repaymentType == RepaymentTypeEnum.REPAYMENTTYPE5.getCode()){
				querter = QuerterTypeEnum.ONE.getCode();
			}else if(repaymentType == RepaymentTypeEnum.REPAYMENTTYPE6.getCode()){
				querter = QuerterTypeEnum.THREE.getCode();
			}else if(repaymentType == RepaymentTypeEnum.REPAYMENTTYPE7.getCode()){
				querter = QuerterTypeEnum.SIX.getCode();
			}
			
			//	计算一期内的天数
			int monthDays = DateUtil.getDaysByQuarter(new Date(), querter);
			//	要还的期数
			int cycle = duration <= monthDays ? 1 : (duration % monthDays > 0 ? (duration/monthDays + 1) : (duration/monthDays));
			//	每期的利息
			BigDecimal eachIncome = BigDecimal.ZERO;
			
			int repayDays = cycle > 1 ? monthDays : duration;
			calendar.setTime(CalculatorHelper.calculateProductRepaymentTime(repayDays, null));
			
			for(int i=0; i < cycle; i++){
				
				Map<String, String> remapment = new HashMap<String, String>();
				remapment.put("sortOrder", (i+1) + "/" + cycle);
				
				//	计算当期内的利息
				int daysbyMonth = DateUtil.getDaysByQuarter(calendar.getTime(), querter);
				eachIncome = calculateDayRate(rate, money).multiply(BigDecimal.valueOf(monthDays));
				
				if((i+1) == cycle){
					remapment.put("repaymentMoney", money.add(income).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
					remapment.put("interest", income.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
					remapment.put("capital", money.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
				} else {
					remapment.put("repaymentMoney", eachIncome.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
					remapment.put("interest", eachIncome.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
					remapment.put("capital", "0.0");
				}
				
				//	计算还款后的剩余天数
				int nestQuarterDays = DateUtil.getNextDaysByQuarter(calendar.getTime(), querter);
				duration = duration - daysbyMonth;
				
				//	判断是否最后一期还款
				if(duration > nestQuarterDays) {
					calendar.add(Calendar.MONTH, querter);
				} else {
					calendar.add(Calendar.DAY_OF_MONTH, duration);
				}
				income = income.subtract(eachIncome);
				if (income.doubleValue() <= 0) {
					income = BigDecimal.ZERO;
				}
				remapment.put("remainMoney", income.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
				repaymentMapList.add(remapment);
				
			}
		}
		
		repaymentMapList.add(totalMap);
		return repaymentMapList;
	}
	
	/**
	 * 计算每月利息
	 * @param rate
	 * @param durate
	 * @return
	 */
	public static BigDecimal calculateMonthRate(BigDecimal rate, BigDecimal money) {
		rate = rate.divide(new BigDecimal(12), 10, RoundingMode.HALF_UP);
		return rate.multiply(money);
	}
	
	/**
	 * 计算每天利息
	 * @param rate
	 * @param durate
	 * @return
	 */
	public static BigDecimal calculateDayRate(BigDecimal rate, BigDecimal money) {
		rate = rate.divide(new BigDecimal(365), 10, RoundingMode.HALF_UP);
		return rate.multiply(money);
	}
}
