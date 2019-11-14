package com.qf.service.impl;

import com.qf.mapper.EmployeeMapper;
import com.qf.pojo.Classes;
import com.qf.pojo.Employee;
import com.qf.service.SuperAdmin_EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SuperAdmin_EmployeeService_impl implements SuperAdmin_EmployeeService {
 @Autowired
 private EmployeeMapper employeeMapper;

    public EmployeeMapper getEmployeeMapper() {
        return employeeMapper;
    }

    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }


    @Override
    public List<Employee> YGCK(Employee employee) {
        List<Employee> list = employeeMapper.getEmployeeCK(employee);
        return list;
    }

    @Override
    public void YGTJ(Employee employee) {
        employeeMapper.addEmployeeTJ(employee);
    }

    @Override
    public void YGXG(Employee employee){
        System.out.println("1111111111111操作了");
        employeeMapper.updateEmployeeXG(employee);
    }

    @Override
    public void YGSC(Employee employee) {
        employeeMapper.deleteEmployeeSC(employee);
    }

    @Override
    public List<Employee> YGMHCK(String string) {
        List<Employee>list = employeeMapper.getEmployeeMHCK(string);
        return list;
    }
}
