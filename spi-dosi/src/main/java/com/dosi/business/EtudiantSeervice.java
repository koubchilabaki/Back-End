package com.dosi.business;

import java.util.List;

import com.dosi.models.Etudiant;

public interface EtudiantSeervice {
	
		//get all students
		public List<Etudiant> getAllStudents();

		// create student
		public Etudiant createStudent(Etudiant etudiant);
		 
		//recherche par annee universitaire et formation
		 public List<Etudiant> findByFormationAnne(String code, String annee);
	

		

}
