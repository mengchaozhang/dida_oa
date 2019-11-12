package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

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
}
