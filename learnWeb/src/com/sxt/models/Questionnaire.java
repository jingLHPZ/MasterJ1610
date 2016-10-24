package com.sxt.models;

import java.util.Date;

public class Questionnaire {

	private Integer id;

    private Integer uid;

    private Integer totalCore;
    
    private Integer financialSituation;
    
    private Integer ageRange;

    private Integer education; 
    
    private Integer job;
    
    private Integer disposableIncome;
    
    private Integer investmentProportion;
    
    private Integer investmentKnowledge;
    
    private Integer investmentExperience;
    
    private Integer investmentLife;
    
    private Integer investmentCycle;
    
    private Integer investmentObjective;

    private Integer primaryObjective;

    private Integer investmentAttitude;
    
    private Integer investmentDistribution;

    private Integer futureInvestmentAttitude;

    private Integer riskBearingType;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTotalCore() {
        return totalCore;
    }

    public void setTotalCore(Integer totalCore) {
        this.totalCore = totalCore;
    }

    public Integer getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(Integer ageRange) {
        this.ageRange = ageRange;
    }

    public Integer getInvestmentObjective() {
        return investmentObjective;
    }

    public void setInvestmentObjective(Integer investmentObjective) {
        this.investmentObjective = investmentObjective;
    }

    public Integer getPrimaryObjective() {
        return primaryObjective;
    }

    public void setPrimaryObjective(Integer primaryObjective) {
        this.primaryObjective = primaryObjective;
    }

    public Integer getInvestmentLife() {
        return investmentLife;
    }

    public void setInvestmentLife(Integer investmentLife) {
        this.investmentLife = investmentLife;
    }

    public Integer getInvestmentExperience() {
        return investmentExperience;
    }

    public void setInvestmentExperience(Integer investmentExperience) {
        this.investmentExperience = investmentExperience;
    }

    public Integer getInvestmentProportion() {
        return investmentProportion;
    }

    public void setInvestmentProportion(Integer investmentProportion) {
        this.investmentProportion = investmentProportion;
    }

    public Integer getInvestmentDistribution() {
        return investmentDistribution;
    }

    public void setInvestmentDistribution(Integer investmentDistribution) {
        this.investmentDistribution = investmentDistribution;
    }

    public Integer getInvestmentAttitude() {
        return investmentAttitude;
    }

    public void setInvestmentAttitude(Integer investmentAttitude) {
        this.investmentAttitude = investmentAttitude;
    }

    public Integer getRiskBearingType() {
        return riskBearingType;
    }

    public void setRiskBearingType(Integer riskBearingType) {
        this.riskBearingType = riskBearingType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Integer getFinancialSituation() {
		return financialSituation;
	}

	public void setFinancialSituation(Integer financialSituation) {
		this.financialSituation = financialSituation;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public Integer getJob() {
		return job;
	}

	public void setJob(Integer job) {
		this.job = job;
	}

	public Integer getDisposableIncome() {
		return disposableIncome;
	}

	public void setDisposableIncome(Integer disposableIncome) {
		this.disposableIncome = disposableIncome;
	}

	public Integer getInvestmentKnowledge() {
		return investmentKnowledge;
	}

	public void setInvestmentKnowledge(Integer investmentKnowledge) {
		this.investmentKnowledge = investmentKnowledge;
	}

	public Integer getInvestmentCycle() {
		return investmentCycle;
	}

	public void setInvestmentCycle(Integer investmentCycle) {
		this.investmentCycle = investmentCycle;
	}

	public Integer getFutureInvestmentAttitude() {
		return futureInvestmentAttitude;
	}

	public void setFutureInvestmentAttitude(Integer futureInvestmentAttitude) {
		this.futureInvestmentAttitude = futureInvestmentAttitude;
	}

}
