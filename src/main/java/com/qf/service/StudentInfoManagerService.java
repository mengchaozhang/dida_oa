package com.qf.service;

import com.qf.pojo.Student;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;
import java.util.List;

public interface StudentInfoManagerService {
    public List<Student> getStudentInfoListByUid(int uid);

    public int addStudentList(List<List<Object>> lists, String cname);

    public int addStudent(Student student);

    List getBankListByExcel(InputStream in, String fileName) throws Exception;

    Workbook getWorkbook(InputStream inStr, String fileName) throws Exception;
}
