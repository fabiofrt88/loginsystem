package com.example.loginsystem.auth.entities;



public class RequestPwdDTO {

    private String email;

    public RequestPwdDTO() {
    }

    public RequestPwdDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
