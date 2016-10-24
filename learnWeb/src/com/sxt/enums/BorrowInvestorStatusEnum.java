package com.sxt.enums;

/**
 * BorrowInvestorStatusEnum
 * 投资记录状态
 *
 * @version 1.0.0
 */
public enum BorrowInvestorStatusEnum {

    INITIAL(0, "投资中"),
    WAIT(1, "还款中"),
    SUCCESS(2, "还款成功");

    private final int code;
    private final String description_zh;

    /**
     * @param code
     * @param description
     * @param description_zh
     */
    private BorrowInvestorStatusEnum(int code, String description_zh) {
        this.code = code;
        this.description_zh = description_zh;
    }

    /**
     * code
     *
     * @return the code
     * @since 1.0.0
     */

    public int getCode() {
        return code;
    }


    /**
     * description_zh
     *
     * @return the description_zh
     * @since 1.0.0
     */

    public String getDescription_zh() {
        return description_zh;
    }

    /**
     * 通过code获取枚举
     *
     * @param code
     * @return StatusEnum
     * @throws
     * @since 1.0.0
     */
    public static BorrowInvestorStatusEnum getByCode(int code) {
        for (BorrowInvestorStatusEnum masOrderStatusEnum : values()) {
            if (masOrderStatusEnum.getCode() == code) {
                return masOrderStatusEnum;
            }
        }
        return null;
    }

}
