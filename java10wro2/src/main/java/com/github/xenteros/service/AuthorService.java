package com.github.xenteros.service;

import com.github.xenteros.dto.AuthorCreateDto;
import com.github.xenteros.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> findAll();

    AuthorDto create(AuthorCreateDto dto);

    void delete(String uuid);
}
