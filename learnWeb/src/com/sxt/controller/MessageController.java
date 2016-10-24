package com.sxt.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sxt.enums.MessageTypeEnum;
import com.sxt.enums.MessageVerifyCodeTypeEnum;
import com.sxt.inter.dto.FormConvertToVo;
import com.sxt.inter.dto.LocalUserDto;
import com.sxt.models.LdMessageLog;
import com.sxt.page.util.Page;
import com.sxt.page.util.PageUtils;
import com.sxt.service.MessageService;
import com.sxt.base.annotation.HttpTimesLimit;
import com.sxt.base.annotation.HttpTimesLimitContainer;
@Controller
@RequestMapping(value = "/message")
public class MessageController extends AbstractGeneralController
{

	@Autowired
	private MessageService messageService;

	
	
	/**
	 * 发送手机验证码
	 * @param user_phone
	 * @param messageType
	 * @param session
	 * @return
	 */
	@HttpTimesLimitContainer({
		 @HttpTimesLimit(key="SMS_60S_Rule",count=1,time=60000),
		 @HttpTimesLimit(key="SMS_5M_Rule",count=3,time=300000),
		 @HttpTimesLimit(key="SMS_1H_Rule",count=30,time=3600000)})
	@RequestMapping(value = "/sendMessage.htm", method = RequestMethod.POST)
	@ResponseBody
	public String sendMessageCode(HttpServletRequest request, @RequestParam(value = "user_phone", required = true) String user_phone,
			@RequestParam(value = "messageType", required = true) Integer messageType,
			HttpSession session) {
		String result = messageService.createRandomMessage(true, 6);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", result);
		Map<String, Object> para = new HashMap<String, Object>();
		para.put("code", result);
		para.put("userName", "");
		messageService.sendMessageVerifyCode(user_phone, MessageTypeEnum.NEW_MEMBER_MOBILE_VERIFY_CODE, para, "1", MessageVerifyCodeTypeEnum.getByCode(messageType));
		String json = "{\"success\":true," + "\"result\":\"" + result + "\"}";
		session.setAttribute("code"+messageType, result);
		return json;
	}
	
	@RequestMapping("/equalToCode.htm")
	public void equalToCode(String code,Integer messageType,HttpServletResponse response,HttpSession session) throws IOException{
		String msg="";
		if(!"".equals(code)){
			if(code.equals(session.getAttribute("code"+messageType))){
				msg="success";
			}else{
				msg="err";
			}
		}else{
			msg="err";
		}
		
		response.getWriter().write(msg);
	}
	/**
	 * 验证码发送次数
	 * @param request
	 * @param response
	 * @param map
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkYzm.htm", method = RequestMethod.POST)
	public void checkYzm(HttpServletRequest request,
			HttpServletResponse response, @RequestParam Map<String, Object> map)
			throws IOException
	{
		Integer nums=map.containsKey("userPhoneNums")?Integer.valueOf(map.get("userPhoneNums").toString()):5;
		response.setContentType("text/html;charset=UTF-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		map.put("createTime", sdf.format(new Date()));
		List list = messageService.checkCode(map);
		String msg = "";
		if (list.size() >= nums)
		{
			msg = "err";
		} else
		{
			msg = "success";
		}
		response.getWriter().write(msg);
	}
	
	/**
	 * 进入个人消息查看页面
	 * 且 read_status != D
	 * @return
	 */
	@RequestMapping(value = "/personMessage.htm", method = RequestMethod.GET)
	public ModelAndView sendMessage(HttpServletRequest request,
			HttpServletResponse response, @RequestParam Map<String, Object> maps){
		ModelAndView mv = new ModelAndView("person/stationnews");
		LocalUserDto currentUser = getLocalUser(request);
		Page<LdMessageLog> page = PageUtils.getPage(request);
		Map<String, Object> para = FormConvertToVo.covertToILdMessageLog(page);
		para.put("uid", currentUser.getUid());
		
		Integer count = messageService.fqueryMessageLogListPageCount(para);
		if(count > 0){
			List<LdMessageLog> messageList = messageService.fqueryMessageLogListPage(para);
			page.setResult(messageList);
			page.setTotalCount(count);
		}
		mv.addObject("page", page);
		return mv;
	}

