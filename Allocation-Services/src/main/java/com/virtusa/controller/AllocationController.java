package com.virtusa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.virtusa.model.Allocation;
import com.virtusa.service.AllocationService;

@RestController
@RequestMapping("/allocateCloud")
public class AllocationController {

	@Autowired
	AllocationService allocationService;
	
	@RequestMapping(value="/allocation",method=RequestMethod.POST)
	public Allocation save(@RequestBody Allocation allocation)
	{
		return allocationService.save(allocation);
	}
	
	@RequestMapping(value="/allocation/{empId}" , method=RequestMethod.GET )
	public List<Allocation> fetchByEmpId(@PathVariable Integer empId)
	{
		return allocationService.fetchByEmpId(empId);
	}
	@RequestMapping(value="/allocation" , method=RequestMethod.GET )
	public List <Allocation> fetchAll(Allocation allocation)
	{
		return allocationService.fetchAll(allocation);
	}
}
