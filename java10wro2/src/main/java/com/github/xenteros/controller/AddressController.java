package com.github.xenteros.controller;

import com.github.xenteros.dto.AddressDto;
import com.github.xenteros.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {


    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public AddressDto createAddress(@RequestParam String street,
                                    @RequestParam String city,
                                    @RequestParam String state) {
        return addressService.create(street, city, state);
    }

    @GetMapping
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid) {
        addressService.deleteByUuid(uuid);
    }
}
