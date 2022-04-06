package com.example.appointment_system_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.appointment_system_final.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
