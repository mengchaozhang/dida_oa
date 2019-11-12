package com.qf.controller;

import com.qf.service.SuperAdmin_ClassesService;
import com.qf.service.SuperAdmin_ClassesService_impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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



    //功能实现
    @RequestMapping("KCGL")
    public String KCHHL(){
        return "";
    }
}
