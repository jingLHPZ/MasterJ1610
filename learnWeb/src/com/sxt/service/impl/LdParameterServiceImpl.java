package com.sxt.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.ILdParameter;
import com.sxt.models.LdParameter;
import com.sxt.service.LdParameterService;

@Service
public class LdParameterServiceImpl implements LdParameterService {
	@Autowired
	private ILdParameter iLdParameter;

	@Override
	public LdParameter queryParameterByName(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return iLdParameter.queryParameterByName(maps);
	}

	@Override
	public void add(LdParameter ldParameter) {
		// TODO Auto-generated method stub
		iLdParameter.add(ldParameter);
	}

	public LdParameter getParameterByName(String name, String defaultValue) {
		// TODO Auto-generated method stub
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", name);
		LdParameter ldParameter = iLdParameter.queryParameterByName(param);
		if(ldParameter == null){
			ldParameter = new LdParameter(name,name,defaultValue,"1");
			iLdParameter.add(ldParameter);
		}
		return ldParameter;
	}

	@Override
	public String queryParameterValue(String name) {
		// TODO Auto-generated method stub
		return iLdParameter.queryParameterValue(name);
	}
}
