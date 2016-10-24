package com.sxt.enums;

/**
 * 
 * ProductBorrowStatusEnum
 * 借款类型
 * @version 1.0.0
 * 产品类型： 1 新手标 2 体验标 3 涨中宝 4 散标
 * 0 新增 1 初审核 2复审 3 投资中 4 满标 5 流标 6 还款中 7 停止发布 8 完成
 */
public enum ExperiencetBorrowStatusEnum {
	
	OPEN(3, "开始投资"),
	CLOSE(9, "关闭投资"),
	PLAN(10, "自动开放关闭投资");
	
	private final int code;
	private final String description_zh;

	/**
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private ExperiencetBorrowStatusEnum(int code, String description_zh) {
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
	public static ExperiencetBorrowStatusEnum getByCode(int code) {
		for (ExperiencetBorrowStatusEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode() == code) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
