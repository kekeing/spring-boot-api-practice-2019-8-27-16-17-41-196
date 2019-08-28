package com.tw.apistackbase.Entity;

import java.util.List;

public class Company {
    private int id;
    private String name;
    private int employeesNumber;
    private List<Employee> employees;


    public Company() {
    }

    public Company(int id, String name, int employeesNumber, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employeesNumber = employeesNumber;
        this.employees = employees;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
