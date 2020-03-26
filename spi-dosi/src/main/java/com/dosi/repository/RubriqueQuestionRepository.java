package com.dosi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dosi.models.RubriqueQuestion;

public interface RubriqueQuestionRepository extends CrudRepository <RubriqueQuestion, Long>{

	List<RubriqueQuestion> findAllbyIdRubrique(@Param("idRubrique") long id );
}
