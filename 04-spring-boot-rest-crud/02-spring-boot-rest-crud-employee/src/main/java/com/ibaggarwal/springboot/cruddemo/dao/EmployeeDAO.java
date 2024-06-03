package com.ibaggarwal.springboot.cruddemo.dao;

import com.ibaggarwal.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    // Method to get all employees
    List<Employee> findAll();

    // Method to get employee by ID
    Employee findByID(int id);

    // Method to add an employee
    Employee save(Employee employee);

    // Method to delete an employee by ID
    void deleteByID(int id);
}
