package com.sxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.inter.IStaticSource;
import com.sxt.inter.dto.ImageDto;
import com.sxt.service.StaticSourceService;

@Service
public class StaticSourceServiceImpl implements StaticSourceService{
	@Autowired
	private IStaticSource iStaticSource;

	public List<ImageDto> getImageByType(Integer type) {
		
		return iStaticSource.getImageByType(type);
	}
}
