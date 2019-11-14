package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.Classes;
import com.qf.pojo.User;
import com.qf.pojo.WeekReport;
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
import java.util.List;

@Controller
public class WeekReportController {
    @Autowired
    private WeekReportManagerService weekReportManagerService;

    @Autowired
    private StudentInfoManagerService studentInfoManagerService;

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
        PageHelper.startPage(pageNum, 5);
        List<WeekReport> weekReportList = null;
        if ("student".equals(uesr.getRolename())) {
            weekReportList = weekReportManagerService.getWeekReportBySidLikeTitle(uesr.getUid(), title);
        } else {
            weekReportList = weekReportManagerService.getWeekReportBySidList(cid);
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
