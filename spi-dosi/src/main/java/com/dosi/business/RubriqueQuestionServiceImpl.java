package com.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dosi.models.RubriqueQuestion;
import com.dosi.repository.QuestionRepository;
import com.dosi.repository.RubriqueQuestionRepository;


public class RubriqueQuestionServiceImpl implements RubriqueQuestionService {

	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	RubriqueQuestionRepository RubriqueQuestionRepository;
	@Override
	public List<RubriqueQuestion> getAllQuestion(long idRubrique) {
	
		return this.RubriqueQuestionRepository.findAllbyIdRubrique(idRubrique);
	}

	@Override
	public void saveRubriqueQuestion(List<RubriqueQuestion> L) {
		 
		this.RubriqueQuestionRepository.saveAll(L);
		
	}

}
