package com.github.xenteros.service;

import com.github.xenteros.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> findAll(int page, int pageSize);

    BookDto create(String title, String authorUuid);
}
