package com.qf.pojo;

public class Grade {
    private int gid;
    private Classes classes;
    private Student student;
    private String stage;
    private double score;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Grade(int gid, Classes classes, Student student, String stage, double score) {
        this.gid = gid;
        this.classes = classes;
        this.student = student;
        this.stage = stage;
        this.score = score;
    }

    public Grade(Classes classes, Student student, String stage, double score) {
        this.classes = classes;
        this.student = student;
        this.stage = stage;
        this.score = score;
    }

    public Grade() {
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gid=" + gid +
                ", classes=" + classes +
                ", student=" + student +
                ", stage='" + stage + '\'' +
                ", score=" + score +
                '}';
    }
}
