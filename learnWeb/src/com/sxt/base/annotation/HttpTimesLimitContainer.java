package com.sxt.base.annotation;
import com.sxt.base.annotation.HttpTimesLimit;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface HttpTimesLimitContainer {
	HttpTimesLimit[] value();
}