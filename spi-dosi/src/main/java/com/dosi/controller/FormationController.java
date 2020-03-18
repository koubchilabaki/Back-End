package com.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dosi.business.EtudiantSeervice;
import com.dosi.business.FormationService;
import com.dosi.models.Formation;
import com.dosi.repository.EtudiantRepository;

@RestController
@CrossOrigin
public class FormationController {
	@Autowired
	FormationService service;

	
	
	
	//affichage de tous les formations
	@RequestMapping  ( value="/formations",method=RequestMethod.GET)
	public List <Formation> getAllFormations(){
		return service.getAllFormations();
	}

}
