package com.sxt.enums;


public enum UserTypeEnum {

    INDIVIDUAL(1, "个人"),
    BUSINESS(2, "企业"),
    INSIDER(3, "内部"),
    sxt(4,"学呗");

    private final Integer code;
    private final String description_zh;

    private UserTypeEnum(Integer code, String description_zh) {
        this.code = code;
        this.description_zh = description_zh;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription_zh() {
        return description_zh;
    }

    public static UserTypeEnum getByCode(Integer code) {
        for (UserTypeEnum masOrderStatusEnum : values()) {
            if (masOrderStatusEnum.getCode().equals(code)) {
                return masOrderStatusEnum;
            }
        }
        return null;
    }
}
