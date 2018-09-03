package com.github.xenteros.dto;


import com.github.xenteros.model.Book;

public class BookDto {

    private String title;
    private String authorFirstName;
    private String authorLastName;

    public BookDto() {
    }
    public BookDto(Book that) {
        this.title = that.getTitle();
        this.authorFirstName = that.getAuthor().getFirstName();
        this.authorLastName = that.getAuthor().getLastName();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }
}
