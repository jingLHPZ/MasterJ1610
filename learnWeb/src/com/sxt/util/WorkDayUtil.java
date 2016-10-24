package com.sxt.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

public class WorkDayUtil {

	private static Properties props;
	private static String weekdays;
	//判断日期是否是节假日
	public static Integer isWeekend(Date param) throws Exception{
		if(props == null) {
			props = PropertiesRead.use_classLoador();
			weekdays = props.getProperty("weekdays");
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		if(weekdays.indexOf(format.format(param)) != -1) {
			return 0;//节假日
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(param);
		if(cal.get(cal.DAY_OF_WEEK) == 1 || cal.get(cal.DAY_OF_WEEK) == 7) {
			return 0;//节假日
		}
		return 1;//工作日
	}
	
	//获取上一个工作日
	public static Date getLastWorkDay(Date param) throws Exception{
		Calendar cal = Calendar.getInstance();
		cal.setTime(param);
		int step = -1;
		while(step >= -10) {//防止死循环
			cal.add(Calendar.DAY_OF_MONTH, -1);
			step--;
			if(isWeekend(cal.getTime()) == 1) {
				cal.getTime();
				break;
			}
		}
		return cal.getTime();
	}
	
	//获取下一个工作日
	public static Date getNextWorkDay(Date param) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(param);
		int step = 1;
		while(step <= 10) {//防止死循环
			cal.add(Calendar.DAY_OF_MONTH, 1);
			step++;
			if(isWeekend(cal.getTime()) == 1) {
				cal.getTime();
				break;
			}
		}
		return cal.getTime();
	}
	
	public static Integer getHourOfDay(Date param) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(param);
		return cal.get(cal.HOUR_OF_DAY);
	}
	
	
	public static void main(String[] args) {
		try {
			String date = "20160502";
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//			Date nextDay = getNextWorkDay(format.parse(date));
//			Date lastDay = getLastWorkDay(format.parse(date));
//			System.out.println("nextDay:" + format.format(nextDay));
//			System.out.println("lastDay" + format.format(lastDay));
//			Calendar cal = Calendar.getInstance();
			Calendar cal = new GregorianCalendar();
			System.out.println("=====" + cal.get(cal.HOUR) + "=======" + cal.get(cal.HOUR_OF_DAY));
//			int dayOfWeek = isWeekend(format.parse(date));
//			System.out.println(dayOfWeek==0?"节假日":"工作日");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
