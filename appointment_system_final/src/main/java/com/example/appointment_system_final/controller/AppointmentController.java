package com.example.appointment_system_final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.appointment_system_final.exceptions.BadRequestException;
import com.example.appointment_system_final.exceptions.ResourceNotFoundException;
import com.example.appointment_system_final.model.AppointmentDTO;
import com.example.appointment_system_final.service.IAppointmentService;

import java.util.Collection;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    IAppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity<?> addAppointment(@RequestBody AppointmentDTO appointmentDTO) throws BadRequestException {
        appointmentService.createAppointment(appointmentDTO);
        return ResponseEntity.ok("Appointment Created");
    }
    @GetMapping("/get/{id}")
    public AppointmentDTO getAppointment(@PathVariable long id)
    {
        return appointmentService.readAppointment(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAppointment(@RequestBody AppointmentDTO appointmentDTO)
    {
        appointmentService.updateAppointment(appointmentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable long id) throws ResourceNotFoundException {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok("Appointment {id} deleted");

    }


    @GetMapping("/getAll")
    public Collection<AppointmentDTO> listAppointments()
    {
        return appointmentService.getAll();
    }

}
