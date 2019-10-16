package com.controller;

import com.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/submitStudentInfo.do")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuid = req.getParameter("stuid");
        String name = req.getParameter("name");
        String major = req.getParameter("major");

        Student student = new Student(stuid, name, major);

        req.getSession().setAttribute("student", student);
        req.getRequestDispatcher(resp.encodeURL("/displayStudent.jsp")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
