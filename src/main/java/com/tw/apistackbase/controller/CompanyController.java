package com.tw.apistackbase.controller;

import com.tw.apistackbase.Entity.Company;
import com.tw.apistackbase.Entity.DB;
import com.tw.apistackbase.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private DB db;
  List<Company> companies = new ArrayList<>();
    @GetMapping(value = "")
    public List<Company> getCompanies() {

        companies = db.getCompanies();
        return companies;
    }

    @GetMapping(value = "/{id}")
    public Company getCompanyById(@PathVariable("id") int id) {
        companies = db.getCompanies();
        for (Company company : companies) {
            if (company.getId() == id) {
                return company;
            }
        }
        return null;

    }

    @GetMapping(value = "/{id}/employees")
    public List<Employee> getEmployees(@PathVariable("id") int id) {
        companies = db.getCompanies();
        for (Company company : companies) {
            if (company.getId() == id) {
                return company.getEmployees();
            }
        }
        return null;
    }

    @PostMapping(value = "")
    public Company addCompany(@RequestBody Company company) {
        companies = db.getCompanies();
        companies.add(company);
        return company;
    }

    @PutMapping(value = "/{id}")
    public Company updateCompany(@PathVariable("id") int id,@RequestBody Company updateCompany) {
        companies = db.getCompanies();
        for (Company company : companies){
            if (company.getId() == id){
                company.setEmployees(updateCompany.getEmployees());
                company.setId(updateCompany.getId());
                company.setName(updateCompany.getName());
                return company;
            }
        }
        return null;
    }
    @DeleteMapping(value = "/{id}")
    public void deleteCompany(@PathVariable("id") int id){
        companies = db.getCompanies();
        Iterator<Company> companyIterator = companies.iterator();
        while (companyIterator.hasNext()){
            if(companyIterator.next().getId() == id){
                companyIterator.remove();
            }
        }

    }
}
