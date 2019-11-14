package com.qf.service;

import com.qf.mapper.HolidayMapper;
import com.qf.pojo.*;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class HolidayServiceImpl implements HolidayService {
    @Autowired
    private HolidayMapper holidayMapper;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    public RuntimeService getRuntimeService() {
        return runtimeService;
    }

    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public HolidayMapper getHolidayMapper() {
        return holidayMapper;
    }

    public void setHolidayMapper(HolidayMapper holidayMapper) {
        this.holidayMapper = holidayMapper;
    }

    /**
     *增加学生假条信息,发起请假流程
     * @param studentHoliday
     * @return
     */
    @Override
    public int addStudentHoliday(StudentHoliday studentHoliday) {
        //获取user表中的所有用户
        List<User> list = holidayMapper.getUserNameList();
        Map<String,Object> map = new HashMap<>();
        map.put("sname",studentHoliday.getUser().getUsername());
        //遍历集合根据角色获取讲师、班主任、校长名字
        for (User u : list){
            if (u.getRolename().equals("teacher")){
                map.put("tname",u.getUsername());
            }else if (u.getRolename().equals("headmaster")){
                map.put("hname",u.getUsername());
            }else if (u.getRolename().equals("boss")){
                map.put("bname",u.getUsername());
            }
        }
        //获取请假天数
        int days = getDays(studentHoliday.getStartDate(),studentHoliday.getEndDate());
        map.put("days",days);
        //如果天数大于3天需要将校长审批的状态修改为未审批，0代表未审批
        if (days >= 3){
            studentHoliday.setBossState(0);
            holidayMapper.addStudentHoliday(studentHoliday);
        }else{
            //请假天数小于3天直接增加请假信息
            studentHoliday.setBossState(1);
            holidayMapper.addStudentHoliday(studentHoliday);
        }
        //发起流程实例
        runtimeService.startProcessInstanceByKey("stuHoliday",studentHoliday.getHid()+"",map);
        //完成任务
        Task task = taskService.createTaskQuery().processDefinitionKeyLike("stuHoliday").taskAssignee(studentHoliday.getUser().getUsername()).singleResult();
        taskService.complete(task.getId());
        return studentHoliday.getHid();
    }

    /**
     * 获取请假天数
     */
   private int getDays(String startDate,String endDate){
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
       Date start = null;
       Date end = null;
       try {
           start = simpleDateFormat.parse(startDate);
           end = simpleDateFormat.parse(endDate);
       } catch (ParseException e) {
           e.printStackTrace();
       }
       long daysTime = end.getTime() - start.getTime();
       int days = (int) (daysTime/(24*60*60*1000));
       return days;
   }

    @Override
    public List<StudentHoliday> getApproveStudentHoliday(String username) {
        //获取待办任务集合
        List<Task> list = taskService.createTaskQuery().taskAssignee(username).list();
        List<String> bussinessKeys = new ArrayList<>();
        //循环遍历获取bussiness Keys，即请假的id
        for (Task task:list){
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                    .processInstanceId(task.getProcessInstanceId()).singleResult();
            bussinessKeys.add(processInstance.getBusinessKey());
        }
        List<StudentHoliday> approveHolidayList = new ArrayList<>();
        if (bussinessKeys.size() != 0){
            approveHolidayList = holidayMapper.getApproveStudentHoliday(bussinessKeys);
        }
        return approveHolidayList;
    }

    @Override
    public int updateTeacherState(int hid, int state, String username) {
        //完成任务
        Task task = taskService.createTaskQuery().processInstanceBusinessKey(hid+"").taskAssignee(username).singleResult();
        taskService.complete(task.getId());
        //审核通过
        return holidayMapper.updateTeacherState(hid,state);
    }

    @Override
    public int updateHeadMaster(int hid, int state, String username) {
        //完成任务
        Task task = taskService.createTaskQuery().processInstanceBusinessKey(hid+"").taskAssignee(username).singleResult();
        taskService.complete(task.getId());
        //审核通过
        return holidayMapper.updateHeadMaster(hid, state);
    }

    @Override
    public int updatebossState(int hid, int state, String username) {
        //完成任务
        Task task = taskService.createTaskQuery().processInstanceBusinessKey(hid+"").taskAssignee(username).singleResult();
        taskService.complete(task.getId());
        //审核通过
        return holidayMapper.updatebossState(hid, state);
    }

    /**
     * 员工请假流程
     * @param employHoliday
     * @return
     */
    @Override
    public int addEmployHoliday(EmployHoliday employHoliday) {
        //获取user表中的所有用户
        List<User> list = holidayMapper.getUserNameList();
        Map<String,Object> map = new HashMap<>();
        map.put("ename",employHoliday.getUser().getUsername());
        //遍历集合根据角色获取讲师、班主任、校长名字
        for (User u : list){
            if (u.getRolename().equals("boss")){
                map.put("bname",u.getUsername());
            }
        }
        //获取请假天数
        int days = getDays(employHoliday.getStartDate(),employHoliday.getEndDate());
        map.put("days",days);
        holidayMapper.addEmployHoliday(employHoliday);

        //发起流程实例
        runtimeService.startProcessInstanceByKey("empHoliday",employHoliday.getHid()+"",map);
        //完成任务
        Task task = taskService.createTaskQuery().processDefinitionKeyLike("empHoliday").taskAssignee(employHoliday.getUser().getUsername()).singleResult();
        taskService.complete(task.getId());
        return employHoliday.getHid();
    }

    @Override
    public List<EmployHoliday> getApproveEmployHoliday(String username) {
        System.out.println(username);
        //获取待办任务集合
        List<Task> list = taskService.createTaskQuery().taskAssignee(username).list();
        List<String> bussinessKeys = new ArrayList<>();
        //循环遍历获取bussiness Keys，即请假的id
        for (Task task:list){
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                    .processInstanceId(task.getProcessInstanceId()).singleResult();
            bussinessKeys.add(processInstance.getBusinessKey());
        }
        List<EmployHoliday> approveHolidayList = new ArrayList<>();
        if (bussinessKeys.size() != 0){
            approveHolidayList = holidayMapper.getApproveEmployHoliday(bussinessKeys);
        }
        return approveHolidayList;
    }

    @Override
    public int updateEmployHoliday(int hid, int state, String username) {
        //完成任务
        Task task = taskService.createTaskQuery().processInstanceBusinessKey(hid+"").taskAssignee(username).singleResult();
        taskService.complete(task.getId());
        //审核通过
        return holidayMapper.updateEmployHoliday(hid, state);
    }

    @Override
    public List<StudentHoliday> getStudentHolidayList(User user) {
       return holidayMapper.getStudentHolidayList(user.getUid());
    }

    @Override
    public List<EmployHoliday> getEmployHolidayList(User user) {
        return holidayMapper.getEmployHolidayList(user.getUid());
    }

    /**
     * 校长分别查看两个表的请假信息
     * @return
     */
    @Override
    public List<StudentHoliday> getStuList() {
        return holidayMapper.getStuList();
    }

    @Override
    public List<EmployHoliday> getEmpList() {
        return holidayMapper.getEmpList();
    }

    @Override
    public List<StudentHoliday> getSname() {
        return holidayMapper.getSname();
    }

    @Override
    public List<EmployHoliday> getEname() {
        return holidayMapper.getEname();
    }
}
