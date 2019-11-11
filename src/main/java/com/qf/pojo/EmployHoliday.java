package com.qf.pojo;

public class EmployHoliday {
    private int hid;
    private User user;
    private String startDate;
    private String EndDate;
    private String reason;
    private int state;

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

    @Override
    public String toString() {
        return "EmployHoliday{" +
                "hid=" + hid +
                ", user=" + user +
                ", startDate='" + startDate + '\'' +
                ", EndDate='" + EndDate + '\'' +
                ", reason='" + reason + '\'' +
                ", state=" + state +
                '}';
    }
}
