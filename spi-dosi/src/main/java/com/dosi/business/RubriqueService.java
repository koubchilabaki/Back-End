package com.dosi.business;

import java.util.List;

import com.dosi.models.Qualificatif;
import com.dosi.models.Rubrique;

public interface RubriqueService {
	
	// fonction qui retorune tous les rubriques
		public List<Rubrique> getAllRubriques();

		// fonction qui crée un rubrique
		public Rubrique createRubrique(Rubrique rubrique);
		
		// fonction qui modifie un rubrique
		public Rubrique updateRubrique(Rubrique rubrique);
		
		// fonction qui supprime un rubrique
		void deleteRubrique(long idRubrique);

		// fonction qui cherche un rubrique
		public Rubrique findRubriqueById(Integer idRubrique);


		// fonction qui vérifie si un rubrique exsite dans une evaluation 
		public boolean findIfIdRubriqueExistsInRbEvalRbQst(long idRubrique);
		
		
		public List<Rubrique> findRubriqueByDesignation(String designation);

}
