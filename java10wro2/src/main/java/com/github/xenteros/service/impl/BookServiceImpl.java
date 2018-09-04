package com.github.xenteros.service.impl;

import com.github.xenteros.dto.BookDto;
import com.github.xenteros.model.Author;
import com.github.xenteros.model.Book;
import com.github.xenteros.repository.AuthorRepository;
import com.github.xenteros.repository.BookRepository;
import com.github.xenteros.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookDto> findAll(int page, int pageSize) {
        Pageable pageable = new PageRequest(page, pageSize, Sort.Direction.ASC, "title");
        return bookRepository.findAll(pageable)
                .getContent()
                .stream()
                .map(BookDto::new)
                .collect(toList());
    }

    @Override
    public BookDto create(String title, String authorUuid) {
        Author author = authorRepository.findOneByUuid(authorUuid);
        if (author == null) {
            throw new RuntimeException();
        }
        Book book = new Book(title, author);
        book = bookRepository.save(book);
        return new BookDto(book);
    }



}
