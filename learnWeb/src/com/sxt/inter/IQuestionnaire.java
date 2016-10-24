package com.sxt.inter;

import com.sxt.models.Questionnaire;

public interface IQuestionnaire {
	public void insert(Questionnaire param);
	
	public Questionnaire getQuestionnaireByUid(Integer param);
	
	public void updateByUid(Questionnaire param);
}
