package com.sxt.enums;

/**
 * 
 * MessageTypeEnum
 * 
 * pillar liu
 * 
 * 2015-09-30
 * 
 * @version 1.0.0
 * 
 */
public enum MessageTypeEnum {

	/**
	 * 1.线上充值成功2.线下充值成功3.还款到帐4.提现成功5.提现失败6.投标成功
	 * 7.VIP认证通过8.发标初审通过9.发标复审通过10.手机发送验证码内容
	 * 11.手机找回密码验证码12.安全中心更改手机号码13.安全中心新手机验证码
	 * 14.会员设置的新标提醒15.新用户注册验证码16.更换手机老手机验证码17.更换手机新手机验证码
	 * 18.忘记登录密码验证码19.忘记交易密码验证码20.修改登录密码提醒21.修改交易密码提醒
	 * 22.提现请求23.标的满标24.用户注册成功25.借款申请审核通过  26.借款人催收提醒
	 */
	ONLINE_PAY_SUC("1", "线上充值成功"), 
	LINE_PAY_SUC("2", "线下充值成功"),
	REPAYMENT_TO_ACCOUNT("3", "还款到帐"),
	WITHDRAW_CASH_SUC("4", "提现成功"),
	WITHDRAW_CASH_FAIL("5", "提现失败"),
	BID_SUC("6", "投标成功"),
	VIP_SUC("7", "VIP认证通过"),
	ISSUING_THE_TRIAL_SUC("8", "发标初审通过"),
	ISSUING_REVIEW_SUC("9", "发标复审通过"),
	MOBILE_VERIFY_CODE("10", "手机发送验证码内容"),
	MOBILE_RETRIEVE_VERIFY_CODE("11", "手机找回密码验证码"),
	SECURITY_CENTER_CHANGE_MOBILE("12", "安全中心更改手机号码"),
	SECURITY_CENTER_NEW_MOBILE_VERIFY_CODE("13", "安全中心新手机验证码"),
	MEMBER_SET_ISSUING("14", "会员设置的新标提醒"),
	NEW_MEMBER_MOBILE_VERIFY_CODE("15", "新用户注册验证码"),
	CHANGE_MOBILE_OLD_VERIFY_CODE("16", "更换手机老手机验证码"),
	CHANGE_MOBILE_NEW_VERIFY_CODE("17", "更换手机新手机验证码"),
	LOGIN_VERIFY_CODE("18", "忘记登录密码验证码"),
	FORGOT_MOBILE_VERIFY_CODE("19", "忘记交易密码验证码"),
	CHANGE_LOGIN_PWD("20", "修改登录密码提醒"),
	CHANGE_TRADE_PWD("21", "修改交易密码提醒"),
	WITHDRAW_CASH_REQUEST("22", "提现请求"),
	FULL_SCALE("23", "标的满标"),
    REGISTER_SUC("24", "用户注册成功"),
	BORROW_SUC("25", "借款申请审核通过"),
	OVERDUE_REPAYMENT("26", "借款人催收短信"),
	MANUAL_INPUT_TEMPLATE("1000", "手工输入内容,不调用数据库模板"),
	AWARD_CODE("27", "奖品码发送短信");
	
	private final String code;
	private final String description_zh;

	/**
	 * 创建一个新的实例 MasOrderStatusEnum.
	 * 
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private MessageTypeEnum(String code, String description_zh) {
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
	public static MessageTypeEnum getByCode(String code) {
		for (MessageTypeEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode().equals(code)) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
