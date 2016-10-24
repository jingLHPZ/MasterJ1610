package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.BorrowInvestor;

/**
 * ILdContractInfo.java
 * 
 * @Description 电子合同信息收集
 * @author 
 * @date 2015年12月31日 下午4:00:11
 * @version 1.0
 */
public interface ILdContractInfo {

	/**
	 * 根据产品ID查询投标记录表
	 * 
	 * @param produId
	 * @return
	 */
	public List<BorrowInvestor> findContactBorrowInfo(Map<String, Object> map);

	/**
	 * 根据UID查询用户信息
	 * 
	 * @param uid
	 * @return
	 */
	public Map<String, Object> findContactUserInfo(String uid);

	/**
	 * 保存生成文件信息
	 * 
	 * @param map
	 */
	public void fInsertContractInfo(Map<String, Object> map);
	
	/**
	 * 查询生成文件信息
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> findContractInfo(Map<String, Object> map);
}
