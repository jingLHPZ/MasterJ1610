package com.sxt.inter.dto;

import java.math.BigDecimal;
import java.util.Date;

public class RewardRecordDto{

	/**校验码 */
	private String content;
	/**金额 */
	private BigDecimal proValue;
	/**类型 */
	private int type;
	/**领取时间 */
	private Date useTime;
	/**过期时间 */
	private Date expireTime;
	/**备注 */
	private String memo;
	/**项目Id*/
	private String productId;
	/**项目名称*/
	private String productName;
	/**使用时间 */
	private Date createTime;
	/**项目类型*/
	private int productType;
	
	private Date updateTime;
	
	public int getProductType()
	{
		return productType;
	}
	public void setProductType(int productType)
	{
		this.productType = productType;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public BigDecimal getProValue()
	{
		return proValue;
	}
	public void setProValue(BigDecimal proValue)
	{
		this.proValue = proValue;
	}
	public int getType()
	{
		return type;
	}
	public void setType(int type)
	{
		this.type = type;
	}
	public Date getUseTime()
	{
		return useTime;
	}
	public void setUseTime(Date useTime)
	{
		this.useTime = useTime;
	}
	public Date getExpireTime()
	{
		return expireTime;
	}
	public void setExpireTime(Date expireTime)
	{
		this.expireTime = expireTime;
	}
	public String getMemo()
	{
		return memo;
	}
	public void setMemo(String memo)
	{
		this.memo = memo;
	}
	public String getProductId()
	{
		return productId;
	}
	public void setProductId(String productId)
	{
		this.productId = productId;
	}
	public String getProductName()
	{
		return productName;
	}
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	public Date getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
