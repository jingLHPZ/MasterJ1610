package com.sxt.inter.dto;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public abstract class AbstractDto implements Serializable {

	private static final long serialVersionUID = 7760854434803988338L;
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public AbstractDto(){
		super();
	}
	protected void copyProperties(Object src, Object target) {
		if (src == null || target == null) {
			return;
		}
		PropertyDescriptor[] pdArray1 = null;
		PropertyDescriptor[] pdArray2 = null;
		try {
			pdArray1 = Introspector.getBeanInfo(src.getClass()).getPropertyDescriptors();
			pdArray2 = Introspector.getBeanInfo(target.getClass()).getPropertyDescriptors();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (pdArray1 != null && pdArray2 != null) {
			for (PropertyDescriptor pd2: pdArray2) {
				if (!pd2.getName().equals("class")) {
					for (PropertyDescriptor pd1: pdArray1) {
						if (pd2.getName().equals(pd1.getName())) {
							Method writeMethod = pd2.getWriteMethod();
							Method readMethod = pd1.getReadMethod();
							
							try {
								writeMethod.invoke(target, readMethod.invoke(src));
							} catch (Exception e) {
							}
						}
					}
				}
			}
		}
	}
}
