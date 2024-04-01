package com.example.cruddemoEmployee.service;

import com.example.cruddemoEmployee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int id);
}
