package com.dosi.business;

import java.util.List;
import com.dosi.models.Evaluation;


public interface EvaluationService {
	
	public List<Evaluation> getAllEvaluations();
		
	   public Evaluation createEvaluation(Evaluation evaluationCreate) throws Exception;

	   public List<Evaluation> findByFormation(String code_formation);
	
	   public List<Evaluation> findByFormationAnne(String code, String annee);
	
	   Evaluation getEvaluationById(Long id);
}
