package com.github.xenteros.dto;

import com.github.xenteros.model.Author;
import com.github.xenteros.model.Book;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorDto {

    private String uuid;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private List<String> books;

    public AuthorDto() {
    }

    public AuthorDto(Author that) {
        this.uuid = that.getUuid();
        this.firstName = that.getFirstName();
        this.lastName = that.getLastName();
        this.books = that.getBooks().stream()
                .map(Book::getTitle)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        if (that.getAddress() == null) {
            return;
        }
        this.street = that.getAddress().getStreet();
        this.city = that.getAddress().getCity();
        this.state = that.getAddress().getState();
    }

    public AuthorDto(String uuid, String firstName, String lastName, String street, String city, String state) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
    }




    public String getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}
