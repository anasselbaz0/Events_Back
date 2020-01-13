package com.anji.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import com.anji.entity.enums.TypeSalle;

@Entity
public class Salle implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String code;
	private TypeSalle type;
	private ArrayList<Date> datesDeReservation; 
	
	@OneToMany(mappedBy = "salle")
	private Collection<Equipement> equipements;
	@ManyToOne
	@JoinColumn(name = "id_reservation")
	private Reservation reservation;
	
	public Salle() {
		super();
		datesDeReservation = new ArrayList<>();
	}

	public Salle(Long id, String code, TypeSalle type, Collection<Equipement> equipement) {
		super();
		this.id = id; 
		this.code = code;
		this.type = type;
		this.equipements = equipement;
		datesDeReservation = new ArrayList<>();
	}

	public void addReservation(Date d) {
		this.datesDeReservation.add(d);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TypeSalle getType() {
		return type;
	}

	public void setType(TypeSalle type) {
		this.type = type;
	}

	public Collection<Equipement> getEquipement() {
		return equipements;
	}

	public void setEquipement(Collection<Equipement> equipement) {
		this.equipements = equipement;
	}

	public ArrayList<Date> getDatesDeReservation() {
		return datesDeReservation;
	}

	@Override
	public String toString() {
		return "Salle [id=" + id + ", code=" + code + ", type=" + type + ", datesDeReservation=" + datesDeReservation
				+ ", equipements=" + equipements + ", reservation=" + reservation + "]";
	}

	public void setDatesDeReservation(ArrayList<Date> datesDeReservation) {
		this.datesDeReservation = datesDeReservation;
	}
	
}
