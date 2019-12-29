package com.anji.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.anji.entity.Evenement;
import com.anji.service.EvenementService;

@RestController
public class EvenementController {

	@Autowired
	private EvenementService eventService;
	
	@GetMapping("/evenements")
	public List<Evenement> getAllEvents() {
		return eventService.getAllEvents();
	}
	
	@GetMapping("/evenements/findByTitre/{titre}")
	public Evenement GetEvenementByTitre(@PathVariable("titre") String titre) {
		return eventService.findByTitre(titre);
	}
	
	@PostMapping("/evenements/add")
	public Evenement addOrUpdateEvenement(@Valid @RequestBody Evenement event) {
		return eventService.addOrUpdateEvenement(event);
	}
	
	@DeleteMapping("/evenements/delete/{Id}")
	public void deleteEventById(@PathVariable("Id") Long id) {
		eventService.deleteEventById(id);
	}
	
	@PostMapping("/evenements/valider/{Id}")
	public void valider(@PathVariable("Id") Long id) {
		eventService.valider(id);
	}
	
}
