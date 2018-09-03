package com.github.xenteros.dto;

public class AuthorCreateDto {

    private String firstName;
    private String lastName;
    private String addressUuid;

    public AuthorCreateDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddressUuid() {
        return addressUuid;
    }
}
