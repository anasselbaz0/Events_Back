package com.anji.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anji.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
