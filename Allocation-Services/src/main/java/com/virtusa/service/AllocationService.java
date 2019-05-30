package com.virtusa.service;

import java.util.List;
import java.util.Optional;

import com.virtusa.model.Allocation;

public interface AllocationService {
	
	Allocation save(Allocation allocation);
	List <Allocation> fetchByEmpId(Integer empid);
	List<Allocation> fetchAll(Allocation allocation);
	//Allocation fetchById(Allocation allocationEmpid,Allocation allocationId );

}
