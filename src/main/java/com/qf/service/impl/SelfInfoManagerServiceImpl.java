package com.qf.service.impl;

import com.qf.mapper.EmployeeMapper;
import com.qf.mapper.StudentMapper;
import com.qf.mapper.UserMapper;
import com.qf.pojo.Employee;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.service.SelfInfoManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelfInfoManagerServiceImpl implements SelfInfoManagerService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private UserMapper userMapper;

    @Override

    public Student getStudentByUid(int uid) {
        return studentMapper.getStudentByUid(uid);
    }

    @Override
    public Employee getEmployeeByUid(int uid) {
        return employeeMapper.getEmployeeByUid(uid);
    }

    @Override
    public int updateStudentInfo(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int alterPassword(User user) {
        return userMapper.updateUser(user);
    }
}
