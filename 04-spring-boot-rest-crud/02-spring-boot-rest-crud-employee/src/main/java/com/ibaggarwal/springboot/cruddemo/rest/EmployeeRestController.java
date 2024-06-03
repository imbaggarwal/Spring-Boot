package com.ibaggarwal.springboot.cruddemo.rest;

import com.ibaggarwal.springboot.cruddemo.entity.Employee;
import com.ibaggarwal.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("employees/{employeeID}")
    public Employee getEmployee(@PathVariable int employeeID){
        Employee employee = employeeService.findByID(employeeID);

        if(employee == null){
            throw new RuntimeException("Employee Not Found!");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);

        Employee theEmployee = employeeService.save(employee);

        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee theEmployee = employeeService.save(employee);

        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeID){
        Employee employee = employeeService.findByID(employeeID);

        if(employee == null){
            throw new RuntimeException("Employee Not Found!");
        }

        employeeService.deleteByID(employeeID);

        return "Employee Deleted: " + employeeID;
    }
}
