package com.sxt.enums;

/**
 * ImageTypeEnum.java
 * 
 * @Description 图片管理类型
 * @author 
 * @date 2015年12月10日 下午4:50:16
 * @version 1.0
 */
public enum ImageTypeEnum {
	BANNER(1, "WEB首页轮播图"),
	BANNERAPP(2, "APP首页轮播图");

	private final int code;
	private final String description_zh;

	private ImageTypeEnum(int code, String description_zh) {
		this.code = code;
		this.description_zh = description_zh;
	}

	public int getCode() {
		return code;
	}

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
	public static ImageTypeEnum getByCode(int code) {
		for (ImageTypeEnum imageTypeEnum : values()) {
			if (imageTypeEnum.getCode() == code) {
				return imageTypeEnum;
			}
		}
		return null;
	}
}
