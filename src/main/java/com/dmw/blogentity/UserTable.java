package com.dmw.blogentity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;


@Entity
@Table(name = "User_Table")
public class UserTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    private String lastName;
    private String email;
    private String pwd;

    public Integer getUserId() {
        return userId;
    }
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
    public void setUserId(Integer userId) {
        this.userId = userId;
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
