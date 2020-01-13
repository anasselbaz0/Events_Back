package com.anji.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anji.entity.Salle;
import com.anji.repository.SalleRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;

@Service
public class SalleService {
	
	@Autowired
	private SalleRepository salleRepos;
	
	public List<Salle> getAllSalles() {
		return salleRepos.findAll();
	}
	
	public Salle getSalleByCode(String code) {
		return salleRepos.findByCode(code);
	}
	
	public Salle getSalleById(Long id) {
		return salleRepos.getOne(id);
	}
	
	public Salle addOrUpdateSalle(Salle salle) {
		return salleRepos.save(salle);
	}
	
	public void deleteSalle(Long id) {
		salleRepos.deleteById(id);
	}

	public boolean isReserved(@Valid Date date, Salle salle) {
		if (salle == null) return false;
		return salle.getDatesDeReservation().contains(date);	
	}
	
	public void reserver(@Valid Date date, Salle salle) {
		if (salle.getDatesDeReservation() == null) {
			salle.setDatesDeReservation(new ArrayList<Date>());
		}
		salle.addReservation(date);
		System.out.println(salle);
		salleRepos.save(salle);
	}
	
}
