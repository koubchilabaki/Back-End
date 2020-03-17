package com.dosi.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dosi.models.Etudiant;

public interface EtudiantRepository extends CrudRepository<Etudiant, String> {
 //recherche par formation et annee univ
	@Query(value= "SELECT * from ETUDIANT where code_formation=?1 AND annee_universitaire=?2", nativeQuery=true)
	List<Etudiant> findByFA(String code_formation, String annee);

}

