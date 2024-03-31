package com.example.cruddemoEmployee.rest;

import com.example.cruddemoEmployee.dao.EmployeeDAO;
import com.example.cruddemoEmployee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")                  //base mapping here
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    //constructor injection of employee DAO
    @Autowired
    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    //expose "/employees" endpoint and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
