package com.anji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anji.entity.Reservation;
import com.anji.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepos;

	public List<Reservation> getAllReservations() {
		return reservationRepos.findAll();
	}
	
	public Reservation addOrUpdateReservation(Reservation reservation) {
		return reservationRepos.save(reservation);
	}
	
	public void deleteReservation(Long id) {
		reservationRepos.deleteById(id);
	}
}
