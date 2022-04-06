package com.example.appointment_system_final.service.impl;

import com.example.appointment_system_final.exceptions.BadRequestException;
import com.example.appointment_system_final.model.Appointment;
import com.example.appointment_system_final.model.AppointmentDTO;
import com.example.appointment_system_final.repository.IAppointmentRepository;
import com.example.appointment_system_final.service.IAppointmentService;
import com.example.appointment_system_final.service.IDoctorService;
import com.example.appointment_system_final.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    @Autowired
    IAppointmentRepository appointmentRepository;
    private IPatientService patientService;
    private IDoctorService doctorService;

    @Autowired
    ObjectMapper mapper;

    
    @Override
    public void createAppointment(AppointmentDTO appointmentDTO) throws BadRequestException {
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        if (patientService.readPatient(appointmentDTO.getPatient().getId()) == null || doctorService.readDoctor(appointmentDTO.getDoctor().getId()) == null)
        	throw new BadRequestException("Does not exist");
               appointmentRepository.save(appointment);
    }

    @Override
    public AppointmentDTO readAppointment(Long id) {
        AppointmentDTO appointmentDTO = null;
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(appointment.isPresent()){
            appointmentDTO = mapper.convertValue(appointment, AppointmentDTO.class);
        }
        return appointmentDTO;
    }

    @Override
    public void updateAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }


    @Override
    public Collection<AppointmentDTO> getAll() {
            List<Appointment> appointments = appointmentRepository.findAll();

            Set<AppointmentDTO> appointmentsDTO = new HashSet<>();
            for(Appointment appointment : appointments){
                appointmentsDTO.add(mapper.convertValue(appointment,AppointmentDTO.class));
            }
            return appointmentsDTO;

    }
}
