package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.Classes;
import com.qf.pojo.Employee;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.service.PageInfoManagerService;
import com.qf.service.SelfInfoManagerService;
import com.qf.service.StudentInfoManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class JumpController {

    @Autowired
    private SelfInfoManagerService selfInfoManagerService;

    @Autowired
    private StudentInfoManagerService studentInfoManagerService;

    @Autowired
    private PageInfoManagerService pageInfoManagerService;

    @RequestMapping("jumpStudentImport")
    public String jumpStudentImport(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Classes> classesList = pageInfoManagerService.getClassesListByUid(user);
        model.addAttribute("classesList", classesList);
        return "student_import";
    }

    @RequestMapping("jumpStudentInfo")
    public String jumpStudentInfo(@RequestParam(defaultValue = "1")int pageNum, int cid, HttpServletRequest request, Model model) {
        PageHelper.startPage(pageNum, 10);
        List<Student> studentList = studentInfoManagerService.getStudentInfoListByCid(cid);
        PageInfo<Student> pageInfo = new PageInfo<>(studentList);
        model.addAttribute("pageInfo", pageInfo);
        request.setAttribute("classes",studentInfoManagerService.getClassesByCid(cid));
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

    @RequestMapping("jumpUpdateInfo")
    public String jumpUpdateInfo(HttpSession session, HttpServletRequest request) {
        User user = (User)session.getAttribute("user");
        Student student = selfInfoManagerService.getStudentByUid(user.getUid());
        request.setAttribute("student", student);
        System.out.println(student);
        return "update_info";
    }

    @RequestMapping("goUpdateInfo")
    public String goUpdateInfo(Student student) {
        int i = selfInfoManagerService.updateStudentInfo(student);
        if (i > 0) {
            return "redirect:jumpSelfInfo";
        }
        return "redirect:jumpUpdateInfo";
    }
}
