package com.sxt.inter.interceptors;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.sxt.base.annotation.HttpTimesLimit;
import com.sxt.base.annotation.HttpTimesLimitContainer;
import com.sxt.base.utils.CommonUtils;


@Component
@Aspect
public class HttpTimesLimitAspect {
	private static Log logger = LogFactory.getLog(HttpTimesLimitAspect.class);
    private static final String sb = "@";
	@Autowired
    private RedisTemplate redisTemplate;

    private void limit(HttpTimesLimit limit, String ip, String url, String phone) {
        String key = limit.key().concat(url).concat(ip).concat(sb).concat(phone);
        ValueOperations operations= redisTemplate.opsForValue();
        //计数器加一
        long count = operations.increment(key, 1);
        if (count == 1) {
            redisTemplate.expire(key, limit.time(), TimeUnit.MILLISECONDS);
        }
        if (count > limit.count()) {
            String msg = String.format("IP[%s]在规定的时间内[%d]ms,访问地址[%s]超过了限定的次数[%d]",ip,limit.time(),url,limit.count());
            logger.info(msg);
            throw new RuntimeException(msg);
        }
    }

    // 切面
    //@before  通知
    //"@annotation(limit)" 切入点
    @Before("@annotation(limit)")
    public void httpTimesLimit(final JoinPoint joinPoint, HttpTimesLimit limit) {
        try {
            Object[] args = joinPoint.getArgs();
            if(ArrayUtils.isEmpty(args)){
                throw new RuntimeException("方法中缺失参数");
            }
            HttpServletRequest request = null;
            String phone = null;
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof HttpServletRequest) {
                    request = (HttpServletRequest) args[i];
                    continue;
                }
                if(args[i] instanceof String){
                	phone = (String) args[i];
                	continue;
                }
            }

            if (request == null) {
                throw new RuntimeException("方法中缺失HttpServletRequest参数");
            }
            if(StringUtils.isEmpty(phone)){
            	throw new RuntimeException("方法中缺失user_phone参数");
            }

            String ip = CommonUtils.getRemoteAddr(request);
            String url = request.getServletPath().toString();
            limit(limit, ip, url, phone);
        } catch (RuntimeException e) {
            logger.error("访问限制发送错误: ", e);
        }
    }

    @Before("@annotation(limits)")
    public void httpTimesLimits(final JoinPoint joinPoint, HttpTimesLimitContainer limits) throws RuntimeException {
        try {
            Object[] args = joinPoint.getArgs();
            if(ArrayUtils.isEmpty(args)){
                throw new RuntimeException("方法中缺失参数");
            }
            if(limits==null||limits.value()==null){
                throw new RuntimeException("annotation中缺失参数");
            }
            HttpServletRequest request = null;
            String phone = null;
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof HttpServletRequest) {
                    request = (HttpServletRequest) args[i];
                    continue;
                }
                if(args[i] instanceof String){
                	phone = (String) args[i];
                	continue;
                }
            }
            if (request == null) {
                throw new RuntimeException("方法中缺失HttpServletRequest参数");
            }

            if(StringUtils.isEmpty(phone)){
            	throw new RuntimeException("方法中缺失user_phone参数");
            }
            String ip = CommonUtils.getRemoteAddr(request);
            String url = request.getServletPath().toString();
            for (HttpTimesLimit limit : limits.value()) {
            	limit(limit, ip, url, phone);
            }
        }catch (RuntimeException e) {
        	logger.error("访问限制发送错误: ", e);
            throw e;
        }
    }
}
