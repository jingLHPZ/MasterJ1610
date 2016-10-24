  package com.sxt.enums;

/**
 * 
 * AccountTypeEnum
 * 
 * pillar liu
 * 
 * 2015-10-08
 * 
 * @version 1.0.0
 * 
 */
public enum AccountTypeEnum {
	
	FREEZE("1", "冻结"),
	UNFREEZE("2", "解冻"),
	RECHARGE("3", "充值"),
	WITHDRAW("4", "提现"),
	INVEST("5","投标"),
	RECEIVEMONEY("6","收到还款本金"),
	DEBTASSIGNMENT("7","债权转让"),
	BUYDEBT("8","购买债权"),
	INTERESTMANAGEMENTFEE("9","利息管理费"),
	BORROW("10","借款"),
	REPAYBORROW("11","归还借款"),
	ENCOURAGE("12","奖励"),
	SERVICECHARGE("13","收到手续费"),
	SERVICEINTEREST("14","收到还款利息"),
	SERVICEADMIN("15","平台管理费"),
	PRODUCTEXPERIENCE("16","体验标"),
	PRODUCTNEWHAND("17","新手标投资"),
	PRODUCTSI("18","专享理财投资"),
	PRODUCTJJ("19","涨中宝季季涨投资"),
	PRODUCTDJ("20","涨中宝双季涨投资"),
	PRODUCTYY("21","涨中宝年年涨投资"),
	COMPOUNDINTEREST("22","涨中宝复投利息"),
	PAYREFUND("23","充值退款"),
	NEWHANDCOLLECTCAPITAL("24","新手标应收本金"),
	NEWHANDCOLLECTINTEREST("25","新手标应收利息"),
	REPAYINTEREST("26","归还利息"),
	EXPERIENCEINTEREST("27","收到体验标还款利息"),
	CIPRODUCTCOLLECTINTEREST("28","涨中宝应收利息"),
	SIPRODUCTCOLLECTINTEREST("29","专享理财应收利息"),
	PEPRODUCTCOLLECTINTEREST("291","私募应收利息"),
	YINGXIANGCOLLECTINTEREST("292","盈享理财应收利息"),
	HIKE("30","加息券"),
	RED("31","红包"),
	RECEIVEINTERESTRATECOUPON("32","收到加息券还款利息"),
	REDCOUPON("33","红包利息"),
	RECEIVEIREDCOUPON("34","收到红包利息"),
	FULLSCALEINCOME("35","满标收入"),
	FULLSCALEPAY("36","满标支出"),
	DEBTASSIGNMENTFEE("37","债权转让手续费"),
	LUCKYDRAW("38","抽奖"),
	CASHMONEY("39","提现手续费"),
	GETCASHCOUPONS("40","领取现金红包"),
	BANKFEE("41", "绑卡支出"),
	HANDADJUSTMENTS("100","手工调整"),
	RECHARGEADJUSTMENTS("101","线下充值调账"),
	USERREG("1201","用户注册奖励"),
	RECOMMENDUSERREG("1202","推荐好友注册奖励"),
	REALNAME("1203","实名认证奖励"),
	RECOMMENDREALNAME("1204","推荐好友实名认证奖励"),
	BANKCARDBIND("1205","银行卡绑定奖励"),
	RECOMMENDBANKCARDBIND("1206","推荐好友银行卡绑定奖励"),
	EMAILBIND("1207","邮件绑定奖励"),
	RECOMMENDBUY("1208","用户购买标的推荐人奖励"),
	USERRECHARGE("1209","用户充值奖励"),
	SANPRODUCT("1210","专享理财购买奖励"),
	ZZBPRODUCT("1211","涨中宝购买奖励"),
	NEWERPRODUCT("1212","新手标购买奖励"),
	EXPERIENCEPRODUCT("1213","体验标购买奖励"),
	INVESTMENTREDENVELOPE("1214", "兑换投资红包奖励"),
	EXPERIENCEGOLD("1215", "兑换体验金奖励"),
	USERSIGN("1216", "用户签到奖励"),
	USERLUCKYDRAW("1217", "用户抽奖奖励"),
	PRESENTEEREG("1218", "被推荐注册奖励"),
	FRIENDCOMMONRODUCT("1220", "投资专享理财奖励"),
	FRIENDZZBPRODUCT("1221", "投资涨中宝奖励"),
	FRIENDNEWERPRODUCT("1222", "投资新手标奖励"),
	FRIENDEXPERIENCEPRODUCT("1223", "投资体验标奖励"),
	FRIENDPEPRODUCT("1224", "投资私募奖励"),
	YXPEPRODUCT("1226", "投资盈享理财奖励"),
	SIPRODUCTRED("4001","专享理财红包支出"),
	SIPRODUCTADDINCOME("4002","专享理财加息券支出"),
	CIPRODUCTORED("7001","季季涨红包支出"),
	CIPRODUCTOADDINCOME("7002","加息券利息支出"),
	CIPRODUCTTRED("7003","双季涨红包支出"),
	CIPRODUCTTADDINCOME("7004","双季涨加息券支出"),
	CIPRODUCTYRED("7005","年年涨红包支出"),
	CIPRODUCTYADDINCOME("7006","年年涨加息券支出"),
	CASHMONEYPURCHASE("120","现金理财申购金额冻结"),
	CASHMONEYPURCHASESUCCESS("121","现金理财申购金额扣款成功"),
	CASHMONEYUNFREEZE("122","现金理财申购解冻"),
	CASHMONEYREDEMPTION("123","现金理财赎回到账"),
	CASHMONEYPURCHASEBORROW("124","现金理财申购金额成功到账"),
	CASHMONEYREDEMPTIONPAY("125","现金理财借款人赎回支出"),
	PRODUCTNEWHANDBORROW("126","新手标借款"),
	YXPRODUCTADDINCOME("127","盈享理财加息券支出"),
	YXPRODUCTRED("128","盈享理财红包支出"),
	SUBTRACTCHARGE("129","扣除手续费"),
	REVOKE("130", "体验标收益回收"),
	REVOKECUSTOME("131", "体验标收益过期失效");
	
	private final String code;
	private final String description_zh;

	/**
	 * 创建一个新的实例 MasOrderStatusEnum.
	 * 
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private AccountTypeEnum(String code, String description_zh) {
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
	public static AccountTypeEnum getByCode(String code) {
		for (AccountTypeEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode().equals(code)) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}

}
