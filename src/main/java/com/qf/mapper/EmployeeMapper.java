package com.qf.mapper;

import com.qf.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    public List<Employee> getEmployeeCK(Employee employee);
    public void addEmployeeTJ(Employee employee);
    public void updateEmployeeXG(Employee employee);
    public void deleteEmployeeSC(Employee employee);
}
