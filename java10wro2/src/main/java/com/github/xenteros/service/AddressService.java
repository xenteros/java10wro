package com.github.xenteros.service;

import com.github.xenteros.dto.AddressDto;

import java.util.List;

public interface AddressService {
    List<AddressDto> findAll();

    AddressDto create(String street,
                      String city,
                      String state);

    void deleteByUuid(String uuid);
}
