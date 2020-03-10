package com.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dosi.models.Formation;

import com.dosi.repository.FormationRepository;

@Service
public class FormationServiceImpl implements FormationService {
	
	@Autowired
	FormationRepository formationRepository;

	@Override
	public List<Formation> getAllFormations() {
		return (List<Formation>) formationRepository.findAll();
	}
}
