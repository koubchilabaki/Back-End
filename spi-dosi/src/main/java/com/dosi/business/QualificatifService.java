package com.dosi.business;

import java.util.List;
import com.dosi.models.Qualificatif;

public interface QualificatifService {
	
	// fonction qui retorune tous les qualificatifs
	public List<Qualificatif> GetAllQualificatifs();

	// fonction qui crée un qualificatif
	public Qualificatif createQualificatif(Qualificatif qualificatif);


}
