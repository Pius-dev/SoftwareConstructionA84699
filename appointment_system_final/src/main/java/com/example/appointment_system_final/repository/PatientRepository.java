package com.example.appointment_system_final.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.appointment_system_final.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("from Patient s where s.lastname like %:lastname%")
    Set<Patient> getPatientByLastNameLike(@Param("lastname")String lastname);
}
