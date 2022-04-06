package com.example.appointment_system_final.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.Getter;
//import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctors")

public class Doctor {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastname;
    private String licenseNumber;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"doctor"})
    private Set<Appointment> appointments;

    public Doctor() {}

	@Override
	public String toString() {
		return "Doctor [name=" + name + ", lastname=" + lastname + ", licenseNumber=" + licenseNumber
				+ ", appointments=" + appointments + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	


}