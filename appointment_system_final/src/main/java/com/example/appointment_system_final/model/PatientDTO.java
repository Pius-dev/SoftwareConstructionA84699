package com.example.appointment_system_final.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

//@Getter @Setter
public class PatientDTO {

        private Long id;
        private String name;
        private String lastname;
        private String dni;
        private Date entryDate;
        private Address address;
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
        
        

    }