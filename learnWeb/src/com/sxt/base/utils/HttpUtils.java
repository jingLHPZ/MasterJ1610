package com.sxt.base.utils;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
/**
 * 
 * @author jl
 *
 */
public class HttpUtils {
    public HttpUtils() {
    }

    public static String getClientIp(HttpServletRequest request) {
        String address = request.getHeader("X-Real-IP");
        if(StringUtils.isNotBlank(address)) {
            return address;
        } else {
            address = request.getHeader("X-Forwarded-For");
            if(StringUtils.isNotBlank(address)) {
                return address;
            } else {
                address = request.getRemoteAddr();
                return StringUtils.isNotBlank(address)?address:request.getRemoteHost();
            }
        }
    }

    public static String genBasePath(HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        sb.append(request.getScheme());
        sb.append("://");
        sb.append(request.getServerName());
        if(request.getServerPort() != 80) {
            sb.append(":");
            sb.append(request.getServerPort());
        }

        return sb.toString();
    }

}
