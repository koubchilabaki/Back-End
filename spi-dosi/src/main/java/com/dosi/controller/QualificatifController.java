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
	public String createQualificatif(@RequestBody Qualificatif qualificatif) {

		try {
			service.createQualificatif(qualificatif);
			return "Ajout effectué avec succès";
		}
		catch (Exception e) {
			
			return "Ajout non effectué !"; 
		}
	}

	// fonction qui modifie un qualificatif 
	@RequestMapping(method = RequestMethod.PUT)
	public String updateQualificatif(@RequestBody Qualificatif qualificatif) {
		
		try {
			service.updateQualificatif(qualificatif);
			return "Modification effectuée avec succès !"; 
		}
		catch (Exception e) {
			
			return "Modification non effectuée !"; 
		}
	}
	
	// fonction qui supprime un qualificatif
	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteQualificatifById(@RequestBody Qualificatif qualificatif) {	
		try {
			
			Integer id = (int) (long) qualificatif.getIdQualificatif();
			service.deleteQualificatif(id);
			
			return "Suppression effectuée avec succès"; 
		}
		catch (Exception e) {
			
			return "Suppression non effectuée !"; 
		}
		
	}	
	
}
