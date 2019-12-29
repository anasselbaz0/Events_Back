package com.anji.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anji.entity.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {

	Evenement findByTitre(String titre);

}
