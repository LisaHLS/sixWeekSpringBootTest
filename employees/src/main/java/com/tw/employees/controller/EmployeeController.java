package com.tw.employees.controller;

import com.tw.employees.model.Employee;
import com.tw.employees.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ASUS on 2018/4/14.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertEmployee(@ModelAttribute("employee") Employee employee) throws Exception {
        employeeService.insertEmployee(employee);
    }

    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    public Employee getEmployeeById(@RequestParam Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
    public void updateEmployee(@ModelAttribute("employee") Employee employee) throws Exception {
        employeeService.updateEmployee(employee);
    }

    @RequestMapping( value = "/deleteEmployee", method = RequestMethod.DELETE)
    public void deleteEmployeeById(@RequestParam Integer id) throws Exception {
        employeeService.deleteEmployeeById(id);
    }

}
