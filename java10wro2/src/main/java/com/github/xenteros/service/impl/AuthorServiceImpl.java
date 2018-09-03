package com.github.xenteros.service.impl;

import com.github.xenteros.dto.AuthorCreateDto;
import com.github.xenteros.dto.AuthorDto;
import com.github.xenteros.model.Address;
import com.github.xenteros.model.Author;
import com.github.xenteros.repository.AddressRepository;
import com.github.xenteros.repository.AuthorRepository;
import com.github.xenteros.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Transactional
@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private AddressRepository addressRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AuthorDto> findAll() {
        return authorRepository.findAll().stream()
                .map(AuthorDto::new)
                .collect(toList());
    }

    @Override
    public AuthorDto create(AuthorCreateDto dto) {
        Address address = addressRepository.findOneByUuid(dto.getAddressUuid());
        Author author = new Author(dto.getFirstName(), dto.getLastName(), address);
        return new AuthorDto(authorRepository.save(author));
    }

    @Override
    public void delete(String uuid) {
        authorRepository.deleteByUuid(uuid);
    }

}
