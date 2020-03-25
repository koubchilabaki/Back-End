package com.dosi.business;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.dosi.models.Rubrique;
import com.dosi.models.Question;
import com.dosi.models.RubriqueQuestion;

public interface RubriqueQuestionService {
	
	public List<RubriqueQuestion> getAllQuestion( long idRubrique);
	
	
	public void saveRubriqueQuestion (List<RubriqueQuestion> L );
	
	public List<Question> findNotUsedInRubrique(long idRubrique);
	
	public  void deleteRubriqueQuestion(RubriqueQuestion entity);

}
