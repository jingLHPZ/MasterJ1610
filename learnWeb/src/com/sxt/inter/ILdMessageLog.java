package com.sxt.inter;

import java.util.List;
import java.util.Map;

import com.sxt.models.LdMessageLog;

public interface ILdMessageLog {
	public List<LdMessageLog> queryMessageLogListPage(Map<String,Object> maps);
	public void add(LdMessageLog log);
	public Integer queryMessageLogListPageCount(Map<String,Object> maps);
	public void updateStatusMessage(Map<String,Object> maps);
	public LdMessageLog fQueryMessageLogById(String id);
	public LdMessageLog fQueryMessageLogByStep(Map<String,Object> maps);
	public List<LdMessageLog> fqueryMessageLogListPage(Map<String,Object> maps);
	public Integer fqueryMessageLogListPageCount(Map<String,Object> maps);
	
	public int  fQueryMessagebyUid(int uid);
}
