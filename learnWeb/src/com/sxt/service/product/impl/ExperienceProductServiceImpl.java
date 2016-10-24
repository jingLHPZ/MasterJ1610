package com.sxt.service.product.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.inter.IBorrowInvestor;
import com.sxt.inter.IBorrowPlan;
import com.sxt.inter.IExperienceProduct;
import com.sxt.inter.IExperienceProductDetail;
import com.sxt.inter.ILdProductExtendInfo;
import com.sxt.inter.IMemberExperienceGoldDetail;
import com.sxt.inter.IMemberMoney;
import com.sxt.inter.IMemberMoneyDetail;
import com.sxt.inter.IMembers;
import com.sxt.inter.IRepaymentDetail;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.models.ExperienceProduct;
import com.sxt.service.product.ExperienceProductService;
@Service
public class ExperienceProductServiceImpl implements ExperienceProductService {
	
	private static Log logger = LogFactory.getLog(ExperienceProductService.class);
	@Autowired
	private IExperienceProduct iExperienceProduct;
	
	@Autowired
	private IExperienceProductDetail experienceProductDetail;
	
	@Autowired
	private IBorrowInvestor iBorrowInvestor;
	
	@Autowired
	private IMemberMoney iMemberMoney;
	
	@Autowired
	private IMembers iMembers;
	
	@Autowired
	private IMemberMoneyDetail iMemberMoneyDetail;
	
	@Autowired
	private IBorrowPlan  iBorrowPlan;
	
	@Autowired
	private IRepaymentDetail  iRepaymentDetail;
	
	@Autowired
	private IMemberExperienceGoldDetail iMemberExperienceGoldDetail;
	
	@Autowired
	private ILdProductExtendInfo  iLdProductExtendInfo;
	
	public List<ExperienceProduct> fQueryProduct() {
		return iExperienceProduct.fQueryProduct();
	}
	
	@Override
	public ExperienceProduct fqueryProductById(String productId) {
		// TODO Auto-generated method stub
		return iExperienceProduct.fqueryProductById(productId);
	}

	@Override
	public void fUpdateStateByProid(String productId) {
		// TODO Auto-generated method stub
		iExperienceProduct.fUpdateStateByProid(productId);
	}
	
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public void payProduct(String productId, BigDecimal investmoney, String systemtradeno,LocalUserDto lud, String ip){
		
	}
	
	public List<ExperienceProduct> fQueryProid(){
		return iExperienceProduct.fQueryProid();
	}

	public String queryExperienceProductByProid(String productId){
		return iExperienceProduct.queryExperienceProductByProid(productId);
	}
	
	public List<String> querySystemTraceNos(Map<String, Object> param){
		return iExperienceProduct.querySystemTraceNos(param);
	}
	
	public BigDecimal queryAffectExperienceGold(Map<String, Object> param){
		BigDecimal affectExperienceGold = iExperienceProduct.queryAffectExperienceGold(param);
		if(affectExperienceGold != null){
			return affectExperienceGold ;
		}
		return BigDecimal.ZERO;
	}
	
	public List<String> querySystemTraceNosByUid(Map<String, Object> param){
		return iExperienceProduct.querySystemTraceNosByUid(param);
	}

	public String queryExProductNameByTraceNo(String productId) {
		return iExperienceProduct.queryExProductNameByTraceNo(productId);
	}

}
