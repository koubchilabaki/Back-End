package com.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dosi.business.QualificatifService;
import com.dosi.business.QualificatifServiceImpl;
import com.dosi.models.Qualificatif;


@RestController
@CrossOrigin
@RequestMapping("/qualificatifs")
public class QualificatifController {
	@Autowired
	private QualificatifService service;

	// fonction qui retourne tous les qualificatifs
	@GetMapping
	public List<Qualificatif> getAllQualificatifs() {
		return service.getAllQualificatifs();
	}

	@GetMapping(value="/{id}")
	public Qualificatif getQualificatifById(@PathVariable("id") Integer id) {
		return service.findQualificatifById(id);
	}
	
	// fonction qui crée un qualificatif  
	@PostMapping(value = "/createQual")
	public Qualificatif createQualificatif(@RequestBody Qualificatif qualificatif) {
		return service.createQualificatif(qualificatif);

	}

	// fonction qui modifie un qualificatif 
	@PutMapping(value = "/updateQual")
	public Qualificatif updateQualificatif(@RequestBody Qualificatif qualificatif) {
		return service.updateQualificatif(qualificatif);
	}
	
	// fonction qui supprime un qualificatif
	@PostMapping(value = "/deleteQual")
	public boolean deleteQualificatifById(@RequestBody Qualificatif qualificatif) {
		
		Integer id = (int) (long) qualificatif.getIdQualificatif();
		if (!service.findIfIdQualificatifExistsInReponse(id) ){
			//HttpHeaders responseHeaders = new HttpHeaders();
			//responseHeaders.set("Contenu", "Le Qualificatif est utilisé dans une question !");
			//service.deleteQualificatif(id);
			throw new RuntimeException("Ce qualificatif est utilisé dans une question");
		} else {
			service.deleteQualificatif(id);
			return true;
		}
	}	
	
	/*
	 * @RequestMapping(value = "/test", method = RequestMethod.POST) public
	 * ResponseEntity<Object> createProduct(@RequestBody Qualificatif qualificatif)
	 * { return new
	 * ResponseEntity<>("Product is created successfully",HttpStatus.CREATED); }
	 */
	 
	
}
