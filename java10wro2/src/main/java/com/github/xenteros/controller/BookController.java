package com.github.xenteros.controller;

import com.github.xenteros.dto.BookDto;
import com.github.xenteros.model.Author;
import com.github.xenteros.model.Book;
import com.github.xenteros.repository.AuthorRepository;
import com.github.xenteros.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    @Autowired
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public List<BookDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(BookDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public BookDto create(String title, String authorUuid) {
        Author author = authorRepository.findOneByUuid(authorUuid);
        Book book = new Book(title, author);
        return new BookDto(bookRepository.save(book));
    }



}
