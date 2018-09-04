package com.github.xenteros.repository;

import com.github.xenteros.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    Set<Book> findAll();

}
