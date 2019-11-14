package com.qf.pojo;

public class EmployHoliday {
    private int hid;
    private int uid;
    private User user;
    private String startDate;
    private String EndDate;
    private String reason;
    private int state;
    private int flag;
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public EmployHoliday(User user, String startDate, String endDate, String reason, int state) {
        this.user = user;
        this.startDate = startDate;
        EndDate = endDate;
        this.reason = reason;
        this.state = state;
    }

    public EmployHoliday(int hid, User user, String startDate, String endDate, String reason, int state) {
        this.hid = hid;
        this.user = user;
        this.startDate = startDate;
        EndDate = endDate;
        this.reason = reason;
        this.state = state;
    }

    public EmployHoliday() {
    }

    public EmployHoliday(int hid, int uid, User user, String startDate, String endDate, String reason, int state) {
        this.hid = hid;
        this.uid = uid;
        this.user = user;
        this.startDate = startDate;
        EndDate = endDate;
        this.reason = reason;
        this.state = state;
    }

    public EmployHoliday(int hid, int uid, User user, String startDate, String endDate, String reason, int state, int flag) {
        this.hid = hid;
        this.uid = uid;
        this.user = user;
        this.startDate = startDate;
        EndDate = endDate;
        this.reason = reason;
        this.state = state;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "EmployHoliday{" +
                "hid=" + hid +
                ", uid=" + uid +
                ", user=" + user +
                ", startDate='" + startDate + '\'' +
                ", EndDate='" + EndDate + '\'' +
                ", reason='" + reason + '\'' +
                ", state=" + state +
                ", flag=" + flag +
                '}';
    }
}
