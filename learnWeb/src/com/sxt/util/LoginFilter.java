package com.sxt.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxt.inter.dto.LocalUserDto;
import com.sxt.controller.AbstractGeneralController;
import com.sxt.util.SingleOnline;


public class LoginFilter extends AbstractGeneralController implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 获得在下面代码中要用的request,response,session对象xx
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        servletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
        LocalUserDto localUserDto = super.getLocalUser(servletRequest);
        if(localUserDto!=null){
        	String ip=super.getRemoteAddr(servletRequest);
        	if (!SingleOnline.isValidUser(localUserDto.getUid(), session.getId()+"-"+ip)) {
                session.invalidate();
                response.getWriter().write("<script language='javascript'>alert('您的账户已在其它地点登录!');location.href='../login.jsp'</script>");
            }else{
            	chain.doFilter(servletRequest, servletResponse);
            }
        }else{
        	chain.doFilter(servletRequest, servletResponse);
        }  
    }

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
