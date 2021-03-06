package com.dosi.controller;

import java.util.List;
import com.dosi.business.EvaluationService;
import com.dosi.business.EvaluationServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dosi.models.Evaluation;

@CrossOrigin
@RequestMapping("/evaluations")
@RestController
public class EvaluationController {
	
	@Autowired
	EvaluationService service;
	
	//affichage de tous les evaluations 
		@RequestMapping(method = RequestMethod.GET)
		public List<Evaluation> getAllEvaluations() {
			return service.getAllEvaluations();
		}
	//ajout evaluation
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public void creerEvaluation(@RequestBody Evaluation evaluationCreate) throws Exception {
		service.createEvaluation(evaluationCreate); 
		
	}
	
	
	//affichage des evaluations par id
	@RequestMapping(value="/{idEvaluation}" ,method = RequestMethod.GET)
	public Evaluation getEvaluationById(@PathVariable("idEvaluation") Long idEvaluation) {
		return service.getEvaluationById(idEvaluation);
	}
	
	//affichage des evaluations par formation
			@RequestMapping(value="/{CodeFormation}",method=RequestMethod.GET)
			public List <Evaluation> findByFormation(@PathVariable("CodeFormation") String code_formation){
				return service.findByFormation(code_formation);
			}
    
	
	//affichage des evaluations par code formation et annee universitaire
			
			@RequestMapping(value="/findByAnneeCodeFormation/{Annee}/{code}", method = RequestMethod.GET)
			public List<Evaluation> findByFormationAnnee(@PathVariable("Annee") String annee, @PathVariable("code") String code) {
				return service.findByFormationAnne(code,annee);

			}	
	   
}
