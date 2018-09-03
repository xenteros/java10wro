package com.github.xenteros.model;

import javax.persistence.*;

@Entity
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private String city;
    private String state;
    @OneToOne(mappedBy = "address")
    private Author author;

    public Address() {
    }


    public Address(Long id, String street, String city, String state) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public Address(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public Long getId() {
        return id;
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

    public Author getAuthor() {
        return author;
    }
    public void removeAuthor() {
        this.author = null;
    }
}
