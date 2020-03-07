package com.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
		return service.GetAllQualificatifs();
	}
	
}
