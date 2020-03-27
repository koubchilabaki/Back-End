package com.dosi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dosi.models.Formation;
import com.dosi.models.Question;

public interface FormationRepository extends CrudRepository<Formation, String>{
//Select * from formation order by code_formation,nom_formation;
	
	@Query(value="Select formation.* from formation order by code_formation,nom_formation", nativeQuery = true)
	List<Formation> findAllOrdered();
}
