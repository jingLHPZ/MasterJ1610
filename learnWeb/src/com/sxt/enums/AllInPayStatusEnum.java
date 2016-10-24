package com.sxt.enums;

public enum AllInPayStatusEnum {

    PAYING(0, "处理中"),
    SUCCESS(1, "交易成功"),
    FAILURE(2, "交易失败");

    private final Integer code;
    private final String description_zh;

    /**
     * 创建一个新的实例 MasOrderStatusEnum.
     *
     * @param code
     * @param description
     * @param description_zh
     */
    private AllInPayStatusEnum(Integer code, String description_zh) {
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
    public static AllInPayStatusEnum getByCode(Integer code) {
        for (AllInPayStatusEnum masOrderStatusEnum : values()) {
            if (masOrderStatusEnum.getCode().equals(code)) {
                return masOrderStatusEnum;
            }
        }
        return null;
    }
}
