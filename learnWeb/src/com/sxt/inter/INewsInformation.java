package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.NewsInformation;


public interface INewsInformation
{
	public List<NewsInformation> fqueryinformation();
	
	public NewsInformation fqueryinfocontent(int newsid);
	
	public List<NewsInformation> fqueryallinfo(Map<String,Object> map);
	
	public Integer queryAllInfoCount();
}
