package com.sxt.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.base.utils.FormatHelper;
import com.sxt.enums.AccountTypeEnum;
import com.sxt.inter.ICiProduct;
import com.sxt.inter.ICiProductDetail;
import com.sxt.inter.ILdMessageLog;
import com.sxt.inter.ILdMessageTemplate;
import com.sxt.inter.ILdParameter;
import com.sxt.inter.IMemberExperienceGoldDetail;
import com.sxt.inter.IMemberMoney;
import com.sxt.inter.IMemberMoneyDetail;
import com.sxt.inter.IMemberScoreDetail;
import com.sxt.inter.IMembers;
import com.sxt.inter.IProduct;
import com.sxt.inter.IRewardRecord;
import com.sxt.inter.ISiProduct;
import com.sxt.inter.ISiProductDetail;
import com.sxt.inter.dto.IndexProductDto;
import com.sxt.models.CiProduct;
import com.sxt.models.CiProductDetail;
import com.sxt.models.LdMemberScoreDetail;
import com.sxt.models.LdMessageLog;
import com.sxt.models.LdMessageTemplate;
import com.sxt.models.LdParameter;
import com.sxt.models.MemberExperienceGoldDetail;
import com.sxt.models.MemberMoney;
import com.sxt.models.MemberMoneyDetail;
import com.sxt.models.Members;
import com.sxt.models.RewardRecord;
import com.sxt.models.SiProduct;
import com.sxt.models.SiProductDetail;
import com.sxt.service.MessageService;
import com.sxt.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private IProduct iProduct;
	@Autowired
	private ISiProduct siProduct;
	@Autowired
	private ISiProductDetail siProductDetail;
	@Autowired
	private ICiProduct ciProduct;
	@Autowired
	private ICiProductDetail ciProductDetail;
	@Autowired
	private IMemberMoney iMemberMoney;
	@Autowired
	private IMemberMoneyDetail iMemberMoneyDetail;
	@Autowired
	private IMembers imembers;
	@Autowired
	private IMemberExperienceGoldDetail iMemberExperienceGoldDetail;
	@Autowired
	private IMemberScoreDetail iMemberScoreDetail;
	@Autowired
	private IRewardRecord iRewardRecord;
	@Autowired
	private ILdMessageLog iLdMessageLog;
	@Autowired
	private MessageService messageService;
	@Autowired
	private ILdParameter iLdParameter;
	@Autowired
	private ILdMessageTemplate iLdMessageTemplate;
	
	public List<IndexProductDto> fQueryAllProduct(Map<String, Object> param)
	{
		return iProduct.fQueryAllProduct(param);
	}
	public int fCountAllProduct(Map<String, Object> param)
	{
		return iProduct.fCountAllProduct(param);
	}
	public List<IndexProductDto> fQueryAllSiproduct(Map<String, Object> param)
	{
		return iProduct.fQueryAllSiproduct(param);
	}
	public List<IndexProductDto> fQueryExperience(Map<String,Object> param)
	{
		return iProduct.fQueryExperience(param);
	}
	public List<IndexProductDto> getInvestCiproduct(Map<String, Object> param) {
		
		return iProduct.getInvestCiproduct(param);
	}
	
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, rollbackFor={RuntimeException.class, Exception.class})
	@Override
	public void userBuyProductAward(int uid, String productId, BigDecimal buyMoney, String ip) {
	}
	@Override
	public List<IndexProductDto> getSiAndPeProduct(Map<String, Object> param) {
		return iProduct.getSiAndPeProduct(param);
	}
	@Override
	public Integer getSiAndPeProductCount(Map<String, Object> param) {
		return iProduct.getSiAndPeProductCount(param);
	}

}
