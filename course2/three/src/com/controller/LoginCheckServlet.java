package com.controller;

import com.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;

@WebServlet("/login.do")
public class LoginCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String pwd = req.getParameter("pwd");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        File file = new File("D:\\customer.txt");
        if (!file.exists()) {
            if (!file.createNewFile()) {
                // 文件创建失败
                out.println("请先注册");
            }
        }
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        try {
            Customer customer = (Customer) ois.readObject();
            if (!customer.getAccount().equals(account)) {
                out.println("用户名错误");
                return;
            }

            if (!customer.getPwd().equals(pwd)) {
                out.println("密码错误");
                return;
            }

            req.getSession().setAttribute("customer", customer);
            req.getRequestDispatcher(resp.encodeURL("/displayCustomer.jsp")).forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("用户信息读取错误");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
