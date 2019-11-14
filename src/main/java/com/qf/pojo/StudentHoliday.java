package com.qf.pojo;

public class StudentHoliday {
    private int hid;
    private int uid;
    private User user;
    private String startDate;
    private String endDate;
    private String reason;
    private int teacherState;
    private int headmasterState;
    private int bossState;
    private int flag;
    private EmployHoliday employHoliday;
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public EmployHoliday getEmployHoliday() {
        return employHoliday;
    }

    public void setEmployHoliday(EmployHoliday employHoliday) {
        this.employHoliday = employHoliday;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getTeacherState() {
        return teacherState;
    }

    public void setTeacherState(int teacherState) {
        this.teacherState = teacherState;
    }

    public int getHeadmasterState() {
        return headmasterState;
    }

    public void setHeadmasterState(int headmasterState) {
        this.headmasterState = headmasterState;
    }

    public int getBossState() {
        return bossState;
    }

    public void setBossState(int bossState) {
        this.bossState = bossState;
    }

    public StudentHoliday(int hid, User user, String startDate, String endDate, String reason, int teacherState, int headmasterState, int bossState) {
        this.hid = hid;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.teacherState = teacherState;
        this.headmasterState = headmasterState;
        this.bossState = bossState;
    }

    public StudentHoliday(User user, String startDate, String endDate, String reason, int teacherState, int headmasterState, int bossState) {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.teacherState = teacherState;
        this.headmasterState = headmasterState;
        this.bossState = bossState;
    }

    public StudentHoliday() {
    }

    public StudentHoliday(int hid, int uid, User user, String startDate, String endDate, String reason, int teacherState, int headmasterState, int bossState) {
        this.hid = hid;
        this.uid = uid;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.teacherState = teacherState;
        this.headmasterState = headmasterState;
        this.bossState = bossState;
    }

    public StudentHoliday(int hid, int uid, User user, String startDate, String endDate, String reason, int teacherState, int headmasterState, int bossState, int flag, EmployHoliday employHoliday) {
        this.hid = hid;
        this.uid = uid;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.teacherState = teacherState;
        this.headmasterState = headmasterState;
        this.bossState = bossState;
        this.flag = flag;
        this.employHoliday = employHoliday;
    }

    @Override
    public String toString() {
        return "StudentHoliday{" +
                "hid=" + hid +
                ", uid=" + uid +
                ", user=" + user +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", reason='" + reason + '\'' +
                ", teacherState=" + teacherState +
                ", headmasterState=" + headmasterState +
                ", bossState=" + bossState +
                ", flag=" + flag +
                ", employHoliday=" + employHoliday +
                '}';
    }
}
