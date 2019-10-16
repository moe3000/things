package controller;

import model.UserBean;
import utils.SysUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login.do")
public class LoginActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String pwd = req.getParameter("pwd");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();


        String path = this.getServletContext().getRealPath("/")+ "user.txt";
        File file = new File(path);

        List<UserBean> users = SysUtils.getAllUsers(file);
        for (UserBean user: users
             ) {
            if (!user.getAccount().equals(account)) {
                continue;
            }

            if (!user.getPwd().equals(pwd)) {
                out.println("密码错误");
            }

            req.getSession().setAttribute("user", user);
            if ("学生".equals(user.getType())) {
                req.getRequestDispatcher(resp.encodeURL("/studentOperation.jsp")).forward(req, resp);
            } else {
                req.getRequestDispatcher(resp.encodeURL("/homework.html")).forward(req, resp);
            }
            return;
        }
        out.println("不存在的用户");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
