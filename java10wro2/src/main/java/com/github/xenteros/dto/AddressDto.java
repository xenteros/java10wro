package com.github.xenteros.dto;

import com.github.xenteros.model.Address;

public class AddressDto {

    private String uuid;
    private String street;
    private String city;
    private String state;

    public AddressDto() {
    }

    public AddressDto(Address that) {
        this.uuid = that.getUuid();
        this.street = that.getStreet();
        this.city = that.getCity();
        this.state = that.getState();
    }

    public String getUuid() {
        return uuid;
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

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
}
