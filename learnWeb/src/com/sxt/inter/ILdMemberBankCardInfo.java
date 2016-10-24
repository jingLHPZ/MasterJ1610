package com.sxt.inter;

import com.sxt.models.LdAllInPayTransactionDetail;
import com.sxt.models.LdMemberBankCardInfo;
import com.sxt.tonglian.dto.SinglePayRequestDto;

public interface ILdMemberBankCardInfo {
    
	public void updateBankCardInfoByUidAndStatus(LdMemberBankCardInfo param);
	
	public void insertAllInPay(LdAllInPayTransactionDetail param);
	
	public void bindCard(SinglePayRequestDto singlePayRequestDto,
			LdAllInPayTransactionDetail ldAllInPayTransactionDetail);
	
	public void updateAllInPayTransactionDetail(LdAllInPayTransactionDetail param);
	
	public void insertBankCardInfo(LdMemberBankCardInfo param);
	
	public LdMemberBankCardInfo selectByUidAndStatusAndCardNo(LdMemberBankCardInfo param);
	
	public LdAllInPayTransactionDetail getAllInPayByUid(Integer uid);
	
	public void updateMemberBankCardInfoByCardNo(LdMemberBankCardInfo bankCardInfo);
}