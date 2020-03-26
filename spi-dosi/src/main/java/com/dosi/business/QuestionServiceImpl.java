package com.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dosi.models.Enseignant;
import com.dosi.models.Question;
import com.dosi.repository.EnseignantRepository;
import com.dosi.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	EnseignantRepository enseignantRepository;
	
	@Autowired
	public QuestionServiceImpl(QuestionRepository questionRepository,EnseignantRepository enseignantRepository) {
		this.questionRepository = questionRepository;
		this.enseignantRepository = enseignantRepository;
	}
	
	@Override
	public List<Question> getAllQuestions() {
		return (List<Question>) questionRepository.findAllOrdered();
	}

	@Override
	public List<Enseignant> getAllEnseignants(){
		return (List<Enseignant>) enseignantRepository.findAll();
	}

	@Override
	public boolean createQuestion(Question question) {
		boolean test = false;
		
		if(questionRepository.countIntituleQuestion(question.getIntitule())==0) {
			questionRepository.save(question);
			test = true;
		}
		return test;
	}

	@Override
	public boolean updateQuestion(Question question) {
		boolean test = false;
		
		int idQuestion=(int)question.getIdQuestion();  
		
		if( questionRepository.countIntituleQuestion(question.getIntitule())<=1 && questionRepository.countQuestionQualificatifEvaluation(idQuestion)==0)  {
			questionRepository.save(question);
			test = true;
		}

		return test;
	}

	@Override
	public void deleteQuestion(Integer idQuestion) {
		questionRepository.deleteById(Long.valueOf(idQuestion));
	}

	@Override
	public Question findQuestionById(Integer idQuestion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findIfIdQuestionExistsInReubriqueQuestion(Integer idQuestion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findIfIdQuestionExistsInQuestionEvaluation(Integer idQuestion) {
		// TODO Auto-generated method stub
		return false;
	}

}
