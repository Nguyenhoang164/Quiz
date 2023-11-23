package com.example.quizwebsite.service;

import com.example.quizwebsite.model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategory {
    public static DataConnected dataConnected = new DataConnected();
    @Override
    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<>();
        try(PreparedStatement preparedStatement = dataConnected.getConnection().prepareStatement("select * from category " );) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String nameCategory = rs.getString("nameCategory");
                String describes = rs.getString("describes");
                categories.add(new Category(id,nameCategory,describes)) ;
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return  categories;
    }
    @Override
    public  void createCategory(Category category) {
        String query = "INSERT INTO category (nameCategory,describes) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = dataConnected.getConnection().prepareStatement(query);
            {
                preparedStatement.setString(1, category.getNameCategory());
                preparedStatement.setString(2, category.getDescribe());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
