package com.qf.service;

import com.qf.pojo.WeekReport;

import java.util.List;

public interface WeekReportManagerService {

    public int addWeekReport(WeekReport weekReport);

    public int deleteWeekReport(int wid);

    public int scoringWeekReport(WeekReport weekReport);

    public List<WeekReport> getWeekReportBySidLikeTitle(int uid, String title);

    public List<WeekReport> getWeekReportBySidList(int uid);

}
