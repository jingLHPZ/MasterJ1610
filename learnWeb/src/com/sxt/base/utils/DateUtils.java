package com.sxt.base.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
/**
 * 
 * @author jl
 *
 */
public class DateUtils {

    public DateUtils() {
    }

    public static Date getNextEndDate(Date date, int offset) {
        if(offset < 1) {
            return date;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            for(int dayOfWeek = calendar.get(7); offset > 0; --offset) {
                if(dayOfWeek == 6) {
                    calendar.add(5, 3);
                } else if(dayOfWeek == 7) {
                    calendar.add(5, 2);
                } else {
                    calendar.add(5, 1);
                }
            }

            return calendar.getTime();
        }
    }

    public static Date getNexMonthEndDate(Date startDate, int period) {
        DateTime beginDate = new DateTime(startDate.getTime());
        DateTime endDate = beginDate.plusMonths(period);
        if(endDate.get(DateTimeFieldType.dayOfMonth()) == beginDate.get(DateTimeFieldType.dayOfMonth())) {
            endDate = endDate.plusDays(-1);
        }

        return endDate.toDate();
    }

    public static Date getCurrentDate() {
        return new Date();
    }

    public static Date parseDate(String dateStr) {
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(dateStr, new String[]{"yyyy-MM-dd", "yyyy-M-d", "yyyy/MM/dd", "yyyy/M/d"});
        } catch (ParseException var2) {
            return null;
        }
    }
    
    public static long getDaysforYear(){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int year = Integer.valueOf(sdf.format(d).substring(0, 4));
		long count = (year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0) ? 366 : 365;
		return count;
    }
    
    /**
     * 根据日期格式化
     * @param date
     * @param pattern
     * @return
     */
    public static String getFormateDate(Date date, String pattern) {
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    	return sdf.format(date);
    }

}
