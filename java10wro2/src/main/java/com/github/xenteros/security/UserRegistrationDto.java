package com.github.xenteros.security;

public class UserRegistrationDto {

    private String username;
    private String password;

    public UserRegistrationDto() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
