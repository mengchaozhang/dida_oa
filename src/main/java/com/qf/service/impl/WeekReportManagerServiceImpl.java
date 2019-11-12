package com.qf.service.impl;

import com.qf.mapper.EmployeeMapper;
import com.qf.mapper.StudentMapper;
import com.qf.mapper.WeekReportMapper;
import com.qf.pojo.Classes;
import com.qf.pojo.Employee;
import com.qf.pojo.Student;
import com.qf.pojo.WeekReport;
import com.qf.service.WeekReportManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public int addWeekReport(WeekReport weekReport) {
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
        return weekReportMapper.updateWeekReport(weekReport);
    }

    @Override
    public List<WeekReport> getWeekReportBySidLikeTitle(int uid, String title) {
        Student student = studentMapper.getStudentByUid(uid);
        return weekReportMapper.getWeekReportBySidLikeTitle(student.getSid(), title);
    }

    @Override
    public List<WeekReport> getWeekReportBySidList(int uid) {
        Employee employee = employeeMapper.getEmployeeByUid(uid);
        Classes classes = employeeMapper.getClassesByEid(employee.getEid());
        List<Student> studentList = studentMapper.getStudentListBycid(classes.getCid());
        ArrayList<Integer> sidList = new ArrayList<>();
        for (Student student : studentList) {
            sidList.add(student.getSid());
        }
        return weekReportMapper.getWeekReportBySidList(sidList);
    }


}
