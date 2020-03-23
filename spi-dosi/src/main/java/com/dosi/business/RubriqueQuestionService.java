package com.dosi.business;

import java.util.List;

import com.dosi.models.Rubrique;
import com.dosi.models.RubriqueQuestion;
import com.dosi.models.RubriqueQuestionPK;


public interface RubriqueQuestionService {

    // fonction qui retorune tous les rubriquesQuestion
    public List<RubriqueQuestion> getAllRubriquesQuestion();

    // fonction qui crÃ©e un rubrique Question
    public RubriqueQuestion createRubriqueQuestion(RubriqueQuestion rubriqueQuestion);






}


