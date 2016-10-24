  package com.sxt.enums;

/**
 * 抽奖类型
 * @author Administrator
 *
 */
public enum LuckyDrawTypeEnum {
	
	COMEAGAIN(1, "再抽一次","COMEAGAIN"),
	SMALLGIFTS(2, "精美小礼品","SMALLGIFTS"),
	INTERESTRATEROLL(3, "0.5%加息卷","INTERESTRATEROLL"),
	INVESTMENTREDTWENTY(4,"投资红包¥20","INVESTMENTREDTWENTY"),
	INVESTMENTREDTEN(5, "投资红包¥10","INVESTMENTREDTEN"),
	INVESTMENTEXPERIENCEFIVETHOUSAND(6,"谢谢参与","INVESTMENTEXPERIENCEFIVETHOUSAND"),
	INVESTMENTEXPERIENCEONETHOUSAND(7,"投资体验金¥1000","INVESTMENTEXPERIENCEONETHOUSAND"),
	CASH(8,"现金¥5","CASH"),
	IPHONE(9,"iphone6s","IPHONE"),
	BENZ(10,"大疆无人机","BENZ");
	private final Integer code;
	private final String description_zh;
	private final String paramCode;
	/**
	 * 创建一个新的实例 MasOrderStatusEnum.
	 * 
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private LuckyDrawTypeEnum(Integer code, String description_zh,String paramCode) {
		this.code = code;
		this.description_zh = description_zh;
		this.paramCode=paramCode;
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
	 * @return MasOrderStatusEnum
	 * @exception
	 * @since 1.0.0
	 */
	public static LuckyDrawTypeEnum getByCode(Integer code) {
		for (LuckyDrawTypeEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode().equals(code)) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

	public String getParamCode() {
		return paramCode;
	}

}
