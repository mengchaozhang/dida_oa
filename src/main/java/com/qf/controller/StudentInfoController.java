package com.qf.controller;

import com.qf.service.StudentInfoManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;

@Controller
public class StudentInfoController {

    @Autowired
    private StudentInfoManagerService studentInfoManagerService;

    @RequestMapping("student_info")
    public String studentInfo() {
        return "student_info";
    }

    @RequestMapping("student_import")
    public String studentImport() {
        return "student_import";
    }

    @RequestMapping("goImport")
    public String goImport(HttpServletRequest request,
                           @RequestParam("cname") String cname
                           ) {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile filename = multipartHttpServletRequest.getFile("filename");
        if (filename.isEmpty()) {
            return "student_import";
        }
        InputStream inputStream = null;
        List<List<Object>> list = null;
        try {
            inputStream = filename.getInputStream();
            list = studentInfoManagerService.getBankListByExcel(inputStream, filename.getOriginalFilename());
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        studentInfoManagerService.addStudentList(list, cname);




        return "student_import";
    }
}
