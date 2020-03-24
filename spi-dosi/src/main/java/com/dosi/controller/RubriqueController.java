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

import com.dosi.business.RubriqueService;

import com.dosi.models.Rubrique;

@RestController
@CrossOrigin
@RequestMapping("/rubriques")
public class RubriqueController {
	
	public RubriqueService rubriqueService;
 
	@Autowired
	public RubriqueController(RubriqueService rubriqueService) {
		super();
		this.rubriqueService = rubriqueService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Rubrique> getAllRubrique()
	{
		return rubriqueService.getAllRubriques();
	}	
	
	@RequestMapping(path="/RechercherDesignation-{designation}",method=RequestMethod.GET)
	public List<Rubrique> getByDesignation(@PathVariable("designation") String designation){
		return rubriqueService.findRubriqueByDesignation(designation);
		
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
    		return new ResponseEntity<String>("Suppression reussite",HttpStatus.OK);
    	    
    	}
    	
    }
	
	@RequestMapping(path="/{idRubrique}", method=RequestMethod.GET)
	public Rubrique getAllRubrique(@PathVariable("idRubrique") long idRubrique)
	{
		return rubriqueService.findRubriqueById(idRubrique);
	}	
	
	

}
