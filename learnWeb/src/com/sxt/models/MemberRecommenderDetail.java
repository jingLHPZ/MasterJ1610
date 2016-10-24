package com.sxt.models;

import java.io.Serializable;
import java.util.Date;

public class MemberRecommenderDetail implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer uid;
	private String mobilephone;
	private String mobilephone2;
	private String info;
	private Date createtime;
	//展示属性
	private Members members;
	private Integer investorNum;
	public Integer getInvestorNum() {
		return investorNum;
	}
	public void setInvestorNum(Integer investorNum) {
		this.investorNum = investorNum;
	}
	
	public Members getMembers() {
		return members;
	}
	public void setMembers(Members members) {
		this.members = members;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getUid()
	{
		return uid;
	}
	public void setUid(Integer uid)
	{
		this.uid = uid;
	}
	public String getMobilephone()
	{
		return mobilephone;
	}
	public void setMobilephone(String mobilephone)
	{
		this.mobilephone = mobilephone;
	}
	public String getMobilephone2()
	{
		return mobilephone2;
	}
	public void setMobilephone2(String mobilephone2)
	{
		this.mobilephone2 = mobilephone2;
	}
	public String getInfo()
	{
		return info;
	}
	public void setInfo(String info)
	{
		this.info = info;
	}
	public Date getCreatetime()
	{
		return createtime;
	}
	public void setCreatetime(Date createtime)
	{
		this.createtime = createtime;
	}
	
}
