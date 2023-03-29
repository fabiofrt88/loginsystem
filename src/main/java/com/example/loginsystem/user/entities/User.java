package com.example.loginsystem.user.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String surname;

    private boolean isActive;

    @Column(length = 36)
    private String activationCode;

    @Column(unique = true)
    private String email;

    private String password;

    private LocalDateTime jwtCreatedOn;


    public User() {
    }

    public User(Long id, String name, String surname, boolean isActive, String activationCode, String email, String password, LocalDateTime jwtCreatedOn) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.isActive = isActive;
        this.activationCode = activationCode;
        this.email = email;
        this.password = password;
        this.jwtCreatedOn = jwtCreatedOn;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getJwtCreatedOn() {
        return jwtCreatedOn;
    }

    public void setJwtCreatedOn(LocalDateTime jwtCreatedOn) {
        this.jwtCreatedOn = jwtCreatedOn;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String setActivationCode) {
        this.activationCode = setActivationCode;
    }
}
