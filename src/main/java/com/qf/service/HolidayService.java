package com.qf.service;

import com.qf.pojo.*;

import java.util.List;

public interface HolidayService {
    public int addStudentHoliday(StudentHoliday studentHoliday);

    public List<StudentHoliday> getApproveStudentHoliday(String username);

    public int updateTeacherState(int hid, int state, String username);

    public int updateHeadMaster(int hid, int state, String username);

    public int updatebossState(int hid, int state, String username);

    public int addEmployHoliday(EmployHoliday employHoliday);

    public List<EmployHoliday> getApproveEmployHoliday(String username);

    public int updateEmployHoliday(int hid, int state, String username);

    public List<StudentHoliday> getStudentHolidayList(User user);

    public List<EmployHoliday> getEmployHolidayList(User user);

    public List<StudentHoliday> getStuList();

    public List<EmployHoliday> getEmpList();

    public List<StudentHoliday> getSname();

    public List<EmployHoliday> getEname();
}
