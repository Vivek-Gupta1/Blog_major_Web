package com.dmw.model;

import jakarta.validation.constraints.Email;

public class RegisterM {

    private String firstName;
    private String lastName;
    private String email;
    private String pwd;

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public @Email String getEmail() {
        return email;
    }
    public String getPwd() {
        return pwd;
    }

    public void setFirstName(String fullname) {
        this.firstName = fullname;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail( String email) {
        this.email = email;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
