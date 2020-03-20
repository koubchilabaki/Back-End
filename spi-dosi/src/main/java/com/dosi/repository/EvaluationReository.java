package com.dosi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dosi.models.Etudiant;
import com.dosi.models.Evaluation;


public interface EvaluationReository extends CrudRepository<Evaluation, Integer> {

		//recherche par formation
	@Query(value= "SELECT * from EVALUATION where evaluation.code_formation=?1 ", nativeQuery=true)
	List<Evaluation> findByFormation(String code_formation);
	
	//recherche par formation et annee univ
		@Query(value= "SELECT * from ETUDIANT where code_formation=?1 AND annee_universitaire=?2", nativeQuery=true)
		List<Evaluation> findByFA(String code_formation, String annee);
	
}


