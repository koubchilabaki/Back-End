package com.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dosi.models.Qualificatif;
import com.dosi.models.Rubrique;
import com.dosi.repository.RubriqueRepository;

@Service
public class RubriqueServiceImpl implements RubriqueService {
	
	@Autowired
	public RubriqueServiceImpl(RubriqueRepository rubriqueRepository) {
		super();
		this.rubriqueRepository = rubriqueRepository;
	}

	RubriqueRepository rubriqueRepository;

	@Override
	public List<Rubrique> getAllRubriques() {
		
		return (List<Rubrique>) rubriqueRepository.findAll();
	}

	@Override
	public Rubrique createRubrique(Rubrique rubrique) {
		return rubriqueRepository.save(rubrique);
	}

	@Override
	public Rubrique updateRubrique(Rubrique rubrique) {
		
		 Rubrique rubriqueUpdate = (Rubrique)rubriqueRepository.findById(Long.valueOf((rubrique.getIdRubrique()))).orElse(null);
		 rubriqueUpdate.setDesignation(rubrique.getDesignation());
		 rubriqueUpdate.setType(rubrique.getType());
		 rubriqueUpdate.setOrdre(rubrique.getOrdre());
		 rubriqueUpdate.setRubriqueQuestions(rubrique.getRubriqueQuestions());
		 rubriqueRepository.save(rubriqueUpdate);
		 return rubriqueUpdate;
	}

	@Override
	public void deleteRubrique(long idRubrique) {
		Rubrique rubriqueDeleted = rubriqueRepository.findById(idRubrique).get();
		rubriqueRepository.delete(rubriqueDeleted);
		
	}

	@Override
	public Rubrique findRubriqueById(long idRubrique) {
		Rubrique rubrique = (Rubrique)rubriqueRepository.findById(Long.valueOf((idRubrique))).orElse(null);
		return rubrique;
	}

	@Override
	public boolean findIfIdRubriqueExistsInRbEvalRbQst(long idRubrique) {
		
		return rubriqueRepository.findIfIdRubriqueExistsInRbEvalRbQst(idRubrique).isEmpty();
	}

	@Override
	public List<Rubrique> findRubriqueByDesignation(String designation) {
		
		return rubriqueRepository.findRubriqueByDesignation(designation);
	}
     
	

}
