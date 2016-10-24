package com.sxt.enums;

/**
 * 
 * CiProductBorrowStatusEnum
 * 涨中宝 类型
 * @version 1.0.0
 * 
 */
public enum CiProductBorrowStatusEnum {
	/**
	 * 借款状态 (0 新增 1 初审核 2复审 3 投资中 4 满标 5 流标 6 还款中 7 停止发布 8 完成 9 逾期)
	 */
	ADD(0, "新增"),
	PRELIMINARYAUDIT(1, "初审核"),
	REVIEW(2, "复审"),
	INVESTMENT(3, "投资中"),
	FULLSCALE(4, "满标"),
	FLOWSTANDARD(5, "流标"),
	REPAYMENT(6, "还款中"),
	STOPPUBLISHING(7, "停止发布"),
	FINISH(8, "完成"),
	OVERDUE(9, "逾期");
	
	private final Integer code;
	private final String description_zh;

	/**
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private CiProductBorrowStatusEnum(Integer code, String description_zh) {
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
	public static CiProductBorrowStatusEnum getByCode(int code) {
		for (CiProductBorrowStatusEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode() == code) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
