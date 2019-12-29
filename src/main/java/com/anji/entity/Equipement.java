package com.anji.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Equipement implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nom;
	private String code;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_salle",
        referencedColumnName = "id"
    )
	private Salle salle;
	
	public Equipement() {
		super();
	}

	public Equipement(Long id, String nom, String code) {
		super();
		this.id = id;
		this.nom = nom;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
}
