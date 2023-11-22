package com.example.quizwebsite.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnected {
    private String localhost = "localhost:3306";
    private String dbname = "pik_quiz";
    private String name = "root";
    private String password = "Kamito@123";
    private String Url = "jdbc:mysql://" + localhost + "/" + dbname;
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(Url,name,password);
        return connection;
    }
}
