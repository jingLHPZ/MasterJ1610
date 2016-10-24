package com.sxt.base.utils;

import java.math.BigDecimal;
import org.apache.commons.lang3.StringUtils;
import com.sxt.base.exception.AccountException;

public class MemberMoneyHelper {
	
    public static void checkAmount(BigDecimal accountMoney, String message) {
        if (accountMoney == null) {
            throw new AccountException("amount can't null");
        }
        if (accountMoney.compareTo(BigDecimal.ZERO) < 0) {
            throw new AccountException(StringUtils.defaultIfBlank(message, "金额不能小于0"));
        }
    }
}
