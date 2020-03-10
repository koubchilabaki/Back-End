package com.dosi.business;

import java.util.List;
import com.dosi.models.Qualificatif;

public interface QualificatifService {
	
	// fonction qui retorune tous les qualificatifs
	public List<Qualificatif> getAllQualificatifs();

	// fonction qui crée un qualificatif
	public Qualificatif createQualificatif(Qualificatif qualificatif);
	
	// fonction qui modifie un qualificatif
	public Qualificatif updateQualificatif(Qualificatif qualificatif);
	
	// fonction qui supprime un qualificatif
	boolean deleteQualificatif(Integer idQualificatif);

	// fonction qui cherche un qualificatif
	public Qualificatif findQualificatifById(Integer idQualificatif);





}
