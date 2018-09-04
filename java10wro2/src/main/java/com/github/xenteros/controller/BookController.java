package com.github.xenteros.controller;

import com.github.xenteros.dto.BookDto;
import com.github.xenteros.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDto> findAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "5") int pageSize) {
        return bookService.findAll(page, pageSize);
    }

    @PostMapping
    public BookDto create(@RequestParam String title, @RequestParam String authorUuid) {
        return bookService.create(title, authorUuid);
    }



}
