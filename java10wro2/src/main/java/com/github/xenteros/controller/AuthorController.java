package com.github.xenteros.controller;

import com.github.xenteros.dto.AuthorDto;
import com.github.xenteros.model.Address;
import com.github.xenteros.model.Author;
import com.github.xenteros.repository.AddressRepository;
import com.github.xenteros.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorRepository authorRepository;
    private AddressRepository addressRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.addressRepository = addressRepository;
    }

    @PostMapping
    public AuthorDto create(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam Long addressId) {
        Address address = addressRepository.findOne(addressId);
        Author author = new Author(firstName, lastName, address);
        return new AuthorDto(authorRepository.save(author));
    }

}
