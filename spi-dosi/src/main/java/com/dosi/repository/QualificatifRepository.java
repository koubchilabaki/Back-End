package com.dosi.repository;

import com.dosi.models.Qualificatif;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificatifRepository extends CrudRepository<Qualificatif, Long> {
	

	@Query(value="SELECT qualificatif.* FROM qualificatif ORDER BY minimal,maximal ASC", nativeQuery = true)
	List<Qualificatif> findAllOrdered();

	
	@Query(value="SELECT COUNT(q.ID_QUALIFICATIF) FROM question q where q.ID_QUALIFICATIF = ?1", nativeQuery = true)
	int countIfIdQualificatifInQuestion(int idQualificatif);
	
	@Query(value="select count(*) from qualificatif where minimal = ?1 and maximal = ?2", nativeQuery = true)
	int countMinimalMaximalQualificatif(String minimal,String maximal);
}
