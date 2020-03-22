package com.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dosi.business.EvaluationService;
import com.dosi.models.Etudiant;
import com.dosi.models.Evaluation;
import com.dosi.repository.EvaluationReository;

@Service
public class EvaluationServiceImpl implements EvaluationService{
	
	
	
	@Autowired
	EvaluationReository evaluationRepository;

	

	@Override
	public List<Evaluation> getAllEvaluations() {
		
		return (List<Evaluation>) evaluationRepository.findAll();
	}



	@Override
	public Evaluation getEvaluationById(Long id) {
		return evaluationRepository.findById(id).orElse(null);
	}

	@Override
	public List<Evaluation> findByFormation(String code_formation) {
		return (List<Evaluation>) evaluationRepository.findByFormation(code_formation);
	}


	@Override
	public Evaluation createEvaluation(Evaluation evaluationCreate) throws Exception {
		return evaluationRepository.save(evaluationCreate);
	}
	
	@Override
	public List<Evaluation> findByFormationAnne(String code, String annee) {
		return evaluationRepository.findByFA(code, annee);
	}



	
	
	

}
