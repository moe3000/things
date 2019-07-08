package seven;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    //学号
    private int no;
    //姓名
    private String name;
    //性别
    private String sex;
    //专业
    private String major;

    public Student() {
    }

    public Student(int no, String name, String sex, String major) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.major = major;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
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

    @Override
    public String toString() {
        return "学号:" + no +", 姓名:" + name + ", 性别:" + sex + ", 专业:" + major;
    }
}
