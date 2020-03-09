package com.dosi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.dosi.models.Qualificatif;
import com.dosi.models.Rubrique;

public interface RubriqueRepository extends CrudRepository<Rubrique, Long>{
	
	@Query(value = "SELECT rubrique.* from rubrique,rubrique_question,rubrique_evaluation WHERE rubrique.ID_RUBRIQUE= ?1 AND rubrique.ID_RUBRIQUE=rubrique_question.ID_RUBRIQUE OR rubrique.ID_RUBRIQUE= ?1 AND rubrique.ID_RUBRIQUE=rubrique_evaluation.ID_RUBRIQUE", nativeQuery = true)
	List<Rubrique> findIfIdRubriqueExistsInRbEvalRbQst(int idRubrique);
	
	
	@Query(value = "SELECT rubrique.* from rubrique where rubrique.designation = ?1",nativeQuery = true)
	List<Rubrique> findRubriqueByDesignation(String designation);
}
