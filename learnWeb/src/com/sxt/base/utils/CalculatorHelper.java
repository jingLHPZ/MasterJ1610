package com.sxt.base.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import com.sxt.util.DateUtil;

public class CalculatorHelper {
	//按季度
	private static final int quarterThree = 3;
	//按半年
	private static final int quarterSix = 6;
	
	private static final int year = 365;
	
	public static final String simple = "yyyy-MM-dd 00:00:00";
	
	public static final String simple00 = "00:00:00";
	
	public static final String simple59 = "23:59:59";

	/**
	 * 一般计算公式 
	 * @param interestRate 投资利率
	 * @param days 周期 (按天计算)
	 * @param months 周期 (按月计算)
	 * @param investmoney 投资本金
	 * @return 【利息】   公式： 【回款本息】=100+100*12%*7/365 =100+0.23 =100.23（元）
	 */
	public static BigDecimal calculateIncome(Float interestRate, Integer days, Integer months, BigDecimal investmoney){
		BigDecimal lvs = new BigDecimal(Float.toString(interestRate)); //利率
		Integer borrowDays = days == null?months:days;//借款期限
		long countDays= days == null?12:year;
		BigDecimal income = ((investmoney.multiply(lvs).multiply(new BigDecimal(borrowDays))).divide(new BigDecimal(countDays), 10, RoundingMode.HALF_UP));
		return income.setScale(2, RoundingMode.HALF_UP);
	}
	
	/**
	 * 计算等额本息方式产生的利息
	 * @param interestRate 利率
	 * @param months 周期 【按月计算】
	 * @param investmoney 投资本金
	 * @return 等额本息方式产生的利息
	 */
	public static BigDecimal calculateIncome(Float interestRate, Integer months, BigDecimal investmoney){
		BigDecimal eachIssueMoney = calculateEachIssueMoney(interestRate, months, investmoney);
		BigDecimal monthCapital = BigDecimal.ZERO;
		BigDecimal monthInterest = BigDecimal.ZERO;
		BigDecimal income = BigDecimal.ZERO;
		for(int i=0; i < months; i++ ){
			monthCapital = calculateMonthCapital(eachIssueMoney, calculateMonthInterest(interestRate, investmoney)).setScale(1, RoundingMode.HALF_UP);
			monthInterest = calculateMonthInterest(interestRate, investmoney);
			income = income.add(monthInterest);
			investmoney = investmoney.subtract(monthCapital);
		}
		return income.setScale(2, RoundingMode.HALF_UP);
	}
	/**
	 * 等额本息 公式
	 * @param interestRate 利率
	 * @param months 借款周期【按月计算】
	 * @param investmoney 投资本金
	 * @return 每月还款额度
	 */
	public static BigDecimal calculateEachIssueMoney(Float interestRate, Integer months, BigDecimal investmoney){
		//月利率
		BigDecimal monthRate = new BigDecimal(Float.toString(interestRate)).divide(new BigDecimal(12), 10 , RoundingMode.HALF_UP);
		//分子
		BigDecimal molecular = monthRate.multiply(new BigDecimal(Math.pow(BigDecimal.ONE.add(monthRate).doubleValue(), months.doubleValue())));
		//分母
		BigDecimal denominator = new BigDecimal(Math.pow(BigDecimal.ONE.add(monthRate).doubleValue(), months.doubleValue())).subtract(BigDecimal.ONE);
		//每期还款额度
		BigDecimal eachIssueMoney = molecular.divide(denominator, 10, RoundingMode.HALF_UP).multiply(investmoney).setScale(2, RoundingMode.HALF_UP);
		
		return eachIssueMoney;
	}
	/**
	 * 等额本息 公式
	 * 每月收款利息
	 * @param interestRate 利率
	 * @param investmoney 投资本金
	 * @return 每月收款利息
	 */
	public static BigDecimal calculateMonthInterest(Float interestRate, BigDecimal investmoney){
		return investmoney.multiply(new BigDecimal(Float.toString(interestRate))).multiply(BigDecimal.ONE.divide(new BigDecimal(12), 10 ,RoundingMode.HALF_UP));
	}
	/**
	 * 等额本息 公式
	 * 每月应还本金
	 * @param eachIssueMoney 每月还款额度
	 * @param eachMonthInterest 每月还款利息
	 * @return 每月还款本金
	 */
	public static BigDecimal calculateMonthCapital(BigDecimal eachIssueMoney, BigDecimal eachMonthInterest){
		return eachIssueMoney.subtract(eachMonthInterest);
	}
	
	/**
	 * 项目第一期还款日期
	 * @param days 周期【天】
	 * @return  项目第一期还款日期
	 */
	public static Date calculateRepaymentTime(Integer days){
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(new Date());//把当前时间赋给日历
		if(days != null){
			calendar.add(Calendar.DAY_OF_MONTH, 0); 
		}else{
			calendar.add(Calendar.MONTH, 1); 
		}
		return calendar.getTime();
	}
	
	/**
	 * 到期一次性还本付息用
	 * @param days 按天计算
	 * @param months 按月计算
	 * @return
	 */
	public static Date calculateProductRepaymentTime(Integer days, Integer months){
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(new Date());
		//先按周期加
		if(days != null){
			calendar.add(Calendar.DAY_OF_MONTH, days); 
		}else{
			calendar.add(Calendar.MONTH, months);
		}
		//再加1天 【T+0】
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		return calendar.getTime();
	}
	
