package com.sxt.models;

import java.util.Date;
import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 盈享理财产品表类 ld_yingxiang_product
 * @author 
 * @date 2016-04-14
 */
public class LdYingxiangProduct  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	private String productId;

	/**
	 * 借款名称
	 */
	private String productName;

	/**
	 * 借款人id
	 */
	private Integer borrowUid;

	/**
	 * 借款期
	 */
	private Integer borrowMonthDuration;

	/**
	 * 借款期
	 */
	private Integer borrowDayDuration;

	/**
	 * 借款金额
	 */
	private BigDecimal borrowMoney;

	/**
	 * 利息
	 */
	private BigDecimal borrowInterest;

	/**
	 * 借款利率（年化）
	 */
	private Float borrowInterestRate;

	/**
	 * 借款费
	 */
	private BigDecimal borrowFee;

	/**
	 * 偿还本金
	 */
	private BigDecimal repaymentMoney;

	/**
	 * 偿还利息
	 */
	private BigDecimal repaymentInterest;

	/**
	 * 逾期还款金额
	 */
	private BigDecimal expiredMoney;

	/**
	 * 还款类型 (4 每月等额本金)
	 */
	private Integer repaymentType;

	/**
	 * 借款类型
	 */
	private Integer borrowType;

	/**
	 * 手续费率
	 */
	private Float borrowProceduresRate;

	/**
	 * 借款状态 (0 新增 1 初审核 2复审 3 投资中 4 满标 5 流标 6 还款中 7 停止发布 8 完成)
	 */
	private Integer borrowStatus;

	/**
	 * 合同编号
	 */
	private String contractID;

	/**
	 * 
	 */
	private Date createTime;

	/**
	 * 
	 */
	private Date updateTime;

	/**
	 * 筹集开始时间
	 */
	private Date collectStartTime;

	/**
	 * 满标时间
	 */
	private Date fullTime;

	/**
	 * 结束时间
	 */
	private Date deadline;

	/**
	 * 最终还款日
	 */
	private Date lastTime;

	/**
	 * 审核时间
	 */
	private Date checkTime;

	/**
	 * 合同模板
	 */
	private String contractTemplate;

	/**
	 * 初审后台用户
	 */
	private String checkUser;

	/**
	 * 复审后台用户
	 */
	private String checkUser2;

	/**
	 * 复审核时间
	 */
	private Date checkTime2;

	/**
	 * 
	 */
	private BigDecimal investFee;

	/**
	 * 
	 */
	private Float investRate;

	/**
	 * 筹集结束时间
	 */
	private Date collectEndTime;

	/**
	 * 借款编号
	 */
	private Integer borrowId;

	/**
	 * 涨中宝产品id
	 */
	private String ciProductId;

	/**
	 * 产品适用类型 1为涨中宝专用产品 2 散标,3:私募基金,4：盈享产品
	 */
	private Integer productAdaptedType;

	/**
	 * 产品排序id 从大到小
	 */
	private Integer productSort;

	/**
	 * 显示标记：1显示，2 为不显示
	 */
	private Integer displayFlag;

	/**
	 * 计息方式：1为满标日起息, 2 为筹集结束日起息
	 */
	private Integer interestWay;
	
	/**
	 * 已投金额
	 */
	private BigDecimal investMoney;
	
	/**
	 * 已投比例
	 */
	private BigDecimal processRate;
	
	/**
	 * 最小投资额
	 */
	private BigDecimal minInvest;
	
	/**
	 * 剩余金额
	 */
	private BigDecimal remainMoney;
	
	/**
	 * 投资用户总数
	 */
	private Integer totalInvestor;
	
	/**
	 * 还款方式
	 */
	private String repaymentTypeValue;
	
	/**
	 * 1为可用红包,0为不可用红包
	 */
	private Integer canBonus;

	/**
	 * 加息券 1为可用加息券 0为不可用加息券
	 */
	private Integer canAddInterest;
	
	private LdYingxiangProductDetail productDetail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getBorrowUid() {
		return borrowUid;
	}

	public void setBorrowUid(Integer borrowUid) {
		this.borrowUid = borrowUid;
	}

	public Integer getBorrowMonthDuration() {
		return borrowMonthDuration;
	}

	public void setBorrowMonthDuration(Integer borrowMonthDuration) {
		this.borrowMonthDuration = borrowMonthDuration;
	}

	public Integer getBorrowDayDuration() {
		return borrowDayDuration;
	}

	public void setBorrowDayDuration(Integer borrowDayDuration) {
		this.borrowDayDuration = borrowDayDuration;
	}

	public BigDecimal getBorrowMoney() {
		return borrowMoney;
	}

	public void setBorrowMoney(BigDecimal borrowMoney) {
		this.borrowMoney = borrowMoney;
	}

	public BigDecimal getBorrowInterest() {
		return borrowInterest;
	}

	public void setBorrowInterest(BigDecimal borrowInterest) {
		this.borrowInterest = borrowInterest;
	}

	public Float getBorrowInterestRate() {
		return borrowInterestRate;
	}

	public void setBorrowInterestRate(Float borrowInterestRate) {
		this.borrowInterestRate = borrowInterestRate;
	}

	public BigDecimal getBorrowFee() {
		return borrowFee;
	}

	public void setBorrowFee(BigDecimal borrowFee) {
		this.borrowFee = borrowFee;
	}

	public BigDecimal getRepaymentMoney() {
		return repaymentMoney;
	}

	public void setRepaymentMoney(BigDecimal repaymentMoney) {
		this.repaymentMoney = repaymentMoney;
	}

	public BigDecimal getRepaymentInterest() {
		return repaymentInterest;
	}

	public void setRepaymentInterest(BigDecimal repaymentInterest) {
		this.repaymentInterest = repaymentInterest;
	}

	public BigDecimal getExpiredMoney() {
		return expiredMoney;
	}

	public void setExpiredMoney(BigDecimal expiredMoney) {
		this.expiredMoney = expiredMoney;
	}

	public Integer getRepaymentType() {
		return repaymentType;
	}

	public void setRepaymentType(Integer repaymentType) {
		this.repaymentType = repaymentType;
	}

	public Integer getBorrowType() {
		return borrowType;
	}

	public void setBorrowType(Integer borrowType) {
		this.borrowType = borrowType;
	}

	public Float getBorrowProceduresRate() {
		return borrowProceduresRate;
	}

	public void setBorrowProceduresRate(Float borrowProceduresRate) {
		this.borrowProceduresRate = borrowProceduresRate;
	}

	public Integer getBorrowStatus() {
		return borrowStatus;
	}

	public void setBorrowStatus(Integer borrowStatus) {
		this.borrowStatus = borrowStatus;
	}

	public String getContractID() {
		return contractID;
	}

	public void setContractID(String contractID) {
		this.contractID = contractID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCollectStartTime() {
		return collectStartTime;
	}

	public void setCollectStartTime(Date collectStartTime) {
		this.collectStartTime = collectStartTime;
	}

	public Date getFullTime() {
		return fullTime;
	}

	public void setFullTime(Date fullTime) {
		this.fullTime = fullTime;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getContractTemplate() {
		return contractTemplate;
	}

	public void setContractTemplate(String contractTemplate) {
		this.contractTemplate = contractTemplate;
	}

	public String getCheckUser() {
		return checkUser;
	}

	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}

	public String getCheckUser2() {
		return checkUser2;
	}

	public void setCheckUser2(String checkUser2) {
		this.checkUser2 = checkUser2;
	}

	public Date getCheckTime2() {
		return checkTime2;
	}

	public void setCheckTime2(Date checkTime2) {
		this.checkTime2 = checkTime2;
	}

	public BigDecimal getInvestFee() {
		return investFee;
	}

	public void setInvestFee(BigDecimal investFee) {
		this.investFee = investFee;
	}

	public Float getInvestRate() {
		return investRate;
	}

	public void setInvestRate(Float investRate) {
		this.investRate = investRate;
	}

	public Date getCollectEndTime() {
		return collectEndTime;
	}

	public void setCollectEndTime(Date collectEndTime) {
		this.collectEndTime = collectEndTime;
	}

	public Integer getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(Integer borrowId) {
		this.borrowId = borrowId;
	}

	public String getCiProductId() {
		return ciProductId;
	}

	public void setCiProductId(String ciProductId) {
		this.ciProductId = ciProductId;
	}

	public Integer getProductAdaptedType() {
		return productAdaptedType;
	}

	public void setProductAdaptedType(Integer productAdaptedType) {
		this.productAdaptedType = productAdaptedType;
	}

	public Integer getProductSort() {
		return productSort;
	}

	public void setProductSort(Integer productSort) {
		this.productSort = productSort;
	}

	public Integer getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(Integer displayFlag) {
		this.displayFlag = displayFlag;
	}

	public Integer getInterestWay() {
		return interestWay;
	}

	public void setInterestWay(Integer interestWay) {
		this.interestWay = interestWay;
	}

	public BigDecimal getInvestMoney() {
		return investMoney;
	}

	public void setInvestMoney(BigDecimal investMoney) {
		this.investMoney = investMoney;
	}

	public BigDecimal getProcessRate() {
		return processRate;
	}

	public void setProcessRate(BigDecimal processRate) {
		this.processRate = processRate;
	}

	public BigDecimal getMinInvest() {
		return minInvest;
	}

	public void setMinInvest(BigDecimal minInvest) {
		this.minInvest = minInvest;
	}

	public BigDecimal getRemainMoney() {
		return remainMoney;
	}

	public void setRemainMoney(BigDecimal remainMoney) {
		this.remainMoney = remainMoney;
	}

	public Integer getTotalInvestor() {
		return totalInvestor;
	}

	public void setTotalInvestor(Integer totalInvestor) {
		this.totalInvestor = totalInvestor;
	}

	public String getRepaymentTypeValue() {
		return repaymentTypeValue;
	}

	public void setRepaymentTypeValue(String repaymentTypeValue) {
		this.repaymentTypeValue = repaymentTypeValue;
	}

	public LdYingxiangProductDetail getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(LdYingxiangProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	public Integer getCanBonus() {
		return canBonus;
	}

	public void setCanBonus(Integer canBonus) {
		this.canBonus = canBonus;
	}

	public Integer getCanAddInterest() {
		return canAddInterest;
	}

	public void setCanAddInterest(Integer canAddInterest) {
		this.canAddInterest = canAddInterest;
	}

}
