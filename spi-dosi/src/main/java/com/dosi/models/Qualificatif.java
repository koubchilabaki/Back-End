package com.dosi.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the QUALIFICATIF database table.
 * 
 */
@Entity
@NamedQuery(name="Qualificatif.findAll", query="SELECT q FROM Qualificatif q")
public class Qualificatif implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SequenceIdGeneratorQualificatif", sequenceName = "QUA_SEQ",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGeneratorQualificatif")
	@Column(name="ID_QUALIFICATIF")
	private long idQualificatif;

	private String maximal;

	private String minimal;

	public Qualificatif() {
	}

	public Qualificatif(String maximal, String minimal) {
		super();
		this.maximal = maximal;
		this.minimal = minimal;
	}
	
	public Qualificatif(long idQualificatif, String maximal, String minimal) {
		super();
		this.idQualificatif = idQualificatif;
		this.maximal = maximal;
		this.minimal = minimal;
	}
	
	public long getIdQualificatif() {
		return this.idQualificatif;
	}

	public void setIdQualificatif(long idQualificatif) {
		this.idQualificatif = idQualificatif;
	}

	public String getMaximal() {
		return this.maximal;
	}

	public void setMaximal(String maximal) {
		this.maximal = maximal;
	}

	public String getMinimal() {
		return this.minimal;
	}

	public void setMinimal(String minimal) {
		this.minimal = minimal;
	}

}