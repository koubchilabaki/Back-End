package com.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dosi.models.RubriqueQuestion;
import com.dosi.models.RubriqueQuestionPK;
import com.dosi.repository.RubriqueQuestionRepository;




@Service
public class RubriqueQuestionServiceImpl implements RubriqueQuestionService {

    @Autowired
    RubriqueQuestionRepository repos;



    public RubriqueQuestionServiceImpl(RubriqueQuestionRepository repos) {
        super();
        this.repos = repos;
    }

    @Override
    public List<RubriqueQuestion> getAllRubriquesQuestion() {
        return (List<RubriqueQuestion>) repos.findAll();
    }

    @Override
    public RubriqueQuestion createRubriqueQuestion(RubriqueQuestion rubriqueQuestion) {
        return repos.save(rubriqueQuestion);
    }












}
