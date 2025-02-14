package com.uniovi.notaneitor.entities;


import javax.persistence.*;

@Entity
public class Professor {

    @Override
    public String toString() {
        return "Professor{" +
                "DNI=" + DNI +
                ", name='" + name + '\'' +
                ", surname='" + lastName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    @Id
    @GeneratedValue
    private Long id;
    private String DNI;
    private String name;
    private String lastName;
    private String category;


    public Professor() {

    }

    public Professor(Long id, String DNI, String name, String surname, String category) {
        this.id = id;
        this.DNI = DNI;
        this.name = name;
        this.lastName = surname;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String surname) {
        this.lastName = surname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDNI(String id) {
        this.DNI = id;
    }

    public String getDNI() {
        return DNI;
    }
}
