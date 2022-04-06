package com.example.appointment_system_final.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name= "addresses")

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank
    @Size(max = 50)
    private String street;
    @NotBlank
    @Size(max = 40)
    private String number;
    @NotBlank
    @Size(max = 90)
    private String district;
    
    @NotBlank
    @Size(max = 60)
    private String province;

    @OneToOne(mappedBy = "address") 
    @JsonIgnoreProperties(value = {"address"})
    private Patient patient;

    public Address() {}

  
    

	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getStreet() {
		return street;
	}




	public void setStreet(String street) {
		this.street = street;
	}




	public String getNumber() {
		return number;
	}




	public void setNumber(String number) {
		this.number = number;
	}




	public String getDistrict() {
		return district;
	}




	public void setDistrict(String district) {
		this.district = district;
	}




	public String getProvince() {
		return province;
	}




	public void setProvince(String province) {
		this.province = province;
	}




	public Patient getPatient() {
		return patient;
	}




	public void setPatient(Patient patient) {
		this.patient = patient;
	}




	@Override
	public String toString() {
		return "Address [street=" + street + ", number=" + number + ", district=" + district + ", province=" + province
				+ ", patient=" + patient + "]";
	}
    


}