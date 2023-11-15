package com.example.quizwebsite.service;

import com.example.quizwebsite.model.Category;
import com.example.quizwebsite.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserDAO implements IUserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public UserDAO() {
    }

    private String username = "root";
    private String password = "123123";
    private String url = "jdbc:mysql://localhost:3306/pik_quiz";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        String query = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
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

    public User getUserByEmail(String email) {
        User user = new User();
        String query = "SELECT * FROM users WHERE email = '" + email + "'";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
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
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setPermission(resultSet.getInt("permission"));
            userList.add(user);
        }
        return userList;
    }


    @Override
    public void addUser(User user) {
        String query = "INSERT INTO users (name, email, password, permission) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
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
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) throws SQLException, ClassNotFoundException {
        connection = getConnection();
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
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
        // Lấy các trường thông tin khác của người dùng từ ResultSet
        // và tạo đối tượng User
        return new User(id, username, email, password, permission);
    }

    public void addCategory(Category category) {
        String query = "INSERT INTO pik_quiz.category (nameCategory,describeCategory) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            {
                preparedStatement.setString(1, category.getNameCategory());
                preparedStatement.setString(2, category.getDescribe());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



//    public List<User> selectAllUsers() {
//
//
//        List<User> users = new ArrayList<>();
//        try (Connection connection = getConnection();
//
//
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//
//
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                int role = rs.getInt("role");
//                users.add(new User(role, name, email));
//            }
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return users;
//    }

}

