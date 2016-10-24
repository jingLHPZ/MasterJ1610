package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.NewsNotice;


public interface INewsNotice
{
	public List<NewsNotice> fquerynewsnotice();
	
	public NewsNotice fquerynewscontent(int newsid);
	
	public List<NewsNotice> fqueryallnotice(Map<String,Object> map);
	
	public Integer queryAllNoticeCount();
}
