package com.ibaggarwal.springboot.cruddemo.dao;

import com.ibaggarwal.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
