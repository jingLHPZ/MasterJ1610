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
import com.sxt.models.NewsInformation;
import com.sxt.page.util.Page;
import com.sxt.page.util.PageUtils;
import com.sxt.service.NewsInformationService;
import com.sxt.service.NewsNoticeService;

@Controller
@RequestMapping("newsinformation")
public class NewsInformationController
{	
	@Autowired
	private NewsInformationService newsInformationService;
	@Autowired
	private NewsNoticeService nowsNoticeSevice;
	@RequestMapping("fquerynewsinformation.htm")
	public ModelAndView fquerynewsinformation(){
		ModelAndView mav=new ModelAndView("../../selfaboutus/a_journalism");
		List<NewsInformation> newsinformationlist=newsInformationService.fqueryinformation();
		mav.addObject("newsinformationlist",newsinformationlist);
		return mav;
	}
	@RequestMapping("fqueryinfocontent.htm")
	public ModelAndView fqueryinfocontent(@RequestParam("newsid") int newsid){
		ModelAndView mav=new ModelAndView("../../selfaboutus/a_journalism_xq");
		NewsInformation newsinfo=newsInformationService.fqueryinfocontent(newsid);
		mav.addObject("newsinfo",newsinfo);
		return mav;
	}
	/**
	 * 行业新闻
	 * @param request
	 * @return
	 */
	@RequestMapping("/fqueryallinformation{pageNo}.htm")
	public ModelAndView fqueryallnewsinformation(@PathVariable("pageNo") Integer pageNo,HttpServletRequest request){
		ModelAndView mav=new ModelAndView("../../selfaboutus/a_journalism");
		Page<NewsInformation> proPage = PageUtils.getPage(request);
		proPage.setPageNo(1);
		if(pageNo != null){
			proPage.setPageNo(pageNo);
		}
		Map<String, Object> map = FormConvertToVo.covertToPage(proPage);
		Integer count = newsInformationService.queryAllInfoCount();
		List<NewsInformation> newsinformationlist = null;
		if(count>0){
			newsinformationlist=newsInformationService.fqueryallinfo(map);	
		}
		mav.addObject("newsinformationlist",newsinformationlist);
		proPage.setResult(newsinformationlist);
		proPage.setTotalCount(count);
		mav.addObject("proPage",proPage);
		return mav;
	}
	
	@RequestMapping("raise.htm")
	public ModelAndView raiseformation(){
		ModelAndView mav=new ModelAndView("../../selfaboutus/raise");
		return mav;
	}
	
	@RequestMapping("raiseMb.htm")
	public ModelAndView raiseMb(){
		ModelAndView mav=new ModelAndView("../../selfaboutus/raiseMb");
		return mav;
	}
	
	@RequestMapping("recruit.htm")
	public ModelAndView recruitZfdl(){
		ModelAndView mav=new ModelAndView("../../selfaboutus/recruit_zfdl");
		return mav;
	}
	
	@RequestMapping("contractZfdl.htm")
	public ModelAndView contractZfdl(){
		ModelAndView mav=new ModelAndView("../../selfaboutus/contract_zfdl");
		return mav;
	}
	
	@RequestMapping("hainan.htm")
	public ModelAndView hainan(){
		ModelAndView mav=new ModelAndView("../../selfaboutus/haihang");
		return mav;
	}
	
	@RequestMapping("yingxiang.htm")
	public ModelAndView yingxinag(){
		ModelAndView mav=new ModelAndView("../../selfaboutus/yingxiang");
		return mav;
	}
	
	@RequestMapping("gtyx.htm")
	public ModelAndView gtyx(){
		ModelAndView mav=new ModelAndView("../../selfaboutus/gtyx");
		return mav;
	}
	
	@RequestMapping("tf.htm")
	public ModelAndView gt(){
		ModelAndView mav=new ModelAndView("../../selfaboutus/tf");
		return mav;
	}
	
	@RequestMapping("ngb.htm")
	public ModelAndView ngb(){
		ModelAndView mav=new ModelAndView("../../selfaboutus/ngb");
		return mav;
	}
	
	
	
	
	
	
	
}
