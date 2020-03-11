package com.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dosi.models.Etudiant;
import com.dosi.models.Qualificatif;
import com.dosi.repository.EtudiantRepository;

@Service
public class EtudiantServiceImpl implements EtudiantSeervice{
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	
	

	@Override
	//affichage
	public List<Etudiant> getAllStudents() {
		// TODO Auto-generated method stub
		return (List<Etudiant>) etudiantRepository.findAll();
	}
	
	
	@Override
	//création
	public Etudiant createStudent(Etudiant etudiant) {
		return  etudiantRepository.save(etudiant);
	}


	@Override
	public List<Etudiant> findByFormationAnne(String code, String annee) {
		return etudiantRepository.findByFA(code, annee);
	}
	
	
	
		
		
	

	

}
