package com.dosi.repository;

import com.dosi.models.Qualificatif;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificatifRepository extends CrudRepository<Qualificatif, Long> {

}
