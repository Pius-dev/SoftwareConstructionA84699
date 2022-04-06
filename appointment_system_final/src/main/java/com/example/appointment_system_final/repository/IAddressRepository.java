package com.example.appointment_system_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appointment_system_final.model.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {
}