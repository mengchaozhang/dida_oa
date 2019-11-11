package com.qf.pojo;

public class Employee {
    private int eid;
    private String ename;
    private String esex;
    private int eage;
    private String ephone;
    private User user;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public int getEage() {
        return eage;
    }

    public void setEage(int eage) {
        this.eage = eage;
    }

    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Employee(int eid, String ename, String esex, int eage, String ephone, User user) {
        this.eid = eid;
        this.ename = ename;
        this.esex = esex;
        this.eage = eage;
        this.ephone = ephone;
        this.user = user;
    }

    public Employee(String ename, String esex, int eage, String ephone, User user) {
        this.ename = ename;
        this.esex = esex;
        this.eage = eage;
        this.ephone = ephone;
        this.user = user;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", esex='" + esex + '\'' +
                ", eage=" + eage +
                ", ephone='" + ephone + '\'' +
                ", user=" + user +
                '}';
    }
}
