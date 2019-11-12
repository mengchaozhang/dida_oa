package com.qf.controller;

import com.qf.pojo.Employee;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.service.SelfInfoManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class JumpController {

    @Autowired
    private SelfInfoManagerService selfInfoManagerService;

    @RequestMapping("jumpStudentImport")
    public String jumpStudentImport() {
        return "student_import";
    }

    @RequestMapping("jumpStudentInfo")
    public String jumpStudentInfo() {
        return "student_info";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("jumpSelfInfo")
    public String jumpSelfInfo(HttpSession session, HttpServletRequest request) {
        User user = (User)session.getAttribute("user");
        if ("student".equals(user.getRolename())) {
            Student student = selfInfoManagerService.getStudentByUid(user.getUid());
            request.setAttribute("student", student);
        } else {
            Employee employee = selfInfoManagerService.getEmployeeByUid(user.getUid());
            request.setAttribute("employee",employee);
        }
        return "self_info";
    }
}
