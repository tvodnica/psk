package com.example.niis.security;

public class JwtResponseDTO {
    private String accessToken;
    private String token;

    public JwtResponseDTO(String accessToken, String token) {
        this.accessToken = accessToken;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }

    public JwtResponseDTO() {
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}