package com.virtusa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.model.Allocation;

public interface  AllocationServiceRepository extends JpaRepository<Allocation, Integer> {

	public List <Allocation> findByempid(Integer empid);
	
	
}
