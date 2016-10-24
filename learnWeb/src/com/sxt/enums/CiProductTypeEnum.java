package com.sxt.enums;

/**
 * 
 * CiProductTypeEnum
 * 涨中宝 类型
 * @version 1.0.0
 * 
 */
public enum CiProductTypeEnum {
	
	SEASON(1, "季季涨"),
	DOUBLESEASON(2, "双季涨"),
	ANNUALLY(3, "年年涨"),
	DAY(4, "天天涨");
	
	private final int code;
	private final String description_zh;

	/**
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private CiProductTypeEnum(int code, String description_zh) {
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
	 * 
	 * 通过code获取枚举
	 * 
	 * @param code
	 * @return StatusEnum
	 * @exception
	 * @since 1.0.0
	 */
	public static CiProductTypeEnum getByCode(int code) {
		for (CiProductTypeEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode() == code) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
