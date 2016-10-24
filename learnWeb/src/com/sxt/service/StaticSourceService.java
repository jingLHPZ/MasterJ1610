package com.sxt.service;

import java.util.List;

import com.sxt.inter.dto.ImageDto;

public interface StaticSourceService {

	public List<ImageDto> getImageByType(Integer type);
}
