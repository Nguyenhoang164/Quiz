package com.example.quizwebsite.model;

import java.util.Date;

// Teacher class
public class Teacher {

    private int id;
    private String name;
    private String email;
    private Date createdDate;
    private Date lastLogin;
    private boolean approved;

    public Teacher() {
    }

    public Teacher(String name, String email) {
        this.name = name;
        this.email = email;
        this.createdDate = new Date();
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
