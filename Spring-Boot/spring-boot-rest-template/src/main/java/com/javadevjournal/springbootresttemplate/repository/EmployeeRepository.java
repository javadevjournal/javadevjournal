package com.javadevjournal.springbootresttemplate.repository;

import com.javadevjournal.springbootresttemplate.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
