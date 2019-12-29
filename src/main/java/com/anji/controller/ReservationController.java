package com.anji.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.anji.entity.Reservation;
import com.anji.service.ReservationService;

@RestController
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/reservations")
	public List<Reservation> getAllReservations() {
		return reservationService.getAllReservations();
	}
	
	@PostMapping("/reservations/add")
	public Reservation addOrUpdateReservation(@Valid @RequestBody Reservation reservation) {
		return reservationService.addOrUpdateReservation(reservation);
	}
	
	@DeleteMapping("/reservations/delete/{Id}")
	public void deleteReservation(@PathVariable("Id") Long id) {
		reservationService.deleteReservation(id);
	}
}
