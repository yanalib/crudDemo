package com.example.cruddemoEmployee.rest;

import com.example.cruddemoEmployee.entity.Employee;
import com.example.cruddemoEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")                  //base mapping here
public class EmployeeRestController {

    private EmployeeService employeeService;

    //constructor injection of employee DAO
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    //expose "/employees" endpoint and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
}
