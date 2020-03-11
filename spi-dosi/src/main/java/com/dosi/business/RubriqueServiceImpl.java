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
		 rubriqueRepository.save(rubriqueUpdate);
		 return rubriqueUpdate;
	}

	@Override
	public void deleteRubrique(Integer idRubrique) {
		Rubrique rubriqueDeleted = (Rubrique)rubriqueRepository.findById(Long.valueOf((idRubrique))).orElse(null);
		rubriqueRepository.delete(rubriqueDeleted);
		
	}

	@Override
	public Rubrique findRubriqueById(Integer idRubrique) {
		Rubrique rubrique = (Rubrique)rubriqueRepository.findById(Long.valueOf((idRubrique))).orElse(null);
		return rubrique;
	}

	@Override
	public boolean findIfIdRubriqueExistsInRbEvalRbQst(Integer idRubrique) {
		
		return rubriqueRepository.findIfIdRubriqueExistsInRbEvalRbQst(idRubrique).isEmpty();
	}

	@Override
	public List<Rubrique> findRubriqueByDesignation(String designation) {
		
		return rubriqueRepository.findRubriqueByDesignation(designation);
	}
     
	

}
