package com.sxt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.INewsInformation;
import com.sxt.models.NewsInformation;
import com.sxt.service.NewsInformationService;
@Service
public class NewsInformationServiceImpl implements NewsInformationService
{
	@Autowired
	private INewsInformation iNewsInformation;
	
	public List<NewsInformation> fqueryinformation()
	{
		return iNewsInformation.fqueryinformation();
	}
	public NewsInformation fqueryinfocontent(int newsid)
	{
		return iNewsInformation.fqueryinfocontent(newsid);
	}
	public List<NewsInformation> fqueryallinfo(Map<String,Object> map)
	{
		return iNewsInformation.fqueryallinfo(map);
	}
	public Integer queryAllInfoCount() {
		return iNewsInformation.queryAllInfoCount();
	}

}
