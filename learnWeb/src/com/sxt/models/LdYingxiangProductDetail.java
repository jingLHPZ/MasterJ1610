package com.sxt.models;

import java.util.Date;
import java.math.BigDecimal;

import java.io.Serializable;

/**
 * 盈享理财产品详情表类 ld_yingxiang_product_detail
 * @author 
 * @date 2016-04-14
 */
public class LdYingxiangProductDetail  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 借款人id
	 */
	private String productId;

	/**
	 * 借款用途
	 */
	private Integer borrowType;

	/**
	 * 
	 */
	private Date datetime;

	/**
	 * 
	 */
	private String addIp;

	/**
	 * 借款备注
	 */
	private String borrowInfo;

	/**
	 * 排名(数字大排在前)
	 */
	private Integer total;

	/**
	 * 
	 */
	private BigDecimal hasPay;

	/**
	 * 部分金额
	 */
	private BigDecimal substituteMoney;

	/**
	 * 活动奖励担保汇率
	 */
	private Float rewardVouchRate;

	/**
	 * 奖励担保金额
	 */
	private BigDecimal rewardVouchMoney;

	/**
	 * 奖励类型 0 没有，1红包，2体验金 3积分
	 */
	private Integer rewardType;

	/**
	 * 奖励需投资最低金额
	 */
	private BigDecimal rewardMin;

	/**
	 * 奖励值
	 */
	private Float rewardValue;

	/**
	 * 最小投资
	 */
	private BigDecimal investMin;

	/**
	 * 最大投资
	 */
	private BigDecimal investMax;

	/**
	 * 提保会员
	 */
	private Integer vouchMember;

	/**
	 * 明码
	 */
	private String password;

	/**
	 * 是否推荐0：不推荐；1：推荐
	 */
	private Integer isRecommend;

	/**
	 * 信息披露
	 */
	private String informationDisclosure;

	/**
	 * 担保公司id
	 */
	private Integer vouchUid;

	/**
	 * 担保金额
	 */
	private BigDecimal vouchMoney;

	/**
	 * 自动投标最大金额，默认为0，即无限制
	 */
	private BigDecimal autoMaxLimit;

	/**
	 * 风控描述
	 */
	private String riskControl;

	/**
	 * 
	 */
	private Date updateTime;

	/**
	 * 罚息利率(按日配置）
	 */
	private Float expiredRate;

	/**
	 * 
	 */
	private Integer rewardTotalScore;

	/**
	 * 奖励体验金
	 */
	private BigDecimal rewardExperienceGold;

	/**
	 * 0:没有奖励方式1按比例 2按数值累计返 3按数值一次返
	 */
	private Integer rewardWay;

	/**
	 * 1为可用红包,0为不可用红包
	 */
	private Integer canBonus;

	/**
	 * 加息券 1为可用加息券 0为不可用加息券
	 */
	private Integer canAddInterest;

	/**
	 * 网签合同类型： 0：线上债权转让合同 1：金融产品收益权转让协议 2：非公开发行产品协议
	 */
	private Integer contractType;

	/**
	 * 投资递增金额
	 */
	private Integer increaseProgressively;

	/**
	 * 备用字段
	 */
	private String extField;

	/**
	 * 备用字段
	 */
	private Integer extField2;

	/**
	 * 投资金额版本号
	 */
	private Integer version;

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

	public Integer getBorrowType() {
		return borrowType;
	}

	public void setBorrowType(Integer borrowType) {
		this.borrowType = borrowType;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getAddIp() {
		return addIp;
	}

	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}

	public String getBorrowInfo() {
		return borrowInfo;
	}

	public void setBorrowInfo(String borrowInfo) {
		this.borrowInfo = borrowInfo;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public BigDecimal getHasPay() {
		return hasPay;
	}

	public void setHasPay(BigDecimal hasPay) {
		this.hasPay = hasPay;
	}

	public BigDecimal getSubstituteMoney() {
		return substituteMoney;
	}

	public void setSubstituteMoney(BigDecimal substituteMoney) {
		this.substituteMoney = substituteMoney;
	}

	public Float getRewardVouchRate() {
		return rewardVouchRate;
	}

	public void setRewardVouchRate(Float rewardVouchRate) {
		this.rewardVouchRate = rewardVouchRate;
	}

	public BigDecimal getRewardVouchMoney() {
		return rewardVouchMoney;
	}

	public void setRewardVouchMoney(BigDecimal rewardVouchMoney) {
		this.rewardVouchMoney = rewardVouchMoney;
	}

	public Integer getRewardType() {
		return rewardType;
	}

	public void setRewardType(Integer rewardType) {
		this.rewardType = rewardType;
	}

	public BigDecimal getRewardMin() {
		return rewardMin;
	}

	public void setRewardMin(BigDecimal rewardMin) {
		this.rewardMin = rewardMin;
	}

	public Float getRewardValue() {
		return rewardValue;
	}

	public void setRewardValue(Float rewardValue) {
		this.rewardValue = rewardValue;
	}

	public BigDecimal getInvestMin() {
		return investMin;
	}

	public void setInvestMin(BigDecimal investMin) {
		this.investMin = investMin;
	}

	public BigDecimal getInvestMax() {
		return investMax;
	}

	public void setInvestMax(BigDecimal investMax) {
		this.investMax = investMax;
	}

	public Integer getVouchMember() {
		return vouchMember;
	}

	public void setVouchMember(Integer vouchMember) {
		this.vouchMember = vouchMember;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

	public String getInformationDisclosure() {
		return informationDisclosure;
	}

	public void setInformationDisclosure(String informationDisclosure) {
		this.informationDisclosure = informationDisclosure;
	}

	public Integer getVouchUid() {
		return vouchUid;
	}

	public void setVouchUid(Integer vouchUid) {
		this.vouchUid = vouchUid;
	}

	public BigDecimal getVouchMoney() {
		return vouchMoney;
	}

	public void setVouchMoney(BigDecimal vouchMoney) {
		this.vouchMoney = vouchMoney;
	}

	public BigDecimal getAutoMaxLimit() {
		return autoMaxLimit;
	}

	public void setAutoMaxLimit(BigDecimal autoMaxLimit) {
		this.autoMaxLimit = autoMaxLimit;
	}

	public String getRiskControl() {
		return riskControl;
	}

	public void setRiskControl(String riskControl) {
		this.riskControl = riskControl;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Float getExpiredRate() {
		return expiredRate;
	}

	public void setExpiredRate(Float expiredRate) {
		this.expiredRate = expiredRate;
	}

	public Integer getRewardTotalScore() {
		return rewardTotalScore;
	}

	public void setRewardTotalScore(Integer rewardTotalScore) {
		this.rewardTotalScore = rewardTotalScore;
	}

	public BigDecimal getRewardExperienceGold() {
		return rewardExperienceGold;
	}

	public void setRewardExperienceGold(BigDecimal rewardExperienceGold) {
		this.rewardExperienceGold = rewardExperienceGold;
	}

	public Integer getRewardWay() {
		return rewardWay;
	}

	public void setRewardWay(Integer rewardWay) {
		this.rewardWay = rewardWay;
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

	public Integer getContractType() {
		return contractType;
	}

	public void setContractType(Integer contractType) {
		this.contractType = contractType;
	}

	public Integer getIncreaseProgressively() {
		return increaseProgressively;
	}

	public void setIncreaseProgressively(Integer increaseProgressively) {
		this.increaseProgressively = increaseProgressively;
	}

	public String getExtField() {
		return extField;
	}

	public void setExtField(String extField) {
		this.extField = extField;
	}

	public Integer getExtField2() {
		return extField2;
	}

	public void setExtField2(Integer extField2) {
		this.extField2 = extField2;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
