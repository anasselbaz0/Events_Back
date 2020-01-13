package com.anji.helper;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalleReservation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("date")
	@JsonFormat(pattern="yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date date;
	private String code;
	public SalleReservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SalleReservation(Date date, String code) {
		super();
		this.date = date;
		this.code = code;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}