package utils;

import model.HomeworkBean;
import model.UserBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SysUtils {

    public static UserBean readUser(String line) {
        String[] cols = line.split(" ");

        UserBean userBean = new UserBean();
        userBean.setAccount(cols[0]);
        userBean.setPwd(cols[1]);
        userBean.setName(cols[2]);
        userBean.setType(cols[3]);

        return userBean;
    }

    public static HomeworkBean readHomework(String line) {
        String[] cols = line.split("\\|");

        HomeworkBean homeworkBean = new HomeworkBean();
        homeworkBean.setAccount(cols[0]);
        homeworkBean.setName(cols[1]);
        homeworkBean.setTitle(cols[2]);
        homeworkBean.setUploadTime(cols[3]);
        homeworkBean.setFilename(cols[4]);
        return homeworkBean;
    }


    public static List<UserBean> getAllUsers(File file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

        List<UserBean> users = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            UserBean user = readUser(line);
            users.add(user);
        }
        br.close();
        return users;
    }

    public static List<HomeworkBean> getAllHomeworks(File file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

        List<HomeworkBean> homeworkBeans = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            HomeworkBean homeworkBean = readHomework(line);
            homeworkBeans.add(homeworkBean);
        }
        br.close();
        return homeworkBeans;
    }

}
