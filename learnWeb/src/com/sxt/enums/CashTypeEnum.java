package com.sxt.enums;

/**
 * CashTypeEnum.java
 * 
 * @Description 现金理财
 * @author 
 * @date 2016年2月29日 下午2:21:09
 * @version 1.0
 */
public enum CashTypeEnum {
	PURCHASE(1, "申购"),
	REDEEM(2, "赎回"),
	INCOME(3, "收益");

	private final int code;
	private final String description_zh;

	/**
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private CashTypeEnum(int code, String description_zh) {
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
	public static CashTypeEnum getByCode(int code) {
		for (CashTypeEnum cashTypeEnum : values()) {
			if (cashTypeEnum.getCode() == code) {
				return cashTypeEnum;
			}
		}
		return null;
	}
}
