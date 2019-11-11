package com.qf.pojo;

public class Classes {
    private int cid;
    private String cname;
    private Course course;
    private String stage;
    private Employee teacher;
    private Employee headmaster;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Employee getTeacher() {
        return teacher;
    }

    public void setTeacher(Employee teacher) {
        this.teacher = teacher;
    }

    public Employee getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(Employee headmaster) {
        this.headmaster = headmaster;
    }

    public Classes(int cid, String cname, Course course, String stage, Employee teacher, Employee headmaster) {
        this.cid = cid;
        this.cname = cname;
        this.course = course;
        this.stage = stage;
        this.teacher = teacher;
        this.headmaster = headmaster;
    }

    public Classes(String cname, Course course, String stage, Employee teacher, Employee headmaster) {
        this.cname = cname;
        this.course = course;
        this.stage = stage;
        this.teacher = teacher;
        this.headmaster = headmaster;
    }

    public Classes() {
    }

    @Override
    public String toString() {
        return "Classes{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", course=" + course +
                ", stage='" + stage + '\'' +
                ", teacher=" + teacher +
                ", headmaster=" + headmaster +
                '}';
    }
}
