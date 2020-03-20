package com.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dosi.business.EtudiantSeervice;
import com.dosi.models.Etudiant;
import com.dosi.models.Qualificatif;
import com.dosi.repository.EtudiantRepository;
@CrossOrigin
@RequestMapping ( value="/etudiants")
@RestController
public class EtudiantController {
	
	@Autowired
	EtudiantSeervice service;

	
	
	
	//affichage de tous les étudiants
	@RequestMapping  (method=RequestMethod.GET)
	public List <Etudiant> getAllStudents(){
		return service.getAllStudents();
	}
	   
		
	//création d'un étudiant 
		@RequestMapping(value="/create", method = RequestMethod.POST)
		public Etudiant createStudent(@RequestBody Etudiant etudiant) {
			return service.createStudent(etudiant);

		}
		
  //recherche
		@RequestMapping(value="/{Annee}/{code}", method = RequestMethod.GET)
		public List<Etudiant> findByFormationAnnee(@PathVariable("Annee") String annee, @PathVariable("code") String code) {
			return service.findByFormationAnne(code,annee);

		}	
   
		



}
