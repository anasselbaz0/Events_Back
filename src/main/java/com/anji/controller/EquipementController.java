package com.anji.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anji.entity.Equipement;
import com.anji.service.EquipementService;

@RestController
public class EquipementController {

	@Autowired
	private EquipementService equipementService;
	
	@GetMapping("/equipements")
	public List<Equipement> getAllEquipements() {
		return equipementService.getAllEquipements();
	}
	
	@PostMapping("/equipements/add")
	public Equipement addOrUpdateEvenement(Equipement equipement) {
		return equipementService.addOrUpdateEvenement(equipement);
	}
	
	@DeleteMapping("/equipements/delete/{Id}")
	public void deleteEventById(Long id) {
		equipementService.deleteEventById(id);
	}
}
