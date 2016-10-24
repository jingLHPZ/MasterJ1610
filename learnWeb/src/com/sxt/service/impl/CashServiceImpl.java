package com.sxt.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.ICash;
import com.sxt.models.CashAccount;
import com.sxt.models.CashAccountDetailDto;
import com.sxt.models.CashProduct;
import com.sxt.models.CashTransit;
import com.sxt.models.IncomeRate;
import com.sxt.service.CashService;

@Service
public class CashServiceImpl implements CashService {

	@Autowired
	private ICash iCash;
	
	public List<CashTransit> getTransitByUid(Map<String, Object> param) {
		return iCash.getTransitByUid(param);
	}

	public Integer getTransitCountByUid(Map<String, Object> param) {
		return iCash.getTransitCountByUid(param);
	}

	public List<CashAccountDetailDto> getDetailByUid(Map<String, Object> param) {
		return iCash.getDetailByUid(param);
	}

	public Integer getDetailCountByUid(Map<String, Object> param) {
		return iCash.getDetailCountByUid(param);
	}

	public CashAccount getCashAccountByUid(Integer uid) {
		return iCash.getCashAccountByUid(uid);
	}

	public CashProduct selectCashProduct() {
		return iCash.selectCashProduct();
	}

	public IncomeRate queryNewIncomeRate() {
		return iCash.queryNewIncomeRate();
	}

	public List<IncomeRate> querySevenIncomeRate() {
		return iCash.querySevenIncomeRate();
	}

	public BigDecimal selectCashMoneyByType(Map<String, Object> param) {
		return iCash.selectCashMoneyByType(param);
	}

	public Integer getTotalUsers() {
		return iCash.getTotalUsers();
	}

	public BigDecimal getTotalIncome() {
		return iCash.getTotalIncome();
	}

	public CashTransit getTransitInfoByUid(Map<String, Object> param) {
		return iCash.getTransitInfoByUid(param);
	}
}
