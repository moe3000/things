package controller;

import model.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@WebServlet("/downloadHomework.do")
public class DownloadHomeworkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBean user = (UserBean) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/four/login.jsp");
            return;
        }

        String account = req.getParameter("account");
        String filename = req.getParameter("filename");


        if ("学生".equals(user.getType()) && !user.getAccount().equals(account)) {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("不能下载别人的作业");
            return;
        }

        String path = this.getServletContext().getRealPath("/") + "\\student\\" + account + "\\" + filename;

        FileInputStream fis = null;
        fis = new FileInputStream(path);
        OutputStream out = resp.getOutputStream();
        resp.setContentType("application/x-msdownload;");
        resp.setHeader("content-disposition", "attachment;filename=" + filename);
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
    }
}
