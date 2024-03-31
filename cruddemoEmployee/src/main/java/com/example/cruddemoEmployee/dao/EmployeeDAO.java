package com.example.cruddemoEmployee.dao;

import com.example.cruddemoEmployee.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
