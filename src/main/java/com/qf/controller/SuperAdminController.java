package com.qf.controller;

import com.qf.pojo.Classes;
import com.qf.pojo.Course;
import com.qf.service.SuperAdmin_ClassesService;
import com.qf.service.SuperAdmin_CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SuperAdminController {
    @Autowired
    private SuperAdmin_ClassesService superAdmin_classesService;

    public SuperAdmin_ClassesService getSuperAdmin_classesService() {
        return superAdmin_classesService;
    }

    public void setSuperAdmin_classesService(SuperAdmin_ClassesService superAdmin_classesService) {
        this.superAdmin_classesService = superAdmin_classesService;
    }
    @Autowired
    private SuperAdmin_CourseService superAdmin_courseService;

    public SuperAdmin_CourseService getSuperAdmin_courseService() {
        return superAdmin_courseService;
    }

    public void setSuperAdmin_courseService(SuperAdmin_CourseService superAdmin_courseService) {
        this.superAdmin_courseService = superAdmin_courseService;
    }

    //功能实现
    //班级管理
    @RequestMapping("BJGL")
    public String KCHHL(HttpServletRequest request){
        Classes classes = new Classes();
        Course course = new Course();

        List<Classes>list = superAdmin_classesService.BJCK(classes);
        List<Course> list1 = superAdmin_courseService.KCCK(course);

        request.getSession().setAttribute("BJlist",list);
        request.getSession().setAttribute("KClist",list1);
        System.out.println(list1.size());
        return "BJGL";
    }

    //课程管理
    @RequestMapping("KCGL")
    public String KCGL(HttpServletRequest request){
        Course course =new Course();
        System.out.println(course);
        System.out.println("111111111111111111");
        List<Course>list = superAdmin_courseService.KCCK(course);
        request.getSession().setAttribute("KClist",list);
        System.out.println("2222222222222222222");
        System.out.println(list);
        return "KCGL";
    }
    @RequestMapping("KCXG")
    public String KCXG(HttpServletRequest request,String courseName){
        return "";
    }
    @RequestMapping("KCSC")
    public String KCSC(HttpServletRequest request){
        return "";
    }
    @RequestMapping("KCTJ")
    public String KCTJ(HttpServletRequest request){
        return "";
    }

    //员工管理
    @RequestMapping("YGGL")
    public String YGGL(HttpServletRequest request){
        return "";
    }
    @RequestMapping("YGXG")
    public String YGXG(HttpServletRequest request){
        return "";
    }
    @RequestMapping("YGSC")
    public String YGSC(HttpServletRequest request){
        return "";
    }
    @RequestMapping("YGTJ")
    public String YGTJ(HttpServletRequest request){
        return "";
    }


    //用户管理
    @RequestMapping("YHGL")
    public String YHGL(HttpServletRequest request){
        return "";
    }

    @RequestMapping("YHTJ")
    public String YHTJ(HttpServletRequest request){
        return "";
    }

    @RequestMapping("YHXG")
    public String YHXG(HttpServletRequest request){
        return "";
    }

    @RequestMapping("YHSC")
    public String YHSC(HttpServletRequest request){
        return "";
    }

    //校色管理
    @RequestMapping("JSGL")
    public String JSGL(HttpServletRequest request){
        return "";
    }

    @RequestMapping("JSTJ")
    public String JSTJ(HttpServletRequest request){
        return "";
    }

    @RequestMapping("JSSC")
    public String JSSC(HttpServletRequest request){
        return "";
    }

    @RequestMapping("JSXG")
    public String JSXG(HttpServletRequest request){
        return "";
    }
}
