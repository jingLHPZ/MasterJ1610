package com.sxt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sxt.inter.dto.FormConvertToVo;
import com.sxt.models.NewsNotice;
import com.sxt.page.util.Page;
import com.sxt.page.util.PageUtils;
import com.sxt.service.NewsNoticeService;

@Controller
@RequestMapping("newsnotice")
public class NewsNoticeController
{
	@Autowired
	private NewsNoticeService nowsNoticeSevice;
	@RequestMapping("fquerynewsnotice.htm")
	public ModelAndView fquerynewsnotice(){
		ModelAndView mav=new ModelAndView("../../selfaboutus/a_notice");
		List<NewsNotice> newsnoticelist=nowsNoticeSevice.fquerynewsnotice();
		mav.addObject("newsnoticelist",newsnoticelist);
		return mav;
	}
	@RequestMapping("fquerynotice.htm")
	public ModelAndView fquerynoticecontent(@RequestParam("newsid") int newsid){
		ModelAndView mav=new ModelAndView("../../selfaboutus/a_notice_xq");
		NewsNotice newsnotice= nowsNoticeSevice.fquerynewscontent(newsid);
		mav.addObject("newsnotice",newsnotice);
		return mav;
	}
	@RequestMapping("fqueryallnotice{pageNo}.htm")
	public ModelAndView fqueryallnotice(@PathVariable("pageNo") Integer pageNo,HttpServletRequest request){
		ModelAndView mav=new ModelAndView("../../selfaboutus/a_notice");
		Page<NewsNotice> proPage = PageUtils.getPage(request);
		proPage.setPageNo(1);
		if(pageNo != null){
			proPage.setPageNo(pageNo);
		}
		Map<String, Object> map = FormConvertToVo.covertToPage(proPage);
		Integer count = nowsNoticeSevice.queryAllNoticeCount();
		List<NewsNotice> newsnoticelist = null;
		if(count>0){
			newsnoticelist=nowsNoticeSevice.fqueryallnotice(map);	
		}
		mav.addObject("newsnoticelist",newsnoticelist);
		proPage.setResult(newsnoticelist);
		proPage.setTotalCount(count);
		mav.addObject("proPage",proPage);
		return mav;
	}
}
