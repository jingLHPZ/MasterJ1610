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
public enum QuerterTypeEnum {
	/**
	 * 周期类型
	 * 1个月
	 * 3个月=1季度
	 * 6个月=半年
	 * 这里不是还款类型
	 */
	ONE(1, "每月付息，到期还本(按天)"),
	THREE(3, "每季度付息，到期还本(按天)"),
	SIX(6, "每半年付息，到期还本(按天)");
	
	private final int code;
	private final String description_zh;

	/**
	 * 创建一个新的实例 RepaymentTypeEnum.
	 * 
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private QuerterTypeEnum(int code, String description_zh) {
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
	public static QuerterTypeEnum getByCode(int code) {
		for (QuerterTypeEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode() == code) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
