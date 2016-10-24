package com.sxt.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.ICiProduct;
import com.sxt.inter.ICiProductDetail;
import com.sxt.inter.ILdContractInfo;
import com.sxt.inter.IRewardRecord;
import com.sxt.inter.ISiProduct;
import com.sxt.inter.ISiProductDetail;
import com.sxt.models.BorrowInvestor;
import com.sxt.service.LdContractService;
import com.sxt.util.DateUtil;

/**
 * LdContractServiceImpl.java
 * 
 * @Description 电子合同生成实例
 * @author 
 * @date 2015年12月31日 上午10:58:17
 * @version 1.0
 */
@Service
public class LdContractServiceImpl implements LdContractService {

	@Autowired
	ILdContractInfo iLdContractInfo;
	
	@Autowired
	ISiProduct iSiProduct;
	
	@Autowired
	ISiProductDetail iSiProductDetail;
	
	@Autowired
	ICiProduct iCiProduct;
	
	@Autowired
	ICiProductDetail iCiProductDetail;
	
	@Autowired
	IRewardRecord iRewardRecord;
	
	private static Log logger = LogFactory.getLog(LdContractServiceImpl.class);


	/**
	 * 电子合同生成
	 */
	@Override
	public String GenerateContractFile(String produId, String flag, BorrowInvestor borrowInvestorinfo) {
		return null;
	}
	
	
	/**
	 * 债权转让模板数据组装
	 * @param map
	 * @return
	 */
	public String setParamAssign(Map<String,Object> map){
		
		return "success";
	}
	
	/**
	 * 权益转让模板数据组装
	 * @param map
	 * @return
	 */
	public String setParamEquity(Map<String,Object> map){
		
		return "success";
	}
	
	
	/**
	 * 拼接付息日 (month)
	 * 
	 * @return
	 */
	public String[] getInterestMonth(Date begin, int month) {
		String[] interestdate = {"","",""};
		for (int i = 1; i <= month; i++) {
			Calendar calendar = Calendar.getInstance(); // 得到日历
			calendar.setTime(begin);
			calendar.add(Calendar.MONTH, i);
			if(i>6 && i<=12) {
				interestdate[1] += DateUtil.dtSimpleFormat(calendar.getTime()) + ",";
			} else if(i>12) {
				interestdate[2] += DateUtil.dtSimpleFormat(calendar.getTime()) + ",";
			} else {
				interestdate[0] += DateUtil.dtSimpleFormat(calendar.getTime()) + ",";
			}
			// 先按周期加
			if(i==month) {
				if(StringUtils.isNotEmpty(interestdate[2])) {
					interestdate[2] = interestdate[2].substring(0, interestdate[2].length()-1);
				}
				if(StringUtils.isNotEmpty(interestdate[1])) {
					interestdate[1] = interestdate[1].substring(0, interestdate[1].length()-1);
				}
				if(StringUtils.isNotEmpty(interestdate[0])) {
					interestdate[0] = interestdate[0].substring(0, interestdate[0].length()-1);
				}
			}
		}
		return interestdate;
	}
	
	/**
	 * 拼接付息日 (day)
	 * 
	 * @return
	 */
	public String getInterestDay(Date begin, int day) {
		Calendar calendar = Calendar.getInstance(); // 得到日历
		calendar.setTime(begin);
		// 先按周期加
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return DateUtil.dtSimpleFormat(calendar.getTime());
	}
	
	@Override
	public List<Map<String, Object>> findContractInfo(Map<String, Object> map) {
		return iLdContractInfo.findContractInfo(map);
	}
}
