package com.virtusa.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.model.Allocation;
import com.virtusa.repository.AllocationServiceRepository;

@Service
public class AllocationServiceImpl implements AllocationService{
	
	@Autowired
	AllocationServiceRepository allocationServiceRepo;

	@Override
	public Allocation save(Allocation allocation) {
		
		return allocationServiceRepo.save(allocation);
	}

	@Override
	public List <Allocation> fetchByEmpId(Integer empid) {
		
		return allocationServiceRepo.findByempid(empid);
	}

	@Override
	public List<Allocation> fetchAll(Allocation allocation) {
		
		return allocationServiceRepo.findAll();
	}

	
//
//	@Override
//	public Allocation fetchById(Allocation allocationEmpid, Allocation allocationId) {
//		
//		Optional<Allocation> optional= allocationServiceRepo.findById(allocationEmpid.getEmpid(),allocationId.getId());
//		if(optional.isPresent())
//		{
//			return optional.get();
//		}
//		else
//		{
//			return null;
//		}
//	}

	

}
