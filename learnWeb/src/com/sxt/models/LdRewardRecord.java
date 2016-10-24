package com.sxt.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LdRewardRecord implements Serializable{
	private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer type;

    private BigDecimal proValue;

    private Date createTime;

    private Date updateTime;

    private String systemTraceNo;

    private String useStatus;

    private Integer uid;

    private String content;
    
    private Date expireTime;
    
    private Date useTime;
    
    private String memo;
    
    public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public Date getUseTime() {
		return useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getProValue() {
        return proValue;
    }

    public void setProValue(BigDecimal proValue) {
        this.proValue = proValue;
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

    public String getSystemTraceNo() {
        return systemTraceNo;
    }

    public void setSystemTraceNo(String systemTraceNo) {
        this.systemTraceNo = systemTraceNo;
    }

    public String getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}