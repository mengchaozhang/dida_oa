package com.qf.service.impl;

import com.qf.mapper.EmployeeMapper;
import com.qf.mapper.StudentMapper;
import com.qf.mapper.WeekReportMapper;
import com.qf.pojo.*;
import com.qf.service.WeekReportManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WeekReportManagerServiceImpl implements WeekReportManagerService {


    @Autowired
    private WeekReportMapper weekReportMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public int addWeekReport(WeekReport weekReport, User user) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createDate = sdf.format(new Date());
        Student student = studentMapper.getStudentByUid(user.getUid());
        weekReport.setCreateDate(createDate);
        weekReport.setStudent(student);
        return weekReportMapper.addWeekReport(weekReport);
    }

    @Override
    public int deleteWeekReport(int wid) {
        String score = weekReportMapper.getScoreByWid(wid);
        if (score == null) {
            return weekReportMapper.deleteWeekReport(wid);
        }
        return -1;
    }

    @Override
    public int scoringWeekReport(WeekReport weekReport) {
        weekReport.setIsDelete(2);
        return weekReportMapper.updateWeekReport(weekReport);
    }

    @Override
    public WeekReport getWeekReportByWid(int wid) {
        return weekReportMapper.getWeekReportByWid(wid);
    }

    @Override
    public List<WeekReport> getWeekReportBySidLikeTitle(int uid, String title) {
        Student student = studentMapper.getStudentByUid(uid);
        return weekReportMapper.getWeekReportBySidLikeTitle(student.getSid(), title);
    }

    @Override
    public List<WeekReport> getWeekReportBySidList(int cid) {
       /* Employee employee = employeeMapper.getEmployeeByUid(user.getUid());
        Classes classes = null;
        if ("teacher".equals(user.getRolename())) {
            classes = employeeMapper.getClassesByTeacherEid(employee.getEid());
        } else {
            classes = employeeMapper.getClassesByHeadmasterEid(employee.getEid());
        }*/

        List<Student> studentList = studentMapper.getStudentListBycid(cid);
        ArrayList<Integer> sidList = new ArrayList<>();
        for (Student student : studentList) {
            sidList.add(student.getSid());
        }
        return weekReportMapper.getWeekReportBySidList(sidList);
    }


}
