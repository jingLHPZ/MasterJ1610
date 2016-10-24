package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.LdLuckyDraw;

public interface ILdLuckyDraw {
	public List queryLuckyDrawList(Map<String,Object> map);
	public Integer queryLuckyDrawCount(Integer uid);
	public Integer add(LdLuckyDraw lucky);
	public Integer queryLuckyDrawNum(Integer uid);
}
