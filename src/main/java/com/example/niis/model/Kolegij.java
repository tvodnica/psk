package com.example.niis.model;

import jakarta.persistence.*;

@Entity
public class Kolegij {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int ects;

    public Kolegij(Long id, String name, int ects) {
        this.id = id;
        this.name = name;
        this.ects = ects;
    }

    public Kolegij() {
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Kolegij{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ects=" + ects +
                '}';
    }
}
