package com.example.appointment_system_final.model;



import java.util.Date;

import org.springframework.stereotype.Component;


@Component
public class AppointmentDTO {

    private Long id;
    
    private Date date;
    private Patient patient;
    private Doctor doctor;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
    
    

}
