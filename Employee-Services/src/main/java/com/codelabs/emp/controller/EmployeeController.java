package com.codelabs.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codelabs.emp.model.Address;
import com.codelabs.emp.model.Employee;
import com.codelabs.emp.model.Project;
import com.codelabs.emp.model.service.EmployeeService;



@RestController
@RequestMapping(value="/emscloud")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	@RequestMapping(value="/employee",method=RequestMethod.POST)
	public Employee save(@RequestBody Employee employee)
	{
		return employeeservice.save(employee);
	}
	
	@RequestMapping(value="/employee" , method=RequestMethod.GET )
	public List<Employee> fetchAllemoployee()
	{
		return employeeservice.fetchAllemployees();
	}
	
	@RequestMapping(value="/employee/{id}" , method=RequestMethod.GET )
	public ResponseEntity<Employee> fetchemployee(@PathVariable Integer id)
	{
		Employee employee=new Employee();
		employee.setId(id);
		Employee employee1= employeeservice.fetchEmployee(employee);
		if(employee1==null)
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
			return ResponseEntity.ok(employee);
		}
	}
	@RequestMapping(value="/employee/{id}/projects",method=RequestMethod.GET)
	public ResponseEntity<List<Project>> fetAllEmployeeProjects(@PathVariable Integer id)
	
	{
		Employee employee=new Employee();
		employee.setId(id);
		Employee employee1= employeeservice.fetchEmployee(employee);
		if(employee1==null)
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
			return ResponseEntity.ok(employee.getProject());
		}
		
	}
	
	@RequestMapping(value="/test")
	public Employee test()
	{
		Employee employee=new Employee();
		employee.setId(1);
		employee.setName("Nadeeshani");
		
		Address adress=new Address();
		adress.setId(1);
		adress.setAddress1("Shanika");
		adress.setCity("Nugegoda");
		employee.setAddress(adress);
		return employee;

	}
	
	@RequestMapping(value="/test2")
	public ResponseEntity<Employee> test2()
	{
		Integer x=null;
		if(x==null)
		{
		Employee employee=new Employee();
		employee.setId(1);
		employee.setName("Nadeeshani");
		
		Address adress=new Address();
		adress.setId(1);
		adress.setAddress1("Shanika");
		adress.setCity("Nugegoda");
		employee.setAddress(adress);
		return ResponseEntity.ok(employee);
		}
		else
		{
			HttpHeaders httpheaders=new HttpHeaders();
			httpheaders.add("status", "invalid-status");
			return ResponseEntity.notFound().headers(httpheaders).build();
		}
	}

}
