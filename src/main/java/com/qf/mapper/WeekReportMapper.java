package com.qf.mapper;

import com.qf.pojo.WeekReport;

import java.util.List;

public interface WeekReportMapper {

    public int addWeekReport(WeekReport weekReport);

    public int deleteWeekReport(int wid);

    public int updateWeekReport(WeekReport weekReport);

    public WeekReport getWeekReportByWid(int wid);

    public String getScoreByWid(int wid);

    public List<WeekReport> getWeekReportBySidLikeTitle(int sid, String title);

    public List<WeekReport> getWeekReportBySidList(List<Integer> sidList);


}
