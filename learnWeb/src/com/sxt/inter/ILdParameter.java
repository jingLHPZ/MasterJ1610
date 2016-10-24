package com.sxt.inter;

import java.util.Map;

import com.sxt.models.LdParameter;

public interface ILdParameter {
	public LdParameter queryParameterByName(Map<String,Object> maps);
	public void add(LdParameter ldParameter);
	public String queryParameterValue(String name);
}
