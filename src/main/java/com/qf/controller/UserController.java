package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.GetRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {


        @Autowired
        private GetRoleService getRoleService;
        @Autowired
        private SecurityManager securityManager;



    @RequestMapping("login")
    public String loginPage(){
            return "login";
    }

    @RequestMapping("goLogin")
    public String login(User user, HttpSession session){
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try{
            subject.login(usernamePasswordToken);
            if(subject.isAuthenticated()){
                User user1 = getRoleService.getUserByUsername(user.getUsername());
                session.setAttribute(user1.getRolename(),user1);
                return "index";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "login";
    }
//
//    @RequestMapping("edit")
//    public  String stu(HttpServletRequest request, HttpSession session){
//         String name = (String) session.getAttribute("uname");
//         int id= getRoleService.getUserByuid(uid);
//    }
//@RequestMapping("view")
//    public String view(HttpServletRequest request,HttpSession session){
//            String name = (String) session.getAttribute("uname");
//
//}
}
