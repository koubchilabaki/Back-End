package com.dosi.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dosi.models.Rubrique;
import com.dosi.models.RubriqueQuestion;
import com.dosi.models.RubriqueQuestionPK;



public interface RubriqueQuestionRepository extends CrudRepository<RubriqueQuestion, Long> {




}
