package com.example.quizwebsite.service;

import com.example.quizwebsite.model.Category;
import com.example.quizwebsite.model.User;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    public static DataConnected dataConnected = new DataConnected();

    @Override
    public User getUserById(int userId) {
        User user = null;
        String query = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement statement = dataConnected.getConnection().prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = extractUserFromResultSet(resultSet);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
@Override
    public User getUserByEmail(String email) {
        User user = new User();
        String query = "SELECT * FROM users WHERE email = '" + email + "'";
        try (PreparedStatement statement = dataConnected.getConnection().prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setPermission(resultSet.getInt("permission"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM users";
        Statement statement = dataConnected.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setPermission(resultSet.getInt("permission"));
            user.setStatus(resultSet.getString("status"));
            java.sql.Time sqlTime = resultSet.getTime("timeLogin");
            if (sqlTime != null) {
                user.setTimeLogin(sqlTime.toLocalTime());
            }

            userList.add(user);
        }
        return userList;
    }


    @Override
    public void addUser(User user) {
        String query = "INSERT INTO users (name, email, password, permission) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = dataConnected.getConnection().prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getPermission());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(User user) {
        String query = "UPDATE users SET username = ?, email = ? WHERE id = ?";
        try (PreparedStatement statement = dataConnected.getConnection().prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = dataConnected.getConnection().prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String username = resultSet.getString("name");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        int permission = resultSet.getInt("permission");
        String status = resultSet.getString("status");
        // Lấy các trường thông tin khác của người dùng từ ResultSet
        // và tạo đối tượng User
        return new User(id, username, email, password, permission,status);
    }

    public void addCategory(Category category) {
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

    @Override
    //Phương thức để ban giáo viên mới đăng ký xong duyệt để unban
    public void checkUser(int id) throws SQLException, ClassNotFoundException {
        String query = "update users set status = ? where id = ?";
        PreparedStatement preparedStatement = dataConnected.getConnection().prepareStatement(query);
        preparedStatement.setString(1,"accepted");
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        dataConnected.getConnection().close();
    }

    @Override
    public List<Category> selectCategory() {
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
    public void updateTimeLogin(String email){
        try {
            Connection connection = dataConnected.getConnection();
            String query = "update users set timeLogin = '" + LocalTime.now() +"' where email = '" + email +"'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

