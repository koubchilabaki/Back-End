package com.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dosi.business.PromotionService;
import com.dosi.models.Promotion;

@RestController
@RequestMapping("/promotions")
public class PromotionController {
	@Autowired
	PromotionService service;

	
	
	
	//affichage de tous les promotions
	@RequestMapping(method=RequestMethod.GET)
	public List <Promotion> getAllFormations(){
		return service.getAllPromo();
	}
	
	//affichage de tous les promotions par formation
		@RequestMapping(value="/{CodeFormation}",method=RequestMethod.GET)
		public List <Promotion> findByFormation(@PathVariable("CodeFormation") String code_formation){
			return service.findByFormation(code_formation);
		}

}
