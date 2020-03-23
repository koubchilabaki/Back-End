package com.dosi.controller;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dosi.business.RubriqueQuestionService;
import com.dosi.business.RubriqueService;

import com.dosi.models.Rubrique;
import com.dosi.models.RubriqueQuestion;
import com.dosi.models.RubriqueQuestionPK;

@RestController
@CrossOrigin
@RequestMapping("/rubriquesQuestion")
public class RubriqueQuestionController {

    public RubriqueQuestionService rubriqueQuestionService;

    @Autowired
    public RubriqueQuestionController(RubriqueQuestionService rubriqueQuestionService) {
        super();
        this.rubriqueQuestionService = rubriqueQuestionService;
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<RubriqueQuestion> getAllRubrique()
    {
        return rubriqueQuestionService.getAllRubriquesQuestion();
    }


    @RequestMapping(path="/CreateRubriqueQuestion",method=RequestMethod.POST)
    public RubriqueQuestion createRubriqueQuestion(@RequestBody RubriqueQuestion rubriqueQuestion) {

        //if(!rubriqueQuestionService.findIfIdRubriqueQuestionExistsInRbEval(rubriqueQuestion.getId().getIdRubrique(), rubriqueQuestion.getId().getIdQuestion()))) {

           /* return new ResponseEntity<String>("Impossible de supprimer la rubrique",HttpStatus.BAD_REQUEST);
        }else {
            rubriqueService.deleteRubrique(idRubrique);
            return new ResponseEntity<String>("Suppression reussite",HttpStatus.OK);



            return rubriqueQuestionService.createRubriqueQuestion(rubriqueQuestion);*/
           return null;
//}


    }


    }
