package com.sxt.enums;

/**
 * 
 * 还款类型  1为普通 2红包 3 加息券
 * 
 * pillar liu
 * 
 * 2015-10-17
 * 
 * @version 1.0.0
 * 
 */
public enum ReturnTypeEnum {
	
	GENERAL(1, "普通"),
	INTERESTRATECOUPON(2,"加息券"),
	RED(3, "红包");
	
	private final Integer code;
	private final String description_zh;

	/**
	 * 创建一个新的实例 MasOrderStatusEnum.
	 * 
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private ReturnTypeEnum(Integer code, String description_zh) {
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
	 * 
	 * 通过code获取枚举
	 * 
	 * @param code
	 * @return StatusEnum
	 * @exception
	 * @since 1.0.0
	 */
	public static ReturnTypeEnum getByCode(Integer code) {
		for (ReturnTypeEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode() == code) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
