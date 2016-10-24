package com.sxt.enums;

public enum WithdrawTypeEnum
{
		
		WAITEXAMINEWITHDRAW(1, "待审核提现"),
		EXAMINETHROUGH(2, "初审通过"),
		ALREADYWITHDRAW(3, "提现成功"),
		EXAMINENOTHROUGH(4, "审核未通过"),
		ALREADYREVOKE(5,"已撤销"),
		PROCESS(6,"处理中"),
		ALLOWWITHDRAW(7, "同意提现待复核"),
		FAIL(8, "提现失败"),
		FAILWAITHADDLE(9, "失败待处理"),
		INVALID(10, "提现失效"),
		WAITPAYVERIFY(11, "待付款审核");
		
		
	  	private final int code;
	  	private final String description_zh;
	  	private WithdrawTypeEnum(int code, String description_zh) {
	  		this.code = code;
	  		this.description_zh = description_zh;
	  	}

	  	public int getCode() {
	  		return code;
	  	}


	  	public String getDescription_zh() {
	  		return description_zh;
	  	}

	  	public static WithdrawTypeEnum getByCode(int code) {
	  		for (WithdrawTypeEnum masOrderStatusEnum : values()) {
	  			if (masOrderStatusEnum.getCode() ==  code) {
	  				return masOrderStatusEnum;
	  			}
	  		}
	  		return null;
	  	}
}
