package com.sxt.enums;

/**
 * 
 * ProductBorrowStatusEnum
 * 借款类型
 * @version 1.0.0
 * 产品类型： 1 新手标 2 体验标 3 涨中宝 4 散标
 * 0 新增 1 初审核 2复审 3 投资中 4 满标 5 流标 6 还款中 7 停止发布 8 完成
 */
public enum ProductBorrowStatusEnum {
	
	ZERO(0, "新增"),
	ONE(1, "初审核"),
	TWO(2, "复审"),
	THREE(3, "投资中"),
	FOUR(4, "满标"),
	FIVE(5, "流标"),
	SIX(6, "还款中"),
	SEVEN(7, "停止发布"),
	EIGHT(8, "完成"),
	NINE(9, "即将开始"),
	TEN(10, "未完成问卷"),
	ELE(11, "未等待24小时");
	
	private final int code;
	private final String description_zh;

	/**
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private ProductBorrowStatusEnum(int code, String description_zh) {
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
	public static ProductBorrowStatusEnum getByCode(int code) {
		for (ProductBorrowStatusEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode() == code) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
