package com.example.appointment_system_final.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import lombok.Getter;
//import lombok.Setter;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "appointments")
//@Getter @Setter
public class Appointment {

    @Id
    @GeneratedValue
    private Long id;
    
    private Date date;

    @ManyToOne
    @JoinColumn(name="patient_id", nullable = false)
    @JsonIgnoreProperties(value = {"appointments"})
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id", nullable = false)
    @JsonIgnoreProperties(value = {"appointments"})
    private Doctor doctor;

    public Appointment() {}

	@Override
	public String toString() {
		return "Appointment [date=" + date + ", patient=" + patient + ", doctor=" + doctor + "]";
	}

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

