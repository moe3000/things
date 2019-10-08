package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/computeAvgScorePoint.do")
public class ScorePointServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String webStr = req.getParameter("web");
        String internetStr = req.getParameter("internet");
        String databaseStr = req.getParameter("database");
        System.out.println(webStr + "," + internetStr + "," + databaseStr);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            int web = Integer.parseInt(webStr);
            int internet = Integer.parseInt(internetStr);
            int database = Integer.parseInt(databaseStr);
        } catch (NumberFormatException e) {
            out.println("输入的成绩或学分有误！");
        }
    }


    private boolean isInt(String num) {
        for (int i = num.length();--i>=0;){
            if (!Character.isDigit(num.charAt(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
