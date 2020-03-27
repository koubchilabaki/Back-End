package com.dosi.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.coyote.Response;
import org.aspectj.runtime.internal.Conversions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dosi.business.RubriqueQuestionService;
import com.dosi.business.RubriqueService;
import com.dosi.models.Question;
import com.dosi.models.Rubrique;
import com.dosi.models.RubriqueQuestion;

@RestController
@CrossOrigin
@RequestMapping("/rubriques")
public class RubriqueController {
	
	@Autowired
	public RubriqueService rubriqueService;
	
	@Autowired
	public RubriqueQuestionService rubriqueQuestionService;
	
 
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Rubrique> getAllRubrique()
	{
		return rubriqueService.getAllRubriques();
	}	
	
	@RequestMapping(path="/RechercherDesignation-{designation}",method=RequestMethod.GET)
	public List<Rubrique> getByDesignation(@PathVariable("designation") String designation){
		return rubriqueService.findRubriqueByDesignation(designation);
		
	}

	@RequestMapping(path="/{idRubrique}",method=RequestMethod.GET)
	public Rubrique getById(@PathVariable("idRubrique") int idRubrique){
		return rubriqueService.findRubriqueById(idRubrique);

	}


	
	@RequestMapping(path="/CreateRubrique",method=RequestMethod.POST)
	public Rubrique createRubrique(@RequestBody Rubrique rubrique) {
		return rubriqueService.createRubrique(rubrique);

	}

	@RequestMapping(path = "/updateRubrique", method = RequestMethod.PUT)
	public ResponseEntity updateRubrique(@RequestBody Rubrique rubrique) {

		if (!rubriqueService.findIfIdRubriqueExistsInRbEvalRbQst(rubrique.getIdRubrique())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Impossible de modifier la rubrique");
		}

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(rubriqueService.updateRubrique(rubrique));


	}
	
    @RequestMapping(path="/deleteRubrique-{idRubrique}",method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteRubrique(@PathVariable("idRubrique") long idRubrique) {
    	
    	if(!rubriqueService.findIfIdRubriqueExistsInRbEvalRbQst(idRubrique)) {
    		
    		return new ResponseEntity<String>("Impossible de supprimer la rubrique",HttpStatus.OK);
    	}else {
    		rubriqueService.deleteRubrique(idRubrique);
    		return new ResponseEntity<String>("Suppression effectuée avec succès",HttpStatus.OK);
    	    
    	}
    	
    }
    
	/*
	@RequestMapping(path="/{idRubrique}", method=RequestMethod.GET)
	public Rubrique getRubrique(@PathVariable("idRubrique") long idRubrique)
	{
		return rubriqueService.findRubriqueById(idRubrique);
	}	
	*/
    
    @RequestMapping(path="/QuestionNonUtiliseDansrubrique-{idRubrique}",method=RequestMethod.GET)
    public List<Question> getQuestionNonUtilise(@PathVariable("idRubrique") long idRubrique)
    {
    	return this.rubriqueQuestionService.findNotUsedInRubrique(idRubrique);
    }

    @RequestMapping(path = "/updateRubriqueQuestion", method = RequestMethod.PUT)
	public ResponseEntity<String> updateRubriqueQuestion(@RequestBody List<RubriqueQuestion> rubriqueQuestion) {


		this.rubriqueQuestionService.saveRubriqueQuestion(rubriqueQuestion);
		return new ResponseEntity<String>("la rubrique a été bien  modifier",HttpStatus.OK);

	}
    
    @RequestMapping(path="/rubriqueQuestion/{idRubrique}",method=RequestMethod.GET)
    public List<RubriqueQuestion> getRubriqueQuestion(@PathVariable("idRubrique") long idRubrique)
    {
    	return this.rubriqueQuestionService.getAllQuestion(idRubrique);
    }
    
    @RequestMapping(path="/deleteRubriqueQuestion",method=RequestMethod.POST)
    public ResponseEntity<String> deleteRubriqueQuestion(@RequestBody  RubriqueQuestion rubriqueQuestion) {
    	
    
    	this.rubriqueQuestionService.deleteRubriqueQuestion(rubriqueQuestion);
    	
    	
			return new ResponseEntity<String>("Suppression effectuée avec succès ",HttpStatus.OK);
    	    
    	}
    	
    
    
    
}
