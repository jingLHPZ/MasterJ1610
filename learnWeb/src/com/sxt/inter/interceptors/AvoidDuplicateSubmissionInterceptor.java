package com.sxt.inter.interceptors;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sxt.base.annotation.AvoidDuplicateSubmission;
import com.sxt.base.utils.TokenProcessor;
import com.sxt.inter.dto.LocalUserDto;
public class AvoidDuplicateSubmissionInterceptor extends HandlerInterceptorAdapter {
    private static final Log LOG = LogFactory.getLog(AvoidDuplicateSubmissionInterceptor.class);
 
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
 
    	LocalUserDto user = (LocalUserDto) request.getSession(true).getAttribute("localUser");
        if (user != null) {
            try {
				HandlerMethod handlerMethod = (HandlerMethod) handler;
				Method method = handlerMethod.getMethod();
 
				AvoidDuplicateSubmission annotation = method.getAnnotation(AvoidDuplicateSubmission.class);
				if (annotation != null) {
				    boolean needSaveSession = annotation.needSaveToken();
				    if (needSaveSession) {
				        request.getSession(false).setAttribute("token", TokenProcessor.getInstance().generateToken(request));
				    }
 
				    boolean needRemoveSession = annotation.needRemoveToken();
				    if (needRemoveSession) {
				        if (isRepeatSubmit(request)) {
				            LOG.warn("please don't repeat submit,[user:" + user.getUserName() + ",url:"
				                    + request.getServletPath() + "]");
				            redirectUrlView(request, response);
				            return false;
				        }
				        request.getSession(false).removeAttribute("token");
				    }
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return true;
			}
        }
        return true;
    }
 
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken = (String) request.getSession(false).getAttribute("token");
        if (serverToken == null) {
            return true;
        }
        String clinetToken = request.getParameter("token");
        if (clinetToken == null) {
            return true;
        }
        if (!serverToken.equals(clinetToken)) {
            return true;
        }
        return false;
    }
    
    private void redirectUrlView(HttpServletRequest request, HttpServletResponse response){
    	try {
        	if(request.getRequestURI().contains("experienceProduct")){
        		response.sendRedirect(request.getContextPath()+"/borrowinvest/fallproductinvest.htm?typeType=3");
            }else if(request.getRequestURI().contains("ciProduct")){
            	response.sendRedirect(request.getContextPath()+"/borrowinvest/fallproductinvest.htm?typeType=1");
            }else if(request.getRequestURI().contains("siproduct")){
            	response.sendRedirect(request.getContextPath()+"/borrowinvest/fallproductinvest.htm?typeType=2");
            }else if(request.getRequestURI().contains("peproduct")){
            	response.sendRedirect(request.getContextPath()+"/borrowinvest/fallproductinvest.htm?typeType=2");
            }else if(request.getRequestURI().contains("newHandProduct")){
            	response.sendRedirect(request.getContextPath()+"/borrowinvest/fallproductinvest.htm?typeType=2");
            }else if(request.getRequestURI().contains("withdraw")) {
            	response.sendRedirect(request.getContextPath()+"/payment/fchongzhirecord.htm?flag=withdraw");
            }else if(request.getRequestURI().contains("bankcard")) {
            	response.sendRedirect(request.getContextPath()+"/bankcard/fquerybank.htm");
            }else if(request.getRequestURI().contains("cash")) {
            	response.sendRedirect(request.getContextPath()+"/cash/toRedeemSuccess.htm");
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
 