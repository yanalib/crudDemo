package com.example.cruddemoEmployee.dao;

import com.example.cruddemoEmployee.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);

    void delete(int id);
}
