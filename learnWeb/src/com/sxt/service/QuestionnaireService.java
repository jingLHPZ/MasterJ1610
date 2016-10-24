package com.sxt.service;

import com.sxt.models.Questionnaire;

public interface QuestionnaireService {
	public void insert(Questionnaire param);
	
	public Questionnaire getQuestionnaireByUid(Integer param);
	
	public void updateByUid(Questionnaire param);
}
