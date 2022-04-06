package com.example.appointment_system_final.model;



import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "patients")

public class Patient {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private String lastname;
    private String dni;
    private Date entryDate;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)  //Patient communicate with  through Appointment
    @JsonIgnoreProperties(value = {"patient"}) // to avoid an infinite circle
    private Set<Appointment> appointments;

    public Patient() {}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", lastname=" + lastname + ", dni=" + dni + ", entryDate=" + entryDate
				+ ", address=" + address + ", appointments=" + appointments + "]";
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

 
}
