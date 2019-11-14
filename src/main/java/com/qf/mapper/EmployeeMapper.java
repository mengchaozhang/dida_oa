package com.qf.mapper;

import com.qf.pojo.Classes;
import com.qf.pojo.Employee;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    public Employee getEmployeeByUid(int uid);

    public Classes getClassesByTeacherEid(int eid);

    public Classes getClassesByHeadmasterEid(int eid);

    public List<Classes> getClassesListByTeacherEid(@Param("eid")int eid);

    public List<Classes> getClassesListByHeadmasterEid(@Param("eid")int eid);

    public List<Classes> getClassesListByBoss();

    public List<Student> getStudentListByCid(int cid);

    public int addStudentList(List<Student> studentList);

    public int addStudent(Student student);

    public int addUser(User user);


    public List<Employee> getEmployeeCK(Employee employee);
    public void addEmployeeTJ(Employee employee);
    public void updateEmployeeXG(Employee employee);
    public void deleteEmployeeSC(Employee employee);;
    public List<Employee> getEmployeeMHCK(String string);;
}
