package com.anji.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anji.entity.Salle;

public interface SalleRepository extends JpaRepository<Salle, Long> {

	Salle findByCode(String code);

}
