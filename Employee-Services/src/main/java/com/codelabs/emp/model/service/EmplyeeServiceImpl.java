package com.codelabs.emp.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codelabs.emp.model.Allocation;
import com.codelabs.emp.model.Employee;
import com.codelabs.emp.model.Telephone;
import com.codelabs.emp.repository.EmployeeRepository;



@Service
public class EmplyeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee employee)
	{
		for(Telephone telephone:employee.getTelephones())
		{
			telephone.setEmployee(employee);
		}
		return employeeRepository.save(employee);
	}
	
	
	@Override
	public List<Employee> fetchAllemployees() {
		return employeeRepository.findAll();
	}
	@Override
	public Employee fetchEmployee(Employee employee) {
		Optional<Employee> optionalEmployee=employeeRepository.findById(employee.getId());
		if(optionalEmployee.isPresent())
		{
			//fetch project allocatiom
			RestTemplate restTemplate= new RestTemplate();
			HttpHeaders hettpHeaders= new HttpHeaders();
			
			//exact token from current context
			OAuth2AuthenticationDetails details=(OAuth2AuthenticationDetails)
					SecurityContextHolder.getContext().getAuthentication().getDetails();
			hettpHeaders.add("Authorization","bearer".concat(details.getTokenValue()));
			ResponseEntity<Allocation[]> responseEntity;
			HttpEntity<String> entity= new HttpEntity<>("",hettpHeaders);
			responseEntity=restTemplate.exchange("http://localhost:8081/emscloud/allocations".concat(employee.getId().toString()), HttpMethod.GET,entity,Allocation[].class);		
			Employee employee1= optionalEmployee.get();
			employee1.setAllocation(responseEntity.getBody());
			
			return employee1;
			}
		else
		{
			return null;
		}
	}

}
