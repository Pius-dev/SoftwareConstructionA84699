package com.example.appointment_system_final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.appointment_system_final.model.Address;
import com.example.appointment_system_final.model.AddressDTO;
import com.example.appointment_system_final.repository.IAddressRepository;
import com.example.appointment_system_final.service.IAddressService;



import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    IAddressService addressService;
    
	@Autowired
	private IAddressRepository addressRepository;

    @PostMapping("/add")
    public ResponseEntity<?> createAddress(@RequestBody AddressDTO addressDTO){
        addressService.createAddress(addressDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public AddressDTO getAddress(@PathVariable long id)
    {
        return addressService.readAddress(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody AddressDTO addressDTO)
    {
        ResponseEntity response = null;
        if (addressService.readAddress(addressDTO.getId()) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            addressService.updateAddress(addressDTO);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable long id) {
        ResponseEntity response = null;
        if (addressService.readAddress(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            addressService.deleteAddress(id);
            response = new ResponseEntity(HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/getAll")
    public List<Address> listAddresses()
    {
        return addressRepository.findAll();
    }




}

