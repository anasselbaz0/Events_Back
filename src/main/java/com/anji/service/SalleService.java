package com.anji.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anji.entity.Salle;
import com.anji.repository.SalleRepository;

@Service
public class SalleService {
	
	@Autowired
	private SalleRepository salleRepos;
	
	public List<Salle> getAllSalles() {
		return salleRepos.findAll();
	}
	
	public Salle getSalleByCode(String code) {
		return salleRepos.findByCode(code);
	}
	
	public Salle getSalleById(Long id) {
		return salleRepos.getOne(id);
	}
	
	public Salle addOrUpdateSalle(Salle salle) {
		return salleRepos.save(salle);
	}
	
	public void deleteSalle(Long id) {
		salleRepos.deleteById(id);
	}

	public boolean isReserved(@Valid Date date, Salle salle) {
		return salle.getDatesDeReservation().contains(date);	
	}
	
	public void reserver(@Valid String sdate, Salle salle) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = simpleDateFormat.parse(sdate);
			System.out.println(simpleDateFormat.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		salle.getDatesDeReservation().add(date);
		salleRepos.save(salle);
	}
	
}
