package controller;

import model.HomeworkBean;
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

@WebServlet("/myHomework.html")
public class MyHomeworkServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBean user = (UserBean) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login.jsp");
            return;
        }

        String path1 = this.getServletContext().getRealPath("/");
        File homeworkFile = new File(path1+ "homework.txt");
        List<HomeworkBean> homeworks = SysUtils.getAllHomeworks(homeworkFile);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html><html><head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>我的作业</title>");
        out.println("</head><body>");
        out.println("<table border=1>");
        out.println("<h4>我的作业</h4>");
        out.println("<tr><td>序号</td><td>学号</td><td>姓名</td><td>作业标题</td><td>上传时间</td><td>下载</td>");

        for (int i = 0; i < homeworks.size(); i++) {
            HomeworkBean homework = homeworks.get(i);
            if (!homework.getName().equals(user.getName())) {
                continue;
            }

            out.println("<tr align=center>");
            out.println("<td>"+ (i + 1) +"</td>");
            out.println("<td>"+ homework.getAccount() +"</td>");
            out.println("<td>"+ homework.getName() +"</td>");
            out.println("<td>"+ homework.getTitle() +"</td>");
            out.println("<td>"+ homework.getUploadTime() +"</td>");
            out.println("<td>"+ "<a href='/four/downloadHomework.do?account=" + homework.getAccount() + "&" + "filename=" + homework.getFilename() + "'>下载</a>" +"</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
