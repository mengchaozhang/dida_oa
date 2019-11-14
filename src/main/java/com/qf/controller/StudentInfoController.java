package com.qf.controller;

import com.qf.pojo.Classes;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.service.SelfInfoManagerService;
import com.qf.service.StudentInfoManagerService;
import com.qf.util.ExcelUtils;
import com.qf.util.MD5Utils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class StudentInfoController {

    @Autowired
    private StudentInfoManagerService studentInfoManagerService;

    @Autowired
    private SelfInfoManagerService selfInfoManagerService;

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
            return "redirect:jumpStudentImport";
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
        return "redirect:jumpStudentImport";
    }

    @RequestMapping("updatePassword")
    public String updatePassword() {
        return "update_password";
    }

    @RequestMapping("goUpdatePassword")
    public String goUpdatePassword(String password, HttpSession session) {
        User user = (User)session.getAttribute("user");
        String passwordMD5 = MD5Utils.md5(password);
        user.setPassword(passwordMD5);
        int i = selfInfoManagerService.alterPassword(user);
        if (i > 0) {
            return "redirect:jumpSelfInfo";
        }
        return "redirect:updatePassword";
    }

    @RequestMapping("export")
    @ResponseBody
    public void export(int cid, HttpServletResponse response) throws Exception {
        //获取数据
        List<Student> studentList = studentInfoManagerService.getStudentInfoListByCid(cid);
        Classes classes = studentInfoManagerService.getClassesByCid(cid);
        //excel标题
        String[] title = {"姓名", "性别", "年龄", "手机号", "班级"};

        //excel文件名
        String fileName = classes.getCname() + "学生信息表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "学生信息表";

        String [][] content = new String[studentList.size()][5];

        for (int i = 0; i < studentList.size(); i++) {
            content[i] = new String[title.length];
            Student student = studentList.get(i);
            content[i][0] = student.getSname();
            content[i][1] = student.getSsex();
            content[i][2] = String.valueOf(student.getSage());
            content[i][3] = student.getSphone();
            content[i][4] = student.getClasses().getCname();
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtils.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
