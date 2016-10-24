package com.sxt.service;


/**
 * 奖励代码service
 * @author 
 * @date：2016年3月2日 下午5:44:49
 * 
 */
public interface LdRewardCodeService {

	/**
	 * 给用户发送奖励码
	 * @param uid
	 * @return
	 */
	public void sendCode(int uid);
	
}
