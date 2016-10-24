package com.sxt.service;

import java.util.List;
import java.util.Map;

import com.sxt.inter.dto.LocalUserDto;
import com.sxt.models.LdLuckyDraw;


public interface LdLuckyDrawService {
	public List queryLuckyDrawList(Map<String,Object> map);
	public Integer queryLuckyDrawCount(Integer uid);
	public Integer add(LdLuckyDraw lucky);
	public void addLuckyDrawMethod(LocalUserDto dto,Integer awardType,String ip);
	public Integer queryLuckyDrawNum(Integer uid);
}
