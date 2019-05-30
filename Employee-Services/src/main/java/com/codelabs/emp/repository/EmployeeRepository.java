package com.codelabs.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelabs.emp.model.Employee;



public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

}
