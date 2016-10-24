package com.sxt.enums;

/**
 * 用户奖励枚举
 * @author 
 * @date：2015年11月9日 下午5:15:03
 * 
 */
public enum UserAwardTypeEnum {
	
	REG(1, "用户注册奖励"),
	RECOMMENDREG(2, "推荐好友注册奖励"),
	REALNAMEBIND(3, "实名认证奖励"),
	RECOMMENDREALNAME(4, "推荐好友实名认证奖励"),
	BANKCARDBIND(5, "银行卡绑定奖励"),
	RECOBANKCARDBIND(6, "推荐好友银行卡绑定奖励"),
	EMAILBIND(7, "邮件绑定奖励"),
	RECOMMENDUSERBUY(8, "用户购买标的推荐人奖励"),
	RECHARGEMONEY(9, "用户充值奖励"),
	COMMONRODUCT(10, "散标购买奖励"),
	ZZBPRODUCT(11, "涨中宝购买奖励"),
	NEWERPRODUCT(12, "新手标购买奖励"),
	EXPERIENCEPRODUCT(13, "体验标购买奖励"),
	INVESTMENTREDENVELOPE(14, "兑换投资红包奖励"),
	EXPERIENCEGOLD(15, "兑换体验金奖励"),
	SIGN(16, "签到奖励"),
	LUCKYDRAW(17, "抽奖奖励"),
	PRESENTEEREG(18, "被推荐注册奖励"),
	FRIENDCOMMONRODUCT(20, "投资散标奖励"),
	FRIENDZZBPRODUCT(21, "投资涨中宝奖励"),
	FRIENDNEWERPRODUCT(22, "投资新手标奖励"),
	FRIENDEXPERIENCEPRODUCT(23, "投资体验标奖励"),
	FRIENDPEPRODUCT(24, "投资私募奖励"),
	PAYEXPERIENCEGOLD(25, "购买体验标"),
	YINGXIANGPRODUCT(26, "投资盈享理财奖励");
	
	private final int code;
	private final String description_zh;
	
	private UserAwardTypeEnum(int code, String description_zh) {
		this.code = code;
		this.description_zh = description_zh;
	}
	
	public static UserAwardTypeEnum getByCode(int code) {
		for (UserAwardTypeEnum userAwordTypeEnum : values()) {
			if (userAwordTypeEnum.getCode() == code) {
				return userAwordTypeEnum;
			}
		}
		return null;
	}
	
	public static String getDescriptionByCode(int code) {
		for (UserAwardTypeEnum userAwordTypeEnum : values()) {
			if (userAwordTypeEnum.getCode() == code) {
				return userAwordTypeEnum.description_zh;
			}
		}
		return null;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescription_zh() {
		return description_zh;
	}
	
}
