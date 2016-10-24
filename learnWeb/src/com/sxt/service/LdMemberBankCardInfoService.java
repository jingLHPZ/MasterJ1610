package com.sxt.service;

import com.sxt.inter.dto.LocalUserDto;
import com.sxt.models.LdAllInPayTransactionDetail;
import com.sxt.models.LdMemberBankCardInfo;
import com.sxt.tonglian.dto.PayQueryResponseDto;
import com.sxt.tonglian.dto.SinglePayRequestDto;

public interface LdMemberBankCardInfoService {
	
	public LdMemberBankCardInfo selectByUidAndStatusAndCardNo(LdMemberBankCardInfo param);
	
	public void updateBankCardInfoByUidAndStatus(LdMemberBankCardInfo param);
	
	public PayQueryResponseDto bindCard(SinglePayRequestDto singlePayRequestDto,LdAllInPayTransactionDetail param,LocalUserDto lud);
	
	public void updateMemberMoneyAndDetail(LocalUserDto lud);
	
	public LdAllInPayTransactionDetail getAllInPayByUid(Integer uid);
	
	public void updateMemberBankCardInfoByCardNo(LdMemberBankCardInfo bankCardInfo);
	
}
