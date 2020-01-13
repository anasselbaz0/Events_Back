package com.anji.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anji.entity.Salle;
import com.anji.helper.SalleReservation;
import com.anji.service.SalleService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;

@RestController
public class SalleController {
	
	@Autowired
	private SalleService salleService;
	
	@GetMapping("/salles")
	public List<Salle> getAllSalles() {
		return salleService.getAllSalles();
	}
	
	@GetMapping("/salles/findByCode/{code}")
	public Salle getSalleByCode(@PathVariable("code") String code) {
		return salleService.getSalleByCode(code);
	}
	
	@PostMapping("/salles/add")
	public Salle addOrUpdateSalle(@Valid @RequestBody Salle salle) {
		return salleService.addOrUpdateSalle(salle);
	}
	
	@DeleteMapping("/salles/delete/{Id}")
	public void deleteSalle(@PathVariable("Id") Long id) {
		salleService.deleteSalle(id);
	}
	
	@JsonDeserialize(using = DateDeserializer.class)
	@GetMapping("/salles/isreserved")
	public boolean isReserved(@Valid @RequestBody SalleReservation salleReservation) {
		Salle salle = salleService.getSalleByCode(salleReservation.getCode());
		return salleService.isReserved(salleReservation.getDate(), salle);
	}
	
	@JsonDeserialize(using = DateDeserializer.class)
	@PostMapping("/salles/reserver")
	public void reserver(@Valid @RequestBody SalleReservation salleReservation) {
		System.out.println(111122);
		Salle salle = null;
		salle = salleService.getSalleByCode(salleReservation.getCode());
		if (salle != null) {
			salleService.reserver(salleReservation.getDate(), salle);
		}
	}
}
