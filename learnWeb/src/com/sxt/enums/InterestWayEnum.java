package com.sxt.enums;

/**
 * 
 * 还款类型
 * 
 * 
 * 2015-10-17
 * 
 * @version 1.0.0
 * 
 */
public enum InterestWayEnum {
	
	NOW(1, "满标日起息"),
	COLLECTENDTIME(2, "筹集结束日起息");
	
	private final Integer code;
	private final String description_zh;

	/**
	 * 创建一个新的实例 RepaymentTypeEnum.
	 * 
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private InterestWayEnum(Integer code, String description_zh) {
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
	public static InterestWayEnum getByCode(Integer code) {
		for (InterestWayEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode() == code) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
