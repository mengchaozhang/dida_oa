package com.qf.service;

import com.qf.pojo.Employee;
import com.qf.pojo.Student;
import com.qf.pojo.User;

public interface SelfInfoManagerService {
    public Student getStudentByUid(int uid);

    public Employee getEmployeeByUid(int uid);

    int updateStudentInfo(Student student);

    public int alterPassword(User user);
}
