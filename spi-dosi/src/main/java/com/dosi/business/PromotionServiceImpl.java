package com.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dosi.models.Etudiant;
import com.dosi.models.Promotion;
import com.dosi.models.PromotionPK;
import com.dosi.repository.EtudiantRepository;
import com.dosi.repository.PromotionRepository;

@Service

public class PromotionServiceImpl implements PromotionService {
	@Autowired
	PromotionRepository promoRepository;

	@Override
	public List<Promotion> getAllPromo() {
		return (List<Promotion>) promoRepository.findAll();
	}

	@Override
	public List<Promotion> findByFormation(String code_formation) {
		return (List<Promotion>) promoRepository.findByFormation(code_formation);
	}
	
	
	
	

	
	}
	
	



