package com.anji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anji.entity.Evenement;
import com.anji.repository.EvenementRepository;

@Service
public class EvenementService {

	@Autowired
	private EvenementRepository evenementRepos;
	
	public List<Evenement> getAllEvents() {
		return evenementRepos.findAll();
	}
	
	public Evenement findByTitre(String titre) {
		return evenementRepos.findByTitre(titre);
	}
	
	public Evenement addOrUpdateEvenement(Evenement event) {
		return evenementRepos.save(event);
	}
	
	public void deleteEventById(Long id) {
		evenementRepos.deleteById(id);
	}

	public void valider(Evenement e) {
		e.setValid(true);
		System.out.println(e);
		evenementRepos.deleteById(evenementRepos.findByTitre(e.getTitre()).getId());
		evenementRepos.save(e);
	}
}
