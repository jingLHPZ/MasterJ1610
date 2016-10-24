package com.sxt.models;

import java.io.Serializable;
import java.util.Date;

public class NewsNotice implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer newsid;
	private String newstitle;
	private String newscontent;
	private String newsurl;
	private Date createdate;
	private Integer newsorder;
	private Integer status;
	
	public Integer getNewsid()
	{
		return newsid;
	}
	public void setNewsid(Integer newsid)
	{
		this.newsid = newsid;
	}
	public String getNewstitle()
	{
		return newstitle;
	}
	public void setNewstitle(String newstitle)
	{
		this.newstitle = newstitle;
	}
	public String getNewscontent()
	{
		return newscontent;
	}
	public void setNewscontent(String newscontent)
	{
		this.newscontent = newscontent;
	}
	public String getNewsurl()
	{
		return newsurl;
	}
	public void setNewsurl(String newsurl)
	{
		this.newsurl = newsurl;
	}
	public Date getCreatedate()
	{
		return createdate;
	}
	public void setCreatedate(Date createdate)
	{
		this.createdate = createdate;
	}
	public Integer getNewsorder()
	{
		return newsorder;
	}
	public void setNewsorder(Integer newsorder)
	{
		this.newsorder = newsorder;
	}
	public NewsNotice(Integer newsid, String newstitle, String newscontent,
			String newsurl, Date createdate, Integer newsorder)
	{
		super();
		this.newsid = newsid;
		this.newstitle = newstitle;
		this.newscontent = newscontent;
		this.newsurl = newsurl;
		this.createdate = createdate;
		this.newsorder = newsorder;
	}
	public NewsNotice()
	{
		super();
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
