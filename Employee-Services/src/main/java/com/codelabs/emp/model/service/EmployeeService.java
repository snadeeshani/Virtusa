package com.codelabs.emp.model.service;

import java.util.List;

import com.codelabs.emp.model.Employee;



public interface EmployeeService {

	Employee save(Employee employee);
	List<Employee> fetchAllemployees();
	Employee fetchEmployee(Employee employee);
}
