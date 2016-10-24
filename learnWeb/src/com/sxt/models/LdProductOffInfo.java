package com.sxt.models;

import java.io.Serializable;
import java.util.Date;

public class LdProductOffInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private String productId;

    private String productName;

    private Integer status;

    private Integer financingScale;

    private Integer investLimit;

    private String durationContent;

    private Integer durationWay;

    private Date createTime;

    private Date updateTime;

    private String info;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFinancingScale() {
        return financingScale;
    }

    public void setFinancingScale(Integer financingScale) {
        this.financingScale = financingScale;
    }

    public Integer getInvestLimit() {
        return investLimit;
    }

    public void setInvestLimit(Integer investLimit) {
        this.investLimit = investLimit;
    }

    public String getDurationContent() {
        return durationContent;
    }

    public void setDurationContent(String durationContent) {
        this.durationContent = durationContent;
    }

    public Integer getDurationWay() {
        return durationWay;
    }

    public void setDurationWay(Integer durationWay) {
        this.durationWay = durationWay;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}