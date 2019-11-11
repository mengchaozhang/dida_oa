package com.qf.pojo;

public class Student {
    private int sid;
    private String sname;
    private String ssex;
    private int sage;
    private String sphone;
    private Classes classes;
    private User user;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Student(int sid, String sname, String ssex, int sage, String sphone, Classes classes, User user) {
        this.sid = sid;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
        this.sphone = sphone;
        this.classes = classes;
        this.user = user;
    }

    public Student(String sname, String ssex, int sage, String sphone, Classes classes, User user) {
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
        this.sphone = sphone;
        this.classes = classes;
        this.user = user;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", sphone='" + sphone + '\'' +
                ", classes=" + classes +
                ", user=" + user +
                '}';
    }
}
