package com.qf.controller;

import com.qf.pojo.Grade;
import com.qf.pojo.Student;
import com.qf.service.GradeManagerService;
import com.qf.service.StudentInfoManagerService;
import com.qf.util.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ScoreController {

    @Autowired
    private StudentInfoManagerService studentInfoManagerService;

    @Autowired
    private GradeManagerService gradeManagerService;


    @RequestMapping("infoScore")
    public String infoScore(int cid, Model model) {
        List<Grade> gradeList = gradeManagerService.getGradeListByCid(cid);
        model.addAttribute("gradeList", gradeList);
        model.addAttribute("classes", studentInfoManagerService.getClassesByCid(cid));
        return "info_score";
    }

    @RequestMapping("entryScore")
    public String entryScore(int cid, Model model) {
        model.addAttribute("studentList", studentInfoManagerService.getStudentInfoListByCid(cid));
        model.addAttribute("classes", studentInfoManagerService.getClassesByCid(cid));
        return "entry_score";
    }

    @RequestMapping("goEntryScore")
    public String goEntryScore(String[] sid, String[] score, int cid, int stage) {
        if (stage == 1) {
            for (int i=0; i<sid.length; i++){
                gradeManagerService.updateScoreBySidAndStage1(score[i], Integer.parseInt(sid[i]));
            }
        } else if (stage == 2) {
            for (int i=0; i<sid.length; i++){
                gradeManagerService.updateScoreBySidAndStage2(score[i], Integer.parseInt(sid[i]));
            }
        } else if (stage == 3) {
            for (int i=0; i<sid.length; i++){
                gradeManagerService.updateScoreBySidAndStage3(score[i], Integer.parseInt(sid[i]));
            }
        } else if (stage == 4) {
            for (int i=0; i<sid.length; i++){
                gradeManagerService.updateScoreBySidAndStage4(score[i], Integer.parseInt(sid[i]));
            }
        }
        return "redirect:infoScore?cid=" + cid;
    }

    @RequestMapping("selfReport")
    public String selfReport(int sid,Model model) {
        Student student = studentInfoManagerService.getStudentBySid(sid);
        model.addAttribute("student", student);
        return "self_report";
    }

    @RequestMapping("selfInfoReport")
    @ResponseBody
    public Map<String, Object> selfInfoReport(int sid) {
        Map<String, Object> map = new HashMap<>();
        List<Double> list = new ArrayList<>();
        Grade grade = gradeManagerService.getGradeBySid(sid);
        if (null != grade.getStage1_score()) {
            list.add(Double.parseDouble(grade.getStage1_score()));
        }
        if (null != grade.getStage2_score()) {
            list.add(Double.parseDouble(grade.getStage2_score()));
        }
        if (null != grade.getStage3_score()) {
            list.add(Double.parseDouble(grade.getStage3_score()));
        }
        if (null != grade.getStage4_score()) {
            list.add(Double.parseDouble(grade.getStage4_score()));
        }
        map.put("scoreList", list);
        return map;
    }

    @RequestMapping("classesInfoReport")
    @ResponseBody
    public Map<String, Object> classesInfoReport(int cid) {
        Map<String, Object> map = new HashMap<>();
        List<Double> list = new ArrayList<>();
        Grade classesAvgGrade = gradeManagerService.getGradeAvgByCid(cid);
        if (null != classesAvgGrade.getStage1_score()) {
            list.add(NumberUtils.tranPointNum(1,Double.parseDouble(classesAvgGrade.getStage1_score())));
        }
        if (null != classesAvgGrade.getStage2_score()) {
            list.add(NumberUtils.tranPointNum(1,Double.parseDouble(classesAvgGrade.getStage2_score())));
        }
        if (null != classesAvgGrade.getStage3_score()) {
            list.add(NumberUtils.tranPointNum(1,Double.parseDouble(classesAvgGrade.getStage3_score())));
        }
        if (null != classesAvgGrade.getStage4_score()) {
            list.add(NumberUtils.tranPointNum(1,Double.parseDouble(classesAvgGrade.getStage4_score())));
        }
        map.put("scoreList", list);
        return map;

    }
}
