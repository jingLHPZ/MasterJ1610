package com.sxt.enums;

/**
 * 
 * MessageVerifyCodeTypeEnum
 * 手机验证码
 * 
 * pillar liu
 * 
 * 2015-09-30
 * 
 * @version 1.0.0
 * 
 */
public enum MessageVerifyCodeTypeEnum {

	/**
        1.注册，
        2.忘记登录密码，
        3.找回交易密码，
        4.提现，
        5.删除银行卡，
        6.验证邮箱
	 */
	REGISTER(1,"注册验证码"),
	MOBILE_FORGET_LOGIN_VERIFY_CODE(2, "忘记登录密码验证码"),
	MOBILE_RETRIEVE_TRANSACTION_VERIFY_CODE(3, "手机找回找回交易密码验证码"),
	SECURITY_CENTER_CHANGE_MOBILE(4, "提现验证码"),
	DELETE_BANK_CARD(5, "删除银行卡验证码"),
	VERIFY_EMAIL(6, "验证邮箱验证码");
	
	private final Integer code;
	private final String description_zh;

	/**
	 * 创建一个新的实例 MasOrderStatusEnum.
	 * 
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private MessageVerifyCodeTypeEnum(Integer code, String description_zh) {
		this.code = code;
		this.description_zh = description_zh;
	}

	

	
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
	public static MessageVerifyCodeTypeEnum getByCode(Integer code) {
		for (MessageVerifyCodeTypeEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode().equals(code)) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
