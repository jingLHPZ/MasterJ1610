package com.sxt.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.inter.ILdMemberBankCardInfo;
import com.sxt.inter.IMemberMoney;
import com.sxt.inter.IMemberMoneyDetail;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.models.LdAllInPayTransactionDetail;
import com.sxt.models.LdMemberBankCardInfo;
import com.sxt.service.LdMemberBankCardInfoService;
import com.sxt.tonglian.dto.PayQueryResponseDto;
import com.sxt.tonglian.dto.SinglePayRequestDto;

@Service
public class LdMemberBankCardInfoServiceImpl implements LdMemberBankCardInfoService{
	
	private static Logger logger = LoggerFactory.getLogger(LdMemberBankCardInfoServiceImpl.class);
	@Autowired
	private ILdMemberBankCardInfo iLdMemberBankCardInfo;
	@Autowired
	private IMemberMoney iMemberMoney;
	@Autowired
	private IMemberMoneyDetail iMemberMoneyDetail;
	
	
	public void updateBankCardInfoByUidAndStatus(LdMemberBankCardInfo param) {
	}

	@Override
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, rollbackFor={RuntimeException.class, Exception.class})
	public PayQueryResponseDto bindCard(SinglePayRequestDto singlePayRequestDto,
			LdAllInPayTransactionDetail ldAllInPayTransactionDetail,LocalUserDto lud) {
		return null;
	}

	@Override
	public LdMemberBankCardInfo selectByUidAndStatusAndCardNo(
			LdMemberBankCardInfo param) {
		return iLdMemberBankCardInfo.selectByUidAndStatusAndCardNo(param);
	}
	
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, rollbackFor={RuntimeException.class, Exception.class})
	public void updateMemberMoneyAndDetail(LocalUserDto lud) {
	}
	
	public LdAllInPayTransactionDetail getAllInPayByUid(Integer uid) {
		return iLdMemberBankCardInfo.getAllInPayByUid(uid);
	}
	
	public void updateMemberBankCardInfoByCardNo(LdMemberBankCardInfo bankCardInfo) {
		iLdMemberBankCardInfo.updateMemberBankCardInfoByCardNo(bankCardInfo);
	}
}
