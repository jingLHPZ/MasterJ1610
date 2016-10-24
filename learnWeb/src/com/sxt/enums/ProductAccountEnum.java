package com.sxt.enums;


public enum ProductAccountEnum {
    SI("1","散标"),
    PE("9","私募"),
    YX("5","盈享理财");

    private final String code;
    private final String description_zh;

    private ProductAccountEnum(String code, String description_zh) {
        this.code = code;
        this.description_zh = description_zh;
    }

    public String getCode() {
        return code;
    }

    public String getDescription_zh() {
        return description_zh;
    }

    public static ProductAccountEnum getByCode(String code) {
        for (ProductAccountEnum productEnum : values()) {
            if (productEnum.getCode().equals(code)) {
                return productEnum;
            }
        }
        return null;
    }
}
