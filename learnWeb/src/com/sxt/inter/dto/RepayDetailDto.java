package com.sxt.inter.dto;

import java.math.BigDecimal;
import java.util.Date;

public class RepayDetailDto {
	/**项目Id*/
	private String productId;
	/** 产品名称 */
	private String productName;
	/** 还款时间 */
	private Date repaymentTime;
	/**回款本金 */
	private BigDecimal capital;
	/**回款利息 */
	private BigDecimal interest;
	/**期数 */
	private Integer sortOrder;
	/**总共期数 */
	private Integer total;
	/**投资的本金*/
	private BigDecimal investorCapital;
	/**项目类型*/
	private Integer productType;
	//实际还款时间
	private Date realReturnDate;
	
	private String systemTraceNo;
	
	public String getProductId()
	{
		return productId;
	}
	public void setProductId(String productId)
	{
		this.productId = productId;
	}
	public Integer getProductType()
	{
		return productType;
	}
	public void setProductType(Integer productType)
	{
		this.productType = productType;
	}
	public String getProductName()
	{
		return productName;
	}
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	public Date getRepaymentTime()
	{
		return repaymentTime;
	}
	public void setRepaymentTime(Date repaymentTime)
	{
		this.repaymentTime = repaymentTime;
	}
	public BigDecimal getCapital()
	{
		return capital;
	}
	public void setCapital(BigDecimal capital)
	{
		this.capital = capital;
	}
	public BigDecimal getInterest()
	{
		return interest;
	}
	public void setInterest(BigDecimal interest)
	{
		this.interest = interest;
	}
	public Integer getSortOrder()
	{
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder)
	{
		this.sortOrder = sortOrder;
	}
	public Integer getTotal()
	{
		return total;
	}
	public void setTotal(Integer total)
	{
		this.total = total;
	}
	public BigDecimal getInvestorCapital()
	{
		return investorCapital;
	}
	public void setInvestorCapital(BigDecimal investorCapital)
	{
		this.investorCapital = investorCapital;
	}
	public Date getRealReturnDate() {
		return realReturnDate;
	}
	public void setRealReturnDate(Date realReturnDate) {
		this.realReturnDate = realReturnDate;
	}
	public String getSystemTraceNo() {
		return systemTraceNo;
	}
	public void setSystemTraceNo(String systemTraceNo) {
		this.systemTraceNo = systemTraceNo;
	}
	
}
