package com.example.quizwebsite.controller;

import com.example.quizwebsite.model.Category;
import com.example.quizwebsite.service.CategoryDAO;
import com.example.quizwebsite.service.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name= "CategoryServlet",value = "/category")
public class CategoryServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String action = req.getParameter("action");
      if (action == null){
          action = "";
      }
      switch (action){
          case "createCategory":
              showPageCreateCategory(req,resp);
              break;
          default:
              showAllListCategory(req,resp);
              break;
      }
    }
    public void showPageCreateCategory(HttpServletRequest request , HttpServletResponse response){
        try {
            request.getRequestDispatcher("category/Create_more_categories.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showAllListCategory(HttpServletRequest req , HttpServletResponse resp){
        List<Category> categories = categoryDAO.getAllCategory();
        req.setAttribute("category",categories);
        //hien thi trang list danh muc
        try {
            req.getRequestDispatcher("category/Categories_List.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
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
                } catch (SQLException | ClassNotFoundException e) {
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
        Category category = new Category();
        category.setNameCategory(nameCategory);
        category.setDescribe(describe);
        categoryDAO.createCategory(category);
        List<Category> categories = categoryDAO.getAllCategory();
        req.setAttribute("category",categories);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("category/Categories_List.jsp");
        requestDispatcher.forward(req,resp);
    }
}