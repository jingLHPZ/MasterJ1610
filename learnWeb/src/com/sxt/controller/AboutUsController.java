package com.sxt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sxt.service.MessageService;

@Controller
@RequestMapping("/aboutus")
public class AboutUsController extends AbstractGeneralController
{
	@Autowired
	private MessageService messageService;
	@RequestMapping("/querySecurity.htm")
	public ModelAndView querySecurity(HttpServletRequest request){
		ModelAndView model=new ModelAndView("../../selfaboutus/security");
		return model;
	}
	@RequestMapping("/queryAboutUs.htm")
	public ModelAndView queryAboutUs(HttpServletRequest request){
		ModelAndView model=new ModelAndView("../../selfaboutus/a_CompanyProfile");
		return model;
	}
	@RequestMapping("/queryPayZn.htm")
	public ModelAndView queryPayZn(HttpServletRequest request){
		ModelAndView model=new ModelAndView("../../selfaboutus/payZn");
		return model;
	}
}
