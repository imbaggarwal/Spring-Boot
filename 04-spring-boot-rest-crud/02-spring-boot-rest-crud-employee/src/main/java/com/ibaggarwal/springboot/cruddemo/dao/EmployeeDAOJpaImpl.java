package com.ibaggarwal.springboot.cruddemo.dao;

import com.ibaggarwal.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // Read Data from Database
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    // Find by ID
    @Override
    public Employee findByID(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    // Add employee
    @Override
    public Employee save(Employee theEmployee) {
        Employee employee = entityManager.merge(theEmployee);
        return employee;
    }

    // Delete by ID
    @Override
    public void deleteByID(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
