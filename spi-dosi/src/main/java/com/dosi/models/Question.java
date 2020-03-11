package com.dosi.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the QUESTION database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")

public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SequenceIdGeneratorQuestion", sequenceName = "QUE_SEQ",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGeneratorQuestion")
	@Column(name="ID_QUESTION")
	private long idQuestion;

	private String intitule;

	@Column(name="TYPE")
	private String type;
	//uni-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT")
	private Enseignant enseignantt;

	//uni-directional many-to-one association to Qualificatif
	//@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name="ID_QUALIFICATIF",referencedColumnName = "ID_QUALIFICATIF")
	private Qualificatif qualificatif;

	public Question() {
	}

	public Question(String intitule, String type, Enseignant enseignantt, Qualificatif qualificatif) {
		super();
		this.intitule = intitule;
		this.type = type;
		this.enseignantt = enseignantt;
		this.qualificatif = qualificatif;
	}

	public Question(long idQuestion, String intitule, String type, Enseignant enseignantt, Qualificatif qualificatiff) {
		super();
		this.idQuestion = idQuestion;
		this.intitule = intitule;
		this.type = type;
		this.enseignantt = enseignantt;
		this.qualificatif = qualificatif;
	}

	public long getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Enseignant getEnseignantt() {
		return this.enseignantt;
	}

	public void setEnseignantt(Enseignant enseignantt) {
		this.enseignantt = enseignantt;
	}

	public Qualificatif getQualificatif() {
		qualificatif.setIdQualificatif(2);
		return this.qualificatif;
	}

	public void setQualificatiff(Qualificatif qualificatif) {
		this.qualificatif = qualificatif;
	}

}