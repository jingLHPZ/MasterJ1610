package com.sxt.enums;

/**
 * 是否实名
 */
public enum IsRealNameEnum {
	
	NO("0", "未实名"),
	YES("1", "已实名");
	
	private final String code;
	private final String description;

	private IsRealNameEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static IsRealNameEnum getByCode(String code) {
		for (IsRealNameEnum beanEnum : values()) {
			if (beanEnum.getCode().equals(code)) {
				return beanEnum;
			}
		}
		return null;
	}

}
