package com.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dosi.business.QualificatifService;
import com.dosi.business.QualificatifServiceImpl;
import com.dosi.models.Qualificatif;


@RestController
@CrossOrigin
@RequestMapping("/qualificatifs")
public class QualificatifController {

	private QualificatifService service;

	@Autowired
	public QualificatifController(QualificatifService service) {
		this.service = service;
	}
	
	// fonction qui retourne tous les qualificatifs
	@RequestMapping(method = RequestMethod.GET)
	public List<Qualificatif> getAllQualificatifs() {
		return service.getAllQualificatifs();
	}

	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public List<Qualificatif> ggetAllQualificatifs() {
		return service.getAllQualificatifs();
	}
	
	// fonction qui crée un qualificatif  
	@RequestMapping(method = RequestMethod.POST)
	public Qualificatif createQualificatif(@RequestBody Qualificatif qualificatif) {
		return service.createQualificatif(qualificatif);

	}

	// fonction qui modifie un qualificatif 
	@RequestMapping(method = RequestMethod.PUT)
	public Qualificatif updateQualificatif(@RequestBody Qualificatif qualificatif) {
		return service.updateQualificatif(qualificatif);
	}
	
	// fonction qui supprime un qualificatif
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteQualificatifById(@RequestBody Qualificatif qualificatif) {
		
		String reponse = "";
		
		Integer id = (int) (long) qualificatif.getIdQualificatif();
		
		if(service.deleteQualificatif(id)) {
			reponse = "Suppression effectuée avec succées";
		}
		else
			reponse = "Suppression non effectuée : Le Qualificatif est utilisé dans une question !";

		return ResponseEntity.accepted().body(reponse);
	}	
	
	/*
	 * @RequestMapping(value = "/test", method = RequestMethod.POST) public
	 * ResponseEntity<Object> createProduct(@RequestBody Qualificatif qualificatif)
	 * { return new
	 * ResponseEntity<>("Product is created successfully",HttpStatus.CREATED); }
	 */
	 
	
}
