package com.sxt.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 还款类型
 * 
 * 
 * 2015-10-17
 * 
 * @version 1.0.0
 * 
 */
public enum RepaymentTypeEnum {
	
	REPAYMENTTYPE1(1, "每月付息，到期还本"),
	REPAYMENTTYPE2(2, "到期还本付息"),
	REPAYMENTTYPE3(3, "每月等额本息"),
	REPAYMENTTYPE4(4, "到期付息"),
	REPAYMENTTYPE5(5, "每月付息，到期还本"),
	REPAYMENTTYPE6(6, "每季度付息，到期还本"),
	REPAYMENTTYPE7(7, "每半年付息，到期还本"),
	REPAYMENTTYPE8(8, "每月等额本金");
	
	private final int code;
	private final String description_zh;

	/**
	 * 创建一个新的实例 RepaymentTypeEnum.
	 * 
	 * @param code
	 * @param description
	 * @param description_zh
	 */
	private RepaymentTypeEnum(int code, String description_zh) {
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
	public static RepaymentTypeEnum getByCode(int code) {
		for (RepaymentTypeEnum masOrderStatusEnum : values()) {
			if (masOrderStatusEnum.getCode() == code) {
				return masOrderStatusEnum;
			}
		}
		return null;
	}
	
	public static List<Map<Integer, Object>> getRepaymentTypeList() {
		List<Map<Integer, Object>> list = new ArrayList<Map<Integer,Object>>();
		for (RepaymentTypeEnum masOrderStatusEnum : values()) {
			Map<Integer, Object> map = new HashMap<Integer, Object>();
			map.put(masOrderStatusEnum.getCode(), masOrderStatusEnum.getDescription_zh());
			list.add(map);
		}
		return list;
	}

}
