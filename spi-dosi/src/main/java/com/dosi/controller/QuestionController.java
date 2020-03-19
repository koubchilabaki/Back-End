package com.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.dosi.business.QuestionService;
import com.dosi.models.Enseignant;
import com.dosi.models.Qualificatif;
import com.dosi.models.Question;

@RestController
@CrossOrigin
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService service;

	
//	public QuestionController(QuestionService service) {
//		this.service = service;
//	}
	
	// fonction qui retourne tous les questions
	@RequestMapping(method = RequestMethod.GET)
	public List<Question> getAllQuestions() {
		return service.getAllQuestions();
	}
	
	// fonction qui ajoute une question
	@RequestMapping(method = RequestMethod.POST)
	public String createQuestion(@RequestBody Question question) {
		
		try {
			String reponse = "";
			
			if(service.createQuestion(question)) {
				reponse = "Ajout effectué avec succès";
			}
			else
				reponse = "Ajout non effectué : L'intitulé doit être unique !";
			
			return reponse; 
		}
		catch (Exception e) {
			
			return "Ajout non effectué !"; 
		}
	}
	
	// fonction qui modifie une question
	@RequestMapping(method = RequestMethod.PUT) 
	public String updateQuestion(@RequestBody Question question) {
				
		try {
			String reponse = "";
			
			if(service.updateQuestion(question)) {
				reponse = "Modification effectuée avec succées";
			}
			else
				reponse = "Modification non effectuée : L'intitulé doit être unique !";

			return reponse; 
		}
		catch (Exception e) {
			
			return "Modification non effectuée !"; 
		}
	}
	
	// fonction qui supprime une question
	@PostMapping("/deleteQuestion")
	public String deleteQuestion(@RequestBody Question question) {
	
		try {

			service.deleteQuestion((int)(long)question.getIdQuestion());
		
			return "Suppression effectuée avec succès"; 
		}
		catch (Exception e) {
			
			return "Suppression non effectuée !"; 
		}
		
	}
	
}
