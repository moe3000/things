package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet("/computeAvgScorePoint.do")
public class ScorePointServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String webStr = req.getParameter("websc");
        String internetStr = req.getParameter("internetsc");
        String databaseStr = req.getParameter("databasesc");

        String webopStr = req.getParameter("webop");
        String internetopStr = req.getParameter("internetop");
        String databaseopStr = req.getParameter("databaseop");

        System.out.println(webStr + "," + internetStr + "," + databaseStr);
        System.out.println(webopStr + "," + internetopStr + "," + databaseopStr);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            int websc = Integer.parseInt(webStr);
            int internetsc = Integer.parseInt(internetStr);
            int databasesc = Integer.parseInt(databaseStr);

            int webop = Integer.parseInt(webopStr);
            int internetop = Integer.parseInt(internetopStr);
            int databaseop = Integer.parseInt(databaseopStr);

            double webp = getPoint(websc);
            double internetp = getPoint(internetsc);
            double databasep = getPoint(databasesc);

            double result = (webp * webop + internetp * internetop + databasep * databaseop )
                    / (webop + internetop + databaseop);

            out.println("平均绩点:" + result);
        } catch (NumberFormatException e) {
            out.println("输入的成绩或学分有误！");
        }
    }


    private double getPoint(int score) {
        if (score < 60) {
            return 0;
        }
        return (score - 60) / 10.0d + 1;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
