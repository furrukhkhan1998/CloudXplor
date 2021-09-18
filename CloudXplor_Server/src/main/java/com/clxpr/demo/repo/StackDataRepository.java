package com.clxpr.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clxpr.demo.model.db.StackData;

public interface StackDataRepository extends JpaRepository<StackData, Long> {  // interface for storing cpu data in database 
	@Query(value = "SELECT max(occurance) FROM StackData")
	int getLatestEntry(); 
	
	List<StackData> findAllByOccurance(int occurance);
}
