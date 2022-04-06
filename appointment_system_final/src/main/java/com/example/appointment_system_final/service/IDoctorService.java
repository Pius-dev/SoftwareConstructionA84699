package com.example.appointment_system_final.service;

import java.util.Collection;

import com.example.appointment_system_final.exceptions.ResourceNotFoundException;
import com.example.appointment_system_final.model.DoctorDTO;

public interface IDoctorService {

	  public void createDoctor(DoctorDTO dent);
	    public DoctorDTO readDoctor(Long id);
	    public void updateDoctor(DoctorDTO doctorDTO) throws ResourceNotFoundException;
	    public void deleteDoctor(Long id) throws ResourceNotFoundException;
	    public Collection<DoctorDTO> getAll();
		


	}