package com.example.quizwebsite.controller;

import com.example.quizwebsite.model.User;
import com.example.quizwebsite.service.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminServlet",value = "/admin")
public class AdminServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "delete":
                    deleteUser(req, resp);
                    break;
                default:
                    showMainAdminPage(req,resp);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
     public void showMainAdminPage(HttpServletRequest request , HttpServletResponse response){
         try {
             List<User> userList = userDAO.getAllUsers();
             request.setAttribute("u",userList);
             request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
         } catch (ServletException | IOException | SQLException | ClassNotFoundException e) {
             throw new RuntimeException(e);
         }
     }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
            try {
                switch (action) {
                    case "listUser":
                        listUser(req, resp);
                        break;
                    case "delete":
                        deleteUser(req, resp);
                        break;
                }
            } catch (Exception ex) {
                throw new ServletException(ex);
            }
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<User> listUser = new ArrayList<>();
        try {
            listUser = userDAO.getAllUsers();
            request.setAttribute("listUser", listUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));
        int permission = Integer.parseInt(httpServletRequest.getParameter("permission"));
        try {
            if (permission == 0){
                System.out.println("cannotDelete");

            }else {
                userDAO.deleteUser(id);
                httpServletResponse.sendRedirect("/admin");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

//    public void blockUserById (HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        User user = userDAO.getUserById(id);
//        if (user.getPermission().equals("admin")) {
//            request.setAttribute("message", "khong the xoa doi tuong admin");
//            List<User> defaultListUser = userDAO.getAllUser();
//            request.setAttribute("defaultListUser", defaultListUser);
//            request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
//        } else {
//            if (user.getStatus() == null) {
//                userDAO.addBlockUser(id);
//                request.setAttribute("messageBlock", "thanh cong");
//                List<User> defaultListUser = userDAO.getAllUser();
//                request.setAttribute("defaultListUser", defaultListUser);
//                request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
//            } else {
//                if (user.getStatus().equals("working")) {
//                    userDAO.addBlockUser(id);
//                    List<User> defaultListUser = userDAO.getAllUser();
//                    request.setAttribute("messageBlock", "thanh cong");
//                    request.setAttribute("defaultListUser", defaultListUser);
//                    request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
//                } else {
//                    userDAO.removeBlockUser(id);
//                    List<User> defaultListUser = userDAO.getAllUser();
//                    request.setAttribute("messageRemove", "thanh cong");
//                    request.setAttribute("defaultListUser", defaultListUser);
//                    request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
//                }
//            }
//        }
//    }
}
