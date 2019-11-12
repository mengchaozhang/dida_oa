package com.qf.service;

import com.qf.pojo.Employee;
import com.qf.pojo.Student;

public interface SelfInfoManagerService {
    public Student getStudentByUid(int uid);

    public Employee getEmployeeByUid(int uid);
}
