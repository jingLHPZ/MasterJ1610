package com.sxt.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.inter.ILdSaleProxyBorrowInvest;
import com.sxt.inter.ILdSaleProxyMembers;
import com.sxt.inter.ILdSaleProxyMerchant;
import com.sxt.inter.ILdSaleProxyProduct;
import com.sxt.models.LdSaleProxyBorrowInvest;
import com.sxt.models.LdSaleProxyMembers;
import com.sxt.models.LdSaleProxyMerchant;
import com.sxt.models.LdSaleProxyProduct;
import com.sxt.service.SaleProxyService;
import com.sxt.util.DateUtil;

/**
 * 代销service
 * @author 
 * @date：2016年5月19日 下午4:40:13
 * 
 */
@Service
public class SaleProxyServiceImpl implements SaleProxyService {

	@Autowired
	private ILdSaleProxyBorrowInvest iSaleProxyBorrowInvest;
	@Autowired
	private ILdSaleProxyMembers iSaleProxyMembers;
	@Autowired
	private ILdSaleProxyProduct iSaleProxyProduct;
	@Autowired
	private ILdSaleProxyMerchant iSaleProxyMerchant;

	
	@Override
	public LdSaleProxyMembers queryMembersByUserId(String userId) {
		LdSaleProxyMembers members = new LdSaleProxyMembers();
		members.setMerchantUid(userId);
		members = iSaleProxyMembers.queryLdSaleProxyMembersByCondition(members);
		return members;
	}

	@Override
	public LdSaleProxyProduct queryProductByProductId(String productId) {
		LdSaleProxyProduct product = new LdSaleProxyProduct();
		product.setMerchantProductId(productId);
		product = iSaleProxyProduct.queryLdSaleProxyProductByCondition(product);
		return product;
	}
	
	@Override
	public LdSaleProxyMerchant queryMerchant(LdSaleProxyMerchant ldSaleProxyMerchant) {
		return iSaleProxyMerchant.queryLdSaleProxyMerchantByCondition(ldSaleProxyMerchant);
	}

	@Override
	public LdSaleProxyBorrowInvest queryBorrowInvest(LdSaleProxyBorrowInvest saleProxyBorrowInvest) {
		return iSaleProxyBorrowInvest.queryLdSaleProxyBorrowInvestByCondition(saleProxyBorrowInvest);
	}

	@Override
	public void addMembers(LdSaleProxyMembers saleProxyMembers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProduct(LdSaleProxyProduct saleProxyProduct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBorrowInvest(LdSaleProxyBorrowInvest saleProxyBorrowInvest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBorrowInvestInfo(Document doc) {
		// TODO Auto-generated method stub
		
	}

}