	/**
	 * 进入个人消息查看页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryMessagePage.htm", method = RequestMethod.POST)
	public ModelAndView queryMessagePage(HttpServletRequest request,
			HttpServletResponse response, @RequestParam Map<String, Object> maps){
		ModelAndView mv = new ModelAndView("person/messageQueryResult");
		Page<LdMessageLog> page = PageUtils.getPage(request);
		LocalUserDto currentUser = getLocalUser(request);

		Map<String, Object> para = FormConvertToVo.covertToILdMessageLog(page);
		para.put("uid", currentUser.getUid());
		para.put("read_status", request.getParameter("readStatus")==""?null:request.getParameter("readStatus"));
		
		Integer count = messageService.selectMessageByPageCount(para);
		if(count > 0){
			List<LdMessageLog> messageList = messageService.selectMessageByPage(para);
			page.setResult(messageList);
			page.setTotalCount(count);
		}
		mv.addObject("page", page);
		return mv;

	}

	/**
	 * 修改消息状态
	 */
	@RequestMapping(value = "/updateStatusMessage.htm", method = RequestMethod.POST)
	public ModelAndView updateStatusMessage(HttpServletRequest request,
			HttpServletResponse response, @RequestParam Map<String, Object> maps)
	{
		ModelAndView mv = new ModelAndView("person/messageQueryResult");
		Page<LdMessageLog> page = PageUtils.getPage(request);
		LocalUserDto currentUser = getLocalUser(request);

		Map<String, Object> para = FormConvertToVo.covertToILdMessageLog(page);
		para.put("uid", currentUser.getUid());
		para.put("read_status", request.getParameter("readStatus"));
		para.put("updateIds", request.getParameter("updateIds"));
		messageService.updateStatusMessage(para);
		para.remove("read_status");
		para.put("read_status",null);
		List<LdMessageLog> messageList = messageService.selectMessageByPage(para);

		Integer count = messageService.selectMessageByPageCount(para);

		page.setResult(messageList);

		page.setTotalCount(count);

		mv.addObject("page", page);
		
		refreshUserSession(messageService, request);
		
		return mv;
	}

	/**
	 * 得到消息详情
	 * 
	 * @param request
	 * @param response
	 * @param maps
	 * @return
	 */
	@RequestMapping(value = "/{id}.htm", method = RequestMethod.GET)
	public ModelAndView fQueryMessage(HttpServletRequest request,
			HttpServletResponse response, @PathVariable String id)
	{
		ModelAndView mv = new ModelAndView("person/stationnews");
		LocalUserDto currentUser = getLocalUser(request);

		Page<LdMessageLog> page = PageUtils.getPage(request);
		Map<String, Object> para = FormConvertToVo.covertToILdMessageLog(page);
		para.put("uid", currentUser.getUid());
		LdMessageLog message = messageService.fQueryMessageLogById(id);
		
		para.put("read_status", "H");
		para.put("updateIds", message.getId()+"_");
		messageService.updateStatusMessage(para);

		List<LdMessageLog> messageList = messageService.selectMessageByPage(para);

		Integer count = messageService.selectMessageByPageCount(para);

		page.setResult(messageList);

		page.setTotalCount(count);

		mv.addObject("page", page);
		mv.addObject("message", message);
		refreshUserSession(messageService, request);
		return mv;

	}

	/**
	 * 得到消息详情 上一条 下一条
	 * 
	 * @param request
	 * @param response
	 * @param maps
	 * @return
	 */
	@RequestMapping(value = "/{step}/{id}.htm", method = RequestMethod.GET)
	public ModelAndView fQueryMessage(HttpServletRequest request,
			HttpServletResponse response, @PathVariable String step,
			@PathVariable String id)
	{
		ModelAndView mv = new ModelAndView("person/stationnews");
		LocalUserDto currentUser = getLocalUser(request);

		Page<LdMessageLog> page = PageUtils.getPage(request);
		Map<String, Object> para = FormConvertToVo.covertToILdMessageLog(page);
		para.put("uid", currentUser.getUid());
		para.put("step", step);
		para.put("read_status", "D");
		para.put("id", id);
		LdMessageLog message = messageService.fQueryMessageLogByStep(para);
		para.remove("read_status");
		if(message != null){
			para.put("read_status", "H");
			para.put("updateIds", message.getId()+"_");
			messageService.updateStatusMessage(para);
		}

		List<LdMessageLog> messageList = messageService.selectMessageByPage(para);

		Integer count = messageService.selectMessageByPageCount(para);

		page.setResult(messageList);

		page.setTotalCount(count);

		mv.addObject("page", page);
		mv.addObject("message", message);
		refreshUserSession(messageService, request);
		return mv;
	}
}
