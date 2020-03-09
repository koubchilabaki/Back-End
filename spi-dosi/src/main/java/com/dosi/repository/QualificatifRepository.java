package com.dosi.repository;

import com.dosi.models.Qualificatif;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificatifRepository extends CrudRepository<Qualificatif, Long> {
	
	
	// fonction qui vérifie si les qualificatifs sont utilisés dans une question
	@Query(value = "SELECT qualificatif.* from qualificatif,reponse_question,question_evaluation WHERE qualificatif.ID_QUALIFICATIF= ?1 AND qualificatif.ID_QUALIFICATIF=question_evaluation.ID_QUALIFICATIF OR question_evaluation.ID_QUESTION=reponse_question.ID_QUESTION_EVALUATION", nativeQuery = true)
	List<Qualificatif> findIfIdQualificatifExistsInReponse(int idQualificatif);
}
