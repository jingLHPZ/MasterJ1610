package com.sxt.service.batch;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sxt.enums.UserAwardTypeEnum;
import com.sxt.models.MemberRecommenderDetail;
import com.sxt.service.BorrowInvestorService;
import com.sxt.service.LdMemberRewardService;
import com.sxt.service.MemberRecommenderDetailService;
import com.sxt.util.DateUtil;

/**
 *	邀请购买奖励job
 * @author 
 * @date：2015年12月8日 下午3:27:27
 * 
 */
@Component
public class RegBuyActivityJob {

	@Autowired
	private MemberRecommenderDetailService memberRecDetailService;
	@Autowired
	private BorrowInvestorService borrowInvestorService;
	@Autowired
	private LdMemberRewardService memberRewardService;
	
	public void regBugAward() {
		
		//	活动日期 2016-01-08 00:00 至 2016-03-09 00:00
		Calendar startTime = Calendar.getInstance();
		Calendar endTime = Calendar.getInstance();
		startTime.set(Calendar.YEAR, 2015); startTime.set(Calendar.MONTH, 0);
		startTime.set(Calendar.DATE, 8); startTime.set(Calendar.HOUR_OF_DAY, 0);
		startTime.set(Calendar.MINUTE, 0); startTime.set(Calendar.SECOND, 0);
		endTime.set(Calendar.YEAR, 2016); endTime.set(Calendar.MONTH, 2);
		endTime.set(Calendar.DATE, 9); endTime.set(Calendar.HOUR_OF_DAY, 0);
		endTime.set(Calendar.MINUTE, 0); endTime.set(Calendar.SECOND, 0);
		
		//	查询所有在活动期间注册的邀请人
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("startTime", DateUtil.simpleDate(startTime.getTime()));
		maps.put("endTime", DateUtil.simpleDate(endTime.getTime()));
		List<Map<String, Object>> uidList = memberRecDetailService.queryRecommenderUid(maps);
		
		//	2月和3月各奖励一次
		Calendar nowTime = Calendar.getInstance();
		int month = nowTime.get(Calendar.MONTH) + 1;
		if (month == 2) {
			maps.put("startTime", DateUtil.simpleDate(startTime.getTime()));
			endTime.set(Calendar.MONTH, 1);
			maps.put("endTime", DateUtil.simpleDate(endTime.getTime()));
		} else if (month == 3) {
			startTime.set(Calendar.MONTH, 1);
			maps.put("startTime", DateUtil.simpleDate(startTime.getTime()));
			endTime.set(Calendar.MONTH, 2);
			maps.put("endTime", DateUtil.simpleDate(endTime.getTime()));
		} else {
			return ;
		}
		
		if (uidList != null && uidList.size() > 0) {
			
			Map<String, Object> recmaps = new HashMap<String, Object>();
			
			for (Map<String, Object> map : uidList) {
				recmaps.put("uid", map.get("uid").toString());
				List<MemberRecommenderDetail> recDetailList = memberRecDetailService.fQueryRecordByMap(recmaps);
				
				//	查询被邀请人在时间期限内投资总额
				if (recDetailList != null && recDetailList.size() > 0) {
					StringBuffer userPhones = new StringBuffer();
					for (int i = 0; i < recDetailList.size(); i++) {
						userPhones.append("'");
						userPhones.append(recDetailList.get(0).getMobilephone2());
						userPhones.append("'");
						if (i < recDetailList.size() -1) userPhones.append(",");
					}
					
					maps.put("userPhones", userPhones);
					Map<String, Object> resultMap = borrowInvestorService.queryInvestMoneyByPhone(maps);
					
					//	给邀请人奖励金额
					double investTotalMoney = Double.valueOf(resultMap.get("investTotalMoney").toString());
					double awardMoney = 0;
					
					if (investTotalMoney >= 1 && investTotalMoney <= 499) {
						awardMoney = 20;
					} else if (investTotalMoney >= 500 && investTotalMoney <= 9999) {
						awardMoney = 50;
					} else if (investTotalMoney >= 10000 && investTotalMoney <= 99999) {
						awardMoney = 100;
					} else if (investTotalMoney >= 100000 && investTotalMoney <= 499999) {
						awardMoney = 200;
					} else if (investTotalMoney >= 500000) {
						awardMoney = 500;
					}
					
					if (awardMoney > 0) {
						memberRewardService.affordUserAward(UserAwardTypeEnum.RECOMMENDUSERBUY.getCode(), 
								(Integer)map.get("uid"), "127.0.0.1", null);
					}
				}
			}
		}
	}
}
