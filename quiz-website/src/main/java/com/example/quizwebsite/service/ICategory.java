package com.example.quizwebsite.service;

import com.example.quizwebsite.model.Category;

import java.util.List;

public interface ICategory {
    List<Category> getAllCategory();
    void createCategory(Category category);
//    Category findCategory(int id);
//    void deleteCategory(int id);
}
