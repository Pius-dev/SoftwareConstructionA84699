package com.example.appointment_system_final.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointment_system_final.exceptions.ResourceNotFoundException;
import com.example.appointment_system_final.model.DoctorDTO;
import com.example.appointment_system_final.service.IDoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
    IDoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<?> addDoctor(@RequestBody DoctorDTO doctorDTO) {
        doctorService.createDoctor(doctorDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public DoctorDTO getDoctor(@PathVariable long id){
        return doctorService.readDoctor(id);

    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDoctor(@RequestBody DoctorDTO doctorDTO) throws ResourceNotFoundException {
          doctorService.updateDoctor(doctorDTO);
         return ResponseEntity.ok("Actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable long id) throws ResourceNotFoundException {
       doctorService.deleteDoctor(id);
       return ResponseEntity.ok("Eliminado");

    }

    @GetMapping("/getAll")
    public Collection<DoctorDTO> listDoctors()
    {
        return doctorService.getAll();
    }


}

