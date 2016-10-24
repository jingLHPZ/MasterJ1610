package com.sxt.base.utils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
/**
 * 
 * @author jl
 * 
 */
public class FormatHelper {

    private static char[] chineseAmt = new char[]{'零', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static char[] units = new char[]{'拾', '百', '千'};
    private static char[] chineseUnits = new char[]{'元', '万', '亿', '兆'};
    private static char[] smallUnits = new char[]{'分', '角'};
    public static final BigDecimal TEHN_THOUSAND = NumberUtils.createBigDecimal("10000");
    public static final BigDecimal THOUSAND = NumberUtils.createBigDecimal("1000");
    public static final String AMOUNT_PATTERN = "###,##0.00";
    public static final String AMOUNT_PATTERN_0 = "###";
    public static final String AMOUNT_PATTERN_1 = "####.#";
    public static final String AMOUNT_PATTERN_WITHOUT_DECIMAL = "###,###";
    public static final String RATE_PATTERN = "#0.00";
    public static final String RMB_CHAR = "¥";
    public static final String PRETTY = "_pretty";
    public static final String CAL = "_cal";
    public static final String YYYY_MM_DD = "yyyy.MM.dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy.MM.dd HH:mm:ss";
    public static final String MM_DD_HH_MM = "MM.dd HH:mm";
    public static final String YYYY_MM_DD_HH_MM_SS_MS = "yyyy.MM.dd HH:mm:ss.SSS";

    public FormatHelper() {
    }

    private static boolean inArray(char[] array, char c) {
        char[] arr$ = array;
        int len$ = array.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            char ch = arr$[i$];
            if(ch == c) {
                return true;
            }
        }

        return false;
    }

    public static String formatInt(BigInteger num) {
        if(num.equals(BigInteger.ZERO)) {
            return "零";
        } else if(num.toString().length() > 16) {
            throw new RuntimeException("数值太大，无法转换");
        } else {
            StringBuffer result = new StringBuffer("");
            BigInteger radix = new BigInteger("10");
            int i = 0;
            char preChar = 0;

            while(num.compareTo(BigInteger.ZERO) == 1) {
                StringBuffer tmp = new StringBuffer();
                BigInteger rest = num.mod(radix);
                num = num.divide(radix);
                if(rest.equals(BigInteger.ZERO) && i % 4 != 0 && preChar != '零' && inArray(chineseAmt, preChar)) {
                    tmp.append('零');
                } else if(!rest.equals(BigInteger.ZERO)) {
                    tmp.append(chineseAmt[rest.intValue()]);
                    if(i % 4 != 0) {
                        tmp.append(units[i % 4 - 1]);
                    }
                }

                if(i % 4 == 0) {
                    if(i / 4 > 0 && inArray(chineseUnits, result.charAt(0))) {
                        result.delete(0, 1);
                    }

                    tmp.append(chineseUnits[i / 4]);
                }

                preChar = tmp.length() > 0?tmp.charAt(0):0;
                ++i;
                result.insert(0, tmp);
            }

            if(!result.toString().endsWith(chineseUnits[0] + "")) {
                result.append(chineseUnits[0] + "");
            }

            return result.toString();
        }
    }

    public static String getPrettyName(String name) {
        return name + "_pretty";
    }

    public static String formatMoneyToThousand(BigDecimal value) {
        return value == null?null:formatInt(value.toBigInteger());
    }

    private static void removeLastZero(StringBuffer sb, String money) {
        String[] moneys = money.split("\\.");
        if(moneys.length <= 1) {
            sb.append(money);
        } else {
            sb.append(moneys[0]);
            if(NumberUtils.createBigDecimal(moneys[1]).compareTo(BigDecimal.ZERO) > 0) {
                sb.append(".");
                sb.append(moneys[1]);
            }

        }
    }

