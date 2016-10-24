package com.sxt.base.common;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
@JsonSerialize(
	 include = Inclusion.NON_NULL
)
public class RestfulResponse {

    private List<Map<String, Object>> objects;
    private Map<String, Object> summaryData;
    private Long totalCount = null;
    private RestfulResponseStatus status = new RestfulResponseStatus();
    private Map<String, Object> object;
    private Object data;

    public RestfulResponse() {
    }

    public List<Map<String, Object>> getObjects() {
        return this.objects;
    }

    public void setObjects(List<Map<String, Object>> objects) {
        this.objects = objects;
    }

    public Long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = Long.valueOf(totalCount);
    }

    public RestfulResponseStatus getStatus() {
        return this.status;
    }

    public void setStatus(RestfulResponseStatus response) {
        this.status = response;
    }

    public void setObject(Map<String, Object> object) {
        this.object = object;
    }

    public Map<String, Object> getObject() {
        return this.object;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setException(Exception e) {
        if(e.getCause() != null) {
            this.getStatus().setMsg(e.getCause().getMessage());
        } else {
            this.getStatus().setMsg(e.getMessage());
        }

    }

    public Map<String, Object> getSummaryData() {
        return this.summaryData;
    }

    public void setSummaryData(Map<String, Object> summaryData) {
        this.summaryData = summaryData;
    }
}
