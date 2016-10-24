package com.sxt.service;

import org.jdom.Document;

import com.sxt.models.LdSaleProxyBorrowInvest;
import com.sxt.models.LdSaleProxyMembers;
import com.sxt.models.LdSaleProxyMerchant;
import com.sxt.models.LdSaleProxyProduct;

/**
 * 代销service
 * @author 
 * @date：2016年5月19日 下午4:27:35
 * 
 */
public interface SaleProxyService {

	/**
	 * 添加代理商投资客户
	 * @param saleProxyMembers
	 */
	public void addMembers(LdSaleProxyMembers saleProxyMembers);
	
	/**
	 * 添加代理商产品信息
	 * @param saleProxyProduct
	 */
	public void addProduct(LdSaleProxyProduct saleProxyProduct);
	
	/**
	 * 添加代理商用户投资记录
	 * @param saleProxyBorrowInvest
	 */
	public void addBorrowInvest(LdSaleProxyBorrowInvest saleProxyBorrowInvest);
	
	/**
	 * 通过userId查询用户
	 * @param userId
	 * 		代理商用户ID
	 * @return
	 */
	public LdSaleProxyMembers queryMembersByUserId(String userId);
	
	/**
	 * 通过产品ID查询产品信息
	 * @param productId
	 * @return
	 */
	public LdSaleProxyProduct queryProductByProductId(String productId);
	
	/**
	 * 添加用户投资信息
	 * @param saleProxyMembers
	 * @param saleProxyProduct
	 * @param saleProxyBorrowInvest
	 */
	public void addBorrowInvestInfo(Document doc);
	
	/**
	 * 查询商户信息
	 * @param ldSaleProxyMerchant
	 * @return
	 */
	public LdSaleProxyMerchant queryMerchant(LdSaleProxyMerchant ldSaleProxyMerchant);
	
	/**
	 * 查询用户投资记录
	 * @param saleProxyBorrowInvest
	 * @return
	 */
	public LdSaleProxyBorrowInvest queryBorrowInvest(LdSaleProxyBorrowInvest saleProxyBorrowInvest);
}
