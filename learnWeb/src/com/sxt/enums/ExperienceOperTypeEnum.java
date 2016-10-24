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
public enum ExperienceOperTypeEnum {
	
	ADD(1, "增加"),
	SUB(2, "减少");
	
	private final int code;
	private final String description_zh;

	/**
	 * 
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private ExperienceOperTypeEnum(int code, String description_zh) {
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
	public static ExperienceOperTypeEnum getByCode(int code) {
		for (ExperienceOperTypeEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode() == code) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
