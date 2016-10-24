package com.sxt.enums;

/**
 * TransferStatusEnum
 * 转让状态
 * @version 1.0.0
 * 
 */
public enum TransferStatusEnum {
	
	UNFORSALE(0, "未转让"),
	FORSALE(1, "转让中"),
	ASSIGNED(2, "已转让");
	
	private final int code;
	private final String description_zh;

	/**
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private TransferStatusEnum(int code, String description_zh) {
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
	public static TransferStatusEnum getByCode(int code) {
		for (TransferStatusEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode() == code) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
