package com.example.quizwebsite.model;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private Date createAt;
    private int permission;

    public User() {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String name, String email) {
        this.email = email;
        this.name = name;
    }

    public User(int id, String name, String email, String password, int permission) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.permission = permission;
    }


    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(String name, String email, String password, int permission) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.permission = permission;
    }

    public User( String name, String email,int id, int permission) {
        this.permission = permission;
        this.name = name;
        this.email = email;
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}
