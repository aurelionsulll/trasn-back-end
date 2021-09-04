package com.example.demo.model.user;

public class AuthData {

    private String email;
    private String password;

    public AuthData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public AuthData setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthData setPassword(String password) {
        this.password = password;
        return this;
    }
}
