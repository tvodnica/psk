package com.example.niis.security;

public class RefreshTokenRequestDTO {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RefreshTokenRequestDTO() {
    }

    public RefreshTokenRequestDTO(String token) {
        this.token = token;
    }
}