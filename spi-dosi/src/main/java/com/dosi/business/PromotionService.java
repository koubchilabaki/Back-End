package com.dosi.business;

import java.util.List;

import com.dosi.models.Etudiant;
import com.dosi.models.Promotion;

public interface PromotionService {
	
	//get all promo
			public List<Promotion> getAllPromo();
			public List<Promotion> findByFormation(String code_formation);

}
