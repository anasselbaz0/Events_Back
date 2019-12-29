package com.anji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anji.entity.Equipement;
import com.anji.repository.EquipementRepository;

@Service
public class EquipementService {

	@Autowired
	private EquipementRepository equipementRepos;
	
	public List<Equipement> getAllEquipements() {
		return equipementRepos.findAll();
	}
	
	public Equipement addOrUpdateEvenement(Equipement equipement) {
		return equipementRepos.save(equipement);
	}
	
	public void deleteEventById(Long id) {
		equipementRepos.deleteById(id);
	}
}
