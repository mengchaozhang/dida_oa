package com.qf.service.impl;

import com.qf.mapper.ClassesMapper;
import com.qf.mapper.EmployeeMapper;
import com.qf.mapper.StudentMapper;
import com.qf.mapper.WeekReportMapper;
import com.qf.pojo.Classes;
import com.qf.pojo.Employee;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.service.StudentInfoManagerService;
import com.qf.util.HanyupinyinUtils;
import com.qf.util.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentInfoManagerServiceImpl implements StudentInfoManagerService {

    @Autowired
    private WeekReportMapper weekReportMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public Classes getClassesByCid(int cid) {
        return classesMapper.getClassesByCid(cid);
    }

    @Override
    public List<Student> getStudentInfoListByCid(int cid) {
        return studentMapper.getStudentListBycid(cid);
    }

    @Override
    public List<Student> getStudentInfoListByUid(int uid) {
        Employee employee = employeeMapper.getEmployeeByUid(uid);
        Classes classes = employeeMapper.getClassesByTeacherEid(employee.getEid());
        return employeeMapper.getStudentListByCid(classes.getCid());
    }

    @Override
    public Student getStudentBySid(int sid) {
        return studentMapper.getStudentBySid(sid);
    }

    @Override
    public int addStudentList(List<List<Object>> list, String cname) {
        String rolename = "student";
        List<Student> studentList = new ArrayList<>();
        for (List<Object> objects : list) {
            User user = new User();
            String username = HanyupinyinUtils.getPinyinString(objects.get(0).toString());
            user.setUsername(username);
            user.setRolename(rolename);
            employeeMapper.addUser(user);
            Student student = new Student();
            student.setSname(objects.get(0).toString());
            student.setSsex(objects.get(1).toString());
            student.setSage((int)NumberUtils.tranPointNum(0, Double.parseDouble(objects.get(2).toString())));
            student.setSphone(""+(long)NumberUtils.tranPointNum(0, Double.parseDouble(objects.get(3).toString())));
            Classes classes = classesMapper.getClassesByCname(cname);
            student.setClasses(classes);
            student.setUser(user);
            studentList.add(student);
        }
        for (Student student1 : studentList) {
            System.out.println(student1);
        }
        return employeeMapper.addStudentList(studentList);
    }

    @Override
    public int addStudent(Student student) {
        return employeeMapper.addStudent(student);
    }

    /**
     * 处理上传的xls文件
     *
     * @param in
     * @param fileName
     * @return
     * @throws Exception
     */
    @Override
    public List getBankListByExcel(InputStream in, String fileName) throws Exception {
        List list = new ArrayList<>();
        //创建Excel工作薄
        Workbook work = this.getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                List<Object> li = new ArrayList<>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    li.add(cell);
                }
                list.add(li);
            }
        }
        work.close();
        return list;
    }

    /**
     * 判断文件格式
     * @param inStr
     * @param fileName
     * @return
     * @throws Exception
     */
    @Override
    public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inStr);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inStr);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return workbook;
    }
}
