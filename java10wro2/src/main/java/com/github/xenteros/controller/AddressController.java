package com.github.xenteros.controller;

import com.github.xenteros.model.Address;
import com.github.xenteros.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private AddressRepository addressRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @PostMapping
    public Address createAddress(@RequestParam String street,
                                 @RequestParam String city,
                                 @RequestParam String state) {
        Address address = new Address(street, city, state);
        return addressRepository.save(address);
    }

    @GetMapping
    public Set<Address> findAll() {
        return addressRepository.findAllBy();
    }
}