	/**
	 * 按季度付息，按天计算
	 * 一季度有多少天
	 * 半年有多少天
	 * @param cycle 3/6
	 * @return
	 */
	public static int getCountForQuarter(int cycle){
		Date now = new Date();
		Calendar startCalendar = Calendar.getInstance(); //得到日历
		startCalendar.setTime(now);
		Calendar endCalendar = Calendar.getInstance(); //得到日历
		endCalendar.add(Calendar.MONTH, cycle);
		return (int) ((endCalendar.getTimeInMillis() - startCalendar.getTimeInMillis()) / (1000 * 60 * 60 * 24));
	}
	
	/**
	 * 等额本金计算利息
	 * 
	 * @param rate
	 * 			利率
	 * @param endTime
	 * 			到期时间
	 * @param capital
	 * 			本金
	 * @return
	 */
	public static BigDecimal getAverageCapitalInterest(BigDecimal rate, Date startDate,
			Date endDate, BigDecimal capital) {
		
		BigDecimal dayRate = calculateDayRate(rate, capital);
		BigDecimal interest = BigDecimal.ZERO;
		
		Calendar startTime = Calendar.getInstance();
		Calendar endTime = Calendar.getInstance();
		startTime.setTime(startDate);
		endTime.setTime(endDate);
		startTime.add(Calendar.MONTH, 1);
		
		if (endDate.compareTo(startTime.getTime()) >= 0) {
			//	一个月以上
			int countMonth = countDeadlineByAverageCapital(startDate, endDate);
			
			//	等额本金利息，不足月的按天算
			BigDecimal perCapital = capital.divide(BigDecimal.valueOf(countMonth), 12, BigDecimal.ROUND_UP);
			endTime.setTime(endDate); startTime.setTime(startDate);
			
			for (int i = 0; i < countMonth; i++) {
				if (i == 0 && startTime.get(Calendar.DAY_OF_MONTH) != endTime.get(Calendar.DAY_OF_MONTH)) {
					
					//	若下个还款日的当月所在日小于起息日的当月所在日，则月加一，天数为还款当月所在日
					Calendar tempTime = Calendar.getInstance();
					tempTime.set(Calendar.MONTH, startTime.get(Calendar.MONTH));
					tempTime.set(Calendar.DAY_OF_MONTH, endTime.get(Calendar.DAY_OF_MONTH));
					
					if (startTime.get(Calendar.DAY_OF_MONTH) >= endTime.get(Calendar.DAY_OF_MONTH)) {
						tempTime.add(Calendar.MONTH, 1);
					}
					
					int countDays = tempTime.get(Calendar.DAY_OF_YEAR) - startTime.get(Calendar.DAY_OF_YEAR);
					if (startTime.get(Calendar.YEAR) < tempTime.get(Calendar.YEAR)) {
						countDays = countDays + 365;
					}
					interest = interest.add(calculateDayRate(rate, capital).multiply(BigDecimal.valueOf(countDays)));
					
					startTime.setTime(tempTime.getTime());
				} else {
					interest = interest.add(calculateMonthRate(rate, capital));
					startTime.add(Calendar.MONTH, 1);
				}
				capital = capital.subtract(perCapital);
			}
			
		} else {
			
			endTime.setTime(endDate);
			startTime.setTime(startDate);
			
			int countDays = endTime.get(Calendar.DAY_OF_YEAR) - startTime.get(Calendar.DAY_OF_YEAR);
			if (startTime.get(Calendar.YEAR) < endTime.get(Calendar.YEAR)) {
				countDays = countDays + 365;
			}
			interest = interest.add(BigDecimal.valueOf(dayRate.doubleValue() * countDays));
		}
		
		return interest.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 计算等额本金期数
	 * @param endTime
	 * @return
	 */
	public static int countDeadlineByAverageCapital (Date startDate, Date endTime) {
		
		Calendar today = Calendar.getInstance();
		Calendar endday = Calendar.getInstance();
		today.setTime(startDate);
		endday.setTime(endTime);
		
		today.add(Calendar.MONTH, 1);
		if (endday.compareTo(today) >= 0) {
			//	一个月以上
			int countMonth = 0;
			while (endday.compareTo(today) >= 0) {
				countMonth += 1;
				today.add(Calendar.MONTH, 1);
			}
			
			//	不足一月的期数加1
			if (endday.compareTo(today) != 0) {
				countMonth += 1;
			}
			
			return countMonth;
		} else {
			return 1;
		}
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
	 * 
	 * @return 本周的周一和周日的日期
	 * @throws ParseException
	 */
	public static Map<String, Object> getWeekDay() throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
	  	Calendar cal = new GregorianCalendar();
	  	cal.setFirstDayOfWeek(Calendar.MONDAY);
	  	cal.setTime(new Date());
	  	cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
	  	DateFormat df = new SimpleDateFormat(simple);
        map.put("mon", DateUtil.string2Date(df.format(cal.getTime())));
	    //这种输出的是上个星期周日的日期，因为老外那边把周日当成第一天
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + Calendar.FRIDAY);
        String dateStr = df.format(cal.getTime());
        dateStr = dateStr.replace(simple00, simple59);
        map.put("sun", DateUtil.string2DateTime(dateStr));
        return map;
	}
	
	/**
	 * 
	 * @return 本月的第一天和最后一天
	 * @throws ParseException
	 */
	public static Map<String, Object> getMonthDate() throws ParseException{
	   Map<String, Object> map = new HashMap<String, Object>();
	   Calendar calendar = Calendar.getInstance(); 
	   DateFormat df = new SimpleDateFormat(simple);  
	   calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE)); 
	   map.put("monthF", DateUtil.string2Date(df.format(calendar.getTime())));
	   //设置日期为本月最大日期  
	   calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));  
	   map.put("monthL", DateUtil.string2Date(df.format(calendar.getTime())));
	   return map;
	}
}
