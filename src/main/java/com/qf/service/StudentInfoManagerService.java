package com.qf.service;

import com.qf.pojo.Classes;
import com.qf.pojo.Student;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;
import java.util.List;

public interface StudentInfoManagerService {
    Classes getClassesByCid(int cid);

    List<Student> getStudentInfoListByCid(int cid);

    public List<Student> getStudentInfoListByUid(int uid);

    Student getStudentBySid(int sid);

    public int addStudentList(List<List<Object>> lists, String cname);

    public int addStudent(Student student);

    List getBankListByExcel(InputStream in, String fileName) throws Exception;

    Workbook getWorkbook(InputStream inStr, String fileName) throws Exception;
}
