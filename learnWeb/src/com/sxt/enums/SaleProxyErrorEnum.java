package com.sxt.enums;

/**
 *
 * @author 
 * @date：2016年5月26日 下午3:52:48
 * 
 */
public enum SaleProxyErrorEnum {

	Error_0000("0000", "操作成功"),
	Error_0001("0001", "交易代码错误"),
	Error_0002("0002", "交易流水号错误"),
	Error_0003("0003", "该商户不存在"),
	Error_0004("0004", "用户ID为空"),
	Error_0005("0005", "用户真实姓名为空"),
	Error_0006("0006", "证件号为空"),
	Error_0007("0007", "投资ID为空"),
	Error_0008("0008", "投资金额错误"),
	Error_0009("0009", "投资时间错误"),
	Error_0010("0010", "产品ID为空"),
	Error_0011("0011", "产品名称为空"),
	Error_0012("0012", "产品金额错误"),
	Error_0013("0013", "产品利率错误"),
	Error_0014("0014", "投资预期收益错误"),
	Error_0015("0015", "产品最终还款日期为空"),
	Error_0017("0017", "产品备注过长"),
	Error_0018("0018", "签名信息不正确"),
	Error_0019("0019", "手机号错误"),
	Error_1001("1001", "服务器正忙，请稍后再试"),
	Error_1002("1002", "重复操作");
	
	
	private final String code;
	private final String description_zh;

	/**
	 * 创建一个新的实例 MasOrderStatusEnum.
	 * 
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private SaleProxyErrorEnum(String code, String description_zh) {
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
	 * @return MasOrderStatusEnum
	 * @exception
	 * @since 1.0.0
	 */
	public static SaleProxyErrorEnum getByCode(String code) {
		for (SaleProxyErrorEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode().equals(code)) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
