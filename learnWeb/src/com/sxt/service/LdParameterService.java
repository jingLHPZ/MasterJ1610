package com.sxt.service;

import java.util.Map;

import com.sxt.models.LdParameter;

public interface LdParameterService {
	public LdParameter queryParameterByName(Map<String,Object> maps);
	public void add(LdParameter ldParameter);
	public LdParameter getParameterByName(String name, String defaultValue);
	public String queryParameterValue(String name);
}
