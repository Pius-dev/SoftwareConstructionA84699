package com.example.appointment_system_final.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointment_system_final.model.Patient;
import com.example.appointment_system_final.model.PatientDTO;
import com.example.appointment_system_final.repository.PatientRepository;
import com.example.appointment_system_final.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ObjectMapper mapper;

    public void createPatient(PatientDTO pac) {
        Patient patient = mapper.convertValue(pac, Patient.class);
        patientRepository.save(patient);
    }

    public PatientDTO readPatient(Long id)     {
        PatientDTO patientDTO = null;
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent()){
            patientDTO = mapper.convertValue(patient, PatientDTO.class);
        }
        return patientDTO;
    }

    public void updatePatient(PatientDTO patientDTO){
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
       patientRepository.save(patient);
    }

    public void deletePatient(Long id)
    {
        patientRepository.deleteById(id);
    }

    public Collection<PatientDTO> getAll()
    {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDTO> patientsDTO = new HashSet<>();
            for(Patient patient : patients){
            patientsDTO.add(mapper.convertValue(patient,PatientDTO.class));
        }
        return patientsDTO;
    }

    public Set<PatientDTO> getPatientWithLastNameLike(String lastname) {

        Set<Patient> patients = patientRepository.getPatientByLastNameLike(lastname);
        Set<PatientDTO> patientsDTO = new HashSet<>();
        for (Patient patient : patients) {
            patientsDTO.add(mapper.convertValue(patient,PatientDTO.class));
        }
        return patientsDTO;
    }

}

