package com.qf.controller;

import com.qf.pojo.EmployHoliday;
import com.qf.pojo.Student;
import com.qf.pojo.StudentHoliday;
import com.qf.pojo.User;
import com.qf.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HolidayController {
   @Autowired
    private HolidayService holidayService;

    public HolidayService getHolidayService() {
        return holidayService;
    }

    public void setHolidayService(HolidayService holidayService) {
        this.holidayService = holidayService;
    }
    /**
     * 学生请假流程
     * @return
     */
    @RequestMapping("stuholiday")
    public String stuholiday(){
        return "holiday";
    }
    @RequestMapping("addHoliday")
    public String holiday(StudentHoliday studentHoliday,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        studentHoliday.setUser(user);
        holidayService.addStudentHoliday(studentHoliday);
        return "redirect:index";
    }
    //学生查询自己的请假记录
    @RequestMapping("holidayList")
    public String waitApproval(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<StudentHoliday> list=holidayService.getStudentHolidayList(user);
        request.setAttribute("list",list);
        return "allholiday";
    }
    //讲师、班主任、校长查询待审批的假条
    @RequestMapping("studentholiday")
    public String studentholiday(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<StudentHoliday> list = holidayService.getApproveStudentHoliday(user.getUsername());
        request.setAttribute("list",list);
        return "wait_approval";
    }
    @RequestMapping("allupdate")
    public String teacher(int hid,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user.getRolename().equals("teacher")){
            holidayService.updateTeacherState(hid,1,user.getUsername());
        }else if (user.getRolename().equals("headmaster")){
            holidayService.updateHeadMaster(hid,1,user.getUsername());
        }else if (user.getRolename().equals("boss")){
            holidayService.updatebossState(hid,1,user.getUsername());
            return "redirect:transfer";
        }
        return "redirect:studentholiday";
    }
    /**
     * 员工请假流程
     */
    @RequestMapping("empholiday")
    public String empholiday(){
        return "employholiday";
    }
    @RequestMapping("addemp")
    public String addemp(EmployHoliday employHoliday,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        employHoliday.setUser(user);
        holidayService.addEmployHoliday(employHoliday);
        return "redirect:index";
    }
    //员工查询自己的请假记录
    @RequestMapping("empholidaylist")
    public String empApproval(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<EmployHoliday> empList = holidayService.getEmployHolidayList(user);
        request.setAttribute("empList",empList);
        return "allholiday";
    }
    @RequestMapping("bossupdate")
    public String bossupdate(int hid,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        holidayService.updateEmployHoliday(hid,1,user.getUsername());
        return "redirect:transfer";
    }
    //校长查询请假历史记录
    @RequestMapping("stuemp")
    public String stuemp(HttpServletRequest request){
        List<StudentHoliday> list = holidayService.getSname();
        System.out.println(list);
        List<EmployHoliday> empList = holidayService.getEname();
        request.setAttribute("list",list);
        request.setAttribute("empList",empList);
        return "historyholiday";
    }
    //讲师、班主任查看学生请假历史记录
    @RequestMapping("teahea")
    public String teahea(HttpServletRequest request){
        List<StudentHoliday> list = holidayService.getSname();
        request.setAttribute("list",list);
        return "historyholiday";
    }
    //校长待审批跳转此处
    @RequestMapping("transfer")
    public String transfer(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<StudentHoliday> list = holidayService.getApproveStudentHoliday(user.getUsername());
        List<EmployHoliday> empList = holidayService.getApproveEmployHoliday(user.getUsername());
        request.setAttribute("list",list);
        request.setAttribute("empList",empList);
        return "wait_approval";
    }
}
