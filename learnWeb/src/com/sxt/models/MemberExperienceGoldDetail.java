package com.sxt.models;

import java.io.Serializable;
import java.util.Date;

public class MemberExperienceGoldDetail implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer uid;
	private Integer type;
	private Integer affectexperiencegold;
	private Integer totalexperiencegold;
	private String info;
	private Date createtime;
	private String addip;
	private String systemtraceno;
	private Integer operateMode;
	
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
	public Integer getType()
	{
		return type;
	}
	public void setType(Integer type)
	{
		this.type = type;
	}
	public Integer getAffectexperiencegold()
	{
		return affectexperiencegold;
	}
	public void setAffectexperiencegold(Integer affectexperiencegold)
	{
		this.affectexperiencegold = affectexperiencegold;
	}
	public Integer gettotalexperiencegold()
	{
		return totalexperiencegold;
	}
	public void settotalexperiencegold(Integer totalexperiencegold)
	{
		this.totalexperiencegold = totalexperiencegold;
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
	public String getAddip()
	{
		return addip;
	}
	public void setAddip(String addip)
	{
		this.addip = addip;
	}
	public String getSystemtraceno()
	{
		return systemtraceno;
	}
	public void setSystemtraceno(String systemtraceno)
	{
		this.systemtraceno = systemtraceno;
	}
	public MemberExperienceGoldDetail(Integer id, Integer uid, Integer type,
			Integer affectexperiencegold, Integer totalexperiencegold,
			String info, Date createtime, String addip, String systemtraceno)
	{
		super();
		this.id = id;
		this.uid = uid;
		this.type = type;
		this.affectexperiencegold = affectexperiencegold;
		this.totalexperiencegold = totalexperiencegold;
		this.info = info;
		this.createtime = createtime;
		this.addip = addip;
		this.systemtraceno = systemtraceno;
	}
	public MemberExperienceGoldDetail()
	{
		super();
	}
	public Integer getOperateMode() {
		return operateMode;
	}
	public void setOperateMode(Integer operateMode) {
		this.operateMode = operateMode;
	}
}
