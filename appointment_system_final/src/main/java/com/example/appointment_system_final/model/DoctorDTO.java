package com.example.appointment_system_final.model;



	public class DoctorDTO {

	    private Long id;
	    private String name;
	    private String lastname;
	    private String licenseNumber;
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
	    
	    

	}