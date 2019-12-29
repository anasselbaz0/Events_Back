package com.anji.controller;

import java.util.Date;
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
import com.anji.service.SalleService;

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
	
	@PostMapping("/salles/isreserved")
	public boolean isReserved(@Valid @RequestBody Date date, @Valid @RequestBody Salle salle) {
		return salleService.isReserved(date, salle);
	}
	
	@PostMapping("/salles/reserver/{Id}")
	public void reserver(@Valid @RequestBody String sdate, @PathVariable("Id") Long id) {
		Salle salle = salleService.getSalleById(id);
		salleService.reserver(sdate, salle);
	}
}
