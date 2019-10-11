package com.controller;

import com.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

@WebServlet("/register.do")
public class CustomerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String pwd = req.getParameter("pwd");
        String name = req.getParameter("name");
        String idCard = req.getParameter("idCard");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if (!verifyAccount(account)) {
            out.println("账号格式错误");
            return;
        }

        if (!verifyPwd(pwd)) {
            out.println("密码格式错误");
            return;
        }

        if (!verifyName(name)) {
            out.println("姓名格式错误");
            return;
        }

        if (!verifyIdCard(idCard)) {
            out.println("身份证格式错误");
            return;
        }

        if (!verifyEmail(email)) {
            out.println("邮箱格式错误");
            return;
        }

        if (!verifyPhone(phone)) {
            out.println("手机号格式错误");
            return;
        }

        Customer customer = new Customer();
        customer.setAccount(account);
        customer.setEmail(email);
        customer.setIdCard(idCard);
        customer.setName(name);
        customer.setPhone(phone);
        customer.setPwd(pwd);

        File file = new File("D:\\customer.txt");
        if (!file.exists()) {
            if (!file.createNewFile()) {
                // 文件创建失败
                out.println("用户信息写入错误");
            }
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(customer);
        req.getSession().setAttribute("customer", customer);
        req.getRequestDispatcher(resp.encodeURL("/displayCustomer.jsp")).forward(req, resp);
    }

    private boolean verifyAccount(String account) {
        return account.matches("[0-9a-zA-Z]*");
    }

    private boolean verifyPwd(String pwd) {
//        return pwd.matches("^(?![0-9]+$)(?![^0-9]+$)(?![a-zA-Z]+$)(?![^a-zA-Z]+$)(?![a-zA-Z0-9]+$)[a-zA-Z0-9\\\\S]+$");
        return true;
    }

    private boolean verifyName(String name) {
        if (name == null || "".equals(name)) {
            return false;
        }

        char[] c = name.toCharArray();
        for (char value : c) {
            if (value < 0x4E00 || value > 0x9FA5) {
                return false;
            }
        }

        return true;
    }

    private boolean verifyIdCard(String idCard) {
        return true;
    }

    private boolean verifyEmail(String email) {
        return email.contains("@");
    }

    private boolean verifyPhone(String phone) {
        return phone.matches("^1\\d{10}$");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
