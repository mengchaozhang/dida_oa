package com.qf.controller;

import com.qf.pojo.*;
import com.qf.service.*;
import com.qf.util.HanyupinyinUtils;
import com.sun.crypto.provider.HmacMD5;
import org.apache.ibatis.annotations.Param;
import org.omg.Dynamic.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SuperAdminController {
    @Autowired
    private SuperAdmin_RoleService superAdmin_roleService;

    public SuperAdmin_RoleService getSuperAdmin_roleService() {
        return superAdmin_roleService;
    }

    public void setSuperAdmin_roleService(SuperAdmin_RoleService superAdmin_roleService) {
        this.superAdmin_roleService = superAdmin_roleService;
    }

    @Autowired
    private SuperAdmin_UserService superAdmin_userService;

    public SuperAdmin_UserService getSuperAdmin_userService() {
        return superAdmin_userService;
    }

    public void setSuperAdmin_userService(SuperAdmin_UserService superAdmin_userService) {
        this.superAdmin_userService = superAdmin_userService;
    }

    @Autowired
    private SuperAdmin_EmployeeService superAdmin_employeeService;

    public SuperAdmin_EmployeeService getSuperAdmin_employeeService() {
        return superAdmin_employeeService;
    }

    public void setSuperAdmin_employeeService(SuperAdmin_EmployeeService superAdmin_employeeService) {
        this.superAdmin_employeeService = superAdmin_employeeService;
    }

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
        //班主任名称集合
        Employee employee = new Employee();
        User user = new User();
        user.setRolename("headmaster");
        employee.setUser(user);
        List<Employee>BZRlist = superAdmin_employeeService.YGCK(employee);
        //讲师名称集合
        user.setRolename("teacher");
        employee.setUser(user);
        List<Employee>JSlist = superAdmin_employeeService.YGCK(employee);

        List<Classes>list = superAdmin_classesService.BJCK(classes);
        List<Course> list1 = superAdmin_courseService.KCCK(course);

        request.getSession().setAttribute("BJlist",list);
        request.getSession().setAttribute("KClist",list1);
        request.getSession().setAttribute("JSlist",JSlist);
        request.getSession().setAttribute("BZRlist",BZRlist);
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
    public String KCXG(HttpServletRequest request, String courseId){

        return "redirect:KCGL";
    }
    @RequestMapping("KCSC")
    public String KCSC(HttpServletRequest request,String courseId){
        int courseId1 = Integer.parseInt(courseId);
        Course course = new Course();
        course.setCourseId(courseId1);
        superAdmin_courseService.KCSC(course);
        return "redirect:KCGL";
    }
    @RequestMapping("KCTJ")
    public String KCTJ(HttpServletRequest request,String courseName){
        Course course =new Course();
        course.setCourseName(courseName);
        superAdmin_courseService.KCTJ(course);
        return "redirect:KCGL";
    }

    //员工管理
    @RequestMapping("YGGL")
    public String YGGL(HttpServletRequest request,String string){
        if (string!=null){
          List<Employee>list = superAdmin_employeeService.YGMHCK(string);
            request.getSession().setAttribute("YGlist",list);
            return "YGGL";
        }else{
        Employee employee = new Employee();
        User user = new User();
        employee.setUser(user);
        List<Employee>list = superAdmin_employeeService.YGCK(employee);
        System.out.println("1111111111111111111111111");
        System.out.println(list);
        request.getSession().setAttribute("YGlist",list);
        return "YGGL";}
    }
    @RequestMapping("YGXG")
    public String YGXG(HttpServletRequest request){
        Employee employee = new Employee();
        employee.setEid(Integer.parseInt(request.getParameter("eid")));
        employee.setEname(request.getParameter("ename"));
        employee.setEsex( request.getParameter("esex"));
        employee.setEage(Integer.parseInt(request.getParameter("eage")));
        employee.setEphone(request.getParameter("ephone"));
        superAdmin_employeeService.YGXG(employee);
        System.out.println(employee);
        return "redirect:YGGL";
    }
    @RequestMapping("YGSC")
    public String YGSC(HttpServletRequest request,String eid){
        System.out.println(eid);
        Employee employee = new Employee();
        employee.setEid(Integer.parseInt(eid));
        superAdmin_employeeService.YGSC(employee);
        return "redirect:YGGL";
    }
    @RequestMapping("YGTJ")
    public String YGTJ(HttpServletRequest request){
        return "";
    }


    //用户管理
    @RequestMapping("YHGL")
    public String YHGL(HttpServletRequest request,String string){
        if (string!=null){
            Role role =new Role();
           List<Role>roles = superAdmin_roleService.RCK(role);
            request.getSession().setAttribute("QXlist",roles);
            List<User>list = superAdmin_userService.UMHCK(string);
            request.getSession().setAttribute("YHlist",list);
            return "YHGL";
        }else {
        User user = new User();
            Role role =new Role();
            List<Role>roles = superAdmin_roleService.RCK(role);
            request.getSession().setAttribute("QXlist",roles);
       List<User>list = superAdmin_userService.UCK(user);
       request.getSession().setAttribute("YHlist",list);
       return "YHGL";}
    }

    @RequestMapping("YHTJ")
    public String YHTJ(HttpServletRequest request){
        String xingming = request.getParameter("username");
        String rolename = request.getParameter("rolename");
        String username= HanyupinyinUtils.getPinyinString(xingming);

        //user表添加
        User user = new User();
        user.setUsername(username);
        user.setPassword("e10adc3949ba59abbe56e057f20f883e");
        user.setRolename(rolename);
        System.out.println(user);
        superAdmin_userService.UTJ(user);
        int uid = user.getUid();
        System.out.println(uid);
        //员工表添加
        User user1 = new User();
        user1.setUid(uid);
        Employee employee = new Employee();
        employee.setUser(user);
        employee.setEname(xingming);
        employee.setEsex(request.getParameter("esex"));
        employee.setEage(Integer.parseInt(request.getParameter("eage")));
        employee.setEphone(request.getParameter("ephone"));
        System.out.println(employee);
        superAdmin_employeeService.YGTJ(employee);

        return "redirect:YHGL";
    }

    @RequestMapping("YHXG")
    public String YHXG(HttpServletRequest request){

      String username = request.getParameter("username");
       String rolename = request.getParameter("rolename");
       User user = new User();
       user.setUid(Integer.parseInt(request.getParameter("uid")));
       user.setUsername(username);
       user.setRolename(rolename);
        System.out.println(user);
       superAdmin_userService.UXG(user);
        return "redirect:YHGL";
    }

    @RequestMapping("YHSC")
    public String YHSC(HttpServletRequest request,String uid){
        System.out.println(uid);
        User user = new User();
        user.setUid(Integer.parseInt(uid));
        superAdmin_userService.USC(user);
        return "redirect:YHGL";
    }

    @RequestMapping("MMCZ")
    public String MMCZ(HttpServletRequest request,String uid){
        User user = new User();
        user.setUid(Integer.parseInt(request.getParameter("uid")));
        user.setPassword("e10adc3949ba59abbe56e057f20f883e");
        superAdmin_userService.UXG(user);
        return "redirect:YHGL";
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
