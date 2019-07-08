package seven;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    //学号
    private String no;
    //姓名
    private String name;
    //性别
    private String sex;
    //专业
    private String major;

    public Student() {
    }

    public Student(String no, String name, String sex, String major) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.major = major;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String writeToLine() {
        if (no == null || name == null || sex == null || major == null) {
            throw new MISException("信息不全，请重新输入");
        }
        return no + "," + name + "," + sex + "," + major;
    }



}
