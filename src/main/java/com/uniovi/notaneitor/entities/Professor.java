package com.uniovi.notaneitor.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


public class Professor {

    @Override
    public String toString() {
        return "Professor{" +
                "DNI=" + DNI +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    private Long DNI;
    private String name;
    private String surname;
    private String category;


    public Professor() {

    }

    public Professor(long DNI, String name, String surname, String category) {
        this.DNI = DNI;
        this.name = name;
        this.surname = surname;
        this.category = category;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDNI(Long id) {
        this.DNI = id;
    }

    public Long getDNI() {
        return DNI;
    }
}
