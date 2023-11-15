package com.example.quizwebsite.controller;

import com.example.quizwebsite.model.Category;
import com.example.quizwebsite.service.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name= "Categoty ",value = "/category")
public class CategoryServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //hien thi trang list danh muc
        req.getRequestDispatcher("/category/categories_List.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "category":
                try {
                    addCategory(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                break;
        }
    }

    public void addCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ClassNotFoundException, ServletException {
        String nameCategory = req.getParameter("categories");
        String describe = req.getParameter("describe");
        int id = Integer.parseInt(req.getParameter("id"));


        req.setAttribute("id",id);
        Category category = new Category(id, nameCategory, describe);
        userDAO.addCategory(category);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Categories_List.jsp");
        requestDispatcher.forward(req,resp);
        resp.sendRedirect("/Categories_List.jsp");
    }
}
