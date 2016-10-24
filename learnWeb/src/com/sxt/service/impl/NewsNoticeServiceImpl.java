package com.sxt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.INewsNotice;
import com.sxt.models.NewsNotice;
import com.sxt.service.NewsNoticeService;
@Service
public class NewsNoticeServiceImpl implements NewsNoticeService
{
	@Autowired
	private INewsNotice iNewsNotice;
	public List<NewsNotice> fquerynewsnotice()
	{
		return iNewsNotice.fquerynewsnotice();
	}
	public NewsNotice fquerynewscontent(int newsid)
	{
		return iNewsNotice.fquerynewscontent(newsid);
	}
	public List<NewsNotice> fqueryallnotice(Map<String, Object> map) {
		return iNewsNotice.fqueryallnotice(map);
	}
	public Integer queryAllNoticeCount() {
		return iNewsNotice.queryAllNoticeCount();
	}
}
