package com.sxt.enums;

/**
 * 
 * 优惠使用状态
 * 2015-10-17
 * 
 * @version 1.0.0
 * 
 */
public enum RewardUseStatusEnum {
	
	UNUSED("0", "绑定未使用"),
	USED("1", "已使用"),
	UNBOUND("2","未绑定");
	
	private final String code;
	private final String description_zh;

	/**
	 * 创建一个新的实例 MasOrderStatusEnum.
	 * 
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private RewardUseStatusEnum(String code, String description_zh) {
		this.code = code;
		this.description_zh = description_zh;
	}

	/**
	 * code
	 * 
	 * @return the code
	 * @since 1.0.0
	 */

	public String getCode() {
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
	public static RewardUseStatusEnum getByCode(String code) {
		for (RewardUseStatusEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode().equals(code)) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
