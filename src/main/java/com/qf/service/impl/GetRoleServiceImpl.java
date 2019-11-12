package com.qf.service.impl;

import com.qf.mapper.EmployeeMapper;
import com.qf.mapper.RoleMapper;
import com.qf.mapper.StudentMapper;
import com.qf.pojo.Employee;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.service.GetRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetRoleServiceImpl implements GetRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public String getPasswordByUsername(String username) {
        return roleMapper.getPasswordByUsername(username);
    }

    @Override
    public User getUserByUsername(String username) {
        return roleMapper.getUserByUsername(username);
    }

    @Override
    public String getEnameByUid(int uid) {
        Employee employee = employeeMapper.getEmployeeByUid(uid);
        return employee.getEname();
    }

    @Override
    public String getSnameByUid(int uid) {
        Student student = studentMapper.getStudentByUid(uid);
        return student.getSname();
    }
}
