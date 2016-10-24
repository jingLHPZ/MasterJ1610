package com.sxt.base.utils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.apache.commons.lang3.math.NumberUtils;
public class MoneyUntils {

    private static char[] CHINESE_LOWER_CASE_AMT = new char[]{'〇', '一', '二', '三', '四', '五', '六', '七', '八', '九'};
    private static char[] CHINESE_UPPER_CASE_AMT = new char[]{'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    private static char[] CHINESE_LOWER_CASE_UNITS = new char[]{'元', '十', '百', '千', '万', '亿', '兆', '京'};
    private static char[] CHINESE_UPPER_CASE_UNITS = new char[]{'圆', '拾', '佰', '仟', '万', '亿', '兆', '京'};
    private static char[] smallUnits = new char[]{'角', '分'};
    public static final BigDecimal TEHN_THOUSAND = NumberUtils.createBigDecimal("10000");
    public static final BigDecimal THOUSAND = NumberUtils.createBigDecimal("1000");

    public MoneyUntils() {
    }

    public static String format2SimpleChineseThousand(BigDecimal value) {
        if(value == null) {
            return "";
        } else {
            StringBuffer sb = new StringBuffer();
            sb.append(value.divide(THOUSAND).setScale(0, RoundingMode.DOWN).toBigInteger().toString());
            if(sb.length() >= 2) {
                sb.insert(sb.length() - 1, "万");
            }

            if(sb.substring(sb.length() - 1).equals("0")) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append("千");
            }

            sb.append("元");
            return sb.toString();
        }
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
}
