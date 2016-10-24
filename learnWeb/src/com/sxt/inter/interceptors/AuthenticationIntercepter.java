package com.sxt.inter.interceptors;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sxt.inter.dto.LocalUserDto;
import com.sxt.util.PropertiesRead;

/**
 * 
 * @author pillar liu
 * 
 * @date 2015-10-8 
 * @mail goodemail88@hotmail.com
 *
 */
public class AuthenticationIntercepter implements HandlerInterceptor {
	
	private static final Log logger = LogFactory.getLog(AuthenticationIntercepter.class);
	
	/**
	 * White list
	 */
    private String[] excludes;
    
    /**
     * Special white list
     */
    private String[] passUnAuthentications;
	
	public String[] getExcludes() {
		return excludes;
	}

	public void setExcludes(String[] excludes) {
		this.excludes = excludes;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object object, Exception exception)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView modelAndView) throws Exception {
		//do nothing
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object object) throws Exception {
		String requestUrl = getRequestUrl(request);
		logger.info("requestUrl:"+requestUrl);
		
		if (requestUrl.indexOf("/app/") >= 0 || requestUrl.indexOf("/inter/") >= 0  || requestUrl.indexOf("/newsinformation/") >= 0 ||requestUrl.indexOf("/newsnotice/") >= 0 ) {
			return true;
		}
		
		// if user didn't login, redirect to the login page
		LOGIN:if(request.getSession(true).getAttribute("localUser")==null && requestUrl.indexOf("login")==-1 && requestUrl.indexOf("logout")==-1){
			// pass the url which should not be authenticated
			for(String passUnAuthentication:passUnAuthentications){
				if(requestUrl.indexOf(passUnAuthentication)!=-1){
					break LOGIN;
				}
			}
			//request.getSession(true).setAttribute("requestUrl", requestUrl);
			response.sendRedirect(request.getContextPath()+"/login/login.htm?view=true");
			return false;
		}
		
		for (String mexclude : excludes) {
			mexclude = mexclude.trim();
			if(mexclude.length()>0){
				if(Pattern.matches(mexclude,requestUrl)){
					return true;
				}
			}
		}
		return true;
	}

	public String getRequestUrl(HttpServletRequest request){
		String requestURL = request.getRequestURL().toString();
		    /*String url = PropertiesRead.use_classLoador().getProperty("webUrl");
		    if (StringUtils.isNotBlank(requestURL)){
		    	if (requestURL.indexOf(url)!=-1){
		    		requestURL = requestURL.substring(url.length());
		    	}
		    	return requestURL;
		    }else{
		    	return "t";
		    }*/
		return requestURL;
	}

	public void setPassUnAuthentications(String[] passUnAuthentications) {
		this.passUnAuthentications = passUnAuthentications;
	}
}
