package com.sxt.page.util;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
/**
 * 
 * QueryResult
 * pillar liu
 * 2015-10-09 下午5:45:36
 * @version 1.0.0
 */
public class QueryResult<T> {
	protected List<T> result = null;
	protected int totalCount = -1;

	public QueryResult() {
	}

	/**
	 * 取得页内的记录列表.
	 */
	public List<T> getResult() {
		if (result == null)
			return Collections.emptyList();
		return result;
	}

	public void setResult(final List<T> result) {
		this.result = result;
	}

	/**
	 * 取得总记录数,默认值为-1.
	 */
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(final int totalCount) {
		this.totalCount = totalCount;
	}
	
	public void setTotalCount(final String totalCount) {
		if(StringUtils.isEmpty(totalCount) || "undefined".equalsIgnoreCase(totalCount))
			this.totalCount = -1;
		else
			this.totalCount = Integer.parseInt(totalCount);
	}
}
