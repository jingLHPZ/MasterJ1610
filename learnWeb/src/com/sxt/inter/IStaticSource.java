package com.sxt.inter;

import java.util.List;

import com.sxt.inter.dto.ImageDto;

public interface IStaticSource {
	
	public List<ImageDto> getImageByType(Integer Type);
}
