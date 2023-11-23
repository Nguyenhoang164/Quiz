package com.example.quizwebsite.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TeacherServlet" , value = "/teacher")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "showPageCategory" :
                showHomeCategory(req,resp);
                break;
            default:
                showHomePageTeacher(resp,req);
                break;
        }
    }
    public void showHomeCategory(HttpServletRequest request , HttpServletResponse response){
        try {
            response.sendRedirect("category");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showHomePageTeacher(HttpServletResponse response , HttpServletRequest request){
        try {
            request.getRequestDispatcher("home/teacher_home.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){

        }
    }
}
