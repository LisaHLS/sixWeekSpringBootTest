package com.tw.employees.service;

import com.tw.employees.model.Employee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Component;

/**
 * Created by ASUS on 2018/4/14.
 */
@Component
public class EmployeeServiceImpl implements EmployeeService{

    public static final String employeesList =
        "[{'id': 1,'name': '小明','age': 20,'gender': '男'}," +

        "{'id': 2,'name': '小红','age': 19,'gender': '女'}," +

        "{'id': 3,'name': '小智','age': 15,'gender': '男'}," +

        "{'id': 4,'name': '小刚','age': 16,'gender': '男'}," +

        "{'id': 5,'name': '小霞','age': 15,'gender': '女'}]";

    private List<Employee> list = (List<Employee>)JSONArray.toList(JSONArray.fromObject(employeesList),new Employee(),new JsonConfig());

    private static Map<Integer, Employee> employees = new HashMap<>();
    public EmployeeServiceImpl() {
        list.stream().forEach(item -> {
            employees.put(item.getId(), item);
        });
    }

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> list = new ArrayList<>(employees.values());
        return list;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employees.containsKey(id) ? employees.get(id) : null;
    }

    @Override
    public void insertEmployee(Employee employee) throws Exception{
        if (null == employee) {
            throw new Exception("Employee can not be null!");
        }

        if (employee.getId() == null || employee.getAge() == null || employee.getName() == null || employee.getGender() == null) {
            throw new Exception("Invalid Employee!");
        }
        employees.put(employee.getId(), employee);
    }

    @Override
    public void updateEmployee(Employee employee) throws Exception {
        if(null == employee){
            throw new Exception("Employee can not be null!");
        }

        if (employee.getId() == null || employee.getAge() == null || employee.getName() == null || employee.getGender() == null) {
            throw new Exception("Invalid Employee!");
        }

        if (!employees.containsKey(employee.getId())) {
            throw new Exception("there is no the Employee which id is " + employee.getId());
        }

        Employee oldEmployee = employees.get(employee.getId());
        oldEmployee.setName(employee.getName());
        oldEmployee.setAge(employee.getAge());
        oldEmployee.setGender(employee.getGender());

        employees.put(employee.getId(), oldEmployee);
    }

    @Override
    public void deleteEmployeeById(Integer id) throws Exception {
        if (!employees.containsKey(id)) {
            throw new Exception("there is no the Employee which id is " + id);
        }
        employees.remove(id);
    }

}
