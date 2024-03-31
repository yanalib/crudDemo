package com.example.cruddemoEmployee.dao;

import entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