    public static String formatMoneyWithYun(BigDecimal value) {
        if(value == null) {
            return "";
        } else {
            DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getInstance(Locale.CHINESE);
            decimalFormat.applyPattern("####,####");
            StringBuffer sb = new StringBuffer();
            String[] moneyStrs = decimalFormat.format(value).split(",");
            if(moneyStrs.length == 1) {
                sb.append(formatThousandMoney(moneyStrs[0])).append("元");
                return sb.toString();
            } else {
                for(int i = 0; i < moneyStrs.length; ++i) {
                    sb.append(formatThousandMoney(moneyStrs[i]));
                    switch(moneyStrs.length - i) {
                    case 1:
                        sb.append("元");
                        break;
                    case 2:
                        sb.append("万");
                        break;
                    case 3:
                        sb.append("亿");
                        break;
                    case 4:
                        sb.append("兆");
                    }
                }

                return sb.toString();
            }
        }
    }

    private static String formatThousandMoney(String moneyStr) {
        int money = Integer.valueOf(moneyStr).intValue();
        return money == 0?"":Integer.toString(money);
    }

    public static String formatShortDate(Date date) {
        return formatDateTime(date, "MM/dd");
    }

    public static String formatDate(Date date) {
        return formatDateTime(date, "yyyy.MM.dd");
    }

    public static String formatDateTime(Date date) {
        return formatDateTime(date, "yyyy.MM.dd HH:mm:ss");
    }

    public static String formatDateShortTime(Date date) {
        return formatDateTime(date, "MM.dd HH:mm");
    }

    public static String formatDateTime(Date date, String pattern) {
        return date == null?null:DateFormatUtils.format(date, pattern);
    }

    public static String formatNumber(BigDecimal amount, String pattern, RoundingMode roundingMode, String unit, String prefix) {
        if(amount == null) {
            return "";
        } else {
            DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getInstance(Locale.CHINESE);
            if(roundingMode == null) {
                decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            } else {
                decimalFormat.setRoundingMode(roundingMode);
            }

            decimalFormat.applyPattern(pattern);
            StringBuffer sb = new StringBuffer();
            if(StringUtils.isNotBlank(prefix)) {
                sb.append(prefix);
            }

            sb.append(decimalFormat.format(amount));
            if(StringUtils.isNotBlank(unit)) {
                sb.append(unit);
            }

            return sb.toString();
        }
    }

    public static String formatNumber(BigDecimal amount) {
        return formatNumber(amount, "###,##0.00", RoundingMode.HALF_UP, (String)null, (String)null);
    }

    public static void transformDateTime(Map<String, Object> map, String name) {
        map.put(getPrettyName(name), formatDateTime((Date)map.get(name)));
    }

    public static void transformDateShortTime(Map<String, Object> map, String name) {
        map.put(getPrettyName(name), formatDateShortTime((Date)map.get(name)));
    }

    public static void transformNumber(Map<String, Object> map, String name, String pattern, RoundingMode roundingMode, String unit, String prefix) {
        map.put(getPrettyName(name), formatNumber((BigDecimal)map.get(name), pattern, roundingMode, unit, prefix));
    }

    public static Date parseDate(String value) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy.MM.dd");
        return fmt.parseDateTime(value).toDate();
    }

    public static Date parseDateTime(String value) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy.MM.dd HH:mm:ss.SSS");
        return fmt.parseDateTime(value).toDate();
    }

    public static Date parseDateTime(String value, String pattern) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
        return fmt.parseDateTime(value).toDate();
    }

    public static String formatRate(BigDecimal amount) {
        return formatNumber(amount, "#0.00", RoundingMode.HALF_DOWN, "%", (String)null);
    }

    public static String convertFileSize(long size) {
        long kb = 1024L;
        long mb = kb * 1024L;
        long gb = mb * 1024L;
        if(size >= gb) {
            return String.format("%.1f GB", new Object[]{Float.valueOf((float)size / (float)gb)});
        } else {
            float f;
            if(size >= mb) {
                f = (float)size / (float)mb;
                return String.format(f > 100.0F?"%.0f MB":"%.1f MB", new Object[]{Float.valueOf(f)});
            } else if(size >= kb) {
                f = (float)size / (float)kb;
                return String.format(f > 100.0F?"%.0f KB":"%.1f KB", new Object[]{Float.valueOf(f)});
            } else {
                return String.format("%d B", new Object[]{Long.valueOf(size)});
            }
        }
    }
}
