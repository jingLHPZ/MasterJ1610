package com.sxt.inter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sxt.models.CashAccount;
import com.sxt.models.CashAccountDetailDto;
import com.sxt.models.CashProduct;
import com.sxt.models.CashTransit;
import com.sxt.models.IncomeRate;

public interface ICash {

	public List<CashTransit> getTransitByUid(Map<String, Object> param);
	
	public Integer getTransitCountByUid(Map<String, Object> param);
	
	public List<CashAccountDetailDto> getDetailByUid(Map<String, Object> param);
	
	public Integer getDetailCountByUid(Map<String, Object> param);

	public CashAccount getCashAccountByUid(Integer uid);
	
	public CashProduct selectCashProduct();
	
	public IncomeRate queryNewIncomeRate();
	
	public List<IncomeRate> querySevenIncomeRate();
	
	public BigDecimal selectCashMoneyByType(Map<String, Object> param);
	
	public Integer getTotalUsers();
	
	public BigDecimal getTotalIncome();
	
	public CashTransit getTransitInfoByUid(Map<String, Object> param);
}
