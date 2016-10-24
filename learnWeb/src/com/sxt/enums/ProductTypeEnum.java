package com.sxt.enums;

/**
 * 
 * ProductTypeEnum
 * 产品类型
 * @version 1.0.0
 * 产品类型： 1 新手标 2 体验标 3 涨中宝 4 散标
 * 
 */
public enum ProductTypeEnum {
	
	NEWHAND(1, "新手标"),
	EXPERIENCE(2, "体验标"),
	SIPRODUCT(3, "散标"),
	ZHANGBAOJI(4, "季季涨"),
	ZHANGBAODOUBLEJI(5, "双季涨"),
	ZHANGBAOYEAR(6, "年年涨"),
	ZHANGBAODAY(7, "天天涨"),
	PRIVATE(8,"私募"),
	YINGXIANG(9,"盈享理财");
	
	private final int code;
	private final String description_zh;

	/**
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private ProductTypeEnum(int code, String description_zh) {
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
	public static ProductTypeEnum getByCode(int code) {
		for (ProductTypeEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode() == code) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
