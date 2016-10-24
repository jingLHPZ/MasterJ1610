package com.sxt.util;

import java.lang.reflect.Method;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cache.interceptor.KeyGenerator;

public class CacheKeyGenerator implements KeyGenerator {
	private static final String NO_PARAM_KEY = "no_param_key";
	@Override
	public Object generate(Object target, Method method, Object... params) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
        buffer.append(target.getClass().getSimpleName()).append(".");
        buffer.append(method.getName()).append(".");
        if (params.length > 0) {
            for (Object each : params) {
                if (each != null) {
                    if (each instanceof Boolean || each instanceof Character || each instanceof Void
                            || each instanceof Short || each instanceof Byte || each instanceof Double
                            || each instanceof Float || each instanceof Integer || each instanceof Long) {
                        buffer.append(each);
                    } else if (each instanceof String) {
                        buffer.append(each);
                    }else if (each instanceof Object[]) {
                        buffer.append(Arrays.hashCode((Object[]) each));
                    } else if (each instanceof HttpServletRequest || each instanceof HttpServletResponse) {
                        continue;
                    } else {
                        buffer.append(each.hashCode());
                    }
                } else {
                    buffer.append(NO_PARAM_KEY);
                }
            }
        } else {
            buffer.append(NO_PARAM_KEY);
        }
        return buffer.toString();
	}

}
