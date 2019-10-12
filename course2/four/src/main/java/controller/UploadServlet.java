package controller;

import model.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/upload.do")
@MultipartConfig(location = "D:\\temp\\", fileSizeThreshold = 1024)
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");

        String path1 = this.getServletContext().getRealPath("/");
        System.out.println(path1);
        String path = path1;
        Part p = req.getPart("fileName");

        UserBean userBean = (UserBean) req.getSession().getAttribute("user");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if (p.getSize() > 1024 * 1024) {
            p.delete();
            out.println("文件太大，不能上传！");
            return;
        } else {
            path = path + "\\student\\" + userBean.getAccount();
        }
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
        String h = p.getHeader("content-disposition");
        String fname = h.substring(h.lastIndexOf("\\") + 1, h.length() - 1);

        String fileType = fname.substring(fname.lastIndexOf("."));

        String newFileName = userBean.getAccount() + "_" + System.currentTimeMillis()  + fileType;
        p.write(path + "\\" + newFileName);
        out.println("文件上传成功");

        //写入记录
        File homeworkFile = new File(path1+ "homework.txt");
        if (!homeworkFile.exists()) {
            homeworkFile.createNewFile();
        }

        FileWriter fw = new FileWriter(homeworkFile, true);
        PrintWriter pw = new PrintWriter(fw);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String line = userBean.getAccount() + " " + userBean.getName() + "  " + title + "   " +  sdf.format(new Date()) + "  " + newFileName;
        pw.println(line);
        pw.flush();
        fw.flush();
        pw.close();
        fw.close();

    }

}
