package com.github.xenteros.service.impl;

import com.github.xenteros.dto.AddressDto;
import com.github.xenteros.model.Address;
import com.github.xenteros.model.Author;
import com.github.xenteros.repository.AddressRepository;
import com.github.xenteros.repository.AuthorRepository;
import com.github.xenteros.service.AddressService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Transactional
@Service
public class AddressServiceImpl implements AddressService {

    private static final Logger LOG = Logger.getLogger(AddressServiceImpl.class);
    private AddressRepository addressRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, AuthorRepository authorRepository) {
        this.addressRepository = addressRepository;
        this.authorRepository = authorRepository;
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
        Address address = addressRepository.findOneByUuid(uuid);
        Author author = address.getAuthor();
        author.removeAddress();
        authorRepository.save(author);
        addressRepository.deleteByUuid(address.getUuid());
    }


}
