package com.model;

import java.io.Serializable;

public class Student implements Serializable {

    private String stuid;

    private String name;

    private String major;

    public Student(String stuid, String name, String major) {
        this.stuid = stuid;
        this.name = name;
        this.major = major;
    }

    public Student() {
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
