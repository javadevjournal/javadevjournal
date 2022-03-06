package com.javadevjournal.springbootresttemplate.controller;

import com.javadevjournal.springbootresttemplate.model.Employee;
import com.javadevjournal.springbootresttemplate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;

  @GetMapping("/employees")
  private List getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @GetMapping("/employees/{id}")
  private Employee getEmployeeById(@PathVariable("id") int id) {
    return employeeService.getEmployeeById(id);
  }

  @PostMapping("/employees")
  private Employee createEmployee(@RequestBody Employee employee) {
    employeeService.saveOrUpdate(employee);
    return employee;
  }

  @PutMapping("/employees/{id}")
  private Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
    Employee updatedEmployee = employeeService.getEmployeeById(id);
    updatedEmployee.setName(employee.getName());
    updatedEmployee.setSalary(employee.getSalary());
    employeeService.saveOrUpdate(updatedEmployee);
    return updatedEmployee;
  }

  @DeleteMapping("/employees/{id}")
  private Employee deleteById(@PathVariable("id") int id) {
    Employee employeeDeleted = employeeService.getEmployeeById(id);
    employeeService.delete(id);
    return employeeDeleted;
  }
}
