package com.sxt.enums;


public enum AdminAccountEnum {

    ONE(111111, "季季涨"),
    TWO(222222, "双季涨"),
    THREE(333333, "私募"),
    FOUR(444444,"散标"),
    FIVE(555555,"体验标"),
    SEX(666666,"新手标"),
    SEVEN(777777,"盈享理财"),
    ADMIN(888888, "公司总账");

    private final Integer code;
    private final String description_zh;

    private AdminAccountEnum(Integer code, String description_zh) {
        this.code = code;
        this.description_zh = description_zh;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription_zh() {
        return description_zh;
    }

    public static AdminAccountEnum getByCode(Integer code) {
        for (AdminAccountEnum masOrderStatusEnum : values()) {
            if (masOrderStatusEnum.getCode().equals(code)) {
                return masOrderStatusEnum;
            }
        }
        return null;
    }
}
