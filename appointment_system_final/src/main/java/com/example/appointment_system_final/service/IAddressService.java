package com.example.appointment_system_final.service;



import java.util.Collection;

import com.example.appointment_system_final.model.AddressDTO;

public interface IAddressService {

    public void createAddress(AddressDTO add);
    public AddressDTO readAddress(Long id);
    public void updateAddress(AddressDTO addressDTO);
    public void deleteAddress(Long id);
    public Collection<AddressDTO> getAll();
}
