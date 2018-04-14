package com.tw.employees.service;


import com.tw.employees.model.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeeList();

    Employee getEmployeeById(Integer id);

    void insertEmployee(Employee employee) throws Exception;

    void deleteEmployeeById(Integer id) throws Exception;

    void updateEmployee(Employee employee) throws Exception;

}
