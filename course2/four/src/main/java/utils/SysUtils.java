package utils;

import model.UserBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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


    public static List<UserBean> getAllUsers(File file) throws IOException {
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);

        List<UserBean> users = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            UserBean user = readUser(line);
            users.add(user);
        }
        br.close();
        reader.close();
        return users;
    }

}
