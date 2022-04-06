package com.example.appointment_system_final.service;

import java.util.Collection;
import java.util.Set;

import com.example.appointment_system_final.model.PatientDTO;

public interface IPatientService {

	   	public void createPatient(PatientDTO pac);
	    public PatientDTO readPatient(Long id);
	    public void updatePatient(PatientDTO patientDTO);
	    public void deletePatient(Long id);
	    public Collection<PatientDTO> getAll();

	    public Set<PatientDTO> getPatientWithLastNameLike(String lastname);
	}
