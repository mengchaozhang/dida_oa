package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.mapper.StudentMapper;
import com.qf.pojo.Classes;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.pojo.WeekReport;
import com.qf.service.SelfInfoManagerService;
import com.qf.service.StudentInfoManagerService;
import com.qf.service.WeekReportManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WeekReportController {
    @Autowired
    private WeekReportManagerService weekReportManagerService;

    @Autowired
    private StudentInfoManagerService studentInfoManagerService;

    @Autowired
    private SelfInfoManagerService selfInfoManagerService;

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("addWeekReport")
    public String addWeekReport() {
        return "add_weekreport";
    }

    @RequestMapping("goAddWeekReport")
    public String goAddWeekReport(WeekReport weekReport, HttpSession session) {
        int i = weekReportManagerService.addWeekReport(weekReport, (User)session.getAttribute("user"));
        if (i > 0) {
            return "redirect:addWeekReport";
        }
        return "redirect:addWeekReport";
    }

    @RequestMapping("lookWeekReport")
    public String lookWeekReport(@RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "0")int cid, HttpSession session, Model model,String title) {
        User uesr = (User) session.getAttribute("user");
        List<WeekReport> weekReportList = null;
        if ("student".equals(uesr.getRolename())) {
            Student student = selfInfoManagerService.getStudentByUid(uesr.getUid());
            PageHelper.startPage(pageNum, 5);
            weekReportList = weekReportManagerService.getWeekReportBySidLikeTitle(student.getSid(), title);
        } else {
            List<Student> studentList = studentMapper.getStudentListBycid(cid);
            List<Integer> sidList = new ArrayList<>();
            if (studentList.size() == 0) {
                weekReportList = null;
            } else {
                for (Student student : studentList) {
                    sidList.add(student.getSid());
                }
                PageHelper.startPage(pageNum, 5);
                weekReportList = weekReportManagerService.getWeekReportBySidList(sidList);
            }
            model.addAttribute("classes", studentInfoManagerService.getClassesByCid(cid));
        }
        PageInfo<WeekReport> pageInfo = new PageInfo<>(weekReportList);
        model.addAttribute("pageInfo", pageInfo);
        return "look_weekreport";
    }

    @RequestMapping("infoWeekReport")
    public String infoWeekReport(int wid,Integer cid, HttpServletRequest request) {
        WeekReport weekReport = weekReportManagerService.getWeekReportByWid(wid);
        if (cid != null) {
            Classes classes = studentInfoManagerService.getClassesByCid(cid);
            request.setAttribute("classes",classes);
        }
        request.setAttribute("weekReport", weekReport);
        return "info_weekreport";
    }

    @RequestMapping("scoringWeekReport")
    public String scoringWeekReport(WeekReport weekReport,int cid) {
        int i = weekReportManagerService.scoringWeekReport(weekReport);
        if (i > 0) {
            return "redirect:lookWeekReport?cid="+cid;
        }
        return "redirect:lookWeekReport?cid="+cid;
    }

    @RequestMapping("deleteWeekReport")
    @ResponseBody
    public String deleteWeekReport(int wid) {
        int i = weekReportManagerService.deleteWeekReport(wid);
        if (i > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

}
