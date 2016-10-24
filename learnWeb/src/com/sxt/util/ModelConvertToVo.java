package com.sxt.util;

import java.math.BigDecimal;

import com.sxt.inter.dto.MemberMoneyDto;
import com.sxt.models.MemberMoney;

/**
 * 
 * @author liudonghui
 *
 */
public class ModelConvertToVo {
	
	/**
	 * convert member money dto
	 * @param memberMoney
	 * @return
	 */
	public static MemberMoneyDto convertToMemberMoneyDto(MemberMoney memberMoney){
		MemberMoneyDto memberMoneyDto = new MemberMoneyDto();
		if(memberMoney == null){
			return memberMoneyDto;
		}
		memberMoneyDto.setMoneyFreeze(BigDecimal.ZERO);
		if(memberMoney.getMoneyFreeze() != null){
			memberMoneyDto.setMoneyFreeze(memberMoney.getMoneyFreeze());
		}
		memberMoneyDto.setMoneyCollect(BigDecimal.ZERO);	
		if(memberMoney.getMoneyCollect() != null){
			memberMoneyDto.setMoneyCollect(memberMoney.getMoneyCollect());
		}
		memberMoneyDto.setAccountMoney(BigDecimal.ZERO);	
		if(memberMoney.getAccountMoney() != null){
			memberMoneyDto.setAccountMoney(memberMoney.getAccountMoney());
		}
		memberMoneyDto.setBackMoney(BigDecimal.ZERO);	
		if(memberMoney.getBackMoney() != null){
			memberMoneyDto.setBackMoney(memberMoney.getBackMoney());
		}
		memberMoneyDto.setCreditLimit(BigDecimal.ZERO);	
		if(memberMoney.getCreditLimit() != null){
			memberMoneyDto.setCreditLimit(memberMoney.getCreditLimit());
		}
		memberMoneyDto.setCreditCuse(BigDecimal.ZERO);	
		if(memberMoney.getCreditCuse() != null){
			memberMoneyDto.setCreditCuse(memberMoney.getCreditCuse());
		}
		memberMoneyDto.setBorrowVouchLimit(BigDecimal.ZERO);	
		if(memberMoney.getBorrowVouchLimit() != null){
			memberMoneyDto.setBorrowVouchLimit(memberMoney.getBorrowVouchLimit());
		}
		memberMoneyDto.setBorrowVouchCuse(BigDecimal.ZERO);	
		if(memberMoney.getBorrowVouchCuse() != null){
			memberMoneyDto.setBorrowVouchCuse(memberMoney.getBorrowVouchCuse());
		}
		memberMoneyDto.setInvestVouchLimit(BigDecimal.ZERO);
		if(memberMoney.getInvestVouchLimit() != null){
			memberMoneyDto.setInvestVouchLimit(memberMoney.getInvestVouchLimit());
		}
		memberMoneyDto.setInvestVouchCuse(BigDecimal.ZERO);	
		if(memberMoney.getInvestVouchCuse() != null){
			memberMoneyDto.setInvestVouchCuse(memberMoney.getInvestVouchCuse());
		}
		memberMoneyDto.setExperienceGold(BigDecimal.ZERO);
		if(memberMoney.getExperienceGold() != null){
			memberMoneyDto.setExperienceGold(memberMoney.getExperienceGold());
		}
		memberMoneyDto.setIncomeMoney(BigDecimal.ZERO);
		if(memberMoney.getIncomeMoney() != null){
			memberMoneyDto.setIncomeMoney(memberMoney.getIncomeMoney());
		}
		memberMoneyDto.setFreeWithdraw(BigDecimal.ZERO);
		if(memberMoney.getFreeWithdraw() != null){
			memberMoneyDto.setFreeWithdraw(memberMoney.getFreeWithdraw());
		}
		memberMoneyDto.setCanusemoney(BigDecimal.ZERO);
		if(memberMoney.getCanusemoney() != null){
			memberMoneyDto.setCanusemoney(memberMoney.getCanusemoney());
		}
		memberMoneyDto.setTotalScore(BigDecimal.ZERO.intValue());
		if(memberMoney.getTotalScore() != null){
			memberMoneyDto.setTotalScore(memberMoney.getTotalScore());
		}
		memberMoneyDto.setUid(memberMoney.getUid());
		memberMoneyDto.setCreateTime(memberMoney.getCreateTime());
		memberMoneyDto.setUpdateTime(memberMoney.getUpdateTime());
		memberMoneyDto.setVersion(memberMoney.getVersion());
		return memberMoneyDto;
	}
}
