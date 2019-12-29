package com.anji.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@OneToMany(mappedBy = "reservation")
	private Collection<Salle> salles;
	@OneToOne
	@JoinColumn(name = "id_evenement", referencedColumnName = "id")
	private Evenement event;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Long id, Collection<Salle> salles, Evenement event) {
		super();
		this.id = id;
		this.salles = salles;
		this.event = event;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Collection<Salle> getSalle() {
		return salles;
	}

	public void setSalle(Collection<Salle> salles) {
		this.salles = salles;
	}

	public Evenement getEvent() {
		return event;
	}

	public void setEvent(Evenement event) {
		this.event = event;
	}
	
}
