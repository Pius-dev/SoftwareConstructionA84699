package com.example.appointment_system_final.service.impl;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointment_system_final.exceptions.ResourceNotFoundException;
import com.example.appointment_system_final.model.Doctor;
import com.example.appointment_system_final.model.DoctorDTO;
import com.example.appointment_system_final.repository.DoctorRepository;
import com.example.appointment_system_final.service.IDoctorService;
import com.fasterxml.jackson.databind.ObjectMapper;




@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    ObjectMapper mapper;

    public void createDoctor(DoctorDTO dent) {
        Doctor doctor = mapper.convertValue(dent, Doctor.class);
        doctorRepository.save(doctor);
    }

    public DoctorDTO readDoctor(Long id)  {
        DoctorDTO doctorDTO = null;
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if(doctor.isPresent()){
            doctorDTO = mapper.convertValue(doctor, DoctorDTO.class);
        }
        return doctorDTO;
    }

    public void updateDoctor(DoctorDTO doctorDTO) throws ResourceNotFoundException{
        Doctor doctor = mapper.convertValue(doctorDTO,Doctor.class);
        if (doctorRepository.getById(doctorDTO.getId()) == null)
            throw new ResourceNotFoundException("No existe un dentita con el id: " + doctorRepository.getById(doctorDTO.getId()));
        doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) throws ResourceNotFoundException {
        if (doctorRepository.findById(id) == null)
            throw new ResourceNotFoundException("No existe un doctora con el id: " + id);
        doctorRepository.deleteById(id);
    }

    public Collection<DoctorDTO> getAll()
    {
        List<Doctor> doctors = doctorRepository.findAll();
        Set<DoctorDTO> doctorsDTO = new HashSet<>();
        for(Doctor doctor : doctors){
           doctorsDTO.add(mapper.convertValue(doctor,DoctorDTO.class));
        }
        return doctorsDTO;
    }

}


