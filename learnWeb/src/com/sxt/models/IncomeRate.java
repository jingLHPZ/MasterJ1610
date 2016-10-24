package com.sxt.models;

import java.util.Date;

public class IncomeRate {
	private static final long serialVersionUID = 1L;
	
    private Integer id;

    private Float incomeRate;
    
    private Float avgIncomeRate;

    private Date rateTime;
    
    private Date updateTime;

    private Integer rateType;
    
    private String rateDate;
    
    private Integer subUid;
    
    private Integer checkUid;

    private Integer rateStatus;

    private String extField;

    private Integer extField2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getIncomeRate() {
        return incomeRate;
    }

    public void setIncomeRate(Float incomeRate) {
        this.incomeRate = incomeRate;
    }

    public Float getAvgIncomeRate() {
		return avgIncomeRate;
	}

	public void setAvgIncomeRate(Float avgIncomeRate) {
		this.avgIncomeRate = avgIncomeRate;
	}

	public Date getRateTime() {
        return rateTime;
    }

    public void setRateTime(Date rateTime) {
        this.rateTime = rateTime;
    }

    public Integer getRateType() {
        return rateType;
    }

    public void setRateType(Integer rateType) {
        this.rateType = rateType;
    }

	public String getRateDate() {
		return rateDate;
	}

	public void setRateDate(String rateDate) {
		this.rateDate = rateDate;
	}

	public Integer getSubUid() {
		return subUid;
	}

	public void setSubUid(Integer subUid) {
		this.subUid = subUid;
	}

	public Integer getCheckUid() {
		return checkUid;
	}

	public void setCheckUid(Integer checkUid) {
		this.checkUid = checkUid;
	}

	public Integer getRateStatus() {
        return rateStatus;
    }

    public void setRateStatus(Integer rateStatus) {
        this.rateStatus = rateStatus;
    }

    public String getExtField() {
        return extField;
    }

    public void setExtField(String extField) {
        this.extField = extField;
    }

    public Integer getExtField2() {
        return extField2;
    }

    public void setExtField2(Integer extField2) {
        this.extField2 = extField2;
    }

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
    
}