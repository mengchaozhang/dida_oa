package com.qf.mapper;

import com.qf.pojo.WeekReport;

import java.util.List;

public interface WeekReportMapper {

    public int addWeekReport(WeekReport weekReport);

    public int deleteWeekReport(int wid);

    public int updateWeekReport(WeekReport weekReport);

    public List<WeekReport> getWeekReportLikeTitle(String Title);

}
