package com.qf.mapper;

import com.qf.pojo.*;

import java.util.List;

public interface HolidayMapper {

    //学生请假流程

    /**
     *学生发起请假
     */
    public int addStudentHoliday(StudentHoliday studentHoliday);
    /**
     *查询待审批学生请假
     */
    public List<StudentHoliday> getApproveStudentHoliday(List<String> list);
    /**
     * 讲师审批
     */
    public int updateTeacherState(int hid,int state);
    /**
     * 班主任审批
     */
    public int updateHeadMaster(int hid,int state );
    /**
     * 校长审批
     */
    public int updatebossState(int hid,int state );


    //员工请假流程

    /**
     * 员工发起请假
     */
    public int addEmployHoliday(EmployHoliday employHoliday);
    /**
     * 查询待审批员工请假
     */
    public List<EmployHoliday> getApproveEmployHoliday(List<String> list);
    /**
     * 校长审批
     */
    public int updateEmployHoliday(int hid,int state);

    //辅助方法
    /**
     * 查询user表中所有用户
     */
    public List<User> getUserNameList();
    /**
     * 查询studentHoliday表显示学生假条信息
     */
    public List<StudentHoliday> getStudentHolidayList(int uid);
    /**
     * 查询employHoliday表中的请假信息
     */
    public List<EmployHoliday> getEmployHolidayList(int uid);
    /**
     * 查看的请假记录
     */
    public List<StudentHoliday> getStuList();
    public List<EmployHoliday> getEmpList();
    /**
     * 获取学生、教师、班主任真名
     */
    public List<StudentHoliday> getSname();
    public List<EmployHoliday> getEname();
}
