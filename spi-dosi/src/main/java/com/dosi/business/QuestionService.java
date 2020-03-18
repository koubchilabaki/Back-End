package com.dosi.business;

import java.util.List;

import com.dosi.models.Enseignant;
import com.dosi.models.Question;

public interface QuestionService {
	
	// fonction qui retorune tous les Questions
	public List<Question> getAllQuestions();

	public List<Enseignant> getAllEnseignants();
	
	// fonction qui crée un Question
	public boolean createQuestion(Question suestion);
	
	// fonction qui modifie un Question
	public boolean updateQuestion(Question suestion);
	
	// fonction qui supprime un Question
	void deleteQuestion(Integer idQuestion);

	// fonction qui cherche un Question
	public Question findQuestionById(Integer idQuestion);


	// fonction qui vérifie si un Question exsite dans une Rubrique Question
	public boolean findIfIdQuestionExistsInReubriqueQuestion(Integer idQuestion);

    // fonction qui vérifie si un Question exsite dans une Question  Evaluation
	public boolean findIfIdQuestionExistsInQuestionEvaluation(Integer idQuestion);
}
