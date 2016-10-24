/**
 * pillar liu
 */
package com.sxt.inter.dto;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.sxt.models.LdMessageLog;
import com.sxt.page.util.Page;

/**
 * vo对象转换为model VoConvertToModel
 * 
 * zhangbin
 * 
 * 2013-1-23 下午1:45:11
 * 
 * @version 1.0.0
 * 
 */
public class FormConvertToVo {
	private static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 
	 * @param riskOrderForm
	 * @param page
	 * @return
	 */
	public static Map<String,Object> covertToILdMessageLog(Page<LdMessageLog> page){
		Map<String,Object> para = new HashMap<String,Object>();
		if(page.getPageNo()==1){
			para.put("startRow", 0);
		}else{
			para.put("startRow", (page.getPageNo()-1)*page.getPageSize());
		}
		para.put("pageSize",page.getPageSize());
		
		return para;
	}
	
	/**
	 * @param <T>
	 * @return 
	 */
	public static <T>  Map<String, Object> covertToPage(Page<T> page){
		Map<String,Object> para = new HashMap<String,Object>();
		if(page.getPageNo()==1){
			para.put("startRow", 0);
		}else{
			para.put("startRow", (page.getPageNo()-1)*page.getPageSize());
		}
		para.put("pageSize",page.getPageSize());
		
		return para;
	}
	
}
