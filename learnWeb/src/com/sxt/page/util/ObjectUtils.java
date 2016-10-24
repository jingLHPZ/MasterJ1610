package com.sxt.page.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 
 * ObjectUtils
 * pillar liu
 * 2015-10-14 下午5:46:54
 * @version 1.0.0
 */
public class ObjectUtils {
	private static final Log logger = LogFactory.getLog(ObjectUtils.class);

	public static Object instanceByClass(String className) {
		try {
			Class cmdClass = Class.forName(className.trim());
			return cmdClass.newInstance();
		} catch (ClassNotFoundException cnfe) {
			logger.error("cann't find class[" + className + "]", cnfe);
		} catch (InstantiationException ie) {
			logger.error("cann't instance for the class. [" + className + "]", ie);
		} catch (IllegalAccessException iae) {
			logger.error("cann't access for the class. [" + className + "]", iae);
		} catch (Exception e) {
			logger.error("other exception for the class. [" + className + "]", e);
		}
		return null;
	}
	
	/**
	 * 对象是否为空
	 */
	@SuppressWarnings("unchecked")
	public static boolean isObjectEmpty(Object object) {
		
	    if (object == null) {
    		return true;
	    } else if (object instanceof String) {
	    	return StringUtils.isEmpty(StringUtils.trim((String) object));
	    } else if (object instanceof List) {
	    	boolean allEntriesStillEmpty = true;
	    	final Iterator<Object> iter = ((List) object).iterator();
	    	while (allEntriesStillEmpty && iter.hasNext()) {
		        final Object listEntry = iter.next();
		        allEntriesStillEmpty = isObjectEmpty(listEntry);
	    	}
	    	return allEntriesStillEmpty;
	    } else {
	    	try {
		        boolean allPropertiesStillEmpty = true;
		        final Map<String, Object> properties = PropertyUtils.describe(object);
		        final Iterator<Entry<String, Object>> iter = properties.entrySet().iterator();
		        while (allPropertiesStillEmpty && iter.hasNext()) {
		        	final Entry<String, Object> entry = iter.next();
		        	final String key = entry.getKey();
		        	final Object value = entry.getValue();
		        	if ("class".equals(key)) continue;
		        	allPropertiesStillEmpty = isObjectEmpty(value);
		        }
		        return allPropertiesStillEmpty;
	    	} catch (IllegalAccessException e) {
	    		throw new RuntimeException(e);
	    	} catch (InvocationTargetException e) {
		        throw new RuntimeException(e);
		  	} catch (NoSuchMethodException e) {
		        throw new RuntimeException(e);
		  	}
    	}
	}
}
