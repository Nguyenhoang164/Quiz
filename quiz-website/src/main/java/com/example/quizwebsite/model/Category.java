package com.example.quizwebsite.model;

public class Category {
    private int id;
    private String nameCategory;
    private String describe;

    public Category(int id, String nameCategory, String describe) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.describe = describe;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
