package com.example.appointment_system_final.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.appointment_system_final.model.PatientDTO;
import com.example.appointment_system_final.service.IPatientService;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	IPatientService patientService;

    @PostMapping("/add")
    public ResponseEntity<?> addPatient(@RequestBody PatientDTO patientDTO) {
        patientService.createPatient(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public PatientDTO getPatient(@PathVariable long id) {
       return patientService.readPatient(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO)
    {
        ResponseEntity response = null;
        if (patientService.readPatient(patientDTO.getId()) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            patientService.updatePatient(patientDTO);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable long id) {
        ResponseEntity response = null;
        if (patientService.readPatient(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            patientService.deletePatient(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Erased");
    }

    @GetMapping("/getAll")
    public Collection<PatientDTO> listPacients()
    {
        return patientService.getAll();
    }

    @GetMapping("/listlastname")
    public Set<PatientDTO> listPatients(@RequestParam String lastname)
    {
        return patientService.getPatientWithLastNameLike(lastname);
    }

}

