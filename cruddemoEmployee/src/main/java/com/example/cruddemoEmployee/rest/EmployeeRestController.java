package com.example.cruddemoEmployee.rest;

import com.example.cruddemoEmployee.entity.Employee;
import com.example.cruddemoEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api")                  //base mapping here
public class EmployeeRestController {

    private EmployeeService employeeService;

    //constructor injection of employee DAO
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    //get a list of all employees - GET - /api/employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //read a single employee - GET - /api/employee/{id}
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if (employee == null){
            throw new RuntimeException("Employee ID not found.");
        }
        return employee;
    }

    //create a new employee - POST - /api/employees
    @PostMapping ("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){ //@RequestBody handles JSON
        theEmployee.setId(0); //in case ID passed to the in the JSON, this will force a save rather than update

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    //update an existing employee - PUT - /api/employees
    @PutMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee){
        return employeeService.save(theEmployee);
    }

    //delete an existing employee - DELETE - /api/employee/{id}
    @DeleteMapping("/employees/{id}")
    public String delete(@PathVariable int id){
        Employee employee = employeeService.findById(id);

        if (employee == null){
            throw new RuntimeException("Employee ID not found - " + id);
        }

        employeeService.deleteById(id);

        return "Deleted employee ID - " + id;
    }
}
