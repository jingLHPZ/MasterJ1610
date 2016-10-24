package com.sxt.inter;

import java.util.List;

import com.sxt.models.LdSaleProxyBorrowInvest;

import java.util.Map;

public interface ILdSaleProxyBorrowInvest {

	/**
	 * 添加一个代销产品投资记录，并且给它分配ID
	 * @param ldSaleProxyBorrowInvest
	 * @return 影响行数
	 */
	public int insert(LdSaleProxyBorrowInvest ldSaleProxyBorrowInvest);

	/**
	 * 编辑代销产品投资记录
	 * @param ldSaleProxyBorrowInvest
	 * @return 影响行数
	 */
	public int update(LdSaleProxyBorrowInvest ldSaleProxyBorrowInvest);

	/**
	 * 根据ID删除代销产品投资记录
	 * @param id
	 * @return 影响行数
	 */
	public int delete(Long id);

	/**
	 * 根据条件查询List代销产品投资记录
	 * @param maps
	 * @return 
	 */
	public List<LdSaleProxyBorrowInvest> queryLdSaleProxyBorrowInvestList(Map<String, Object> params);

	/**
	 * 根据条件查询代销产品投资记录
	 * @param ldSaleProxyBorrowInvest
	 * @return 
	 */
	public LdSaleProxyBorrowInvest queryLdSaleProxyBorrowInvestByCondition(LdSaleProxyBorrowInvest ldSaleProxyBorrowInvest);

	/**
	 * 根据条件查询代销产品投资记录总个数
	 * @param ldSaleProxyBorrowInvest
	 * @return 
	 */
	public int queryLdSaleProxyBorrowInvestCount(LdSaleProxyBorrowInvest ldSaleProxyBorrowInvest);

}
