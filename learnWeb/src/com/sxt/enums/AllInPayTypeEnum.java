package com.sxt.enums;

public enum AllInPayTypeEnum {

    BATCHPAY(1, "批量代付"),
    REALTIME(2, "实时付款"),
    BINDKARD(3, "绑银行卡");

    private final Integer code;
    private final String description_zh;

    /**
     * 创建一个新的实例 MasOrderStatusEnum.
     *
     * @param code
     * @param description
     * @param description_zh
     */
    private AllInPayTypeEnum(Integer code, String description_zh) {
        this.code = code;
        this.description_zh = description_zh;
    }

    /**
     * code
     *
     * @return the code
     * @since 1.0.0
     */

    public Integer getCode() {
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
    public static AllInPayTypeEnum getByCode(Integer code) {
        for (AllInPayTypeEnum masOrderStatusEnum : values()) {
            if (masOrderStatusEnum.getCode().equals(code)) {
                return masOrderStatusEnum;
            }
        }
        return null;
    }
}
