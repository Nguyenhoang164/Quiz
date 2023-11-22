package com.example.quizwebsite.controller;

import com.example.quizwebsite.model.User;
import com.example.quizwebsite.service.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SignUpServlet", value = "/signup")
public class SignUpServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sign-up/sign-up.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register":
                try {
                    signUpNewUser(request,response);
                    request.setAttribute("successMessage", "Đăng ký thành công!");
                    request.getRequestDispatcher("/login/login.jsp").forward(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                break;
        }
    }

    private void signUpNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException {
        String name = request.getParameter("displayName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        int permission = 0;
        if (role != null && role.equals("student")) {
            permission = 2;
        } else {
            permission = 1;
        }
        User newUser = new User(name, email, password, permission);
        userDAO.addUser(newUser);
    }
}