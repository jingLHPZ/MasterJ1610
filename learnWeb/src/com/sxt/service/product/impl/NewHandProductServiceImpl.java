package com.sxt.service.product.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.base.exception.ServiceException;
import com.sxt.base.utils.CalculatorHelper;
import com.sxt.base.utils.FormatHelper;
import com.sxt.enums.AccountTypeEnum;
import com.sxt.enums.BorrowInvestorStatusEnum;
import com.sxt.enums.BorrowPlanStatusEnum;
import com.sxt.enums.ProductTypeEnum;
import com.sxt.enums.RepaymentStatusEnum;
import com.sxt.enums.RepaymentTypeEnum;
import com.sxt.enums.TransferStatusEnum;
import com.sxt.inter.IBorrowInvestor;
import com.sxt.inter.IBorrowPlan;
import com.sxt.inter.ILdProductExtendInfo;
import com.sxt.inter.IMemberMoney;
import com.sxt.inter.IMemberMoneyDetail;
import com.sxt.inter.IMembers;
import com.sxt.inter.INewHandProduct;
import com.sxt.inter.INewHandProductDetail;
import com.sxt.inter.IRepaymentDetail;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.inter.dto.MemberMoneyDto;
import com.sxt.models.BorrowInvestor;
import com.sxt.models.BorrowPlan;
import com.sxt.models.LdProductExtendInfo;
import com.sxt.models.MemberMoneyDetail;
import com.sxt.models.Members;
import com.sxt.models.NewHandProduct;
import com.sxt.models.NewHandProductDetail;
import com.sxt.models.RepaymentDetail;
import com.sxt.service.product.NewHandProductService;
import com.sxt.util.ModelConvertToVo;
@Service
public class NewHandProductServiceImpl implements NewHandProductService {
	
	private static Log logger = LogFactory.getLog(NewHandProductService.class);
	@Autowired
	private INewHandProduct iNewHandProduct;
	
	@Autowired
	private INewHandProductDetail newHandProductDetail;
	
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
	private ILdProductExtendInfo  iLdProductExtendInfo;
	
	
	public List<NewHandProduct> fQueryProduct() {
		return iNewHandProduct.fQueryProduct();
	}
	
	@Override
	public NewHandProduct fqueryProductById(String productId) {
		// TODO Auto-generated method stub
		return iNewHandProduct.fqueryProductById(productId);
	}

	@Override
	public void fUpdateStateByProid(String productId) {
		// TODO Auto-generated method stub
		iNewHandProduct.fUpdateStateByProid(productId);
	}
	@Override
	public String[] fQueryProductIds(){
		return iNewHandProduct.fQueryProductIds();
	}
	
	
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	@Override
	public void payProduct(String productId, BigDecimal investmoney, String systemtradeno,LocalUserDto lud, String ip){
	}
	

	
	public String queryNewHandProduct(String proid){
		return iNewHandProduct.queryNewHandProduct(proid);
	}
}
