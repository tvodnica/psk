package com.example.niis.security;

import jakarta.persistence.*;

@Entity
@Table(name = "ROLES")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    private String name;

    public UserRole(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserRole(String name) {
        this.name = name;
    }

    public UserRole() {
    }
}
