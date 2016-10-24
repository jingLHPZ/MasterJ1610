package com.sxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.inter.IQuestionnaire;
import com.sxt.models.Questionnaire;
import com.sxt.service.QuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	@Autowired
	private IQuestionnaire iQuestionnaire; 
	
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void insert(Questionnaire param) {
		iQuestionnaire.insert(param);
	}
	
	public Questionnaire getQuestionnaireByUid(Integer param) {
		return iQuestionnaire.getQuestionnaireByUid(param);
	}
	
	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
	public void updateByUid(Questionnaire param) {
		iQuestionnaire.updateByUid(param);
	}
}
