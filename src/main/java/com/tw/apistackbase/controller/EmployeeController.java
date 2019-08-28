package com.tw.apistackbase.controller;


import com.tw.apistackbase.Entity.DB;
import com.tw.apistackbase.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private  DB db;

     List<Employee>  employees = new ArrayList<>();



    @GetMapping(value = "")
    public List<Employee> getEmployees(){
        employees = db.getEmployees();
        return employees;
    }
    @GetMapping(value = "/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id){
        employees = db.getEmployees();
        for (Employee employee : employees){
            if (employee.getId() == id){
                return employee;
            }
        }
        return null;
    }

    @GetMapping(value = "/{gender}")
    public List<Employee> getMaleEmployees(@PathVariable("gender") String gender){
        employees = db.getEmployees();
        List<Employee> maleEmployees = new ArrayList<>();
        for (Employee employee : employees){
            if (employee.getGender().equals(gender)){
                maleEmployees.add(employee);
            }
            return maleEmployees;
        }
        return null;

    }
    @PostMapping(value = "")
    public Employee addEmployee(@RequestBody Employee employee){
        employees = db.getEmployees();
        employees.add(employee);
        return employee;
    }

    @PutMapping(value = "/{id}")
    public Employee updateEmployee(@PathVariable("id") int id,@RequestBody Employee newEmployee){
        employees = db.getEmployees();
        for (Employee employee : employees){
            if (employee.getId() == id){
                employee.setName(newEmployee.getName());
                employee.setAge(newEmployee.getAge());
                employee.setGender(newEmployee.getGender());
                employee.setSalary(newEmployee.getSalary());
            }
            return employee;
        }
        return null;
    }
    @DeleteMapping(value = "{id}")
    public void deleteEmployee(@PathVariable("id") int id){
        employees = db.getEmployees();
        Iterator<Employee> iterator= employees.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getId() == id){
                iterator.remove();
            }
        }

    }
}
