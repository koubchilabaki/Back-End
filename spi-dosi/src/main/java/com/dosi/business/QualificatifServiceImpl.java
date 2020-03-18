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

	@Override
	public List<Qualificatif> getAllQualificatifs() {
		// TODO Auto-generated method stub
		return (List<Qualificatif>) qualificatifRepository.findAllOrdered();
	}

	@Override
	public Qualificatif createQualificatif(Qualificatif qualificatif) {
		// TODO Auto-generated method stub
		return qualificatifRepository.save(qualificatif);
	}

	@Override
	public Qualificatif updateQualificatif(Qualificatif qualificatif) {
		// TODO Auto-generated method stub
		Qualificatif lequalificatif = (Qualificatif) qualificatifRepository.findById(Long.valueOf(qualificatif.getIdQualificatif())).orElse(null);
		lequalificatif.setMaximal(qualificatif.getMaximal());
		lequalificatif.setMinimal(qualificatif.getMinimal());
		qualificatifRepository.save(lequalificatif);
		return lequalificatif;
	}

	@Override
	public void deleteQualificatif(Integer idQualificatif) {
		Qualificatif qualificatif= qualificatifRepository.findById(Long.valueOf(idQualificatif)).orElse(null);
		qualificatifRepository.delete(qualificatif);
	}

	@Override
	public Qualificatif findQualificatifById(Integer idQualificatif) {
		// TODO Auto-generated method stub
		
		return qualificatifRepository.findById(Long.valueOf(idQualificatif)).orElse(null);

	}






}
