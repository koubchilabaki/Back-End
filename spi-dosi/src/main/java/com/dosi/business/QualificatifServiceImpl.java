package com.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dosi.models.Qualificatif;
import com.dosi.repository.QualificatifRepository;

@Service
public class QualificatifServiceImpl implements QualificatifService {

	
	QualificatifRepository qualificatifRepository;

	@Autowired
	public QualificatifServiceImpl(QualificatifRepository qualificatifRepository) {
		this.qualificatifRepository = qualificatifRepository;
	}

	// fonction qui ajoute un qualificatif
	@Override
	public Qualificatif createQualificatif(Qualificatif qual) {
		return qualificatifRepository.save(qual);
	}

	// fonction qui cherche tous les qualificatifs
	@Override
	public List<Qualificatif> GetAllQualificatifs() {
		// TODO Auto-generated method stub
		return (List<Qualificatif>) qualificatifRepository.findAll();
	}



}
