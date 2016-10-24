package com.sxt.enums;

/**
 * 
 * PayStatusEnum
 * 
 * pillar liu
 * 
 * 2015-10-17
 * 
 * @version 1.0.0
 * 
 */
public enum PayStatusEnum {
	
	PAYING(1, "充值中"),
	SUCCESS(2, "成功"),
	FAILURE(3, "失败");
	
	private final Integer code;
	private final String description_zh;

	/**
	 * 创建一个新的实例 MasOrderStatusEnum.
	 * 
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private PayStatusEnum(Integer code, String description_zh) {
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
	public static PayStatusEnum getByCode(Integer code) {
		for (PayStatusEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode().equals(code)) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
