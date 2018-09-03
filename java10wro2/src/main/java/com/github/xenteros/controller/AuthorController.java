package com.github.xenteros.controller;

import com.github.xenteros.dto.AuthorCreateDto;
import com.github.xenteros.dto.AuthorDto;
import com.github.xenteros.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public AuthorDto create(@RequestBody AuthorCreateDto authorCreateDto) {
        return authorService.create(authorCreateDto);
    }

    @GetMapping
    public List<AuthorDto> findAll(){
        return authorService.findAll();
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid) {
        authorService.delete(uuid);
    }

}
