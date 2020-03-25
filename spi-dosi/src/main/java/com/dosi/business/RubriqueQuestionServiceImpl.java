package com.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dosi.models.Question;
import com.dosi.models.RubriqueQuestion;
import com.dosi.repository.QuestionRepository;
import com.dosi.repository.RubriqueQuestionRepository;

@Service
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

	@Override
	public List<Question> findNotUsedInRubrique(long idRubrique) {
		
		return this.questionRepository.findNotUsedInRubrique(idRubrique);
	}


}
