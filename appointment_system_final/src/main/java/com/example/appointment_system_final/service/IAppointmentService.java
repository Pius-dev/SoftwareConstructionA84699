package com.example.appointment_system_final.service;

import java.util.Collection;

import com.example.appointment_system_final.exceptions.BadRequestException;
import com.example.appointment_system_final.model.AppointmentDTO;



public interface IAppointmentService {

    void createAppointment(AppointmentDTO app) throws BadRequestException;
    public AppointmentDTO readAppointment(Long id);
    public void updateAppointment(AppointmentDTO appointmentDTO);
    public void deleteAppointment(Long id);
    Collection<AppointmentDTO> getAll();
}
