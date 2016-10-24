package com.sxt.base.utils;

import com.sxt.base.constant.Gender;
import com.sxt.base.utils.FormatHelper;
import java.util.Date;
public class IdentityCardUtils {
    public IdentityCardUtils() {
    }

    public static Date getBirthday(String cardID) {
        Date returnDate = null;
        cardID = cardID.trim();
        int len = checkCardIdLength(cardID);
        StringBuffer tempStr = null;
        if(len == 15) {
            tempStr = new StringBuffer(cardID.substring(6, 12));
            tempStr.insert(0, "19");
        } else {
            tempStr = new StringBuffer(cardID.substring(6, 14));
        }

        try {
            if(tempStr != null) {
                returnDate = FormatHelper.parseDateTime(tempStr.toString(), "yyyyMMdd");
            }

            return returnDate;
        } catch (Exception var5) {
            throw new RuntimeException("输入的身份证错误，不能获取相应的出生日期:" + cardID);
        }
    }

    public static Gender getGender(String cardID) {
        cardID = cardID.trim();
        int len = checkCardIdLength(cardID);
        String sex = null;
        if(len == 15) {
            sex = cardID.substring(14, 15);
        } else {
            sex = cardID.substring(16, 17);
        }

        return Integer.parseInt(sex) % 2 == 0?Gender.FEMALE:Gender.MALE;
    }

    private static int checkCardIdLength(String cardID) {
        int len = cardID.length();
        if(cardID != null && (len == 15 || len == 18)) {
            return len;
        } else {
            throw new RuntimeException("输入的身份证错误，不能获取相应的性别:" + cardID);
        }
    }

}
