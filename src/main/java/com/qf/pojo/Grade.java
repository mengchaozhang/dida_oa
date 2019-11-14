package com.qf.pojo;

public class Grade {
    private int gid;
    private Classes classes;
    private Student student;
    private String stage1_score;
    private String stage2_score;
    private String stage3_score;
    private String stage4_score;

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

    public String getStage1_score() {
        return stage1_score;
    }

    public void setStage1_score(String stage1_score) {
        this.stage1_score = stage1_score;
    }

    public String getStage2_score() {
        return stage2_score;
    }

    public void setStage2_score(String stage2_score) {
        this.stage2_score = stage2_score;
    }

    public String getStage3_score() {
        return stage3_score;
    }

    public void setStage3_score(String stage3_score) {
        this.stage3_score = stage3_score;
    }

    public String getStage4_score() {
        return stage4_score;
    }

    public void setStage4_score(String stage4_score) {
        this.stage4_score = stage4_score;
    }
}
