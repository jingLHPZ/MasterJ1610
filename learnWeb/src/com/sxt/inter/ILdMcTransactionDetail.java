package com.sxt.inter;

import com.sxt.models.LdMcTransactionDetail;

/**
 * 民生支付详情
 * @author 
 * @date：2015年12月30日 下午5:51:09
 * 
 */
public interface ILdMcTransactionDetail {

	/**
	 * 通过商户号查询明细
	 * @param merOrderId
	 * @return
	 */
	public LdMcTransactionDetail selectByMerOrderId(String merOrderId);
	
	/**
	 * 新增消费记录
	 * @param mcTransactionDetail
	 */
	public void insert(LdMcTransactionDetail mcTransactionDetail);
	
	/**
	 * 更新明细状态
	 * @param mcTransactionDetail
	 */
	public void updatePayStatus(LdMcTransactionDetail mcTransactionDetail);
}
