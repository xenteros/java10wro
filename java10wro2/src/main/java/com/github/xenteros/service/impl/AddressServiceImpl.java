package com.github.xenteros.service.impl;

import com.github.xenteros.dto.AddressDto;
import com.github.xenteros.model.Address;
import com.github.xenteros.repository.AddressRepository;
import com.github.xenteros.service.AddressService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AddressServiceImpl implements AddressService {

    private static final Logger LOG = Logger.getLogger(AddressServiceImpl.class);
    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressDto> findAll() {
        return addressRepository.findAllBy().stream()
                .map(AddressDto::new)
                .collect(toList());
    }

    @Override
    public AddressDto create(String street,
                             String city,
                             String state) {
        Address address = new Address(street, city, state);
        address = addressRepository.save(address);
        return new AddressDto(address);
    }

    @Override
    public void deleteByUuid(String uuid) {
        addressRepository.deleteByUuid(uuid);
    }


}
