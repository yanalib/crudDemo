package com.example.cruddemoEmployee.dao;

import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    //define fields for entity manager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result list
        List<Employee> employees = query.getResultList();

        //return the results
        return employees;
    }
}
