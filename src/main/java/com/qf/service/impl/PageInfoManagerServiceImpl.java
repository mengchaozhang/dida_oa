package com.qf.service.impl;

import com.qf.mapper.EmployeeMapper;
import com.qf.pojo.Classes;
import com.qf.pojo.Employee;
import com.qf.pojo.User;
import com.qf.service.PageInfoManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageInfoManagerServiceImpl implements PageInfoManagerService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Classes> getClassesListByUid(User user) {
        Employee employee = employeeMapper.getEmployeeByUid(user.getUid());
        List<Classes> classesList = null;
        if ("teacher".equals(user.getRolename())) {
            classesList = employeeMapper.getClassesListByTeacherEid(employee.getEid());
        } else {
            classesList = employeeMapper.getClassesListByHeadmasterEid(employee.getEid());
        }
        return classesList;
    }

    @Override
    public List<Classes> getClassesList() {
        return employeeMapper.getClassesListByBoss();
    }
}
