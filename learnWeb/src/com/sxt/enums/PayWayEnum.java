package com.sxt.enums;

/**
 * 
 * 支付渠道
 * 
 * pillar liu
 * 
 * 2015-10-17
 * 
 * @version 1.0.0
 * 
 */
public enum PayWayEnum {
	
	MSPAYGATEWAY("1", "民生支付-网关支付"),
	MSPAYSHORTCUT("2", "民生支付-快捷支付"),
	OFFLINEPAY("3", "线下充值"),
	TLPAYGATEWAY("4", "通联支付-网关支付"),
	TLPAYSHORTCUT("5", "通联支付-快捷支付");
	
	private final String code;
	private final String description_zh;

	/**
	 * 创建一个新的实例 MasOrderStatusEnum.
	 * 
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private PayWayEnum(String code, String description_zh) {
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
	public static PayWayEnum getByCode(String code) {
		for (PayWayEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode().equals(code)) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
