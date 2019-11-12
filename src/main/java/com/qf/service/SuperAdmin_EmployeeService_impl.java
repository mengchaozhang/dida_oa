package com.qf.service;

import com.qf.mapper.EmployeeMapper;
import com.qf.pojo.Classes;
import com.qf.pojo.Employee;
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
    public void YGXG(Employee employee) {
        employeeMapper.updateEmployeeXG(employee);
    }

    @Override
    public void YGSC(Employee employee) {
        employeeMapper.deleteEmployeeSC(employee);
    }
}
