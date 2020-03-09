package com.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	
	public QuestionController(QuestionService service) {
		this.service = service;
	}
	
	// fonction qui retourne tous les questions
	@RequestMapping(method = RequestMethod.GET)
	public List<Question> getAllQuestions() {
		return service.getAllQuestions();
	}


	// fonction qui ajoute une question
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createQuestion(@RequestBody Question question) {
		String reponse = "";
		
		if(service.updateQuestion(question)) {
			reponse = "Ajout effectué avec succées";
		}
		else
			reponse = "Ajout non effectué : L'intitulé doit être unique !";

		return ResponseEntity.accepted().body(reponse);
	}
	
	// fonction qui modifie une question
	@RequestMapping(method = RequestMethod.PUT) 
	public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
		
		String reponse = "";
		
		if(service.updateQuestion(question)) {
			reponse = "Modification effectuée avec succées";
		}
		else
			reponse = "Modification non effectuée : L'intitulé doit être unique !";

		return ResponseEntity.accepted().body(reponse); 
	}
	
	// fonction qui modifie une question
	@RequestMapping(method = RequestMethod.DELETE) 
	public ResponseEntity<?> deleteQuestion(@RequestBody Question question) {
		
		String reponse = "";
		
		if(service.deleteQuestion((int)(long)question.getIdQuestion())) {
			reponse = "Suppression effectuée avec succées";
		}
		else
			reponse = "Suppression non effectuée : La question est déja utilisée !";

		return ResponseEntity.accepted().body(reponse); 
	}
	
}
