package com.github.xenteros.repository;

import com.github.xenteros.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Set<Author> findAll();
    void deleteByUuid(String uuid);
    Author findOneByUuid(String uuid);
}
