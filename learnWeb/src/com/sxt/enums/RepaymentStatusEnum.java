package com.sxt.enums;

/**
 * RepaymentStatusEnum
 * 收款状态
 * @version 1.0.0
 * 
 */
public enum RepaymentStatusEnum {
	
	WAIT(1, "待收款"),
	SUCCESS(2, "收款成功"),
	FAILURE(3, "收款失败"),
	REVOKE(4, "体验标收益回收");
	
	private final int code;
	private final String description_zh;

	/**
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private RepaymentStatusEnum(int code, String description_zh) {
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
	public static RepaymentStatusEnum getByCode(int code) {
		for (RepaymentStatusEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode() == code) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
