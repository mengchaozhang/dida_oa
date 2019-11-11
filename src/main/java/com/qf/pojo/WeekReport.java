package com.qf.pojo;

public class WeekReport {
    private int wid;
    private String title;
    private String createDate;
    private String info;
    private Student student;
    private double score;
    private int isDelete;

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public WeekReport(int wid, String title, String createDate, String info, Student student, double score, int isDelete) {
        this.wid = wid;
        this.title = title;
        this.createDate = createDate;
        this.info = info;
        this.student = student;
        this.score = score;
        this.isDelete = isDelete;
    }

    public WeekReport(String title, String createDate, String info, Student student, double score, int isDelete) {
        this.title = title;
        this.createDate = createDate;
        this.info = info;
        this.student = student;
        this.score = score;
        this.isDelete = isDelete;
    }

    public WeekReport() {
    }

    @Override
    public String toString() {
        return "WeekReport{" +
                "wid=" + wid +
                ", title='" + title + '\'' +
                ", createDate='" + createDate + '\'' +
                ", info='" + info + '\'' +
                ", student=" + student +
                ", score=" + score +
                ", isDelete=" + isDelete +
                '}';
    }
}
