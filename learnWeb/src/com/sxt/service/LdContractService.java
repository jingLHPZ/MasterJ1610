package com.sxt.service;

import java.util.List;
import java.util.Map;

import com.sxt.models.BorrowInvestor;

/**
 * LdContractService.java
 * 
 * @Description 合同生成服务
 * @author 
 * @date 2015年12月31日 上午10:56:22
 * @version 1.0
 */
public interface LdContractService {
	/**
	 * 生成合同
	 * 
	 * @param map
	 * @return
	 */
	public String GenerateContractFile(String produId, String flag, BorrowInvestor borrowInvestorinfo);
	
	/**
	 * 查询生成合同相关信息
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> findContractInfo(Map<String, Object> map);
}
